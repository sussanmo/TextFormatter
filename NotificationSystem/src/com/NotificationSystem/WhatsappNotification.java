package com.NotificationSystem;

import com.NotificationSystem.NotificationDecorator;

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
        String notificaiton = "Whatsapp Notification: " + getNotification();
        System.out.println(notificaiton);
        addNotification(notificaiton);

    }


}


