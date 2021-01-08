package ufrj.mobilepoll.database.helper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import ufrj.mobilepoll.model.City;
import ufrj.mobilepoll.utils.DatabaseManagerUtils;
import ufrj.mobilepoll.utils.DateTimeUtils;

/**
 * Adaptador do banco de dados específico para a tabela de cidades
 * Created by alira on 09/10/15.
 */
public class CityDbHelper extends BaseDbHelper
{
    /** Nome da tabela de dados de municípios */
    public static final String DATABASE_TABLE = "MOB_Cidade";

    /** Nome da coluna de identificação do registro (chave primária) */
    private static final String KEY_ID = "M_Id";
    /** Tipo de dado da coluna do identificador do município no banco */
    private static final String KEY_ID_TYPE = "integer";

    /** Nome da coluna que armazena o nome do município */
    private static final String KEY_NAME = "M_Nome";
    /** Tipo de dado da coluna do nome do município */
    private static final String KEY_NAME_TYPE = "varchar";

    /** Nome da coluna que armazena o descritivo do município */
    private static final String KEY_DESCRIPTION = "M_Descricao";
    /** Tipo de dado da coluna do descritivo do município */
    private static final String KEY_DESCRIPTION_TYPE = "varchar";

    /** Nome da coluna que armazena o identificador da unidade federativa à qual pertence */
    private static final String KEY_UF = "M_UF";
    /** Tipo de dado da coluna do identificador da unidade federativa à qual o município pertence */
    private static final String KEY_UF_TYPE = "integer";

    /** Nome da coluna que armazena a data e hora do registro do município */
    private static final String KEY_REGISTER_DATETIME = "M_DataHoraRegistro";
    /** Tipo de dado da coluna de data e hora do registro do município */
    private static final String KEY_REGISTER_DATETIME_TYPE = "datetime";

    /** Comando de criação da tabela de municípios no SQLite */
    public static final String CREATE_TABLE = "create table " + DATABASE_TABLE
                                            + "("
                                            +       KEY_ID                + " " + KEY_ID_TYPE                + " primary key autoincrement not null,"
                                            +       KEY_NAME              + " " + KEY_NAME_TYPE              + " not null,"
                                            +       KEY_DESCRIPTION       + " " + KEY_DESCRIPTION_TYPE       + ","
                                            +       KEY_UF                + " " + KEY_UF_TYPE                + " not null,"
                                            +       KEY_REGISTER_DATETIME + " " + KEY_REGISTER_DATETIME_TYPE + " not null default current_timestamp"
                                            + ")";

    /** Comando de exclusão da tabela de municípios do banco */
    public static final String DELETE_TABLE = "drop table " + DATABASE_TABLE;

    /** Comando de limpeza (exclusão de todos os registros) da tabela de municípios */
    public static final String CLEAR_TABLE = "delete from " + DATABASE_TABLE;

    /** Construtor */
    public CityDbHelper(Context context)
    {
        super(context);
    }

    /** Evento de criação da base de dados, no caso de não existir */
    @Override
    public void onCreate(SQLiteDatabase db)
    {
        DatabaseManagerUtils.CreateAllTables(db);
        DatabaseManagerUtils.CreateInitData(db);
    }

    /** Evento de atualização da base de dados, no caso da versão corrente ser superior à do banco */
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        DatabaseManagerUtils.DeleteAllTables(db);
        DatabaseManagerUtils.CreateAllTables(db);
        DatabaseManagerUtils.CreateInitData(db);
    }

    /**
     * Registra novo município na base
     * @param city Dados do novo município
     * @return Id do município registrado
     */
    public long create(City city)
    {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_NAME, city.getName());
        values.put(KEY_DESCRIPTION, city.getDescription());

        if(city.getFederalUnityId() != null)
        {
            values.put(KEY_UF, city.getFederalUnityId());
        }

        long registerId = db.insert(DATABASE_TABLE, null, values);

        return registerId;
    }

    /**
     * Busca município pelo ID da tabela
     * @param cityId Id do município que se deseja encontrar
     * @return Dados do município encontrado
     */
    public City getById(long cityId)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        City city = null;

        String raw_query = "select " + KEY_ID                + ","
                                     + KEY_NAME              + ","
                                     + KEY_DESCRIPTION       + ","
                                     + KEY_UF                + ","
                                     + KEY_REGISTER_DATETIME
                        + " from " + DATABASE_TABLE
                        + " where " + KEY_ID + " = ?";

        String[] parameters = {Long.toString(cityId)};

        Cursor cursor = db.rawQuery(raw_query, parameters);

