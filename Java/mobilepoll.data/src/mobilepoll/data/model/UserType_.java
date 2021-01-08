package mobilepoll.data.model;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;


@StaticMetamodel(UserType.class)
public class UserType_
{
    public static volatile SingularAttribute<UserType, Long> id;
    public static volatile SingularAttribute<UserType, String> name;
    public static volatile SingularAttribute<UserType, String> description;
}