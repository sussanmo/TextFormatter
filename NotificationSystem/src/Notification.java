import java.util.ArrayList;
import java.util.HashMap;

public abstract class Notification { // basic notification class

    protected String notification = "";
    private static ArrayList<String> notificationHistory = new ArrayList<>(); //common messages



    public String getNotification() {
        return notification;
    }

    public abstract void sendNotification();


    public void setNotification(String notification){
        this.notification = notification;
    }



    private void addNotification(String message){
        notificationHistory.add(message);
    }

    public ArrayList<String> getNotificationHistory(){
        return notificationHistory;
    }

}
