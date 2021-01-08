package mobilepoll.data.model;

import java.util.Date;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;


@StaticMetamodel(AddressType.class)
public class AddressType_
{
    public static volatile SingularAttribute<AddressType, Long> id;
    public static volatile SingularAttribute<AddressType, String> name;
    public static volatile SingularAttribute<AddressType, String> fullIconPath;
    public static volatile SingularAttribute<AddressType, String> comments;
    public static volatile SingularAttribute<AddressType, Date> registerDateTime;
}