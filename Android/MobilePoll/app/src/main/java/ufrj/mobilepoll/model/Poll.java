package ufrj.mobilepoll.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Classe do modelo de dados para enquetes, propriamente ditas.
 * Created by alira on 09/10/15.
 */
public class Poll
{
    private void InitializeFields()
    {
        this.answerList = new ArrayList<Answer>();
    }

    /** Construtor */
    public Poll() { }

    /** Identificador único do registro no banco */
    private long id;
    /** GET para o identificador único do registro no banco */
    public long getId() { return id; }
    /** SET para o identificador único do registro no banco */
    public void setId(long id) { this.id = id; }

    /** Identificador da pesquisa que foi executada */
    private long researchId;
    /** GET para o identificador da pesquisa que foi executada */
    public long getResearchId() { return researchId; }
    /** SET para o identificador da pesquisa que foi executada */
    public void setResearchId(long id) { this.researchId = id; }

    /** Pesquisa que foi executada */
    private Research research;
    /** GET para a pesquisa que foi executada */
    public Research getResearch() { return research; }
    /** SET para a pesquisa que foi executada */
    public void setResearch(Research research) { this.research = research; }

    /** Identificador do entrevistador */
    private long interviewerId;
    /** GET para o identificador do entrevistador no banco */
    public long getInterviewerId() { return interviewerId; }
    /** SET para o identificador do entrevistador no banco */
    public void setInterviewerId(long id) { this.interviewerId = id; }

    /** Entrevistador */
    private User interviewer;
    /** GET para o entrevistador */
    public User getInterviewer() { return interviewer; }
    /** SET para o entrevistador */
    public void setInterviewer(User interviewer) { this.interviewer = interviewer; }

    /** Identificador do entrevistado no banco */
    private long interviewedId;
    /** GET para o identificador do entrevistado no banco */
    public long getInterviewedId() { return interviewedId; }
    /** SET para o identificador do entrevistado no banco */
    public void setInterviewedId(long id) { this.interviewedId = id; }

    /** Entrevistado */
    private Interviewed interviewed;
    /** GET para o entrevistado */
    public Interviewed getInterviewed() { return interviewed; }
    /** SET para o entrevistado */
    public void setInterviewed(Interviewed interviewed) { this.interviewed = interviewed; }

    private long gpsDataId;
    public long getGpsDataId() { return gpsDataId; }
    public void setGpsDataId(long id) { this.gpsDataId = id; }

    private GpsData gpsData;
    public GpsData getGpsData() { return gpsData; }
    public void setGpsData(GpsData data) { this.gpsData = data; }

    /** Data e hora de início da execução da enquete */
    private Date initDatetime;
    /** GET para a data e hora de início da execução da enquete */
    public Date getInitDatetime() { return initDatetime; }
    /** SET para a data e hora de início da execução da enquete. */
    public void setInitDatetime(Date dateTime) { this.initDatetime = dateTime; }

    /** Data e hora da última ação realizada na enquete */
    private Date lastActivityDatetime;
    /** GET para a data e hora da última ação realizada na enquete */
    public Date getLastActivityDatetime() { return lastActivityDatetime; }
    /** SET para a data e hora da última ação realizada na enquete */
    public void setLastActivityDatetime(Date dateTime) { this.lastActivityDatetime = dateTime ;}

    /** Data e hora de término de execução da enquete */
    private Date finishDatetime;
    /** GET para a data e hora do término da execução da enquete */
    public Date getFinishDatetime() { return finishDatetime; }
    /** SET para a data e hora do término da execução da enquete */
    public void setFinishDatetime(Date dateTime) { this.finishDatetime = dateTime; }

    /** Chave pública identificadora da enquete */
    private String pollKey;
    /** GET para a chave pública identificadora da enquete */
    public String getPollKey() { return pollKey; }
    /** SET para a chave pública identificadora da enquete */
    public void setPollKey(String key) { this.pollKey = key; }

    /** Causa do término da enquete */
    private String finishPollReason;
    /** GET para a causa do término da enquete */
    public String getFinishPollReason() { return finishPollReason; }
    /** SET para a causa do término da enquete */
    public void setFinishPollReason(String reason) { this.finishPollReason = reason; }

    /** Listagem de respostas associadas a esta enquete */
    private List<Answer> answerList;
    /** GET para a listagem de respostas associadas a esta enquete */
    public List<Answer> getAnswerList() { return answerList; }
    /** SET para a listagem de respostas associadas e esta pergunta */
    public void setAnswerList(List<Answer> list) { this.answerList = list; }
    public void addAnswerToAnswerList(Answer answer)
    {
        this.answerList.add(answer);
    }
}