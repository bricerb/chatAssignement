import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by Brice on 8/25/16.
 */
public class Server {

    Socket connection = null;

    public Server () {}

    public Server (Socket connection) {this.connection = connection;}

    public void startServer() {
        try {
            System.out.println("Starting Server");
            ServerSocket listener = new ServerSocket(8080);

            while(true) {
                Socket incConnection = listener.accept();
                ConnectionHandler handler = new ConnectionHandler(incConnection);
                Thread multiThreadServer = new Thread(handler);
                multiThreadServer.start();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

}
