package ufrj.mobilepoll.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe do modelo de dados para atividades profissionais
 * Created by alira on 09/10/15.
 */
public class Business
{
    private void InitializeFields()
    {

    }

    /** Construtor */
    public Business() { }

    /** Identificador único do registro no banco */
    private long id;
    /** GET para o id do registro no banco */
    public long getId() { return id; }
    /** SET para o id do registro no banco */
    public void setId(long id) { this.id = id; }

    /** Nome da atividade profissional */
    private String name;
    /** GET para o nome da atividade profissional */
    public String getName() { return name; }
    /** SET para o nome da atividade profissional */
    public void setName(String name) { this.name = name; }

    /** Descritivo da atividade profissional */
    private String description;
    /** GET para o descritivo da atividade profissional */
    public String getDescription() { return description; }
    /** SET para o descritivo da atividade profissional */
    public void setDescription(String description) { this.description = description; }

    /** Id da área de atuação à qual a atividade profissional pertence */
    private long occupationAreaId;
    /** GET para o id da área de atuação à qual a atividade profissional pertence */
    public long getOccupationAreaId() { return occupationAreaId; }
    /** SET para o id da área de atuação à qual a atividade profissional pertence */
    public void setOccupationAreaId(long id) { this.occupationAreaId = id; }

    /** Área de atuação à qual a atividade profissional pertence */
    private OccupationArea occupationArea;
    /** GET para a área de atuação à qual a atividade profissional pertence */
    public OccupationArea getOccupationArea() { return occupationArea; }
    /** SET para a área de atuação à qual a atividade profissional pertence */
    public void setOccupationArea(OccupationArea area) { this.occupationArea = area; }

    private List<Interviewed> interviewedList;
    public List<Interviewed> getInterviewedList() { return interviewedList; }
    public void setInterviewedList(List<Interviewed> list) { this.interviewedList = list; }
    public void AddInterviewedToList(Interviewed interviewed)
    {
        this.interviewedList.add(interviewed);
    }
}