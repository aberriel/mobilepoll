package mobilepoll.data.model;

import java.util.Date;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;


@StaticMetamodel(ManufacturerTechnicalAssistance.class)
public class ManufacturerTechnicalAssistance_
{
    public static volatile SingularAttribute<ManufacturerTechnicalAssistance, Long> id;
    public static volatile SingularAttribute<ManufacturerTechnicalAssistance, MobileDeviceTechnicalAssistance> technicalAssistance;
    public static volatile SingularAttribute<ManufacturerTechnicalAssistance, MobileDeviceManufacturer> manufacturer;
    public static volatile SingularAttribute<ManufacturerTechnicalAssistance, String> workedModels;
    public static volatile SingularAttribute<ManufacturerTechnicalAssistance, String> comments;
    public static volatile SingularAttribute<ManufacturerTechnicalAssistance, Date> associationDateTime;
}