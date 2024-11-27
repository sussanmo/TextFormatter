package com.NotificationSystem;

import com.NotificationSystem.NotificationDecorator;

public class PushNotification extends NotificationDecorator {
    public PushNotification(Notification notificationDecorator) {
        super(notificationDecorator);
    }

    @Override
    public String getNotification() {
        return  notificationDecorator.getNotification() ;
    }

    @Override
    public void sendNotification() {
        String notificaiton = "Push Notification: " + getNotification();
        System.out.println("Push Notification: " + getNotification());
        addNotification(notificaiton);
    }
}
