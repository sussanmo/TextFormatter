import java.util.ArrayList;

public class Logger {

    private static Logger uniqueInstance; // single instance for singleton
    private static ArrayList<String> logHistory;

    private Logger(){

//        empty = true;
//        boiled = false;
    }
    public static Logger getInstance() {
        if (uniqueInstance == null) {
            System.out.println("Creating new Logger instance");
            uniqueInstance = new Logger();
            logHistory = new ArrayList<>(); // instantiate once logger is available
        }
        System.out.println("Returning instance");
        return uniqueInstance;
    }

    public void log(String log){
        System.out.println("LOG: " + log);
        logHistory.add(log); // add to history
    }

    public void logWithSeverity(String severity, String log){
        // make severtiy upper case to mock real log
        String logType = severity.toUpperCase();
        System.out.println(logType + ": " + log);
        logHistory.add(log); // add to history
    }

    public void printLogHistory(){
        for(String log: logHistory){
            System.out.println(log);
        }

    }

    public ArrayList<String> getLogHistory(){
        return logHistory;
    }




}
