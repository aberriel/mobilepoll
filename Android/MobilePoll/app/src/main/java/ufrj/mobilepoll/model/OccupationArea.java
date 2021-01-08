package ufrj.mobilepoll.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe do modelo de dados para áreas de atuação profissional, que agregam atividades profissionais
 * Created by alira on 09/10/15.
 */
public class OccupationArea
{
    /** Inicializa atributos e variáveis da classe */
    private void InitFields()
    {
        this.nestedOccupationAreaList = new ArrayList<OccupationArea>();
        this.businessList = new ArrayList<Business>();
    }

    /** Construtor */
    public OccupationArea()
    {
        InitFields();
    }

    /**
     * Construtor
     * @param name Nome da área de atividade profissional
     */
    public OccupationArea(String name)
    {
        InitFields();
        this.name = name;
    }

    public OccupationArea(String name, OccupationArea parentOccupationArea)
    {
        InitFields();
        this.name = name;
        this.parentOccuparionArea = parentOccupationArea;
    }

    /** Identificador único do registro no banco */
    private int id;
    /** GET para o id do registro no banco */
    public int getId() { return id; }
    /** SET para o id do registro no banco */
    public void setId(int id) { this.id = id; }

    /** Nome da área de atuação profissional */
    private String name;
    /** GET para o nome da área de atuação profissional */
    public String getName() { return name; }
    /** SET para o nome da área de atuação profissional */
    public void setName(String name) { this.name = name; }

    /** Descritivo da área de atuação profissional */
    private String description;
    /** GET para a área de atuação profissional */
    public String getDescription() { return description; }
    /** SET para a área de atuação profissional */
    public void setDescription(String description) { this.description = description; }

    private OccupationArea parentOccuparionArea;
    public OccupationArea getParentOccuparionArea() { return parentOccuparionArea; }
    public void setParentOccuparionArea(OccupationArea parentOccuparionArea) { this.parentOccuparionArea = parentOccuparionArea; }

    private List<OccupationArea> nestedOccupationAreaList;
    public List<OccupationArea> getNestedOccupationAreaList() { return nestedOccupationAreaList; }
    public void setNestedOccupationAreaList(List<OccupationArea> list) { this.nestedOccupationAreaList = list; }
    public void addOccupationAreaToNestesOccupationAreaList(OccupationArea area)
    {
        this.nestedOccupationAreaList.add(area);
    }

    /** Atividades profissionais pertencentes a esta área de atuação */
    private List<Business> businessList;
    /** GET para a listagem de atividades profissionais pertencentes a esta área */
    public List<Business> getBusinessList() { return businessList; }
    /** SET para a listagem de atividades profissionais pertencentes a esta área. */
    public void setBusinessList(List<Business> list) { this.businessList = list; }
    public void addBusinessToBusinessList(Business business)
    {
        businessList.add(business);
    }
}