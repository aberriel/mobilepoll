package ufrj.mobilepoll.database.helper;

/**
 * Created by alira on 09/10/15.
 */
public class AnswerDbHelper
{
    public static final String DATABASE_TABLE = "MOB_Resposta";

    private static final String KEY_ID = "M_Id";
    private static final String KEY_ID_TYPE = "integer";

    private static final String KEY_QUESTION = "M_Questao";
    private static final String KEY_QUESTION_TYPE = "integer";

    private static final String KEY_TEXTUAL_RESPONSE = "RespostaTextual";
    private static final String KEY_TEXTUAL_RESPONSE_TYPE = "varchar";

    private static final String KEY_EXPLANATION = "M_Justificativa";
    private static final String KEY_EXPLANATION_TYPE = "varchar";

    private static final String KEY_POLL = "M_Enquete";
    private static final String KEY_POLL_TYPE = "integer";

    private static final String KEY_GPS_DATA = "M_DadosGps";
    private static final String KEY_GPS_DATA_TYPE = "integer";

    private static final String KEY_REGISTER_DATETIME = "M_DataHoraRegistro";
    private static final String KEY_REGISTER_DATETIME_TYPE = "datetime";

    public static final String CREATE_TABLE = "create table " + DATABASE_TABLE
                                            + "("
                                            +       KEY_ID + " " + KEY_ID_TYPE + " not null primary key autoincrement,"
                                            +       KEY_QUESTION + " " + KEY_QUESTION_TYPE + " not null,"
                                            +       KEY_TEXTUAL_RESPONSE + " " + KEY_TEXTUAL_RESPONSE_TYPE + ","
                                            +       KEY_EXPLANATION + " " + KEY_EXPLANATION_TYPE + ","
                                            +       KEY_POLL + " " + KEY_POLL_TYPE + " not null,"
                                            +       KEY_GPS_DATA + " " + KEY_GPS_DATA_TYPE + ","
                                            +       KEY_REGISTER_DATETIME + " " + KEY_REGISTER_DATETIME_TYPE + " not null default current_timestamp"
                                            + ")";

    public static final String DELETE_TABLE = "drop table " + DATABASE_TABLE;

    public static final String CLEAR_TABLE = "delete from " + DATABASE_TABLE;
}