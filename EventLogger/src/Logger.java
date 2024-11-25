public class Logger {

    private static Logger uniqueInstance; // single instance for singleton

    private Logger(){

//        empty = true;
//        boiled = false;
    }
    public static Logger getInstance() {
        if (uniqueInstance == null) {
            System.out.println("Creating new Logger instance");
            uniqueInstance = new Logger();
        }
        System.out.println("Returning instance");
        return uniqueInstance;
    }

    public void log(String log){
        System.out.println("LOG: " + log);
    }

}
