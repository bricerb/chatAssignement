import java.io.*;
import java.net.Socket;

/**
 * Created by Brice on 8/25/16.
 */
public class ConnectionHandler implements Runnable{

    Socket connection = null;

    public ConnectionHandler() {}

    public ConnectionHandler(Socket incConnection) {this.connection = incConnection;}

    public void run() {

        try{
            handleIncomingConnection(connection);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }



    public void handleIncomingConnection (Socket incClient) throws IOException{


        System.out.println("client: " + incClient);
        System.out.println(incClient.getInetAddress().getHostAddress() + " has connected.");


        BufferedReader clientInput = new BufferedReader(new InputStreamReader(incClient.getInputStream()));
        PrintWriter chatDisplay = new PrintWriter(incClient.getOutputStream(), true);
        MessageStamp message = new MessageStamp();

        String inputLine;



        while ((inputLine = clientInput.readLine()) != null) {
            if (message.getUserName() == null) {
                if ((inputLine.split("=")[0]).equals("name")) {
                    message.setUserName(inputLine.split("=")[1]);
                    chatDisplay.println(message.getUserName());
                    System.out.println(message.getUserName() + " has connected.");
                    } else {
                        chatDisplay.write("Invalid Input.");
                    }
                } else {

                    System.out.println(message.getUserName() + " says: " + inputLine);
                    chatDisplay.println(inputLine);
                }
            }
        }
    }
