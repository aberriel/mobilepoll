package ufrj.mobilepoll.model;

/**
 * Classe do modelo de dados para campos de identificação exigidos em pesquisas
 * Created by alira on 09/10/15.
 */
public class MandatoryIdentifierField
{
    /** Construtor */
    public MandatoryIdentifierField() { }

    /** Identificador único do registro no banco */
    private long id;
    /** GET para o id do registro no banco */
    public long getId() { return id; }
    /** SET para o id do registro no banco */
    public void setId(long id) { this.id = id; }

    /** Nome do campo identificador exigido */
    private String name;
    /** GET para o nome do campo identificador */
    public String getName() { return name; }
    /** SET para o nome do campo identificador */
    public void setName(String name) { this.name = name; }

    /** Id da pesquisa à qual o campo identificador se aplica */
    private long researchId;
    /** GET para o id da pesquisa à qual o campo identificador se aplica */
    public long getResearchId() { return researchId; }
    /** SET para o id da pesquisa à qual o campo identificador se aplica */
    public void setResearchId(long id) { this.researchId = id; }

    /** Pesquisa à qual o campo identificador se aplica */
    private Research research;
    /** GET para a pesquisa à qual o campo identificador se aplica */
    public Research getResearch() { return research; }
    /** SET para a pesquisa à qual o campo identificador se aplica */
    public void setResearch(Research research) { this.research = research; }
}