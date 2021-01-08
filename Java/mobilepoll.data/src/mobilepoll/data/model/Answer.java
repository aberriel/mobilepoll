package mobilepoll.data.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Classe persistente do hibernate para respostas das questões
 * @author alira
 */
@Entity
@Table(name = "Resposta")
public class Answer
{
    private void doInit()
    {
        if(this.alternativeList == null)
        {
            this.alternativeList = new ArrayList<Alternative>();
        }
    }
    
    public Answer()
    {
        this.doInit();
    }
    
    /** Identificador único do registro no banco */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id", unique = true, nullable = false)
    long id;
    /** GET para o identificador único do registro no banco */
    public long getId() { return id; }
    /** SET para o identificador único do registro no banco */
    public void setId(long id) { this.id = id; }
    
    /** Enquete à qual a resposta pertence */
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "Enquete",
                nullable = false,
                foreignKey = @ForeignKey(name = "FK_Resposta_Enquete"))
    Poll poll;
    /** GET para a enquete à qual a resposta pertence */
    public Poll getPoll() { return poll; }
    /** SET para a enquete à qual a resposta pertence */
    public void setPoll(Poll poll) { this.poll = poll; }
    
    /** Questão à qual a resposta pertence */
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "Questao",
                nullable = false,
                foreignKey = @ForeignKey(name = "FK_Resposta_Questao"))
    Question question;
    /** GET para a questão à qual a resposta pertence */
    public Question getQuestion() { return question; }
    /** SET para a questão à qual a resposta pertence */
    public void setQuestion(Question question) { this.question = question; }
    
    /** Resposta textual */
    @Column(name = "RespostaTextual", columnDefinition = "TEXT", nullable = true)
    String textualAnswer;
    /** GET para a resposta textual */
    public String getTextualAnswer() { return this.textualAnswer; }
    /** SET para a resposta textual */
    public void setTextualAnswer(String tAnswer) { this.textualAnswer = tAnswer; }
    
    /** Justificativa à resposta dada (quando for exigido */
    @Column(name = "JustificativaResposta", columnDefinition = "TEXT", nullable = true)
    String reasonForAnswer;
    /** GET para a justificativa à resposta dada (quando for exigido) */
    public String getReasonForAnswer() { return this.reasonForAnswer; }
    /** SET para a justificativa à resposta dada (quando for exigido) */
    public void setReasonForAnswer(String reason) { this.reasonForAnswer = reason; }
    
    /** Data e hora da submissão da resposta */
    @Column(name = "DataHora", nullable = false, columnDefinition = "datetime")
    @Temporal(TemporalType.TIMESTAMP)
    Date dateTime;
    /** GET para a data e hora da submissão da resposta */
    public Date getDateTime() { return dateTime; }
    /** SET para a data e hora da submissão da resposta */
    public void setDateTime(Date dateTime) { this.dateTime = dateTime; }
    
    /**
     * Coordenadas do local onde a resposta foi coletada
     * 
     * Faz mais sentido em enquete realizada na rua, onde pode ser interessante
     * saber o local onde a entrevista foi feita.
     */
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "DadosGps",
                nullable = true,
                foreignKey = @ForeignKey(name = "FK_Resposta_DadosGps"))
    GpsData gpsData;
    /** GET para as coordenadas do local onde a resposta foi coletada */
    public GpsData getGpsData() { return this.gpsData; }
    /** SET para as coordenadas do local onde a resposta foi coletada
    public void setGpsData(GpsData gd) { this.gpsData = gd; }
    
    /** Alternativas selecionadas para esta resposta */
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "AlternativaResposta", catalog = "enquetemobile",
               joinColumns =
                       {
                           @JoinColumn(name = "Resposta",
                                       nullable = false)
                       },
               inverseJoinColumns =
                       {
                           @JoinColumn(name = "Alternativa",
                                       nullable = false)
                       })
    List<Alternative> alternativeList;
    /** GET para as alternativas selecionadas para esta resposta */
    public List<Alternative> getAlternativeList() { return alternativeList; }
    /** SET para as alternativas selecionadas para esta resposta */
    public void setAlternativeList(List<Alternative> aList) { this.alternativeList = aList; }
}
