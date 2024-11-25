public class Main {
    public static void main(String[] args) {

        Logger loggerInstance = Logger.getInstance();
        loggerInstance.log("Error");
        loggerInstance.log("warning ");

        loggerInstance.logWithSeverity("info", "extensible for future requirements, such as logging to a file, database, or remote server.");
        loggerInstance.logWithSeverity("debug", "outfit generation has 2 items in closet");
        loggerInstance.logWithSeverity("error", "support features like retrieving log history and flushing logs.");


    }
}