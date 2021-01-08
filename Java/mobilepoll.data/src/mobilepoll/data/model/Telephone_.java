package mobilepoll.data.model;

import java.util.Date;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;


@StaticMetamodel(Telephone.class)
public class Telephone_
{
    public static volatile SingularAttribute<Telephone, Long> id;
    public static volatile SingularAttribute<Telephone, String> countryCode;
    public static volatile SingularAttribute<Telephone, String> cityCode;
    public static volatile SingularAttribute<Telephone, String> number;
    public static volatile SingularAttribute<Telephone, String> extension;
    public static volatile SingularAttribute<Telephone, Persona> persona;
    public static volatile SingularAttribute<Telephone, TelephoneType> type;
    public static volatile SingularAttribute<Telephone, Date> registerDateTime;
    public static volatile SingularAttribute<Telephone, String> comments;
}