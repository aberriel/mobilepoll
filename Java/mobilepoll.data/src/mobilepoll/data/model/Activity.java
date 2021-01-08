package mobilepoll.data.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

/**
 * Ramos de atividade profissional ou funções.
 * 
 * @author alira
 */
@Entity
@Table(name = "Atividade")
public class Activity implements Serializable
{
    private void doInit()
    {
        if(this.registerDateTime == null)
        {
            this.registerDateTime = new Date();
        }
    }
    
    /** Construtor */
    public Activity()
    {
        this.doInit();
    }
    
    /**
     * Construtor
     * @param name Nome da função ou atividade profissional
     */
    public Activity(String name)
    {
        this.name = name;
        this.doInit();
    }
    
    public Activity(ActivityArea activityArea)
    {
        this.activityArea = activityArea;
        this.doInit();
    }
    
    public Activity(ActivityArea activityArea, String name)
    {
        this.activityArea = activityArea;
        this.name = name;
        this.doInit();
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
    
    /** Nome da função ou atividade profissional */
    @Column(name = "Nome", length = 200, unique = true, nullable = false)
    String name;
    /** GET para o nome da função ou atividade profissional */
    public String getName() { return name; }
    /** SET para o nome da função ou atividade profissional */
    public void setName(String name) { this.name = name; }
    
    /** Comentários e/ou observações pertinentes */
    @Column(name = "Comentarios", length = 3000, nullable = true)
    String comments;
    /** GET para os comentários e/ou observações pertinentes */
    public String getComments() { return comments; }
    /** SET para os comentários e/ou observações pertinentes */
    public void setComments(String comments) { this.comments = comments; }
    
    /** Área de atividade profissional à qual esta função pertence */
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "AreaAtuacao", nullable = false)
    ActivityArea activityArea;
    /** GET para a área de atividade profissional à qual esta função pertence */
    public ActivityArea getActivityArea() { return this.activityArea; }
    /** SET para a área de atividade profissional à qual esta função pertence */
    public void setActivityArea(ActivityArea aa) { this.activityArea = aa; }
    
    /** Data e hora da criação do registro no banco */
    @Column(name = "DataHoraRegistro", nullable = false, columnDefinition = "datetime")
    @Temporal(TemporalType.TIMESTAMP)
    Date registerDateTime;
    /** GET para a data e hora da criação do registro no banco */
    public Date getRegisterDateTime() { return registerDateTime; }
    /** SET para a data e hora da criação do registro no banco */
    public void setRegisterDateTime(Date dateTime) { this.registerDateTime = dateTime; }
    
    @PrePersist
    private void OnSave()
    {
        if(this.registerDateTime == null)
        {
            this.registerDateTime = new Date();
        }
    }
}