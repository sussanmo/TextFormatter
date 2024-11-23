import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {



        Notification notificationSys = new BasicNotification("System Update"); // basic notiicaiotn
        notificationSys.sendNotification();

        Notification SMSnotification = new SMSNotification(notificationSys);  // basic notiicaiotn
        SMSnotification.sendNotification();



//        ArrayList<String> basicNotification = new ArrayList<>();
//        basicNotification = notificationSys.getNotificationHistory();
//        for (String notif: basicNotification){
//            System.out.println(notif);
//        }






    }
}