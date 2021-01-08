package ufrj.mobilepoll.model;

import java.util.Date;

/**
 * Classe do modelo de dados para respostas de questões
 * Created by alira on 09/10/15.
 */
public class Answer
{
    /** Construtor */
    public Answer() { }

    /** Identificador único do registro no banco */
    private long id;
    /** GET para o identificador único do registro no banco */
    public long getId() { return id; }
    /** SET para o identificador único do registro no banco */
    public void setId(long id) { this.id = id; }

    /** Id da questão à qual a resposta corresponde */
    private long questionId;
    /** GET para o id da questão à qual a resposta corresponde */
    public long getQuestionId() { return questionId; }
    /** SET para o id da questão à qual a resposta corresponde */
    public void setQuestionId(long id) { this.questionId = id; }

    /** Questão à qual a resposta corresponde. */
    private Question question;
    /** GET para a questão à qual a resposta corresponde */
    public Question getQuestion() { return question; }
    /** SET para a questão à qual a resposta corresponde */
    public void setQuestion(Question question) { this.question = question; }

    private String textualResponse;
    public String getTextualResponse() { return textualResponse; }
    public void setTextualResponse(String response) { this.textualResponse = response; }

    /** Justificativa à resposta dada */
    private String explanation;
    /** GET para a justificativa à resposta dada */
    public String getExplanation() { return explanation; }
    /** SET para a justificativa à resposta dada */
    public void setExplanation(String explanation) { this.explanation = explanation; }

    private long pollId;
    public long getPollId() { return pollId; }
    public void setPollId(long id) { this.pollId = id; }

    private Poll poll;
    public Poll getPoll() { return poll; }
    public void setPoll(Poll poll) { this.poll = poll; }

    private long gpsDataId;
    public long getGpsDataId() { return gpsDataId; }
    public void setGpsDataId(long gpsDataId) { this.gpsDataId = gpsDataId; }

    /** Dados GPS da localização no momento em que a resposta foi coletada */
    private GpsData gpsData;
    public GpsData getGpsData() { return gpsData; }
    public void setGpsData(GpsData data) { this.gpsData = data; }

    /** Data e hora em que a resposta foi coletada */
    private Date registerDateTime;
    /** GET para a data e hora em que a resposta foi coletada */
    public Date getRegisterDateTime() { return registerDateTime; }
    /** SET para a data e hora em que a resposta foi coletada */
    public void setRegisterDateTime(Date dateTime) { this.registerDateTime = dateTime; }
}