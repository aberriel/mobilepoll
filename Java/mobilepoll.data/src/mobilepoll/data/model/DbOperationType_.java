package mobilepoll.data.model;

import java.util.Date;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;


@StaticMetamodel(DbOperationType.class)
public class DbOperationType_
{
    public static volatile SingularAttribute<DbOperationType, Integer> id;
    public static volatile SingularAttribute<DbOperationType, String> name;
    public static volatile SingularAttribute<DbOperationType, String> description;
    public static volatile SingularAttribute<DbOperationType, Date> registerDateTime;
}