package server;


public class ServerLaunch {

  public static void main(String[] args) {
    
    ServerHandler serverSocket = new ServerHandler();
    serverSocket.startServer();

  }
 
}