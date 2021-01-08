package mobilepoll.data.model;

import java.util.Date;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import mobilepoll.data.model.enums.Gender_Tp;
import mobilepoll.data.model.enums.MaritalStatus_Tp;
import mobilepoll.data.model.enums.PersonType_Tp;

/**
 *
 * @author alira
 */
@StaticMetamodel(Persona.class)
public class Persona_
{
    /** Identificador único do registro no sistema */
    public static volatile SingularAttribute<Persona, Long> id;
    /** Nome da pessoa (se for pessoa jurpidica, será o nome fantasia) */
    public static volatile SingularAttribute<Persona, String> name;
    /** Nome abreviado */
    public static volatile SingularAttribute<Persona, String> shortName;
    /** E-mail principal */
    public static volatile SingularAttribute<Persona, String> primaryEmail;
    /** E-mail alternativo */
    public static volatile SingularAttribute<Persona, String> secondaryEmail;
    /** Documento de identificação da pessoa (RG, passaporte, etc) */
    public static volatile SingularAttribute<Persona, IdentityDocument> identityDocument;
    /** Número do CPF */
    public static volatile SingularAttribute<Persona, String> cpf;
    /** Número do CNPJ */
    public static volatile SingularAttribute<Persona, String> cnpj;
    /** Razão social (somente pessoa jurídicao */
    public static volatile SingularAttribute<Persona, String> corporateName;
    /** Inscrição estadual */
    public static volatile SingularAttribute<Persona, String> stateInscription;
    /** Inscrição municipal */
    public static volatile SingularAttribute<Persona, String> municipalInscription;
    /** Título eleitoral (somente pessoa física */
    public static volatile SingularAttribute<Persona, BallotTitle> ballotTitle;
    /** Sexo */
    public static volatile SingularAttribute<Persona, Gender_Tp> gender;
    /** Estado civil */
    public static volatile SingularAttribute<Persona, MaritalStatus_Tp> maritalStatus;
    /** Data de nascimento */
    public static volatile SingularAttribute<Persona, Date> birthday;
    /** Tipo da pessoa (física ou jurídica) */
    public static volatile SingularAttribute<Persona, PersonType_Tp> personType;
    /** Chave pública identificadora da pessoa */
    public static volatile SingularAttribute<Persona, String> personKey;
    /** Flag indicador de registro válido */
    public static volatile SingularAttribute<Persona, Boolean> isValid;
    /** Código de ativação da conta da pessoa */
    public static volatile SingularAttribute<Persona, String> activationKey;
    /** Data e hora em que a conta foi ativada */
    public static volatile SingularAttribute<Persona, Date> activationDate;
    /** Data e hora da criação do registro no banco */
    public static volatile SingularAttribute<Persona, Date> registerDateTime;
    /** Data e hora da última atualização do registro */
    public static volatile SingularAttribute<Persona, Date> lastUpdateDateTime;
    /** Data e hora da exclusão da pessoa do sistema */
    public static volatile SingularAttribute<Persona, Date> deleteDateTime;
    public static volatile SingularAttribute<Persona, String> deleteKey;
    public static volatile SingularAttribute<Persona, String> registerNumber;
    public static volatile SingularAttribute<Persona, String> comments;
    /** Endereços da pessoa */
    public static volatile ListAttribute<Persona, Address> addresses;
    /** Telefones da pessoa */
    public static volatile ListAttribute<Persona, Telephone> telephones;
    public static volatile ListAttribute<Persona, MaintenanceData> retiredDevices;
    public static volatile ListAttribute<Persona, MaintenanceData> returnedDevices;
    public static volatile ListAttribute<Persona, MaintenanceData> repairedDevices;
    public static volatile ListAttribute<Persona, AuditingData> performedAudits;
}
