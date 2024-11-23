import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        Notification notificationSys = new BasicNotification("System Update"); // basic notiicaiotn
        //notificationSys.sendNotification();

        Notification SMSnotification = new SMSNotification(notificationSys);  // basic notiicaiotn
        //SMSnotification.sendNotification();

        Notification emailNotifications = new EmailNotification(notificationSys);  // basic notiicaiotn
        //emailNotifications.sendNotification();
        //emailNotifications.setNotification("Reminder permissions needed");
        //emailNotifications.sendNotification();

        Notification slackNotification = new SlackNotification(notificationSys);  // basic notiicaiotn
        slackNotification.setNotification("New team member joined! ");
        //slackNotification.sendNotification();

        ArrayList<String> notificationHistory = emailNotifications.getNotificationHistory();
        for (int i = 0; i < notificationHistory.size(); i++){
            System.out.println(notificationHistory.get(i));
        }

        NotificationPreferences notificationChannels = new NotificationPreferences();
        notificationChannels.addNotificationChannel(SMSnotification);
        notificationChannels.addNotificationChannel(emailNotifications);
        notificationChannels.addNotificationChannel(slackNotification);

        notificationChannels.sendNotificationbyPreference();










    }
}