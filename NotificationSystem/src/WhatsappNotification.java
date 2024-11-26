public class WhatsappNotification extends NotificationDecorator {
    public WhatsappNotification(Notification notificationDecorator) {
        super(notificationDecorator);
    }

    @Override
    public String getNotification() {
        return notificationDecorator.getNotification();
    }

    @Override
    public void sendNotification() {
        System.out.println("Whatsapp Notification: " + getNotification());
    }

}


