public class EmailNotification extends NotificationDecorator{


    public EmailNotification(Notification notificationDecorator) {
        super(notificationDecorator);
    }

    @Override
    public String getNotification() {
        return  notificationDecorator.getNotification() ;
    }

    @Override
    public void sendNotification() {
        System.out.println("Emailed Notification: " + getNotification());
        notificationHistory.add(getNotification());


    }
}
