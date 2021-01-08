package ufrj.mobilepoll.model;

import java.util.Date;

/**
 * Classe do modelo de dados para registro de municípios.
 * Created by alira on 08/10/15.
 */
public class City
{
    /** Construtor */
    public City() { }

    /**
     * Construtor
     * @param name Nome da cidade
     */
    public City(String name)
    {
        this.name = name;
    }

    /**
     * Construtor
     * @param name Nome da cidade
     * @param federalUnityId Id do estado ao qual a cidade pertence
     */
    public City(String name, long federalUnityId)
    {
        this.name = name;
        this.federalUnityId = federalUnityId;
    }

    /**
     * Construtor
     * @param name Nome da cidade
     * @param federalUnity Estado ao qual a cidade pertence
     */
    public City(String name, FederalUnity federalUnity)
    {
        this.name = name;
        this.federalUnity = federalUnity;
    }

    /** Identificador único do registro no banco */
    private long id;
    /** GET para o id do registro no banco */
    public long getId() { return id; }
    /** SET para o id do registro no banco */
    public void setId(long id) { this.id = id; }

    /** Nome da cidade */
    private String name;
    /** GET para o nome da cidade */
    public String getName() { return name; }
    /** SET para o nome da cidade */
    public void setName(String name) { this.name = name; }

    /** Descritivo da cidade */
    private String description;
    /** GET para o descritivo da cidade */
    public String getDescription() { return description; }
    /** SET para o descritivo da cidade */
    public void setDescription(String description) { this.description = description; }

    /** Id do estado ao qual a cidade pertence */
    private Long federalUnityId;
    /** GET para o id do estado ao qual a cidade pertence */
    public Long getFederalUnityId() { return federalUnityId; }
    /** SET para o id do estado ao qual a cidade pertence */
    public void setFederalUnityId(Long id) { this.federalUnityId = id; }

    /** Estado ao qual a cidade pertence */
    private FederalUnity federalUnity;
    /** GET para o estado ao qual a cidade pertence */
    public FederalUnity getFederalUnity() { return federalUnity; }
    /** SET para o estado ao qual a cidade pertence */
    public void setFederalUnity(FederalUnity federalUnity) { this.federalUnity = federalUnity; }

    /** Data e hora da inclusão do registro na tabela */
    private Date registerDateTime;
    /** GET para a data e hora de inclusão do registro na tabela */
    public Date getRegisterDateTime() { return registerDateTime; }
    /** SET para a data e hora de inclusão do registro na tabela */
    public void setRegisterDateTime(Date dateTime) { this.registerDateTime = dateTime; }
}