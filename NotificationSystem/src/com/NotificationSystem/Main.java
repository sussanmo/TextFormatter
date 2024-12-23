package com.NotificationSystem;

import com.NotificationSystem.BasicNotification;
import com.NotificationSystem.EmailNotification;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Notification notificationSys = new BasicNotification("New Outlook Email "); // basic notiicaiotn
        notificationSys.sendNotification();

        Notification SMSnotification = new SMSNotification(notificationSys);  // basic notiicaiotn
        SMSnotification.sendNotification();

        Notification emailNotifications = new EmailNotification(notificationSys);  // basic notiicaiotn
        emailNotifications.sendNotification();
        emailNotifications.setNotification("Reminder permissions needed");
        emailNotifications.sendNotification();

        Notification slackNotification = new SlackNotification(notificationSys);  // basic notiicaiotn
        slackNotification.sendNotification();

        Notification whatsappNotification = new WhatsappNotification(notificationSys);
        whatsappNotification.sendNotification();

        Notification pushNotification = new PushNotification(notificationSys);
        pushNotification.sendNotification();

        ArrayList<String> notificationHistory = emailNotifications.getNotificationHistory();
        for (int i = 0; i < notificationHistory.size(); i++){
            System.out.println(notificationHistory.get(i));
        }

        NotificationPreferences notificationChannels = new NotificationPreferences();
        notificationChannels.setNotificationChannel(SMSnotification);
        notificationChannels.addNotificationChannelForMultipleNotification(SMSnotification);
        notificationChannels.addNotificationChannelForMultipleNotification(emailNotifications);
        notificationChannels.addNotificationChannelForMultipleNotification(slackNotification);
        notificationChannels.addNotificationChannelForMultipleNotification(whatsappNotification);
        notificationChannels.addNotificationChannelForMultipleNotification(pushNotification);

        notificationChannels.setEnabledNotificationChannels(SMSnotification);
        //notificationChannels.sendNotification();
        notificationChannels.disableNotificationChannels(SMSnotification);






    }
}