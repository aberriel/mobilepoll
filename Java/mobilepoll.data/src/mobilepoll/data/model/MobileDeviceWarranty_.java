package mobilepoll.data.model;

import java.util.Date;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import mobilepoll.data.model.enums.WarrantyOriginType_Tp;


@StaticMetamodel(MobileDeviceWarranty.class)
public class MobileDeviceWarranty_
{
    public static volatile SingularAttribute<MobileDeviceWarranty, Long> id;
    public static volatile SingularAttribute<MobileDeviceWarranty, String> warrantyContractNumber;
    public static volatile SingularAttribute<MobileDeviceWarranty, WarrantyOriginType_Tp> warrantyOriginType;
    public static volatile SingularAttribute<MobileDeviceWarranty, MobileDevice> mobileDevice;
    public static volatile SingularAttribute<MobileDeviceWarranty, InsuranceContract> insuranceContract;
    public static volatile SingularAttribute<MobileDeviceWarranty, Date> initDateTime;
    public static volatile SingularAttribute<MobileDeviceWarranty, Date> expectedFinishDateTime;
    public static volatile SingularAttribute<MobileDeviceWarranty, Date> realFinishDateTime;
    public static volatile SingularAttribute<MobileDeviceWarranty, String> finishReason;
    public static volatile SingularAttribute<MobileDeviceWarranty, Double> value;
    public static volatile ListAttribute<MobileDeviceWarranty, MobileDeviceInvoice> associatedMobileDeviceList;
}