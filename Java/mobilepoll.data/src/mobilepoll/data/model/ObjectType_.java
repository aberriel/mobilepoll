package mobilepoll.data.model;

import java.util.Date;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;


@StaticMetamodel(ObjectType.class)
public class ObjectType_
{
    public static volatile SingularAttribute<ObjectType, Long> id;
    public static volatile SingularAttribute<ObjectType, String> name;
    public static volatile SingularAttribute<ObjectType, String> description;
    public static volatile SingularAttribute<ObjectType, Integer> literalIdentifier;
    public static volatile SingularAttribute<ObjectType, Date> registerDateTime;
    public static volatile ListAttribute<ObjectType, ApplicationActionType> actionTypeList;
    public static volatile ListAttribute<ObjectType, ObjectRightType> objectRightTypeList;
    public static volatile ListAttribute<ObjectType, Right> rightList;
}