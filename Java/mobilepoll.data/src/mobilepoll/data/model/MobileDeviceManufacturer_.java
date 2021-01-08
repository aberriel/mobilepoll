package mobilepoll.data.model;

import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;


@StaticMetamodel(MobileDeviceManufacturer.class)
public class MobileDeviceManufacturer_
{
    public static volatile SingularAttribute<MobileDeviceManufacturer, String> webPage;
    public static volatile ListAttribute<MobileDeviceManufacturer, MobileDeviceBrand> mobileDeviceBrandList;
    public static volatile ListAttribute<MobileDeviceManufacturer, ManufacturerProvider> associatedProviderList;
    public static volatile ListAttribute<MobileDeviceManufacturer, ManufacturerTechnicalAssistance> associatedTechnicalAssistanceList;
}