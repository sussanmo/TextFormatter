public class Main {
    public static void main(String[] args) {

        Logger loggerInstance = Logger.getInstance();
        loggerInstance.log("Error");
        loggerInstance.log("warning ");

        loggerInstance.logWithSeverity(Logger.Severity.INFO, "extensible for future requirements, such as logging to a file, database, or remote server.");
        loggerInstance.logWithSeverity(Logger.Severity.DEBUG, "outfit generation has 2 items in closet");
        loggerInstance.logWithSeverity(Logger.Severity.ERROR, "support features like retrieving log history and flushing logs.");

        loggerInstance.logHistoryFile();
        loggerInstance.logHistoryFile();

        loggerInstance.archiveLogOnDemand();

        loggerInstance.outputDestinationLog(Logger.Severity.INFO + " extensible for future requirements, such as logging to a file, database, or remote server.", Logger.OutputType.console);

    }
}