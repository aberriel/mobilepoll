package mobilepoll.data.model;

import java.util.Date;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;


@StaticMetamodel(CommunicationControl.class)
public class CommunicationControl_
{
    public static volatile SingularAttribute<CommunicationControl, Long> id;
    public static volatile SingularAttribute<CommunicationControl, Long> remoteId;
    public static volatile SingularAttribute<CommunicationControl, Integer> operationId;
    public static volatile SingularAttribute<CommunicationControl, MobileDevice> mobileDevice;
    public static volatile SingularAttribute<CommunicationControl, Date> departureDateTime;
    public static volatile SingularAttribute<CommunicationControl, Date> incomingDateTime;
    public static volatile SingularAttribute<CommunicationControl, String> departurePackageContent;
    public static volatile SingularAttribute<CommunicationControl, String> incomingPackageContent;
    public static volatile SingularAttribute<CommunicationControl, Boolean> hasReturn;
    public static volatile SingularAttribute<CommunicationControl, String> userKey;
    public static volatile SingularAttribute<CommunicationControl, Integer> communicationDirection;
    public static volatile SingularAttribute<CommunicationControl, Boolean> processed;
    public static volatile SingularAttribute<CommunicationControl, String> errorMessage;
    public static volatile SingularAttribute<CommunicationControl, String> communicationKey;
}