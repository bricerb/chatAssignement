import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 * Created by Brice on 8/26/16.
 */
public class MessageStamp {

    private String userName;
    private LocalDateTime timeStamp = LocalDateTime.now();
    private String message;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public LocalDateTime getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(LocalDateTime timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
