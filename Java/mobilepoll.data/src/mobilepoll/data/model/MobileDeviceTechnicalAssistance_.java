package mobilepoll.data.model;

import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;


@StaticMetamodel(MobileDeviceTechnicalAssistance.class)
public class MobileDeviceTechnicalAssistance_
{
    public static volatile SingularAttribute<MobileDeviceTechnicalAssistance, Client> client;
    public static volatile ListAttribute<MobileDeviceTechnicalAssistance, ManufacturerTechnicalAssistance> associatedManufacturerList;
    public static volatile ListAttribute<MobileDeviceTechnicalAssistance, MaintenanceData> maintenanceDataList;
}
