package ufrj.mobilepoll.database.helper;

/**
 * Created by alira on 09/10/15.
 */
public class CommunicationControlDbHelper
{
    public static final String DATABASE_TABLE = "MOB_ControleComunicacao";

    private static final String KEY_ID = "M_Id";
    private static final String KEY_ID_TYPE = "integer";

    private static final String KEY_PACKAGE_CONTENT = "M_ConteudoPacote";
    private static final String KEY_PACKAGE_CONTENT_TYPE = "varchar";

    private static final String KEY_OPERATION = "M_Operacao";
    private static final String KEY_OPERATION_TYPE = "integer";

    private static final String KEY_SEND_DATETIME = "M_DataHoraEnvio";
    private static final String KEY_SEND_DATETIME_TYPE = "datetime";

    private static final String KEY_RECEIVE_DATETIME = "M_DataHoraRetorno";
    private static final String KEY_RECEIVE_DATETIME_TYPE = "datetime";

    private static final String KEY_REQUIRE_FEEDBACK = "M_RequerRetorno";
    private static final String KEY_REQUIRE_FEEDBACK_TYPE = "integer";

    private static final String KEY_REQUIRE_IMMEDIATE_FEEDBACK = "M_RequerRetornoImediato";
    private static final String KEY_REQUIRE_IMMEDIATE_FEEDBACK_TYPE = "integer";

    private static final String KEY_PROCESSED = "M_Processado";
    private static final String KEY_PROCESSED_TYPE = "integer";

    private static final String KEY_COMMUNICATION_RESPONSE = "M_RetornoComunicacao";
    private static final String KEY_COMMUNICATION_RESPONSE_TYPE = "varchar";

    private static final String KEY_COMMUNICATION_DIRECTION = "M_SentidoComunicacao";
    private static final String KEY_COMMUNICATION_DIRECTION_TYPE = "integer";

    private static final String KEY_ERROR_MESSAGE = "M_MensagemErro";
    private static final String KEY_ERROR_MESSAGE_TYPE = "varchar";

    public static final String CREATE_TABLE = "create table " + DATABASE_TABLE
                                            + "("
                                            +       KEY_ID                         + " " + KEY_ID_TYPE                         + " not null primary key autoincrement,"
                                            +       KEY_PACKAGE_CONTENT            + " " + KEY_PACKAGE_CONTENT_TYPE            + ","
                                            +       KEY_OPERATION                  + " " + KEY_OPERATION_TYPE                  + " not null,"
                                            +       KEY_SEND_DATETIME              + " " + KEY_SEND_DATETIME_TYPE              + ","
                                            +       KEY_RECEIVE_DATETIME           + " " + KEY_RECEIVE_DATETIME_TYPE           + ","
                                            +       KEY_REQUIRE_FEEDBACK           + " " + KEY_REQUIRE_FEEDBACK_TYPE           + " not null default 0,"
                                            +       KEY_REQUIRE_IMMEDIATE_FEEDBACK + " " + KEY_REQUIRE_IMMEDIATE_FEEDBACK_TYPE + " not null default 0,"
                                            +       KEY_PROCESSED                  + " " + KEY_PROCESSED_TYPE                  + " not null default 0,"
                                            +       KEY_COMMUNICATION_RESPONSE     + " " + KEY_COMMUNICATION_RESPONSE_TYPE     + ","
                                            +       KEY_COMMUNICATION_DIRECTION    + " " + KEY_COMMUNICATION_DIRECTION_TYPE    + " not null,"
                                            +       KEY_ERROR_MESSAGE              + " " + KEY_ERROR_MESSAGE_TYPE
                                            + ")";

    /** Comando de exclusão da tabela de gerenciamento de comunicação entre servidor e dispositivo móvel. */
    public static final String DELETE_TABLE = "drop table " + DATABASE_TABLE;

    /** Comando de limpeza (exclusão de todos os registros) da tabela de gerenciamento de comunicação entre servidor e dispositivo móvel */
    public static final String CLEAR_TABLE = "delete from " + DATABASE_TABLE;
}