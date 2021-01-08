package mobilepoll.data.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.*;

/**
 * Áreas de atuação profissional
 * @author alira
 */
@Entity
@Table(name = "AreaAtuacao")
public class ActivityArea implements Serializable
{
    private void doInit()
    {
        if(this.inheritedActivityAreaList == null)
        {
            this.inheritedActivityAreaList = new ArrayList<ActivityArea>();
        }
        
        if(this.activityList == null)
        {
            this.activityList = new ArrayList<Activity>();
        }
    }
    
    /** Construtor */
    public ActivityArea()
    {
        this.doInit();
    }
    
    /**
     * Construtor
     * @param name Nome da área de atuação
     */
    public ActivityArea(String name)
    {
        this.doInit();
        this.name = name;
    }
    
    /** Identificador único do registro no banco */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id", nullable = false, unique = true)
    long id;
    /** GET para o identificador único do registro no banco */
    public long getId() { return id; }
    /** SET para o identificador único do registro no banco */
    public void setId(long id) { this.id = id; }
    
    /** Nome da área de atuação profissional */
    @Column(name = "Nome", length = 200, nullable = false)
    String name;
    /** GET para o nome da área de atuação profissional */
    public String getName() { return name; }
    /** SET para o nome da área de atuação profissional */
    public void setName(String name) { this.name = name; }
    
    /** Comentários e/ou observações pertinentes */
    @Column(name = "Comentarios", length = 3000, nullable = true)
    String comments;
    /** GET para os comentários e/ou observações pertinentes */
    public String getComments() { return comments; }
    /** SET para os comentários e/ou observações pertinentes */
    public void setComments(String comments) { this.comments = comments; }
    
    /** Área de atuação pai (para a árvore de áreas de atuação) */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "AreaAtuacaoPai", nullable = true)
    ActivityArea parentActivityArea;
    /** GET para a área de atuação pai (para a árvore de áreas de atuação) */
    public ActivityArea getParentActivityArea() { return this.parentActivityArea; }
    /** SET para a área de atuação pai (para a árvore de áreas de atuação) */
    public void setParentActivityArea(ActivityArea aArea) { this.parentActivityArea = aArea; }
    
    /** Data e hora de criação do registro no banco */
    @Column(name = "DataHoraRegistro", nullable = false, columnDefinition = "datetime")
    @Temporal(TemporalType.TIMESTAMP)
    Date registerDateTime;
    /** GET para a data e hora da criação do registro no banco */
    public Date getRegisterDateTime() { return registerDateTime; }
    /** SET para a data e hora da criação do registro no banco */
    public void setRegisterDateTime(Date dateTime) { this.registerDateTime = dateTime; }
    
    /** Áreas de atuação filhas */
    @OneToMany(fetch = FetchType.LAZY,
               cascade = CascadeType.ALL,
               mappedBy = "parentActivityArea",
               targetEntity = ActivityArea.class)
    List<ActivityArea> inheritedActivityAreaList;
    /** GET para a lista de áreas de atuação filhas */
    public List<ActivityArea> getInheritedActivityAreaList() { return inheritedActivityAreaList; }
    /** SET para a lista de áreas de atuação filhas */
    public void setInheritedActvityAreaList(List<ActivityArea> iaaList) { this.inheritedActivityAreaList = iaaList; }
    
    /** Atividades profissionais pertencentes a esta área de atuação */
    @OneToMany(fetch = FetchType.LAZY,
               cascade = CascadeType.ALL,
               mappedBy = "activityArea",
               targetEntity = Activity.class)
    List<Activity> activityList;
    /** GET para a lista de atividades profissionais pertencentes a esta área de atuação */
    public List<Activity> getActivityList() { return this.activityList; }
    /** SET para a lista de atividades profissionais pertencentes a esta área de atuação */
    public void setActivityList(List<Activity> aList) { this.activityList = aList; }
    
    @PrePersist
    private void onSave()
    {
        if(this.registerDateTime == null)
        {
            this.registerDateTime = new Date();
        }
    }
}