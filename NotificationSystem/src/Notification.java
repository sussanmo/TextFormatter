import java.util.ArrayList;
import java.util.HashMap;

public abstract class Notification { // basic notification class

    protected String notification = "New Notification";
    private static ArrayList<String> notificationHistory = new ArrayList<>(); //common messages

//    public Notification (String message){
//        this.notification = message;
//    }

    public String getNotification() {
        return notification;
    }

    public abstract void sendNotification();

//    public void sendNotification() {
//        System.out.println("New notification: " + notification);
//        addNotification(notification);
//    }


    private void addNotification(String message){
        notificationHistory.add(message);
    }

    public ArrayList<String> getNotificationHistory(){
        return notificationHistory;
    }

}
