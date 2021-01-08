package mobilepoll.data.model;

import java.util.Date;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;


@StaticMetamodel(Address.class)
public class Address_
{
    public static volatile SingularAttribute<Address, Long> id;
    public static volatile SingularAttribute<Address, AddressType> addressType;
    public static volatile SingularAttribute<Address, String> street;
    public static volatile SingularAttribute<Address, String> number;
    public static volatile SingularAttribute<Address, String> complement;
    public static volatile SingularAttribute<Address, String> neighborhood;
    public static volatile SingularAttribute<Address, City> city;
    public static volatile SingularAttribute<Address, String> zipCode;
    public static volatile SingularAttribute<Address, Persona> persona;
    public static volatile SingularAttribute<Address, String> comments;
    public static volatile SingularAttribute<Address, Boolean> mainAddress;
    public static volatile SingularAttribute<Address, Date> registerDateTime;
}