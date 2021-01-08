package mobilepoll.data.model;

import java.util.Date;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;


@StaticMetamodel(LogApp.class)
public class LogApp_
{
    public static volatile SingularAttribute<LogApp, Long> id;
    public static volatile SingularAttribute<LogApp, String> description;
    public static volatile SingularAttribute<LogApp, System> system;
    public static volatile SingularAttribute<LogApp, String> ip;
    public static volatile SingularAttribute<LogApp, Date> registerDateTime;
    public static volatile SingularAttribute<LogApp, String> userLogin;
    public static volatile SingularAttribute<LogApp, String> module;
    public static volatile SingularAttribute<LogApp, String> className;
    public static volatile SingularAttribute<LogApp, String> method;
    public static volatile SingularAttribute<LogApp, String> parameters;
    public static volatile SingularAttribute<LogApp, String> urlSourceFile;
    public static volatile SingularAttribute<LogApp, String> sourceFileLineNumber;
    public static volatile SingularAttribute<LogApp, Long> applicationActionType;
    public static volatile SingularAttribute<LogApp, String> sqlCode;
    public static volatile SingularAttribute<LogApp, String> exceptionType;
    public static volatile SingularAttribute<LogApp, String> capturedException;
    public static volatile SingularAttribute<LogApp, String> usedWebBrowser;
    public static volatile SingularAttribute<LogApp, String> source;
}
