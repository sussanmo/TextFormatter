import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Date;







public class Logger {

    private static Logger uniqueInstance; // single instance for singleton
    private static ArrayList<String> logHistory;

    private static HashMap<String, String> severityLogHistory;

    private static String logFileDirectory = "eventLoggerFile.txt";
    private final static String archiveFileDirectory = "archivedLogDirectory";

    private String currentDate = new SimpleDateFormat("yyyyMMdd").format(new Date());

    private String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());


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
        //System.out.println("LOG: " + log);
        String logwithTime = timeStamp + "- " + log;
        writeLogFile(logwithTime);
        logHistory.add(logwithTime); // add to history
        archiveLogPeriodically(logwithTime);
    }

    public void logConsole(String log){ //system admin uses
        String logwithTime = timeStamp + "- " + log;
        System.out.println("LOG: " + logwithTime);
    }

    public void logRemoteServer(String log){
        System.out.println("Remote log sent to {}: " + log);
    }

    public void logWithSeverity(Severity severity, String log) { // implemented consistency for logs
        String logwithTime = timeStamp + "- " + log;

        // make severtiy upper case to mock real log
        String logMessage = severity.toString() + ":" + logwithTime;
        //System.out.println(logMessage);
        writeLogFile(logwithTime);
        logHistory.add(logwithTime); // add to history
        severityLogHistory.put(severity.toString(), logwithTime);
        archiveLogPeriodically(logwithTime);
    }

    public enum Severity {
        INFO,
        DEBUG,
        ERROR;

        @Override
        public String toString() {
            return name().toUpperCase();
        }
    }



    public void logHistoryFile() {
        for (String log : logHistory) {
            //System.out.println(log);
            writeLogFile(log);
        }
    }

    public ArrayList<String> getLogHistory() {
        return logHistory;
    }

    public void LogHistoryWithSeverity() {
        for (String severity : severityLogHistory.keySet()) {
            //System.out.println(severity + ":" + severityLogHistory.get(severity));
            writeLogFile(severity + ":" + severityLogHistory.get(severity) );
        }
    }

    public void writeLogFile(String log) {
        if(!checkLogHistoryDuplicate(log,logFileDirectory )){
            try (FileWriter writer = new FileWriter(logFileDirectory, true)) {

                writer.write(log + "\n");

            } catch (IOException exception) {
                System.out.println("Error in writing file");
            }
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

        private boolean checkLogHistoryDuplicate(String log, String logFileName){
            boolean alreadyInFile = false;

            File file = new File(logFileName);

            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                String line = reader.readLine();
                while (line != null){
                    if(log.equals(line)){
                        alreadyInFile = true;
                    }
                    line = reader.readLine();
                }
            } catch (IOException e) {
                //throw new RuntimeException(e);
            }

            return alreadyInFile;

        }




        public enum OutputType{
                console,
                file,
                remoteServer;

        @Override
        public String toString() {
            return name().toUpperCase();
        }
        }

        public void outputDestinationLog(String log, OutputType outputLocation){
            switch (outputLocation) {
                case console:
                    logConsole(log);
                    break;
                case file:
                    writeLogFile(log);
                    break;
                case remoteServer:
                    logRemoteServer(log);
                    break;
                default:
                   logConsole(log);
            }
        }

    }





