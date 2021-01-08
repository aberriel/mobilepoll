package mobilepoll.data.model;

import java.util.Date;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;


@StaticMetamodel(System.class)
public class System_
{
    public static volatile SingularAttribute<System, Long> id;
    public static volatile SingularAttribute<System, String> name;
    public static volatile SingularAttribute<System, String> description;
    public static volatile SingularAttribute<System, Boolean> mobile;
    public static volatile SingularAttribute<System, String> systemKey;
    public static volatile SingularAttribute<System, String> fullIconPath;
    public static volatile SingularAttribute<System, Date> registerDateTime;
    public static volatile ListAttribute<System, LogApp> applicationLogList;
    public static volatile ListAttribute<System, LogDB> databaseLogList;
    public static volatile ListAttribute<System, GlobalConfiguration> globalConfigurationList;
    public static volatile ListAttribute<System, ClientConfiguration> clientConfigurationList;
    public static volatile ListAttribute<System, MobileDeviceType> mobileDeviceTypeList;
    public static volatile ListAttribute<System, Resource> resourceList;
    public static volatile ListAttribute<System, SessionManager> sessionList;
}