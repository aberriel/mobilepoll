package mobilepoll.data.model;

import java.util.*;
import javax.persistence.metamodel.*;

@StaticMetamodel(GpsData.class)
public class GpsData_
{
    public static volatile SingularAttribute<GpsData, Long> id;
    public static volatile SingularAttribute<GpsData, Long> remoteId;
    public static volatile SingularAttribute<GpsData, Float> latitude;
    public static volatile SingularAttribute<GpsData, Float> longitude;
    public static volatile SingularAttribute<GpsData, MobileDevice> mobileDevice;
    public static volatile SingularAttribute<GpsData, Date> registerDateTime;
    public static volatile SingularAttribute<GpsData, Date> dataGatheringDateTime;
}
