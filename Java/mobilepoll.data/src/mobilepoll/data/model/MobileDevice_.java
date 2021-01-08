package mobilepoll.data.model;

import java.util.Date;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;


@StaticMetamodel(MobileDevice.class)
public class MobileDevice_
{
    /** Identificador único do registro no banco */
    public static volatile SingularAttribute<MobileDevice, Long> id;
    /** Chave pública identificadora do dispositivo móvel */
    public static volatile SingularAttribute<MobileDevice, String> key;
    /** Cliente dono do dispositivo móvel */
    public static volatile SingularAttribute<MobileDevice, Client> client;
    /** Modelo do dispositivo móvel */
    public static volatile SingularAttribute<MobileDevice, Model> mobileDeviceModel;
    /** Tipo do dispositivo móvel (se tablet, smartphone, etc) */
    public static volatile SingularAttribute<MobileDevice, MobileDeviceType> mobileDeviceType;
    /** Número da nota de compra do dispositivo */
    public static volatile SingularAttribute<MobileDevice, String> taxInvoiceNumber;
    /** Número de série (IMEI) do dispositivo */
    public static volatile SingularAttribute<MobileDevice, String> imei;
    /** Descritivo dos tipos de rede suportadas */
    public static volatile SingularAttribute<MobileDevice, String> supportedNetworkList;
    public static volatile SingularAttribute<MobileDevice, User> owner;
    /** Data e hora do registro do dispositivo no banco */
    public static volatile SingularAttribute<MobileDevice, Date> registerDateTime;
    public static volatile SingularAttribute<MobileDevice, MobileDeviceInvoice> invoiceData;
    public static volatile ListAttribute<MobileDevice, GpsData> gpsDataList;
    public static volatile ListAttribute<MobileDevice, Research> researchs;
    public static volatile ListAttribute<MobileDevice, CommunicationControl> communicationControlList;
    public static volatile ListAttribute<MobileDevice, MobileDeviceWarranty> warrantyList;
    public static volatile ListAttribute<MobileDevice, MobileDeviceInsurance> mobileDeviceInsuranceList;
}