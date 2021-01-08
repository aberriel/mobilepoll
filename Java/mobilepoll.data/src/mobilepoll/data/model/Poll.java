package mobilepoll.data.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.*;

/**
 * Enquetes.
 * 
 * Cada enquete consiste em um conjunto de respostas de uma entrevista feita na rua ou online
 * @author alira
 */
@Entity
@Table(name = "enquete")
public class Poll
{
    private void doInit()
    {
        if(this.answerList == null)
        {
            this.answerList = new ArrayList<Answer>();
        }
        
        this.finishDateTime = null;
    }
    
    /** Construtor */
    public Poll()
    {
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
    
    /**
     * Local a partir do qual foi feita a enquete.
     * 
     * Como local, podemos ter Web, dispositivo móvel, etc
     */
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "OrigemEnquete", nullable = true)
    System pollOrigin;
    /** GET para o local a partir do qual foi feita a enquete */
    public System getPollOrigin() { return pollOrigin; }
    /** SET para o local a partir do qual foi feita a enquete */
    public void setPollOrigin(System origin) { this.pollOrigin = origin; }
    
    /** Entrevistador */
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "Entrevistador", nullable = true)
    User interviewer;
    /** GET para o entrevistador */
    public User getInterviewer() { return interviewer; }
    /** SET para o entrevistador */
    public void setInterviewer(User interviewer) { this.interviewer = interviewer; }
    
    /** Entrevistado */
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "Entrevistado", nullable = true)
    Interviewee interviewee;
    /** GET para o entrevistado */
    public Interviewee getInterviewee() { return interviewee; }
    /** SET para o entrevistado */
    public void setInterviewee(Interviewee i) { this.interviewee = i; }
    
    /** Endereço IP do entrevistado (para enquete respondida pela web) */
    @Column(name = "IPEntrevistado", length = 15, nullable = true)
    String intervieweeIp;
    /** GET para o endereço IP do entrevistado (para enquete respondida pela web) */
    public String getIntervieweeIp() { return intervieweeIp; }
    /** SET para o endereço IP do entrevistado (para enquete respondida pela web) */
    public void setIntervieweeIp(String ip ) { this.intervieweeIp = ip; }
    
    /** Pesquisa englobada por essa enquete */
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "Pesquisa", nullable = false)
    Research research;
    /** GET para a pesquisa englobada por essa enquete */
    public Research getResearch() { return research; }
    /** SET para a pesquisa englobada por essa enquete */
    public void setResearch(Research research) { this.research = research; }
    
    /** Data e hora do início da pesquisa */
    @Column(name = "DataHoraInicio", nullable = false, columnDefinition = "datetime")
    @Temporal(TemporalType.TIMESTAMP)
    Date initDateTime;
    /** GET para a data e hora do início da pesquisa */
    public Date getInitDateTime() { return initDateTime; }
    /** SET para a data e hora do início da pesquisa */
    public void setInitDateTime(Date dateTime) { this.initDateTime = dateTime; }
    
    /**
     * Data e hora em que foi realizada a última movimentação na enquete.
     * 
     * Como movimentação, temos:
     * 
     *      1 - Responder questão
     *      2 - Navegação entre questões
     *      3 - Inicio da enquete
     *      4 - Cancelamento da enquete
     */
    @Column(name = "DataHoraUltimaAtualizacao", nullable = false, columnDefinition = "datetime")
    @Temporal(TemporalType.TIMESTAMP)
    Date lastActivityDateTime;
    /** GET para a data e hora da última movimentação na enquete */
    public Date getLastActivityDateTime() { return lastActivityDateTime; }
    /** SET para a data e hora da última movimentação na enquete */
    public void setLastActivityDateTime(Date dateTime) { this.lastActivityDateTime = dateTime; }
    
    /** Data e hora do fim da pesquisa */
    @Column(name = "DataHoraTermino", nullable = true)
    @Temporal(TemporalType.TIMESTAMP)
    Date finishDateTime;
    /** GET para a data e hora do fim da pesquisa */
    public Date getFinishDateTime() { return finishDateTime; }
    /** SET para a data e hora dom fim da pesquisa */
    public void setFinishDateTime(Date dateTime) { this.finishDateTime = dateTime; }
    
    /** Causa do motivo do fim da enquete */
    @Column(name = "MotivoTermino")
    @Enumerated(EnumType.ORDINAL)
    SurveyFinishReason finishReason;
    /** GET para a causa do fim da enquete */
    public SurveyFinishReason getFinishReason() { return finishReason; }
    /** SET para a causa do fim da enquete */
    public void setFinishReason(SurveyFinishReason fr) { this.finishReason = fr; }
    
    /** Mensagem de erro ocorrida na enquete */
    @Column(name = "MensagemErro", nullable = true, columnDefinition = "TEXT")
    String errorMessage;
    /** GET para a mensagem de erro ocorrida na enquete */
    public String getErrorMessage() { return errorMessage; }
    /** SET para a mensagem de erro ocorrida na enquete */
    public void setErrorMessage(String msg) { this.errorMessage = msg; }
    
    /**
     * Coordenadas do local onde a enquete foi realizada
     * 
     * No caso de haver deslocamentos ao longo da enquete, será marcado somente o
     * local de início.
     */
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "DadosGps", nullable = true)
    GpsData gpsData;
    /** GET para as coordenadas do local onde a enquete foi feita */
    public GpsData getGpsData() { return gpsData; }
    /** SET para as coordenadas do local onde a enquete foi feita. */
    public void setGpsData(GpsData gd) { this.gpsData = gd; }
    
    /** Respostas desta enquete */
    @OneToMany(fetch = FetchType.LAZY,
               cascade = CascadeType.ALL,
               mappedBy = "poll")
    List<Answer> answerList;
    /** GET para a lista de respostas desta enquete */
    public List<Answer> getAnswerList() { return answerList; }
    /** SET para a lista de respostas desta enquete */
    public void setAnswerList(List<Answer> aList) { this.answerList = aList; }
    
    @PrePersist
    private void onSave()
    {
        if(this.initDateTime == null)
        {
            this.initDateTime = new Date();
        }
        
        this.lastActivityDateTime = new Date();
    }
}
