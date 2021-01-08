package mobilepoll.data.model;

import java.util.Date;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;


@StaticMetamodel(ApplicationActionType.class)
public class ApplicationActionType_
{
    public static volatile SingularAttribute<ApplicationActionType, Long> id;
    public static volatile SingularAttribute<ApplicationActionType, String> name;
    public static volatile SingularAttribute<ApplicationActionType, String> description;
    public static volatile SingularAttribute<ApplicationActionType, ObjectType> objectType;
    public static volatile SingularAttribute<ApplicationActionType, Date> registerDateTime;
    public static volatile ListAttribute<ApplicationActionType, ObjectRightType> objectRightTypeList;
}