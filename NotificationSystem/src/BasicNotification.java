public class BasicNotification extends Notification{
    public BasicNotification() { // basic implementation of notification
        this.notification = "New Notification: System Update";
    }

    @Override
    public void sendNotification() {
        System.out.println(notification);
    }
}
