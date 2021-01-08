package ufrj.mobilepoll.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe do modelo de dados para tipo de resposta que pode ser dada
 * Created by alira on 09/10/15.
 */
public class AnswerType
{
    private void InitializeFields()
    {
        this.questionList = new ArrayList<Question>();
    }

    /** Construtor */
    public AnswerType()
    {
        InitializeFields();
    }

    public AnswerType(String name)
    {
        InitializeFields();
        this.name = name;
    }

    public AnswerType(String name, int graphicComponentId)
    {
        InitializeFields();
        this.name = name;
        this.graphicComponentId = graphicComponentId;
    }

    /** Identificador único do registro no banco */
    private int id;
    /** GET para o identificador único do registro no banco */
    public int getId() { return id; }
    /** SET para o identificador único do registro no banco */
    public void setId(int id) { this.id = id; }

    /** Nome do tipo de resposta de questão */
    private String name;
    /** GET para o nome do tipo de resposta */
    public String getName() { return name; }
    /** SET para o nome do tipo de resposta */
    public void setName(String name) { this.name = name; }

    /** Componnete gráfico a ser desenhado na tela */
    private int graphicComponentId;
    /** GET para o componente gráfico a ser desenhado.
    public int getGraphicComponentId() { return graphicComponentId; }
     /** SET para o componente gráfico a ser desenhado na tela */
    public void setGraphicComponentId(int id) { this.graphicComponentId = id; }

    /** Flag indicativo da possibilidade de seleção de mais de uma alternativa. */
    private boolean allowMultipleAnswer;
    /** GET para o flag indicador da possibilidade de seleção de mais de uma alternativa. */
    public boolean isAllowMultipleAnswer() { return allowMultipleAnswer; }
    /** SET para o flag indicador da possibilidade de seleção de mais de uma alternativa. */
    public void setAllowMultipleAnswer(boolean allow) { this.allowMultipleAnswer = allow; }

    /** Listagem de questões que possuem este tipo de resposta */
    private List<Question> questionList;
    /** GET para a listagem de questões que possuem este tipo de resposta. */
    public List<Question> getQuestionList() { return questionList; }
    /** SET para a listagem de questões que possuem este tipo de resposta. */
    public void setQuestionList(List<Question> list) { this.questionList = list; }

    /**
     * Adiciona questão à lista de questões que possuem este tipo de resposta
     * @param question Questão a ser adicionada
     */
    public void addQuestionToQuestionList(Question question)
    {
        this.questionList.add(question);
    }
}