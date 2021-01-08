package ufrj.mobilepoll.database.helper;

/**
 * Adaptador do banco de dados específico para a tabela de questões
 * Created by alira on 09/10/15.
 */
public class QuestionDbHelper
{
    /** Nome da tabela de questões de pesquisas no banco */
    public static final String DATABASE_TABLE = "MOB_Questao";

    /** Coluna de identificador único do registro no banco (chave primária, ID) */
    private static final String KEY_ID = "M_Id";
    private static final String KEY_ID_TYPE = "integer";

    /** Coluna de identificador da pesquisa à qual a questão pertence */
    private static final String KEY_RESEARCH = "M_Pesquisa";
    /** Tipo da coluna do identificador da pesquisa à qual a questão pertence (no caso, String) */
    private static final String KEY_RESEARCH_TYPE = "integer";

    /** Coluna de enunciado da questão */
    private static final String KEY_STATEMENT = "M_Enunciado";
    /** Tipo da coluna do enunciado da questão (no caso, String) */
    private static final String KEY_STATEMENT_TYPE = "varchar";

    /** Coluna do número da questão */
    private static final String KEY_NUMBER = "M_Numero";
    /** Tipo da coluna do número da questão (no caso, String) */
    private static final String KEY_NUMBER_TYPE = "varchar";

    private static final String KEY_ANSWERTYPE = "M_TipoDeResposta";
    private static final String KEY_ANSWERTYPE_TYPE = "integer";

    private static final String KEY_REQUIRED_QUESTION = "M_FLG_QuestaoObrigatoria";
    private static final String KEY_REQUIRED_QUESTION_TYPE = "integer";

    private static final String KEY_REQUIRED_EXPLANATION = "M_FLG_JustificativaObrigatoria";
    private static final String KEY_REQUIRED_EXPLANATION_TYPE = "integer";

    private static final String KEY_ALLOW_MULTIPLE_ANSWER = "M_PermiteMultiplasRespostas";
    private static final String KEY_ALLOW_MULTIPLE_ANSWER_TYPE = "integer";

    private static final String KEY_DEFAULT_ALTERNATIVE = "M_AlternativaPadrao";
    private static final String KEY_DEFAULT_ALTERNATIVE_TYPE = "integer";

    private static final String KEY_SELECTABLE_ALTERNATIVE_QUANTITY = "M_QtdeAlternativasSelecionaveis";
    private static final String KEY_SELECTABLE_ALTERNATIVE_QUANTITY_TYPE = "integer";

    /** Script de criação da tabela de questões das pesquisas */
    public static final String CREATE_TABLE = "create table " + DATABASE_TABLE
                                            + "("
                                            +       KEY_ID                              + " " + KEY_ID_TYPE                              + " not null primary key autoincrement,"
                                            +       KEY_RESEARCH                        + " " + KEY_RESEARCH_TYPE                        + " not null,"
                                            +       KEY_STATEMENT                       + " " + KEY_STATEMENT_TYPE                       + " not null,"
                                            +       KEY_NUMBER                          + " " + KEY_NUMBER_TYPE                          + " not null,"
                                            +       KEY_ANSWERTYPE                      + " " + KEY_ANSWERTYPE_TYPE                      + ","
                                            +       KEY_REQUIRED_QUESTION               + " " + KEY_REQUIRED_QUESTION_TYPE               + " not null default 0,"
                                            +       KEY_REQUIRED_EXPLANATION            + " " + KEY_REQUIRED_EXPLANATION_TYPE            + " not null default 0,"
                                            +       KEY_ALLOW_MULTIPLE_ANSWER           + " " + KEY_ALLOW_MULTIPLE_ANSWER_TYPE           + ","
                                            +       KEY_DEFAULT_ALTERNATIVE             + " " + KEY_DEFAULT_ALTERNATIVE_TYPE             + ","
                                            +       KEY_SELECTABLE_ALTERNATIVE_QUANTITY + " " + KEY_SELECTABLE_ALTERNATIVE_QUANTITY_TYPE
                                            + ")";

    /** Script de exclusão da tabela de questões das pesquisas */
    public static final String DELETE_TABLE = "drop table " + DATABASE_TABLE;

    /** Script de limpeza (exclusão de dados) da tabela de questões das pesquisas */
    public static final String CLEAR_TABLE = "delete from " + DATABASE_TABLE;
}