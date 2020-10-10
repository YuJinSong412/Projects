package server.dataCommunication;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ServerHandler {

  ExecutorService executorService;

  ServerSocket serverSocket;

  List<Client> connections = new Vector<Client>(); // 연결되어있는 클라이언트들


  public void startServer() {

    executorService = Executors.newFixedThreadPool(100);
    try {
      serverSocket = new ServerSocket();
      serverSocket.bind(new InetSocketAddress("localhost", 5027));
      System.out.println("서버 연결 기다림");
      // -> serverSocket 생성 및 포트 바인딩


    } catch (Exception e) {
      if (!serverSocket.isClosed()) {
        stopServer();
      }
      return;
    }

    // 연결을 수락하는 코드
    Runnable runnable = new Runnable() { // 수락 작업 생성

      @Override
      public void run() {

        while (true) {
          try {
            Socket socket = serverSocket.accept();
            System.out.println("연결 수락: " + socket.getRemoteSocketAddress() + ": "
                + Thread.currentThread().getName()); // Thread.currentThread().getName());

            Client client = new Client(socket);
            connections.add(client);
            System.out.println("연결 개수: " + connections.size());

          } catch (IOException e) {
            if (!serverSocket.isClosed()) {
              stopServer();
            }
            break;
          }

        }

      }

    };
    executorService.submit(runnable);
  }

  public void stopServer() {

    try {

      Iterator<Client> iterator = connections.iterator();
      while (iterator.hasNext()) {
        Client client = iterator.next();
        client.socket.close();
        iterator.remove();
      }
      if (serverSocket != null && !serverSocket.isClosed()) {
        serverSocket.close();
      }
      if (executorService != null && !executorService.isShutdown()) {
        executorService.shutdown();
      }
    } catch (Exception e) {
    }
  }
  
  
  class Client {
	    Socket socket;
	    
	    String userName;

	    public Client(Socket socket) {

	      this.socket = socket;

	      receive();
	    }

	    // 클라이언트의 데이터를 받는 메소드
	    void receive() {

	      Runnable runnable = new Runnable() {

	        @Override
	        public void run() {

	          byte[] byteArr = new byte[1024];

	          try {
	            while (true) {
	              InputStream inputStream = socket.getInputStream();

	              int readByteCount = inputStream.read(byteArr); // 데이터 받기

	              if (readByteCount == -1) {
	                throw new IOException();
	              }

	              Message ms = toObject(byteArr, Message.class);
	              System.out.println("요청처리: " + socket.getRemoteSocketAddress() + ": "
	                  + Thread.currentThread().getName());

	              userName = ms.getSendUserName();
	              System.out.println(userName+"qq");
	              
	              send(byteArr);

	              for (Client client : connections) { // 모든 클라이언트에게 보냄
	                System.out.println(client.userName+"ss"+ms.getReceiveFriendName());
	                if(client.userName != null) {
	                  if(client.userName.equals(ms.getReceiveFriendName()) && !ms.getSendUserName().equals(ms.getReceiveFriendName())) {
	                    client.send(byteArr);
	                  }

	                }
	              }
	              

	            }
	          } catch (Exception e) {
	            try {
	              connections.remove(Client.this);
	              socket.close(); 
	            } catch (IOException e2) {
	            }
	          }
	        }

	      };
	      executorService.submit(runnable);
	    }

	    private Message toObject(byte[] byteArr, Class<Message> class1) {

	      Object obj = null;
	      try {
	        ByteArrayInputStream bis = new ByteArrayInputStream(byteArr);
	        ObjectInputStream ois = new ObjectInputStream(bis);
	        obj = ois.readObject();
	      } catch (Exception e) {
	      }

	      return class1.cast(obj);
	    }


	    void send(byte[] bytes) {

	      Runnable runnable = new Runnable() {

	        @Override
	        public void run() {

	          try {
	            OutputStream outputStream = socket.getOutputStream();
	            outputStream.write(bytes);
	            outputStream.flush();
	            System.out.println("서버에서 데이터 보냄");
	          } catch (Exception e) {
	            e.printStackTrace();
	          }

	        }

	      };

	      executorService.submit(runnable);

	    }
	  }

}

/*
http://tcpschool.com/java/java_usingClass_innerClass
*/