/*
        String[] columns = {KEY_ID,
                            KEY_NAME,
                            KEY_DESCRIPTION,
                            KEY_UF,
                            KEY_REGISTER_DATETIME};

        Cursor cursor = db.query(DATABASE_TABLE,
                                 columns,
                                 KEY_ID + " = ?",
                                 new String[]{String.valueOf(cityId)},
                                 null,
                                 null,
                                 null);
*/

        if(cursor != null && cursor.moveToFirst())
        {
            city = getCityFromCursor(cursor);
        }

        return city;
    }

    /**
     * Busca municípios de uma unidade federativa em específico
     * @param federalUnityId Id d unidade federativa cujos municípios se deseja encontrar
     * @return Coleção dos municípios do estado em questão
     */
    public List<City> getByFederalUnity(long federalUnityId)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        List<City> cityList = new ArrayList<City>();

        String raw_query = "select " + KEY_ID                 + ","
                                     + KEY_NAME               + ","
                                     + KEY_DESCRIPTION        + ","
                                     + KEY_UF                 + ","
                                     + KEY_REGISTER_DATETIME
                         + " from " + DATABASE_TABLE
                         + " where " + KEY_UF + " = ?";

        String[] parameters = {Long.toString(federalUnityId)};

        Cursor cursor = db.rawQuery(raw_query, parameters);

        if(cursor != null && cursor.moveToFirst())
        {
            do
            {
                City city = getCityFromCursor(cursor);
                cityList.add(city);
            } while(cursor.moveToNext());
        }

        return cityList;
    }

    /**
     * Recupera todas as cidades registradas no banco
     * @return Coleção de cidades encontradas na base de dados
     */
    public List<City> getAll()
    {
        SQLiteDatabase db = this.getWritableDatabase();
        List<City> cityList = new ArrayList<City>();

        String raw_query = "select " + KEY_ID                 + ","
                                     + KEY_NAME               + ","
                                     + KEY_DESCRIPTION        + ","
                                     + KEY_UF                 + ","
                                     + KEY_REGISTER_DATETIME
                         + " from " + DATABASE_TABLE;

        Cursor cursor = db.rawQuery(raw_query, null);

        // Aqui capturo o resultado obtido
        // No pior dos casos, retorno uma lista vazia, indicador de que nenhum registro foi achado
        if(cursor != null && cursor.moveToFirst())
        {
            do
            {
                City city = getCityFromCursor(cursor);
                cityList.add(city);
            } while(cursor.moveToNext());
        }

        return cityList;
    }

    /**
     * Atualiza dados de município
     * @param city Dados do município atualizados
     * @return Total de registros afetados (0 ou 1)
     */
    public int update(City city)
    {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_NAME, city.getName());
        values.put(KEY_DESCRIPTION, city.getDescription());
        values.put(KEY_UF, city.getFederalUnityId());

        if(city.getFederalUnityId() != null)
        {
            values.put(KEY_UF, city.getFederalUnityId());
        }

        return db.update(DATABASE_TABLE, // Nome da tabela do registro a ser atualizado
                         values, // Valores atualizados
                         KEY_ID + " = ?", // Cláusula WHERE
                         new String[] { String.valueOf(city.getId()) } // Parâmetros da cláusula WHERE
                        );
    }

    /**
     * Remove município da base
     * @param cityId Id do registro a ser apagado da tabela de cidades
     * @return Total de linhas afetadas (no caso, 0 ou 1)
     */
    public int delete(long cityId)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        int affectedRows = db.delete(DATABASE_TABLE, // Nome da tabela
                                     KEY_ID + " = ?", // cláusula WHERE
                                     new String[]{ String.valueOf(cityId) } // Parâmetro da cláusula WHERE
                           );

        return affectedRows;
    }

    /**
     * Recupera cidade de resultado de consulta no banco.
     * @param cursor Stream de resultado de consulta com o banco.
     * @return Cidade recuperada.
     */
    public City getCityFromCursor(Cursor cursor)
    {
        City city = new City();
        city.setId(cursor.getLong(cursor.getColumnIndex(KEY_ID)));
        city.setName(cursor.getString(cursor.getColumnIndex(KEY_NAME)));

        if(!cursor.isNull(cursor.getColumnIndex(KEY_DESCRIPTION)))
        {
            city.setDescription(cursor.getString(cursor.getColumnIndex(KEY_DESCRIPTION)));
        }
        else
        {
            city.setDescription(null);
        }

        if(!cursor.isNull(cursor.getColumnIndex(KEY_UF)))
        {
            city.setFederalUnityId(cursor.getLong(cursor.getColumnIndex(KEY_UF)));
        }
        else
        {
            city.setFederalUnityId(null);
        }

        String registerDateTime_Str = cursor.getString(cursor.getColumnIndex(KEY_REGISTER_DATETIME));
        city.setRegisterDateTime(DateTimeUtils.GetDateTimeFromString(registerDateTime_Str));

        return city;
    }
}