import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Created by Brice on 8/25/16.
 */
public class Client {

    public static void main(String[] args) {
        System.out.println("Running");

        try {
            Socket clientSocket = new Socket("10.0.0.126", 8024);
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            out.print("I regret nothing... IN BRICE WE TRUST");
            String serverRespone = in.readLine();
            clientSocket.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

}
