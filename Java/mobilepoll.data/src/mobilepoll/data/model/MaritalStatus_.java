package mobilepoll.data.model;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;


@StaticMetamodel(MaritalStatus.class)
public class MaritalStatus_
{
    public static volatile SingularAttribute<MaritalStatus, Integer> id;
    public static volatile SingularAttribute<MaritalStatus, String> name;
    public static volatile SingularAttribute<MaritalStatus, String> description;
}