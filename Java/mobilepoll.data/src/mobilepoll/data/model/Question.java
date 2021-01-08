package mobilepoll.data.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import org.hibernate.annotations.Type;

/**
 * Classe persistente para questões das pesquisas registradas no sistema
 * @author alira
 */
@Entity
@Table(name = "Questao")
public class Question
{
    private void doInit()
    {
        if(this.alternativeList == null)
        {
            this.alternativeList = new ArrayList<Alternative>();
        }
        
        if(this.answerList == null)
        {
            this.answerList = new ArrayList<Answer>();
        }
        
        // Por padrão, a questão é sempre obrigatória
        this.required = true;
        // Por padrão, não exigirei justificativa
        this.reasonRequired = false;
    }
    
    /** Construtor */
    public Question()
    {
        this.doInit();
    }
    
    /**
     * Construtor
     * @param statement Enunciado da questão
     */
    public Question(String statement)
    {
        this.doInit();
        this.statement = statement;
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
    
    /** Pesquisa à qual a questão pertence */
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "Pesquisa",
                nullable = false,
                foreignKey = @ForeignKey(name = "FK_Questao_Pesquisa"))
    Research research;
    /** GET para a pesquisa à qual a questão pertence */
    public Research getResearch() { return research; }
    /** SET para a pesquisa à qual a questão pertence */
    public void setResearch(Research research) { this.research = research; }
    
    /** Enunciado da questão */
    @Column(name = "Enunciado", columnDefinition = "TEXT", nullable = false)
    String statement;
    /** GET para o enunciado da questão */
    public String getStatement() { return statement; }
    /** SET para o enunciado da questão */
    public void setStatement(String questionStatement) { this.statement = questionStatement; }
    
