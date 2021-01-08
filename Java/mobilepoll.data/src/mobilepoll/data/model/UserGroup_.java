package mobilepoll.data.model;

import java.util.Date;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;


@StaticMetamodel(UserGroup.class)
public class UserGroup_
{
    public static volatile SingularAttribute<UserGroup, Long> id;
    public static volatile SingularAttribute<UserGroup, String> name;
    public static volatile SingularAttribute<UserGroup, String> description;
    public static volatile SingularAttribute<UserGroup, Boolean> systemGroup;
    public static volatile SingularAttribute<UserGroup, Date> registerDateTime;
    public static volatile SingularAttribute<UserGroup, Date> lastActionDateTime;
    public static volatile ListAttribute<UserGroup, User> userList;
    public static volatile ListAttribute<UserGroup, Right> rightList;
}