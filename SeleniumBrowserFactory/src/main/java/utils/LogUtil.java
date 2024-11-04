package utils;

import java.io.IOException;
import java.util.logging.*;

public class LogUtil {
    private static Logger logger = null;
    private static FileHandler fileHandler = null;

    public static void setUpLog() {
        LogManager.getLogManager().reset();
        logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
        try {
            fileHandler = new FileHandler("src/main/resources/testLog.log");
            fileHandler.setLevel(Level.ALL);
            fileHandler.setFormatter(new SimpleFormatter());
            logger.addHandler(fileHandler);
        } catch (IOException e) {
            logger.log(Level.SEVERE, "File logger not working");
        }
    }

    public static void makeLog(final String message, String name) {
        logger.info(message + " : " + name);
    }

    public static void makeLog(final String message) {
        logger.info(message);
    }

    public static void tearDownLog() {
        fileHandler.close();
    }
}
