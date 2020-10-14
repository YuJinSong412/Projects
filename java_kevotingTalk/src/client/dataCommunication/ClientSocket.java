package client.datacommunication;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import client.frame.ChatWindowPanel;
import server.datacommunication.Message;
import server.userdb.UserDAO;

public class ClientSocket {

  Socket socket;

  public void startClient() {

    Thread thread = new Thread() {

      @Override
      public void run() {

        try {
          socket = new Socket();
          socket.connect(new InetSocketAddress("localhost", 5027));
          System.out.println("연결 요청");
          // -> socket 생성 및 연결 요청
        } catch (IOException e) {
          System.out.println("서버 통신 안됨");
          if (!socket.isClosed()) {
            stopClient();
          }
          return;
        }
        receive();
      }
    };
    thread.start();
    
  }

  public void stopClient() {

    try {
      if (socket != null && !socket.isClosed()) {
        socket.close();
      }
    } catch (IOException e) {
    }
  }


  // 서버에서 보낸 데이터를 받는 역할
  public void receive() {

    while (true) {
      
      //수신 버퍼의 최대 사이즈 지정
      int maxBufferSize = 1024;
      
      //버퍼 생성
      byte[] recvBuffer = new byte[maxBufferSize];
      
      //서버로부터 받기 위한 입력 스트림 뚫음
      InputStream inputStream;
      try {
        inputStream = socket.getInputStream();
        int readByteCount = inputStream.read(recvBuffer); 
        
        if(readByteCount == -1) {
          throw new IOException();
        }
        
        Message ms = toObject(recvBuffer, Message.class);
        
        ChatWindowPanel.displayComment(ms);
        
      } catch (IOException e) {
        e.printStackTrace();
      }

    }
  }

  private Message toObject(byte[] recvBuffer, Class<Message> class1) {

    Object obj = null;
    try {
      ByteArrayInputStream bis = new ByteArrayInputStream(recvBuffer);
      ObjectInputStream ois = new ObjectInputStream(bis);
      obj = ois.readObject();
    }catch(Exception e) {}
    
    return class1.cast(obj);
  }

  // 사용자가 메시지 입력 후 전송 버튼 클릭하면 메시지를 매개값으로 호출, 서버로 메시지를 보내는 역할
  // 채팅방 들어갈 때도 해당
  public void send(Message messageInfo) { 

    Thread thread = new Thread() {

      @Override
      public void run() {

        //객체를 byte array로 변환
        byte[] bytes = null;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        try {
          ObjectOutputStream oos = new ObjectOutputStream(bos);
          oos.writeObject(messageInfo);
          oos.flush();
          oos.close();
          bos.close();
          bytes = bos.toByteArray();
        } catch (IOException e) {
        }
        
        // message객체를 byte로 변환 후 소켓을 통해 보냄
        try {
          byte[] data = bytes;
          OutputStream outputStream = socket.getOutputStream();
          outputStream.write(data);
          outputStream.flush();
          System.out.println("서버로 보내기 완료완료!");
        } catch (IOException e) {
          System.out.println("노노 서버로 통신 안됨");
          e.printStackTrace();
        }


      }
    };
    thread.start();
  }


}