    /** Tipo de resposta a ser dada à questão */
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "TipoDeResposta",
                nullable = true,
                foreignKey = @ForeignKey(name = "FK_Questao_TipoResposta"))
    AnswerType responseType;
    /** GET para o tipo de resposta a ser dada à questão */
    public AnswerType getResponseType() { return responseType; }
    /** SET para o tipo de resposta a ser dada à questão */
    public void setResponseType(AnswerType rType) { this.responseType = rType; }
    
    /**
     * Número da questão.
     * Indica a ordem em que a questão deve aparecer
     */
    @Column(name = "NumeroQuestao", nullable = false)
    int questionNumber;
    /** GET para o número da questão */
    public int getQuestionNumber() { return this.questionNumber; }
    /** SET para o número da questão */
    public void setQuestionNumber(int qNumber) { this.questionNumber = qNumber; }
    
    /**
     * Flag para questão de resposta obrigatória
     * A questão pode ser opcional. Neste caso, uma alternativa padrão deve ser fornecida.
     */
    @Column(name = "QuestaoObrigatoria", columnDefinition = "TINYINT", length = 1, nullable = false)
    @Type(type = "org.hibernate.type.NumericBooleanType")
    boolean required;
    /** GET para o flag de questão obrigatória */
    public boolean isRequired() { return required; }
    /** SET para o flag de questão obrigatória */
    public void setRequired(boolean isRequired) { this.required = isRequired; }
    
    /** Flag para questão de justificativa obrigatória */
    @Column(name = "JustificativaObrigatoria", columnDefinition = "TINYINT", length = 1, nullable = false)
    @Type(type = "org.hibernate.type.NumericBooleanType")
    boolean reasonRequired;
    /** GET para o flag de justificativa obrigatória */
    public boolean isReasonRequired() { return this.reasonRequired; }
    /** SET para o flag de justificativa obrigatória */
    public void setReasonRequired(boolean isRequired) { this.reasonRequired = isRequired; }
    
    /** Mensagem de solicitação de justificativa */
    @Column(name = "MensagemJustificativaPersonalizada", length = 300, nullable = true)
    String customReasonMessage;
    /** GET para a mensagem de solicitação de justificativa */
    public String getCustomReasonMessage() { return this.customReasonMessage; }
    /** SET para a mensagem de solicitação de justificativa */
    public void setCustomReasonMessage(String message) { this.customReasonMessage = message; }
    
    /** Máximo de alternativas que podem ser selecionadas (para questão de múltipla escolha). */
    @Column(name = "MaximoAlternativasSelecionaveis", nullable = true)
    Integer maximumSelectableAlternatives;
    /** GET para o máximo de alternativas que podem ser selecionadas */
    public Integer getMaximumSelectableAlternatives() { return this.maximumSelectableAlternatives; }
    /** SET para o máximo de alternativas que podem ser selecionadas */
    public void setMaximumSelectableAlternatives(Integer maxNumber) { this.maximumSelectableAlternatives = maxNumber; }
    
    /**
     * Alternativa padrão.
     * 
     * Para o caso do usuário não selecionar uma alternativa e a questão não ser
     * obrigatória, o sistema possibilitará pular a questão fornecendo como resposta a
     * alternativa padrão (default).
     * 
     * Assim, para o caso do usuário cadastrar a questão como sendo "não obrigatória",
     * este deverá fornecer uma alternativa padrão
     */
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "AlternativaPadrao", nullable = true)
    Alternative defaultAlternative;
    /** GET para a alternativa padrão */
    public Alternative getDefaultAlternative() { return this.defaultAlternative; }
    /** SET para a alternativa padrão */
    public void setDefaultAlternative(Alternative alternative) { this.defaultAlternative = alternative; }
    
    @Column(name = "IdOperacaoPendente", nullable = true)
    Integer pendingOperationId;
    public Integer getPendingOperationId() { return this.pendingOperationId; }
    public void setPendingOperationId(Integer id) { this.pendingOperationId = id; }
    
    /** Data e hora da criação do registro no banco */
    @Column(name = "DataHoraRegistro", nullable = false, columnDefinition = "datetime")
    @Temporal(TemporalType.TIMESTAMP)
    Date registerDateTime;
    /** GET para a data e hora da criação do registro no banco */
    public Date getRegisterDateTime() { return this.registerDateTime; }
    /** SET para a data e hora da criação do registro no banco */
    public void setRegisterDateTime(Date dateTime) { this.registerDateTime = dateTime; }
    
    /** Data e hora da últikma atualização do registro */
    @Column(name = "DataHoraUltimaAtualizacao", nullable = false, columnDefinition = "datetime")
    @Temporal(TemporalType.TIMESTAMP)
    Date lastUpdateDateTime;
    /** GET para a data e hora da última atualização no registro */
    public Date getLastUpdateDateTime() { return this.lastUpdateDateTime; }
    /** SET para a data e hora da última atualização no registro */
    public void setLastUpdateDateTime(Date dateTime) { this.lastUpdateDateTime = dateTime; }
    
    @Column(name = "DataHoraExclusao", columnDefinition = "datetime", nullable = true)
    Date deleteDateTime;
    public Date getDeleteDateTime() { return this.deleteDateTime; }
    public void setDeleteDateTime(Date dt) { this.deleteDateTime = dt; }
    
    @Column(name = "ChaveExclusao", length = 64, nullable = true)
    String deleteKey;
    public String getDeleteKey() { return this.deleteKey; }
    public void setDeleteKey(String dKey) { this.deleteKey = dKey; }
    
    /** Flag indicador de questão válida */
    @Column(name = "Valido", columnDefinition = "TINYINT", nullable = false, length = 1)
    @Type(type = "org.hibernate.type.NumericBooleanType")
    boolean valid;
    /** GET para o flag indicador de questão válida */
    public boolean isValid() { return this.valid; }
    /** SET para o flag indicador de questão válida */
    public void setValid(boolean isValid) { this.valid = isValid; }
    
    /** Alternativas desta questão */
    @OneToMany(fetch = FetchType.LAZY,
               cascade = CascadeType.ALL,
               mappedBy = "question")
    List<Alternative> alternativeList;
    /** GET para a lista de alternativas desta questão */
    public List<Alternative> getAlternativeList() { return alternativeList; }
    /** SET para a lista de alternativas desta questão */
    public void setAlternativeList(List<Alternative> aList) { this.alternativeList = aList; }
    
    /** Respostas dadas a esta questão */
    @OneToMany(fetch = FetchType.LAZY,
               cascade = CascadeType.ALL,
               mappedBy = "question")
    List<Answer> answerList;
    /** GET para a lista de respostas dadas a esta questão */
    public List<Answer> getAnswerList() { return answerList; }
    /** SET para a lista de respostas dadas a esta questão */
    public void setAnswerList(List<Answer> aList) { this.answerList = aList; }
    
    @PrePersist
    private void onSave()
    {
        if(this.registerDateTime == null)
        {
            this.registerDateTime = new Date();
        }
        
        this.lastUpdateDateTime = new Date();
    }
}
