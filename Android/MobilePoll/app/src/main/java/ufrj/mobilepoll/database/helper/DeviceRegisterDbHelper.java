package ufrj.mobilepoll.database.helper;

/**
 * Created by alira on 09/10/15.
 */
public class DeviceRegisterDbHelper
{
    /** Nome da tabela do banco de dados que armazenará os identificadores do dispositivo móvel */
    public static final String DATABASE_TABLE = "MOB_RegistroDispositivo";

    private static final String KEY_ID = "M_Id";
    private static final String KEY_ID_TYPE = "integer";

    private static final String KEY_MOBILE_DEVICE_ID = "REDI_IdDispositivoMovel";
    private static final String KEY_MOBILE_DEVICE_ID_TYPE = "integer";

    private static final String KEY_IMEI = "REDI_IMEI";
    private static final String KEY_IMEI_TYPE = "varchar";

    private static final String KEY_CLIENT_ID = "REDI_IdCliente";
    private static final String KEY_CLIENT_ID_TYPE = "integer";

    private static final String KEY_TRADE_NAME = "REDI_NomeFantasiaCliente";
    private static final String KEY_TRADE_NAME_TYPE = "varchar";

    private static final String KEY_COMPANY_NAME = "REDI_RazaoSocialCliente";
    private static final String KEY_COMPANY_NAME_TYPE = "varchar";

    private static final String KEY_CLIENT_DOCUMENT_NUMBER = "REDI_CnpjCliente";
    private static final String KEY_CLIENT_DOCUMENT_NUMBER_TYPE = "varchar";

    private static final String KEY_VALIDATION_CODE = "REDI_CodigoValidacao";
    private static final String KEY_VALIDATION_CODE_TYPE = "varchar";

    private static final String KEY_LAST_AUTHENTICATED_USER_ID = "REDI_IdUsuarioAutorizado";
    private static final String KEY_LAST_AUTHENTICATED_USER_ID_TYPE = "integer";

    private static final String KEY_LAST_SYNC_DATETIME = "DataHoraUltimoSincronismo";
    private static final String KEY_LAST_SYNC_DATETIME_TYPE = "datetime";

    private static final String KEY_TOLERANCE_TO_ANSWER_POLL = "ToleranciaParaResponderEnquete";
    private static final String KEY_TOLERANCE_TO_ANSWER_POLL_TYPE = "datetime";

    private static final String KEY_TOLERANCE_WITHOUT_ACTIVITY = "ToleranciaSemMovimentacao";
    private static final String KEY_TOLERANCE_WITHOUT_ACTIVITY_TYPE = "datetime";

    private static final String KEY_SESSION_TIME_LIMIT = "M_TempoLimiteSessao";
    private static final String KEY_SESSION_TIME_LIMIT_TYPE = "datetime";

    private static final String KEY_MOBILE_DEVICE_KEY = "M_ChaveDispositivoMovel";
    private static final String KEY_MOBILE_DEVICE_KEY_TYPE = "varchar";

    private static final String KEY_APPLICATION_KEY = "M_ChaveApp";
    private static final String KEY_APPLICATION_KEY_TYPE = "varchar";

    private static final String KEY_LAST_UPDATE_DATETIME = "M_DataHoraUltimaAtualizacao";
    private static final String KEY_LAST_UPDATE_DATETIME_TYPE = "datetime";

    /** Comando de criação da tabela de dados do dispositivo móvel no SQLite */
    public static final String CREATE_TABLE = "create table " + DATABASE_TABLE
                                            + "("
                                            +       KEY_ID + " " + KEY_ID_TYPE + " not null primary key autoincrement,"
                                            +       KEY_MOBILE_DEVICE_ID + " " + KEY_MOBILE_DEVICE_ID_TYPE + " not null,"
                                            +       KEY_IMEI + " " + KEY_IMEI_TYPE + " not null,"
                                            +       KEY_CLIENT_ID + " " + KEY_CLIENT_ID_TYPE + " not null,"
                                            +       KEY_TRADE_NAME + " " + KEY_TRADE_NAME_TYPE + ","
                                            +       KEY_COMPANY_NAME + " " + KEY_COMPANY_NAME_TYPE + ","
                                            +       KEY_CLIENT_DOCUMENT_NUMBER + " " + KEY_CLIENT_DOCUMENT_NUMBER_TYPE + ","
                                            +       KEY_VALIDATION_CODE + " " + KEY_VALIDATION_CODE_TYPE + ","
                                            + ")";

    /** Comando de exclusão da tabela de dados do dispositivo. */
    public static final String DELETE_TABLE = "drop table " + DATABASE_TABLE;

    /** Comando de limpeza da tabela (exclusão de todos os registros) de dados do dispositivo */
    public static final String CLEAR_TABLE = "delete from " + DATABASE_TABLE;
}