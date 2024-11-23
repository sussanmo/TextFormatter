public class SMSNotification extends NotificationDecorator {

    public SMSNotification(Notification notificationDecorator) {
        super(notificationDecorator);
    }

    @Override
    public String getNotification() {
        return notificationDecorator.getNotification() + " via SMS";
    }

    @Override
    public void sendNotification() {
        System.out.println("New SMS Notification: " + getNotification());

    }




}
