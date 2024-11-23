import java.util.ArrayList;

public abstract class NotificationDecorator extends Notification {

    public NotificationDecorator(String notification) {
        super(notification);
    }

    public abstract ArrayList<String> notifications();


}
