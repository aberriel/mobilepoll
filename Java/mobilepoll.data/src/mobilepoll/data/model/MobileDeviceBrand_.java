package mobilepoll.data.model;

import java.util.Date;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;


@StaticMetamodel(MobileDeviceBrand.class)
public class MobileDeviceBrand_
{
    public static volatile SingularAttribute<MobileDeviceBrand, Long> id;
    public static volatile SingularAttribute<MobileDeviceBrand, String> name;
    public static volatile SingularAttribute<MobileDeviceBrand, MobileDeviceManufacturer> mobileDeviceManufacturer;
    public static volatile SingularAttribute<MobileDeviceBrand, String> comments;
    public static volatile SingularAttribute<MobileDeviceBrand, Date> registerDateTime;
    public static volatile ListAttribute<MobileDeviceBrand, Model> mobileDeviceModelList;
}