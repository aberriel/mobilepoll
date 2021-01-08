package ufrj.mobilepoll.model;

/**
 * Classe do modelo de dados para alternativas de questões.
 * Created by alira on 09/10/15.
 */
public class Alternative
{
    private void initFields()
    {
        this.requiredExplanation = false;
    }

    /** Construtor */
    public Alternative()
    {
        initFields();
    }

    /** Identificador único do registro no banco */
    private long id;
    /** GET para o identificador único do registro no banco */
    public long getId() { return id; }
    /** SET para o identificador único do registro no banco */
    public void setId(long id) { this.id = id; }

    /** Id da questão à qual a alternativa pertence */
    private long questionId;
    /** GET para o id da questão à qual a alternativa pertence */
    public long getQuestionId() { return questionId; }
    /** SET para o id da questão à qual a alternativa pertence */
    public void setQuestionId(long id) { this.questionId = id; }

    /** Questão à qual a alternativa pertence */
    private Question question;
    /** GET para a questão à qual a alternativa pertence */
    public Question getQuestion() { return question; }
    /** SET para a questão à qual a alterntiva pertence */
    public void setQuestion(Question question) { this.question = question; }

    private String number;
    public String getNumber() { return number; }
    public void setNumber(String number) { this.number = number; }

    /** Valor (conteúdo) da alternativa */
    private String value;
    /** GET para o conteúdo da laternativa */
    public String getValue() { return value; }
    /** SET para o conteúdo da alternativa */
    public void setValue(String value) { this.value = value; }

    private Long nextQuestionId;
    public Long getNextQuestionId() { return nextQuestionId; }
    public void setNextQuestionId(Long id) { this.nextQuestionId = id; }

    private Question nextQuestion;
    public Question getNextQuestion() { return nextQuestion; }
    public void setNextQuestion(Question question) { this.nextQuestion = question; }

    /** Flag indicador da necessidade de justificativa para seleção de resposta redonda. */
    private boolean requiredExplanation;
    /** GET para o flag indicador de requisição de justificativa */
    public boolean isRequiredExplanation() { return requiredExplanation; }
    /** SET para o flag indicador de requisição de justificativa */
    public void setRequiredExplanation(boolean required) { this.requiredExplanation = required; }
}