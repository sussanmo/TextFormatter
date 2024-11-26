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
        String notificaiton = "Slack Update: " + getNotification();
        System.out.println(notification);
        addNotification(notificaiton);

    }


}
