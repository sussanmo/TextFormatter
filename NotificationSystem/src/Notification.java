import java.util.ArrayList;
import java.util.HashMap;

public class Notification { // basic notification class

    private static ArrayList<String> notificationHistory = new ArrayList<>(); //common messages

    private String notification;

    public Notification (String message){
        this.notification = message;
    }
    public void sendNotification() {
        System.out.println("New notification: " + notification);
        addNotification(notification);
    }

    private void addNotification(String message){
        notificationHistory.add(message);
    }

    public ArrayList<String> getNotificationHistory(){
        return notificationHistory;
    }

}
