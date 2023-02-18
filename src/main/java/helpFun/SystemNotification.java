package helpFun;

public class SystemNotification {
    private static final String ANSI_RESET = "\u001B[0m";
    private static final String ANSI_RED = "\u001B[31m";

    public static void notification(String message) {
        System.out.println(ANSI_RED + "SYSTEM_NOTIFICATION: " + ANSI_RESET + message);
    }
}