package mobilepoll.data.model;

import java.util.Date;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import mobilepoll.data.model.enums.RightScope_Tp;


@StaticMetamodel(Right.class)
public class Right_
{
    public static volatile SingularAttribute<Right, Long> id;
    public static volatile SingularAttribute<Right, UserGroup> userGroup;
    public static volatile SingularAttribute<Right, User> user;
    public static volatile SingularAttribute<Right, ObjectType> objectType;
    public static volatile SingularAttribute<Right, RightScope_Tp> rightScope;
    public static volatile SingularAttribute<Right, Integer> totalRecordLimit;
    public static volatile SingularAttribute<Right, Integer> objectRight;
    public static volatile SingularAttribute<Right, Boolean> valid;
    public static volatile SingularAttribute<Right, Date> registerDateTime;
}