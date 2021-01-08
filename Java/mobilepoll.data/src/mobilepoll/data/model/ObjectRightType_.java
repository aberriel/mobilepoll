package mobilepoll.data.model;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;


@StaticMetamodel(ObjectRightType.class)
public class ObjectRightType_
{
    public static volatile SingularAttribute<ObjectRightType, Long> id;
    public static volatile SingularAttribute<ObjectRightType, String> name;
    public static volatile SingularAttribute<ObjectRightType, String> description;
    public static volatile SingularAttribute<ObjectRightType, ObjectType> objectType;
    public static volatile SingularAttribute<ObjectRightType, ApplicationActionType> applicationActionType;
    public static volatile SingularAttribute<ObjectRightType, Integer> literalIdentifier;
}