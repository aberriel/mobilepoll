package mobilepoll.data.model;

import java.util.Date;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;


@StaticMetamodel(Model.class)
public class Model_
{
    /** Identificador único do registro no banco */
    public static volatile SingularAttribute<Model, Long> id;
    /** Nome do modelo de dispositivo móvel */
    public static volatile SingularAttribute<Model, String> name;
    /** Fabricante ao qual pertence este model */
    public static volatile SingularAttribute<Model, MobileDeviceBrand> mobileDeviceBrand;
    /** Especificações técnicas do modelo */
    public static volatile SingularAttribute<Model, String> technicalSpecifications;
    /** Lista de redes suportadas */
    public static volatile SingularAttribute<Model, String> supportedNetworkList;
    public static volatile SingularAttribute<Model, String> webPage;
    public static volatile SingularAttribute<Model, String> comments;
    /** Data e hora da criação do registro no banco */
    public static volatile SingularAttribute<Model, Date> registerDateTime;
    public static volatile ListAttribute<Model, MobileDevice> mobileDeviceList;
}