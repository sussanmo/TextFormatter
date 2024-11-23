import java.util.ArrayList;
import java.util.HashMap;

public class Notification { // basic notification class

    private static ArrayList<String> notifications = new ArrayList<>(); //common messages


    public Notification (ArrayList<String> systemMessages){
        this.notifications = systemMessages;
    }
    public void sendNotification(String message) {
        System.out.println("New notification: " + message);
    }

    public void addNotification(String message){
        notifications.add(message);
    }

}
