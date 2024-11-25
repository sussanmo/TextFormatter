import java.io.File;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.io.IOException;
import java.util.Date;







public class Logger {

    private static Logger uniqueInstance; // single instance for singleton
    private static ArrayList<String> logHistory;

    private static HashMap<String, String> severityLogHistory;

    private static String logFileDirectory = "eventLoggerFile.txt";
    private final static String archiveFileDirectory = "archivedLogDirectory";

    private String currentDate = new SimpleDateFormat("yyyyMMdd").format(new Date());


    private Logger() {

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

    public void log(String log) {
        System.out.println("LOG: " + log);
        logHistory.add(log); // add to history
        archiveLogPeriodically(log);
    }

    public void logWithSeverity(String severity, String log) {
        // make severtiy upper case to mock real log
        String logMessage = severity.toUpperCase() + ":" + log;
        System.out.println(logMessage);
        logHistory.add(logMessage); // add to history
        severityLogHistory.put(severity.toUpperCase(), log);
        writeLogFile(logMessage);
        archiveLogPeriodically(log);

    }

    public void printLogHistory() {
        for (String log : logHistory) {
            System.out.println(log);
        }

    }

    public ArrayList<String> getLogHistory() {
        return logHistory;
    }

    public void printLogHistoryWithSeverity() {
        for (String severity : severityLogHistory.keySet()) {
            System.out.println(severity + ":" + severityLogHistory.get(severity));
        }
    }

    public void writeLogFile(String log) {
        try (FileWriter writer = new FileWriter(logFileDirectory, true)) {

            writer.write(log + "\n");

        } catch (IOException exception) {
            System.out.println("Error in writing file");
        }
    }

    public void archiveLogPeriodically(String logMessage) { // archives logs each day
        String timestampToday = new SimpleDateFormat("yyyyMMdd").format(new Date());
        String archiveFileName = "";

        File archiveDir = new File(archiveFileDirectory);
        if (!archiveDir.exists()) {
            archiveDir.mkdirs();
        }


        if(!timestampToday.equals(currentDate)){
            archiveFileName = new File(archiveDir, "logArchive_" + timestampToday + ".txt").getPath();
            currentDate = timestampToday; //update this
        }else {
            archiveFileName = new File(archiveDir, "logArchive_" + currentDate + ".txt").getPath();
        }

        try (FileWriter writer = new FileWriter(archiveFileName, true)) {
            writer.write(logMessage + "\n");
            System.out.println("Logs archived successfully to: " + archiveFileName);
        } catch (IOException e) {
            System.out.println("Error archiving logs: " + e.getMessage());
        }

    }

    public void archiveLogOnDemand() { // archives logs each day

        File archiveDir = new File(archiveFileDirectory);
        if (!archiveDir.exists()) {
            archiveDir.mkdirs();
        }

        String archiveFileName = new File(archiveDir, "logArchiveFile.txt").getPath();


        try (FileWriter writer = new FileWriter(archiveFileName, true)) {
            for (String log : logHistory) {
                writer.write(log + "\n");
            }
            System.out.println("Logs archived successfully for the day: " + archiveFileName);
        } catch (IOException e) {
            System.out.println("Error archiving logs: " + e.getMessage());
        }
        }

    }





