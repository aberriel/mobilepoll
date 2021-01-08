package mobilepoll.data.model;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;


@StaticMetamodel(WarrantyOriginType.class)
public class WarrantyOriginType_
{
    public static volatile SingularAttribute<WarrantyOriginType, Integer> id;
    public static volatile SingularAttribute<WarrantyOriginType, String> name;
    public static volatile SingularAttribute<WarrantyOriginType, String> description;
}