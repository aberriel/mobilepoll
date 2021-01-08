package mobilepoll.data.model;

import java.util.Date;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;


@StaticMetamodel(ClientConfiguration.class)
public class ClientConfiguration_
{
    public static volatile SingularAttribute<ClientConfiguration, Long> id;
    public static volatile SingularAttribute<ClientConfiguration, System> system;
    public static volatile SingularAttribute<ClientConfiguration, Client> client;
    public static volatile SingularAttribute<ClientConfiguration, Date> registerDateTime;
    public static volatile SingularAttribute<ClientConfiguration, Date> invalidationDateTime;
    public static volatile SingularAttribute<ClientConfiguration, Date> passwordExpirationPeriod;
    public static volatile SingularAttribute<ClientConfiguration, Date> toleranceToResponsePoll;
    public static volatile SingularAttribute<ClientConfiguration, Date> toleranceWithoutMovement;
}