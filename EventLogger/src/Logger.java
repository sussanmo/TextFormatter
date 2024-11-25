import java.util.ArrayList;
import java.util.HashMap;

public class Logger {

    private static Logger uniqueInstance; // single instance for singleton
    private static ArrayList<String> logHistory;

    private static HashMap<String, String> severityLogHistory;

    private Logger(){

//        empty = true;
//        boiled = false;
    }
    public static Logger getInstance() {
        if (uniqueInstance == null) {
            System.out.println("Creating new Logger instance");
            uniqueInstance = new Logger();
            logHistory = new ArrayList<>(); // instantiate once logger is available
            severityLogHistory = new HashMap<>();
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
        logHistory.add(logType + ": " + log); // add to history
        severityLogHistory.put(severity.toUpperCase(),(log));
    }

    public void printLogHistory(){
        for(String log: logHistory){
            System.out.println(log);
        }

    }

    public ArrayList<String> getLogHistory(){
        return logHistory;
    }

    public void printLogHistoryWithSeverity() {
        for (String severity : severityLogHistory.keySet()) {
            System.out.println(severity + ":" + severityLogHistory.get(severity));
        }
    }




}
