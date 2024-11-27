package com.NotificationSystem;

import java.util.ArrayList;
import java.util.HashMap;

public class NotificationPreferences extends Notification { // class to let user choose where to get notifs

    private Notification channelPreference;
    private ArrayList<Notification> notificationPreference = new ArrayList<>();

    //private HashMap<com.NotificationSystem.Notification, Boolean> enabledNotificationChannels = new HashMap<>();

    public void addNotificationChannelForMultipleNotification(Notification notificationType) {
        notificationPreference.add(notificationType);
    }

    @Override
    public void sendNotification() { // this is actually for multiple channels
        for (Notification channel : notificationPreference) {
            if (isEnabledChannel(channel)) {
                channel.sendNotification();
            } else {
                System.out.println("Channel is not enabled");
            }
            //channel.sendNotification();
        }
    }


    public void setNotificationChannel(Notification notificationChannel) {
        this.channelPreference = notificationChannel;

    }

    public void setEnabledNotificationChannels(Notification notificationChannel) {
        notificationPreference.add(notificationChannel);
    }

    public void disableNotificationChannels(Notification notificationChannel) {
        if (notificationPreference.contains(notificationChannel)) {
            notificationPreference.remove(notificationChannel);
            //System.out.println(notificationChannel+ " was successfully disabled");
        }
    }

    public boolean isEnabledChannel(Notification notificationChannel) {
        if (!notificationPreference.contains(notificationChannel)) {
            return false;
        }
        return true;
    }





}
