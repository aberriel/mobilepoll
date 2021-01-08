package ufrj.mobilepoll.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe do modelo de dados para questões das pesquisas
 * Created by alira on 09/10/15.
 */
public class Question
{
    private void InitializeFields()
    {
        this.alternativeList = new ArrayList<Alternative>();
    }

    /** Construtor */
    public Question() { }

    /** Identificador único do registro no banco */
    private long id;
    /** GET para o id do registro no banco */
    public long getId() { return id; }
    /** SET para o id do registro no banco */
    public void setId(long id) { this.id = id; }

    /** Id da pesquisa à qual a questão pertence */
    private long researchId;
    /** GET para o id da pesquisa à qual a questão pertence */
    public long getResearchId() { return researchId; }
    /** SET para o id da pesquisa à qual a questão pertence */
    public void setResearchId(long id) { this.researchId = id; }

    /** Pesquisa à qual a questão pertence */
    private Research research;
    /** GET para a pesquisa à qual a questão pertence */
    public Research getResearch() { return research; }
    /** SET para a pesquisa à qual a questão pertence */
    public void setResearch(Research research) { this.research = research; }

    /** Enunciado da questão */
    private String statement;
    /** GET para o enunciado da questão */
    public String getStatement() { return statement; }
    /** SET para o enunciado da questão */
    public void setStatement(String statement) { this.statement = statement; }

    /** Número da questão (indica a ordem em que deve aparecer) */
    private String number;
    /** GET para o número da questão */
    public String getNumber() { return number; }
    /** SET para o número da questão */
    public void setNumber(String number) { this.number = number; }

    /** Id do tipo de resposta a ser dada nesta questão */
    private long answerTypeId;
    /** GET para o id do tipo de resposta a ser dada nesta questão */
    public long getAnswerTypeId() { return answerTypeId; }
    /** SET para o id do tipo de resposta a ser dada nesta questão */
    public void setAnswerTypeId(long id) { this.answerTypeId = id; }

    /** Tipo de resposta a ser dada nesta questão */
    private AnswerType answerType;
    /** GET para o tipo de resposta a ser dada nesta questão */
    public AnswerType getAnswerType() { return answerType; }
    /** SET para o tipo de resposta a ser dada nesta questão */
    public void setAnswerType(AnswerType type) { this.answerType = type; }

    /** Flag indicador de resposta obrigatória */
    private boolean requiredQuestion;
    /** GET para o flag indicador de resposta obrigatória */
    public boolean isRequiresQuestion() { return requiredQuestion; }
    /** SET para o flag indicador de resposta obrigatória */
    public void setRequiredQuestion(boolean required) { this.requiredQuestion = required; }

    /** Flag indicador de justificativa obrigatória */
    private boolean requiredExplanation;
    /** GET para o flag indicador de justificativa obrigatória */
    public boolean isRequiredExplanation() { return requiredExplanation; }
    /** SET para o flag indicador de justificativa obrigatória */
    public void setRequiredExplanation(boolean required) { this.requiredExplanation = required; }

    /** Flag indicador da possibilidade de seleção de mais de uma alternativa para a resposta. */
    private boolean allowMultipleAnswer;
    /** GET para o flag indicador da possibilidade de seleção de mais de uma alternativa para a resposta */
    public boolean isAllowMultipleAnswer() { return allowMultipleAnswer; }
    /** SET para o flag indicador da possibilidade de seleção de mais de uma alternativa para a resposta */
    public void setAllowMultipleAnswer(boolean allow) { this.allowMultipleAnswer = allow; }

    /** Id da alternativa padrão para o caso de nenhuma selecionada. */
    private long defaultAlternativeId;
    /** GET para o id da alternativa default a ser selecionada quando nenhuma for indicada. */
    public long getDefaultAlternativeId() { return defaultAlternativeId; }
    /** SET para o id da alternativa default a ser selecionada quando nenhuma for indicada. */
    public void setDefaultAlternativeId(long id) { this.defaultAlternativeId = id; }

    /** Alternativa default para o caso de nenhuma selecionada. */
    private Alternative defaultAlternative;
    /** GET para a alternativa padrão a ser selecionada quando nenhuma for indicada. */
    public Alternative getDefaultAlternative() { return defaultAlternative; }
    /** SET para a alternativa padrão a ser selecionada quando nenhuma for indicada. */
    public void setDefaultAlternative(Alternative alternative) { this.defaultAlternative = alternative; }

    /** Máximo de alternativas que podem ser selecionadas em uma resposta. Default é TODAS. */
    private int selectableAlternativeQuantity;
    /** GET para o máximo de alternativas que podem ser selecionadas em uma resposta. */
    public int getSelectableAlternativeQuantity() { return selectableAlternativeQuantity; }
    /** SET para o máximo de alternativas que podem ser selecionadas em uma resposta */
    public void setSelectableAlternativeQuantity(int quantity) { this.selectableAlternativeQuantity = quantity; }

    /** Listagem de alternativas desta questão */
    private List<Alternative> alternativeList;
    /** GET para a listagem de alternativas desta questão */
    public List<Alternative> getAlternativeList() { return alternativeList; }
    /** SET para a listagem de alternativas desta questão */
    public void setAlternativeList(List<Alternative> list) { this.alternativeList = list; }
}