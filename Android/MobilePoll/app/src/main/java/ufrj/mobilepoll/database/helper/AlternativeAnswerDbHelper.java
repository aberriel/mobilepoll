package ufrj.mobilepoll.database.helper;

/**
 * Adaptador do banco de dados específico para a tabela associativa de alternativas e respostas
 * Created by alira on 09/10/15.
 */
public class AlternativeAnswerDbHelper
{
    /** Nome da tabela associativa entre alternativas e respostas */
    public static final String DATABASE_TABLE = "MOB_AlternativaResposta";

    /** Nome da coluna identificadora da alternativa a ser associada à resposta */
    private static final String KEY_ALTERNATIVE = "M_Alternativa";
    private static final String KEY_ALTERNATIVE_TYPE = "integer";

    /** Nome da coluna identificadora da resposta à qual a alternativa está sendo associada */
    private static final String KEY_ANSWER = "M_Resposta";
    private static final String KEY_ANSWER_TYPE = "integer";

    /** Comando de criação da tabela associativa entre alternativas e respostas */
    public static final String CREATE_TABLE = "create table " + DATABASE_TABLE
                                            + "("
                                            +       KEY_ALTERNATIVE + " " + KEY_ALTERNATIVE_TYPE + " not null,"
                                            +       KEY_ANSWER + " " + KEY_ANSWER_TYPE + " not null,"
                                            +       "PROMARY KEY (" + KEY_ALTERNATIVE + ", " + KEY_ANSWER_TYPE + ")"
                                            + ")";

    /** Comando de exclusão da tabela */
    public static final String DELETE_TABLE = "drop table " + DATABASE_TABLE;

    /** Comando de limpeza (exclusão de todos os registros) da tabela */
    public static final String CLEAR_TABLE = "delete from " + DATABASE_TABLE;
}