package mobilepoll.data.model;

import java.util.Date;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;


@StaticMetamodel(MobileDeviceType.class)
public class MobileDeviceType_
{
    /** Identificador único do registro no banco */
    public static volatile SingularAttribute<MobileDeviceType, Long> id;
    /** Nome do tipo de dispositivo móvel */
    public static volatile SingularAttribute<MobileDeviceType, String> name;
    /** DEscritivo do tipo de dispositivo móvel */
    public static volatile SingularAttribute<MobileDeviceType, String> description;
    public static volatile SingularAttribute<MobileDeviceType, System> system;
    /** Data e hora da criação do registro no banco */
    public static volatile SingularAttribute<MobileDeviceType, Date> registerDateTime;
    /** Dispositivos móveis que pertencem a este tipo */
    public static volatile ListAttribute<MobileDeviceType, MobileDevice> mobileDeviceList;
}