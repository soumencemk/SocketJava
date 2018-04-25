package client;

import java.io.*;
import java.net.Socket;

/**
 * @author Soumen Karmakar
 * 4/25/2018
 */
public class EchoClient {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            Socket client = new Socket("localhost", 9999);
            OutputStream outToServer = client.getOutputStream();
            DataOutputStream out = new DataOutputStream(outToServer);
            System.out.print("COMMAND : ");
            String s = br.readLine();
            out.writeUTF(s);
            client.close();

        }
    }
}
