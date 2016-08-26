/**
 * Created by Brice on 8/25/16.
 */
public class ChatRunner {

    public static void main(String[] args) {
        System.out.println("Running");

        Server myServer = new Server();
        myServer.startServer();
    }
}