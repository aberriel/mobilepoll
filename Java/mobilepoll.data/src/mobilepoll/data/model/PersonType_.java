package mobilepoll.data.model;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;


@StaticMetamodel(PersonType.class)
public class PersonType_
{
    public static volatile SingularAttribute<PersonType, Integer> id;
    public static volatile SingularAttribute<PersonType, String> name;
    public static volatile SingularAttribute<PersonType, String> description;
}