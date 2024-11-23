import java.util.ArrayList;

public abstract class NotificationDecorator extends Notification {

    protected Notification notificationDecorator;

    public NotificationDecorator(Notification notification) {
        this.notificationDecorator = notification;
    }

    @Override
    public String getNotification() {
        return notificationDecorator.getNotification();
    }

    @Override
    public void setNotification(String newMessage) {
        notificationDecorator.setNotification(newMessage);
    }

    @Override
    public ArrayList<String> getNotificationHistory() {
        return notificationDecorator.getNotificationHistory();
    }






}
