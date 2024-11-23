public class PushNotification extends NotificationDecorator{
    public PushNotification(Notification notificationDecorator) {
        super(notificationDecorator);
    }

    @Override
    public String getNotification() {
        return  notificationDecorator.getNotification() ;
    }

    @Override
    public void sendNotification() {
        System.out.println("Push Notification: " + getNotification());
    }
}
