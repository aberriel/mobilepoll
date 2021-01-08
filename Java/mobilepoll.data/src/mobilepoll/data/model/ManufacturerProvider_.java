package mobilepoll.data.model;

import java.util.Date;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;


@StaticMetamodel(ManufacturerProvider.class)
public class ManufacturerProvider_
{
    public static volatile SingularAttribute<ManufacturerProvider, Long> id;
    public static volatile SingularAttribute<ManufacturerProvider, MobileDeviceManufacturer> mobileDeviceManufacturer;
    public static volatile SingularAttribute<ManufacturerProvider, MobileDeviceProvider> mobileDeviceProvider;
    public static volatile SingularAttribute<ManufacturerProvider, Date> associationDateTime;
}