package ufrj.mobilepoll.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe do modelo de dados para pesquisas
 * Created by alira on 09/10/15.
 */
public class Research
{
    /** Inicialização dos atributos e variáveis da classe */
    private void InitializeFields()
    {
        this.mandatoryIdentifierFieldList = new ArrayList<MandatoryIdentifierField>();
        this.questionList = new ArrayList<Question>();
        this.pollList = new ArrayList<Poll>();
    }

    /** Construtor */
    public Research()
    {
        InitializeFields();
    }

    /**
     * Construtor
     * @param name Nome da pesquisa
     */
    public Research(String name)
    {
        InitializeFields();
        this.name = name;
    }

    /**
     * Construtor
     * @param name Nome da pesquisa
     * @param researchGroupId Id da categoria à qual a pesquisa pertence
     */
    public Research(String name, long researchGroupId)
    {
        InitializeFields();
        this.name = name;
        this.researchGroupId = researchGroupId;
    }

    /** Identificador único do registro no banco */
    private long id;
    /** GET para o id do registro no banco */
    public long getId() { return id; }
    /** SET para o id do registro no banco */
    public void setId(long id) { this.id = id; }

    /** Nome da pesquisa */
    private String name;
    /** GET para o nome da pesquisa */
    public String getName() { return name; }
    /** SET para o nome da pesquisa */
    public void setName(String name) { this.name = name; }

    /** Descritivo da pesquisa */
    private String description;
    /** GET para o descritivo da pesquisa */
    public String getDescription() { return description; }
    /** SET para o descritivo da pesquisa */
    public void setDescription(String description) { this.description = description; }

    /** Id da categoria à qual esta pesquisa pertence */
    private long researchGroupId;
    /** GET para o id da categoria à qual esta pesquisa pertence */
    public long getResearchGroupId() { return researchGroupId; }
    /** SET para o id da categoria à qual esta pesquisa pertence */
    public void setResearchGroupId(long id) { this.researchGroupId = id; }

    /** Categoria à qual esta pesquisa pertence */
    private ResearchGroup researchGroup;
    /** GET para a categoria à qual esta pesquisa pertence */
    public ResearchGroup getResearchGroup() { return researchGroup; }
    /** SET para a categoria à qual esta pesquisa pertence */
    public void setResearchGroup(ResearchGroup group) { this.researchGroup = group; }

    private List<MandatoryIdentifierField> mandatoryIdentifierFieldList;
    public List<MandatoryIdentifierField> getMandatoryIdentifierFieldList() { return mandatoryIdentifierFieldList; }
    public void setMandatoryIdentifierFieldList(List<MandatoryIdentifierField> list) { this.mandatoryIdentifierFieldList = list; }
    public void addMandatoryFieldToMandatoryFieldList(MandatoryIdentifierField identifierField)
    {
        this.mandatoryIdentifierFieldList.add(identifierField);
    }

    /** Questões pertencentes a esta pesquisa */
    private List<Question> questionList;
    /** GET para a lista de questões pertencentes a esta pesquisa */
    public List<Question> getQuestionList() { return questionList; }
    /** SET para a lista de questões pertencentes a esta pesquisa */
    public void setQuestionList(List<Question> list) { this.questionList = list; }
    public void addQuestionToQuestionList(Question question)
    {
        this.questionList.add(question);
    }

    /** Listagem de execuções desta pesquisa (enquetes) */
    private List<Poll> pollList;
    /** GET para a listagem de execuções desta pesquisa (enquetes) */
    public List<Poll> getPollList() { return pollList; }
    /** SET para a listagem de execuções desta pesquisa (enquetes) */
    public void setPollList(List<Poll> list) { this.pollList = list; }
    /** Adiciona enquete ao array de execuções desta pesquisa */
    public void addPollToPollList(Poll poll)
    {
        this.pollList.add(poll);
    }
}