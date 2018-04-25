package server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;

/**
 * @author Soumen Karmakar
 * 4/24/2018
 */
public class MyServer {

    public static void main(String[] args) throws IOException {
        new Thread(() -> {
            try {
                ServerSocket serverSocket = new ServerSocket(9999);
                while (true) {
                    System.out.println("Waiting for client on port " +
                            serverSocket.getLocalPort() + "...");
                    Socket server = serverSocket.accept();
                    System.out.println("Just connected to " + server.getRemoteSocketAddress());
                    DataInputStream inputStream = new DataInputStream(server.getInputStream());
                    System.out.println(inputStream.readUTF());
                    DataOutputStream out = new DataOutputStream(server.getOutputStream());
                    out.writeUTF("Thank you for connecting to " + server.getLocalSocketAddress()
                            + "\nGoodbye!");
                    server.close();
                }
            } catch (SocketTimeoutException e) {
                System.out.println("SOCKET TIME OUT");
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }


        }).start();
    }

}
