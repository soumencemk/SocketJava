package server;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author Soumen Karmakar
 * 4/25/2018
 */
public class EchoServer {
    public static void main(String[] args) throws IOException {
        new Thread(() -> {
            try {
                ServerSocket serverSocket = new ServerSocket(9999);

                while(true) {
                    System.out.println("Waiting for client on port " +
                            serverSocket.getLocalPort() + "...");
                    Socket server = serverSocket.accept();
                    DataInputStream inputStream = new DataInputStream(server.getInputStream());
                    String s = inputStream.readUTF();
                    System.out.println(server.getRemoteSocketAddress() + ":: Says :" + s);
                    if(s.equalsIgnoreCase("exit")){
                        System.out.println("RECEIVED SIGTERM !");
                        break;
                    }
                    server.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }).start();
    }
}
