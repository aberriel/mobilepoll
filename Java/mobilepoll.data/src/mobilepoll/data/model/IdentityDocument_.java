package mobilepoll.data.model;

import java.util.Date;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;


/** Classe estática de metadados do hibernate para documentos de identificação de pessoas */
@StaticMetamodel(IdentityDocument.class)
public class IdentityDocument_
{
    /** Identificador único do registro no banco */
    public static volatile SingularAttribute<IdentityDocument, Long> id;
    /** Número do documento de identidade */
    public static volatile SingularAttribute<IdentityDocument, String> number;
    /** Nome da instituição emissora */
    public static volatile SingularAttribute<IdentityDocument, String> issuingInstitution;
    /** Unidade federativa onde o documento foi emitido */
    public static volatile SingularAttribute<IdentityDocument, FederalUnity> issuingState;
    /** Data de emissão do documento */
    public static volatile SingularAttribute<IdentityDocument, Date> issuingDate;
    /** Pessoa dona do documento */
    public static volatile SingularAttribute<IdentityDocument, Persona> persona;
}