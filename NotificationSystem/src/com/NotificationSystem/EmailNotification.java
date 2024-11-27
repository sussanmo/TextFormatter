package com.NotificationSystem;

public class EmailNotification extends NotificationDecorator {


    public EmailNotification(Notification notificationDecorator) {
        super(notificationDecorator);
    }

    @Override
    public String getNotification() {
        return  notificationDecorator.getNotification() ;
    }

    @Override
    public void sendNotification() {
        String notificaiton = "Emailed Notification: " + getNotification();
        System.out.println(notificaiton);
        addNotification(notificaiton);



    }


}
