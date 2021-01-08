package mobilepoll.data.model;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;


@StaticMetamodel(MobileDeviceInvoice.class)
public class MobileDeviceInvoice_
{
    public static volatile SingularAttribute<MobileDeviceInvoice, Long> id;
    public static volatile SingularAttribute<MobileDeviceInvoice, Invoice> invoice;
    public static volatile SingularAttribute<MobileDeviceInvoice, MobileDevice> mobileDevice;
    public static volatile SingularAttribute<MobileDeviceInvoice, MobileDeviceWarranty> warranty;
    public static volatile SingularAttribute<MobileDeviceInvoice, String> measurementUnit;
    public static volatile SingularAttribute<MobileDeviceInvoice, Double> unitValue;
    public static volatile SingularAttribute<MobileDeviceInvoice, String> productCode;
    public static volatile SingularAttribute<MobileDeviceInvoice, Double> quantity;
    public static volatile SingularAttribute<MobileDeviceInvoice, Double> ipiAliquot;
    public static volatile SingularAttribute<MobileDeviceInvoice, Double> ipiValue;
    public static volatile SingularAttribute<MobileDeviceInvoice, Double> icmsAliquot;
    public static volatile SingularAttribute<MobileDeviceInvoice, Double> icmsCalculationBasis;
    public static volatile SingularAttribute<MobileDeviceInvoice, Double> icmsValue;
    public static volatile SingularAttribute<MobileDeviceInvoice, String> cfop;
    public static volatile SingularAttribute<MobileDeviceInvoice, String> ncm;
    public static volatile SingularAttribute<MobileDeviceInvoice, String> cst;
}