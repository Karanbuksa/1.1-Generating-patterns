import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Logger {
    protected int num = 1;
    protected Date date = new Date();
    private static Logger logger;

    private Logger() {
    }

    public void log(String msg) {
        System.out.println("[" + DateTimeFormatter.ofPattern("d.MM.yyyy hh:mm:ss")
                .format(LocalDateTime.now()) + " " + num++ + "] " + msg);
    }

    public static Logger getInstance() {
        if (logger == null) logger = new Logger();
        return logger;
    }
}
