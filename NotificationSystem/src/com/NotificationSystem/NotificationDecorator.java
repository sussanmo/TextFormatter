package com.NotificationSystem;

import java.util.ArrayList;

public abstract class NotificationDecorator extends Notification {

    protected Notification notificationDecorator;

    protected static ArrayList<String> notificationHistory = new ArrayList<>(); // Common messages


    public NotificationDecorator(Notification notification) {
        this.notificationDecorator = notification;
    }

    @Override
    public String getNotification() {
        return notificationDecorator.getNotification();
    }

    @Override
    public void setNotification(String newMessage) {
        notificationDecorator.setNotification(newMessage);
    }


    protected void addNotification(String message) {
        notificationHistory.add(message);
    }






}
