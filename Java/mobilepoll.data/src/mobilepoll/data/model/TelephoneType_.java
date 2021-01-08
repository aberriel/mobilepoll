package mobilepoll.data.model;

import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;


@StaticMetamodel(TelephoneType.class)
public class TelephoneType_
{
    public static volatile SingularAttribute<TelephoneType, Long> id;
    public static volatile SingularAttribute<TelephoneType, String> name;
    public static volatile SingularAttribute<TelephoneType, String> comments;
    public static volatile SingularAttribute<TelephoneType, String> fullIconPath;
    public static volatile ListAttribute<TelephoneType, Telephone> telephones;
}