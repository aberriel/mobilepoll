package mobilepoll.data.model;

import java.util.Date;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import mobilepoll.data.model.enums.OperationTypeDB_Tp;


@StaticMetamodel(LogDB.class)
public class LogDB_
{
    public static volatile SingularAttribute<LogDB, Long> id;
    public static volatile SingularAttribute<LogDB, Date> dateTime;
    public static volatile SingularAttribute<LogDB, String> dbUser;
    public static volatile SingularAttribute<LogDB, String> systemUser;
    public static volatile SingularAttribute<LogDB, System> system;
    public static volatile SingularAttribute<LogDB, String> tableName;
    public static volatile SingularAttribute<LogDB, Long> registerId;
    public static volatile SingularAttribute<LogDB, String> oldValues;
    public static volatile SingularAttribute<LogDB, String> newValues;
    public static volatile SingularAttribute<LogDB, OperationTypeDB_Tp> operationTypeInDatabase;
}