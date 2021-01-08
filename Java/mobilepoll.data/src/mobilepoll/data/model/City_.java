package mobilepoll.data.model;

import java.util.Date;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;


@StaticMetamodel(City.class)
public class City_
{
    public static volatile SingularAttribute<City, Long> id;
    public static volatile SingularAttribute<City, String> name;
    public static volatile SingularAttribute<City, FederalUnity> federalUnity;
    public static volatile SingularAttribute<City, String> comments;
    public static volatile SingularAttribute<City, Date> registerDateTime;
    public static volatile ListAttribute<City, Address> addressList;
}