package mobilepoll.utils.log;

import java.io.FileInputStream;
import java.util.Properties;
import mobilepoll.config.AppConfig;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

/**
 *
 * @author anselmolira
 */
public class LoggingCapsule
{
    private static Logger logger = Logger.getLogger("globo");
    
    public static void configureLogger()
    {
        try
        {
            AppConfig appConfig = new AppConfig();
            String logConfigFile = appConfig.getLoggerConfigFile();
            Properties p = new Properties();
            p.load(new FileInputStream(logConfigFile));
            PropertyConfigurator.configure(p);
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
    }
    
    public static void trace(String message)
    {
        LoggingCapsule.configureLogger();
        logger.trace(message);
    }
    
    public static void trace(String message, Throwable t)
    {
        LoggingCapsule.configureLogger();
        logger.trace(message, t);
    }
    
    public static void debug(String message)
    {
        LoggingCapsule.configureLogger();
        logger.debug(message);
    }
    
    public static void debug(String message, Throwable t)
    {
        LoggingCapsule.configureLogger();
        logger.debug(message, t);
    }
    
    public static void info(String message)
    {
        LoggingCapsule.configureLogger();
        logger.info(message);
    }
    
    public static void info(String message, Throwable t)
    {
        LoggingCapsule.configureLogger();
        logger.info(message, t);
    }
    
    public static void warn(String message)
    {
        LoggingCapsule.configureLogger();
        logger.warn(message);
    }
    
    public static void warn(String message, Throwable t)
    {
        LoggingCapsule.configureLogger();
        logger.warn(message, t);
    }
    
    public static void error(String message)
    {
        LoggingCapsule.configureLogger();
        logger.error(message);
    }
    
    public static void error(String message, Throwable t)
    {
        LoggingCapsule.configureLogger();
        logger.error(message, t);
    }
    
    public static void fatal(String message)
    {
        LoggingCapsule.configureLogger();
        logger.fatal(message);
    }
    
    public static void fatal(String message, Throwable t)
    {
        LoggingCapsule.configureLogger();
        logger.fatal(message, t);
    }
}