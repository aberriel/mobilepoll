package ufrj.mobilepoll.database.helper;

/**
 * Created by alira on 09/10/15.
 */
public class InterviewerClientMailDbHelper
{
    public static final String DATABASE_TABLE = "MOB_CorreioClienteEntrevistador";

    private static final String KEY_ID = "M_Id";
    private static final String KEY_ID_TYPE = "integer";

    private static final String KEY_MESSAGE_STATUS = "M_StatusMensagem";
    private static final String KEY_MESSAGE_STATUS_TYPE = "integer";

    private static final String KEY_MESSAGE_DIRECTION = "M_SentidoMensagem";
    private static final String KEY_MESSAGE_DIRECTION_TYPE = "integer";

    private static final String KEY_MESSAGE = "M_Mensagem";
    private static final String KEY_MESSAGE_TYPE = "varchar";

    private static final String KEY_OPEN_CONFIRMATION = "M_ConfirmacaoAbertura";
    private static final String KEY_OPEN_CONFIRMATION_TYPE = "integer";

    private static final String KEY_COMMUNICATION_CONTROL = "M_ControleComunicacao";
    private static final String KEY_COMMUNICATION_CONTROL_TYPE = "integer";

    /** Comando de criação da tabela */
    public static final String CREATE_TABLE = "create table " + DATABASE_TABLE
                                            + "("
                                            +       KEY_ID + " " + KEY_ID_TYPE + " not null primary key autoincrement,"
                                            +       KEY_MESSAGE_STATUS + " " + KEY_MESSAGE_STATUS_TYPE + ","
                                            +       KEY_MESSAGE_DIRECTION + " " + KEY_MESSAGE_DIRECTION_TYPE + ","
                                            +       KEY_MESSAGE + " " + KEY_MESSAGE_TYPE + ","
                                            +       KEY_OPEN_CONFIRMATION + " " + KEY_OPEN_CONFIRMATION_TYPE + " not null default 0,"
                                            +       KEY_COMMUNICATION_CONTROL + " " + KEY_COMMUNICATION_CONTROL_TYPE
                                            + ")";

    /** Comando de exclusão da tabela de gestão de comunicação entre cliente e entrevistador. */
    public static final String DELETE_TABLE = "drop table " + DATABASE_TABLE;

    /** Comando de limpeza (exclusão de todos os registros) da tabela de gestão de comunicação entre cliente e entrevistador */
    public static final String CLEAR_TABLE = "delete from " + DATABASE_TABLE;
}