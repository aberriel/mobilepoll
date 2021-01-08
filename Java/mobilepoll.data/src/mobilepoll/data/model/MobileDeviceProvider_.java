package mobilepoll.data.model;

import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;


@StaticMetamodel(MobileDeviceProvider.class)
public class MobileDeviceProvider_
{
    public static volatile SingularAttribute<MobileDeviceProvider, String> webPage;
    public static volatile SingularAttribute<MobileDeviceProvider, Client> client;
    public static volatile ListAttribute<MobileDeviceProvider, ManufacturerProvider> associatedManufacturerList;
    public static volatile ListAttribute<MobileDeviceProvider, Invoice> invoiceList;
}