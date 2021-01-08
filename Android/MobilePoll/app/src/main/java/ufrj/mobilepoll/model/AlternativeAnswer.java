package ufrj.mobilepoll.model;

/**
 * Created by alira on 09/10/15.
 */
public class AlternativeAnswer
{
    /** Construtor */
    public AlternativeAnswer() { }

    /** Identificador da alternativa selecionada */
    private int alternativeId;
    /** GET para o identificador da alternativa selecionada */
    public int getAlternativeId() { return alternativeId; }
    /** SET para o identificador da alternativa selecionada */
    public void setAlternativeId(int id) { this.alternativeId = id; }

    /** Alternativa selecionada */
    private Alternative alternative;
    /** GET para a alternativa selecionada */
    public Alternative getAlternative() { return alternative; }
    /** SET para a alternativa selecionada */
    public void setAlternative(Alternative alternative) { this.alternative = alternative; }

    /** Identificador da resposta à qual a alternativa foi associada */
    private int answerId;
    /** GET para o identificador da resposta à qual a alternativa foi associada. */
    public int getAnswerId() { return answerId; }
    /** SET para o identificador da resposta à qual a alternativa foi associada. */
    public void setAnswerId(int id) { this.answerId = id; }

    private Answer answer;
    public Answer getAnswer() { return answer; }
    public void setAnswer(Answer answer) { this.answer = answer; }
}