public class SlackNotification extends NotificationDecorator{

    public SlackNotification(Notification notificationDecorator) {
        super(notificationDecorator);
    }

    @Override
    public String getNotification() {
        return  notificationDecorator.getNotification() ;
    }

    @Override
    public void sendNotification() {
        System.out.println("Slack Update: " + getNotification());
    }


}
