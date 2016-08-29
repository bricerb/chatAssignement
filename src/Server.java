import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

/**
 * Created by Brice on 8/25/16.
 */
public class Server {

    Socket connection = null;

    private ArrayList<MessageStamp> messagesHistory;

    public Server () {}

    public Server (Socket connection) {this.connection = connection;}

    public ArrayList<MessageStamp> getMessages() {
        return messagesHistory;
    }

    public void addMessages(String IncomingMessage) {
        MessageStamp stamp = new MessageStamp();
        messagesHistory.add(stamp.setMessage(IncomingMessage);
    }

    public void startServer() {
        try {
            System.out.println("Starting Server");
            ServerSocket listener = new ServerSocket(8080);

            while(true) {
                Socket incConnection = listener.accept();
                ConnectionHandler handler = new ConnectionHandler(incConnection);
                Thread multiThreadServer = new Thread(handler);

                //
//                Thread incThreadServer = new Thread(handler.IncomingMessageDisplay());
//                 cannot resolve constructor. Thread needed for incoming messages.

                multiThreadServer.start();

                //
//                incThreadServer.start();
                //
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

}
