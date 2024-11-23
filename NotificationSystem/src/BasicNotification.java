public class BasicNotification extends Notification{
    public BasicNotification(String notification) {
        this.notification = notification;
    }

    @Override
    public void sendNotification() {
        System.out.println(notification);
        notificationHistory.add(notification);
    }






}
