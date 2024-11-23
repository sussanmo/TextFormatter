import java.util.ArrayList;

public class NotificationPreferences { // class to let user choose where to get notifs
    private ArrayList<Notification> notificationPreference = new ArrayList<>();

    public void addNotificationChannel(Notification notificationType){
        notificationPreference.add(notificationType);
    }

    public void sendNotificationbyPreference(){
        for (Notification channel: notificationPreference){
            channel.sendNotification();
        }

    }



}
