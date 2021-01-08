package mobilepoll.data.model;

import java.util.Date;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;


/** Classe estática de metadados do hibernate para unidades federativas */
@StaticMetamodel(FederalUnity.class)
public class FederalUnity_
{
    /** Identificador único do registro no banco */
    public static volatile SingularAttribute<FederalUnity, Long> id;
    /** Nome da unidade federativa */
    public static volatile SingularAttribute<FederalUnity, String> name;
    /** Sigla da unidade federativa */
    public static volatile SingularAttribute<FederalUnity, String> abbreviation;
    /** Comentários e/ou observações pertinentes */
    public static volatile SingularAttribute<FederalUnity, String> comments;
    /** Data e hora da criação do registro no banco */
    public static volatile SingularAttribute<FederalUnity, Date> registerDateTime;
    /** Municípios pertencentes a esta unidade federativa */
    public static volatile ListAttribute<FederalUnity, City> cities;
    /** Documentos de identificação emitidos nesta unidade federativa */
    public static volatile ListAttribute<FederalUnity, IdentityDocument> identityDocumentList;
    /** Títulos de eleitor emitidos nesta unidade federativa */
    public static volatile ListAttribute<FederalUnity, BallotTitle> ballotTitleList;
}