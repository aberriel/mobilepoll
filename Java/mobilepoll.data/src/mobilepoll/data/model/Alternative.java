package mobilepoll.data.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import javax.persistence.*;
import org.hibernate.annotations.Type;

/**
 * Classe persistente do hibernate para alternativas das questões das pesquisas dos clientes
 * @author alira
 */
@Entity
@Table(name = "Alternativa")
public class Alternative
{
    private void doInit()
    {
        this.valid = true;
        
        if(this.answerList == null)
        {
            this.answerList = new ArrayList<Answer>();
        }
    }
    
    /** Construtor */
    public Alternative()
    {
        this.doInit();
    }
    
    /**
     * Construtor
     * @param value Valor (conteúdo) da alternativa
     */
    public Alternative(String value)
    {
        this.doInit();
        this.value = value;
    }
    
    /**
     * Construtor
     * @param question
     * @param value 
     */
    public Alternative(Question question, String value)
    {
        this.question = question;
        this.value = value;
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
    
    @Column(name = "ChavePublica", length = 64, nullable = false)
    String publicKey;
    public String getPublicKey() { return this.publicKey; }
    public void setPublicKey(String pKey) { this.publicKey = pKey; }
    
    /** Questão à qual a alternativa pertence */
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "Questao",
                nullable = false,
                foreignKey = @ForeignKey(name = "FK_Alternativa_Questao"))
    Question question;
    /** GET para a questão à qual a alternativa pertence */
    public Question getQuestion() { return this.question; }
    /** SET para a questão à qual a alternativa pertence */
    public void setQuestion(Question question) { this.question = question; }
    
    /**
     * Número da alternativa.
     * Indica a ordem em que deve ser exibida.
     */
    @Column(name = "Numero", nullable = false)
    int number;
    /** GET para o número da alternativa. */
    public int getNumber() { return this.number = number; }
    /** SET para o número da alternativa */
    public void setNumber(int number) { this.number = number; }
    
    /** Valor (conteúdo) da alternativa */
    @Column(name = "ValorAlternativa", columnDefinition = "TEXT", nullable = true)
    String value;
    /** GET para o valor (conteúdo) da alternativa */
    public String getValue() { return value; }
    /** SET para o valor (conteúdo) da alternativa */
    public void setValue(String value) { this.value = value; }
    
    /** Questão seguinte a ser exibida, no caso da escolha dessa alternativa */
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "ProximaQuestao",
                nullable = true,
                foreignKey = @ForeignKey(name = "FK_Alternativa_QuestaoProxima"))
    Question nextQuestion;
    /** GET para a questão seguinte a ser exibida no caso da escolha dessa alternativa */
    public Question getNextQuestion() { return this.nextQuestion; }
    /** SET para a questão seguinte a ser exibida no caso da escolha dessa alternativa */
    public void setNextQuestion(Question question) { this.nextQuestion = question; }
    
    /**
     * Flag de justificativa obrigatória.
     * 
     * No caso do entrevistado selecionar esta alternativa, seja na múltipla
     * escolha ou escolha simples, sempre que essa alternativa for selecionada, 
     * no confirmação da questão, a justificativa será pedida
     */
    @Column(name = "JustificativaObrigatoria",
            columnDefinition = "TINYINT",
            length = 1,
            nullable = true)
    @Type(type = "org.hibernate.type.NumericBooleanType")
    boolean reasonRequired;
    /** GET para o flag de justificativa obrigatória */
    public boolean isReasonRequired() { return this.reasonRequired; }
    /** SET para o flag de justificativa obrigatória */
    public void setReasonRequired(boolean isRequired) { this.reasonRequired = isRequired; }
    
    /**
     * Id de operação pendente no registro.
     * O id de operação pendente permite o controle das operações relativas a este registro
     * entre o servidor e o dispositivo móvel
     */
    @Column(name = "IdOperacaoPendente", nullable = true)
    Integer pendantOperationId;
    /** GET para o id de operação pendente no registro */
    public Integer getPendantOperationId() { return this.pendantOperationId; }
    /** SET para o id de operação pendente no registro */
    public void setPendantOperationId(Integer id) { this.pendantOperationId = id; }
    
    /** Data e hora da criação do registro no banco */
    @Column(name = "DataHoraRegistro", nullable = false, columnDefinition = "datetime")
    @Temporal(TemporalType.TIMESTAMP)
    Date registerDateTime;
    /** GET para a data e hora da criação do registro no banco */
    public Date getRegisterDateTime() { return this.registerDateTime; }
    /** SET para a data e hora da criação do registro no banco */
    public void setRegisterDateTime(Date dateTime) { this.registerDateTime = dateTime; }
    
    /** Data e hora da última atualização no registro */
    @Column(name = "DataHoraUltimaAtualizacao", nullable = false, columnDefinition = "datetime")
    @Temporal(TemporalType.TIMESTAMP)
    Date lastUpdateDateTime;
    /** GET para a data e hora da última atualização no registro */
    public Date getLastUpdateDateTime() { return this.lastUpdateDateTime; }
    /** SET para a data e hora da última atualização no registro */
    public void setLastUpdateDateTime(Date dateTime) { this.lastUpdateDateTime = dateTime; }
    
    /** Flag de registro válido */
    @Column(name = "Valido", columnDefinition = "TINYINT", length = 1, nullable = false)
    @Type(type = "org.hibernate.type.NumericBooleanType")
    boolean valid;
    /** GET para o flag de registro válido */
    public boolean isValid() { return valid; }
    /** SET para o flag de registro válido */
    public void setValid(boolean isValid) { this.valid = isValid; }
    
    /** Respostas que contêm esta alternativa */
    @ManyToMany(mappedBy = "alternativeList",
                fetch = FetchType.LAZY)
    List<Answer> answerList;
    /** GET para a lista de respostas que contêm esta alternativa */
    public List<Answer> getAnswerList() { return this.answerList; }
    /** SET para a lista de respostas que contêm esta alternativa */
    public void setAnswerList(List<Answer> aList) { this.answerList = aList; }
    
    @PrePersist
    private void onSave()
    {
        if(this.registerDateTime == null)
        {
            this.registerDateTime = new Date();
        }
        
        if(this.publicKey == null || this.publicKey.isEmpty())
        {
            this.publicKey = UUID.randomUUID().toString();
        }
        
        this.lastUpdateDateTime = new Date();
    }
}
