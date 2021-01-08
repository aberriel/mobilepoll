package mobilepoll.data.model;

import java.util.Date;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;


/** Classe estática de metadados do hibernate para notas fiscais de dispositivos móveis */
@StaticMetamodel(Invoice.class)
public class Invoice_
{
    /** Identificador único do registro no banco */
    public static volatile SingularAttribute<Invoice, Long> id;
    /** Cliente que adquiriu o dispositivo */
    public static volatile SingularAttribute<Invoice, Client> client;
    /** Empresa que vendeu o dispositivo e emitiu a nota */
    public static volatile SingularAttribute<Invoice, MobileDeviceProvider> provider;
    /** Número da nota */
    public static volatile SingularAttribute<Invoice, String> invoiceNumber;
    /** Número do protocolo de autorização para emissão da nota */
    public static volatile SingularAttribute<Invoice, String> usageAuthorizationProtocol;
    /** Data e hora da emissão da nota */
    public static volatile SingularAttribute<Invoice, Date> dateTime;
    public static volatile ListAttribute<Invoice, MobileDeviceInvoice> associatedMobileDeviceList;
}