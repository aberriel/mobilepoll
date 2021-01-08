package mobilepoll.data.model;

import java.util.Date;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;


@StaticMetamodel(ServerAddressType.class)
public class ServerAddressType_
{
    /** Identificador único do registro no banco */
    public static volatile SingularAttribute<ServerAddressType, Long> id;
    public static volatile SingularAttribute<ServerAddressType, String> name;
    public static volatile SingularAttribute<ServerAddressType, String> description;
    public static volatile SingularAttribute<ServerAddressType, String> format;
    public static volatile SingularAttribute<ServerAddressType, Date> registerDateTime;
    public static volatile SingularAttribute<ServerAddressType, User> owner;
    public static volatile ListAttribute<ServerAddressType, EmailData> emailConfigurationDataList;
}