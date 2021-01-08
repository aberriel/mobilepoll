package ufrj.mobilepoll.database.helper;

/**
 * Created by alira on 09/10/15.
 */
public class GpsDataDbHelper
{
    /** Nome da tabela de dados de localização coletados durante o uso da aplicação. */
    public static final String DATABASE_TABLE = "MOB_GPS_Data";

    /** Nome da coluna identificadora do registro (chave primária) */
    private static final String KEY_ID = "M_Id";
    private static final String KEY_ID_TYPE = "integer";

    /** Nome da coluna da coordenada de latitude */
    private static final String KEY_LATITUDE = "M_Latitude";
    /** Tipo de dado da coluna de latitude */
    private static final String KEY_LATITUDE_TYPE = "real";

    /** Nome da coluna da coordenada de longitude */
    private static final String KEY_LONGITUDE = "M_Longitude";
    /** Tipo de dado da coluna de longitude */
    private static final String KEY_LONGITUDE_TYPE = "real";

    /** Nome da coluna de data e hora de coleta da localização */
    private static final String KEY_REGISTER_DATETIME = "M_RegisterDateTime";
    /** Tipo de dado da coluna de data e hora de coleta da localização */
    private static final String KEY_REGISTER_DATETIME_TYPE = "datetime";

    public static final String CREATE_TABLE = "create table " + DATABASE_TABLE
                                            + "("
                                            +       KEY_ID + " " + KEY_ID_TYPE + " not null primary key autoincrement,"
                                            +       KEY_LATITUDE + " " + KEY_LATITUDE_TYPE + " not null,"
                                            +       KEY_LONGITUDE + " " + KEY_LONGITUDE_TYPE + " not null,"
                                            +       KEY_REGISTER_DATETIME + " " + KEY_REGISTER_DATETIME_TYPE + " not null default current_timestamp"
                                            + ")";

    public static final String DELETE_TABLE = "drop table " + DATABASE_TABLE;

    public static final String CLEAR_TABLE = "delete from " + DATABASE_TABLE;
}