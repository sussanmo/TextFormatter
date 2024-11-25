import java.io.FileWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.io.IOException;


public class Logger {

    private static Logger uniqueInstance; // single instance for singleton
    private static ArrayList<String> logHistory;

    private static HashMap<String, String> severityLogHistory;

    private static String logFileDirectory = "eventLoggerFile.txt";

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
        String logMessage = severity.toUpperCase() + ":" + log;
        System.out.println(logMessage);
        logHistory.add(logMessage); // add to history
        severityLogHistory.put(severity.toUpperCase(),log);
        writeLogFile(logMessage);
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

    public void writeLogFile(String log){
        try (FileWriter writer = new FileWriter(logFileDirectory, true)) {

            writer.write(log + "\n");

        }catch (IOException exception){
            System.out.println("Error in writing file");
        }
    }


}
