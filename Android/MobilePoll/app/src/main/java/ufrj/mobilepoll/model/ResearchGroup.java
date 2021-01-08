package ufrj.mobilepoll.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Classe do modelo de dados para grupos ou categorias de pesquisa
 * Created by alira on 09/10/15.
 */
public class ResearchGroup
{
    private void InitializeFields()
    {
        this.researchList = new ArrayList<Research>();
    }

    /** Construtor */
    public ResearchGroup()
    {
        InitializeFields();
    }

    /**
     * Construtor
     * @param name Nome da categoria de pesquisa
     */
    public ResearchGroup(String name)
    {
        InitializeFields();
        this.name = name;
    }

    /**
     * Construtor
     * @param name Nome da categoria de pesquisa
     * @param description Descritivo da categoria de pesquisa
     */
    public ResearchGroup(String name, String description)
    {
        InitializeFields();
        this.name = name;
        this.description = description;
    }

    /** Identificador único do registro no banco */
    private long id;
    /** GET para o id do registro no banco */
    public long getId() { return id; }
    /** SET para o id do registro no banco */
    public void setId(long id) { this.id = id; }

    /** Nome do grupo ou categoria de pesquisa */
    private String name;
    /** GET para o nome do grupo ou categoria de pesquisa */
    public String getName() { return name; }
    /** SET para o nome do grupo ou categoria de pesquisa */
    public void setName(String name) { this.name = name; }

    /** Descritivo do grupo ou categoria de pesquisa */
    private String description;
    /** GET para o descritivo do grupo ou categoria de pesquisa */
    public String getDescription() { return description; }
    /** SET para o descritivo do grupo ou categoria de pesquisa */
    public void setDescription(String description) { this.description = description; }

    /** Data e hora da inserção do registro na tabela */
    private Date registerDateTime;
    /** GET para a data e hora de inserção do registro na tabela */
    public Date getRegisterDateTime() { return registerDateTime; }
    /** SET para a data e hora de inserção do registro n atabela */
    public void setRegisterDateTime(Date dateTime) { this.registerDateTime = dateTime; }

    /** Pesquisas pertencentes a este grupo ou categoria */
    private List<Research> researchList;
    /** GET para a listagem de pesquisas pertencentes a este grupo ou categoria */
    public List<Research> getResearchList() { return researchList; }
    /** SET para a listagem de pesquisas pertencentes a este grupo ou categoria */
    public void setResearchList(List<Research> list) { this.researchList = list; }

    /**
     * Adiciona pesquisa à listagem de pesquisas pertencentes ao grupo ou categoria
     * @param research Pesquisa a ser adicionada ao conjunto de pesquisas desta categoria
     */
    public void addResearchToResearchList(Research research)
    {
        this.researchList.add(research);
    }
}