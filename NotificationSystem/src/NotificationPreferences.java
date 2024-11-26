import java.util.ArrayList;

public class NotificationPreferences extends Notification { // class to let user choose where to get notifs

    private Notification channelPreference;
    private ArrayList<Notification> notificationPreference = new ArrayList<>();

    public void addNotificationChannelForMultipleNotification(Notification notificationType){
        notificationPreference.add(notificationType);
    }

    @Override
    public void sendNotification(){ // this is actually for multiple channels
        for (Notification channel: notificationPreference){
            channel.sendNotification();
        }
    }


    public void setNotificationChannel(Notification notificationChannel){
        this.channelPreference = notificationChannel;
        channelPreference.sendNotification();

    }





}
