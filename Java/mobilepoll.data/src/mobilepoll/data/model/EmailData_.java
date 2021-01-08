package mobilepoll.data.model;

import java.util.Date;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;


@StaticMetamodel(EmailData.class)
public class EmailData_
{
    public static volatile SingularAttribute<EmailData, Long> id;
    public static volatile SingularAttribute<EmailData, String> name;
    public static volatile SingularAttribute<EmailData, String> description;
    public static volatile SingularAttribute<EmailData, String> login;
    public static volatile SingularAttribute<EmailData, String> password;
    public static volatile SingularAttribute<EmailData, Boolean> ssl;
    public static volatile SingularAttribute<EmailData, ServerAddressType> smtpServerAddressType;
    public static volatile SingularAttribute<EmailData, String> smtpServerAddress;
    public static volatile SingularAttribute<EmailData, String> portNumber;
    public static volatile SingularAttribute<EmailData, Date> registerDateTime;
    public static volatile SingularAttribute<EmailData, Date> invalidationDateTime;
    public static volatile ListAttribute<EmailData, GlobalConfiguration> globalConfigurationList;
}