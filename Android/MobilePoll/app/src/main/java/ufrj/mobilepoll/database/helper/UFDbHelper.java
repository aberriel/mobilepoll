package ufrj.mobilepoll.database.helper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import ufrj.mobilepoll.model.City;
import ufrj.mobilepoll.model.FederalUnity;
import ufrj.mobilepoll.utils.DatabaseManagerUtils;

/**
 * Adaptador do banco de dados específico para a tabela de unidades federativas
 * Created by alira on 11/10/15.
 */
public class UFDbHelper extends BaseDbHelper
{
    /** Nome da tabela do banco de unidades federativas */
    public static final String DATABASE_TABLE = "MOB_UF";

    /** Nome da coluna do identificador do registro */
    private static final String KEY_ID = "M_Id";
    /** Tipo de dado da coluna de identificação do registro */
    private static final String KEY_ID_TYPE = "integer";

    /** Nome da coluna da tabela do nome da unidade federativa */
    private static final String KEY_NAME = "M_Nome";
    /** Tipo de dado da coluna do nome da unidade federativa */
    private static final String KEY_NAME_TYPE = "varchar";

    /** Nome da coluna da tabela da sigla da unidade federativa */
    private static final String KEY_ABBREVIATION = "M_Sigla";
    /** Tipo de dado da coluna da sigla da unidade federativa */
    private static final String KEY_ABBREVIATION_TYPE = "varchar";

    /** Comando de criação da tabela no banco */
    public static final String CREATE_TABLE = "create table " + DATABASE_TABLE
                                            + "("
                                            +       KEY_ID           + " " + KEY_ID_TYPE           + " primary key not null autoincrement,"
                                            +       KEY_NAME         + " " + KEY_NAME_TYPE         + " not null,"
                                            +       KEY_ABBREVIATION + " " + KEY_ABBREVIATION_TYPE + " not null"
                                            + ")";

    /** Comando de limpeza da tabela no banco */
    public static final String CLEAR_TABLE = "delete from " + DATABASE_TABLE;

    /** Comando de exclusão da tabela do banco */
    public static final String DELETE_TABLE = "drop table " + DATABASE_TABLE;

    /** Construtor */
    public UFDbHelper(Context context)
    {
        super(context);
    }

    /**
     * Evento de criação do banco de dados quando este não existir
     * @param db Conexão com o banco de dados
     */
    @Override
    public void onCreate(SQLiteDatabase db)
    {
        DatabaseManagerUtils.CreateAllTables(db);
    }

    /**
     * Evento de atualização da base de dados, quando as versões forem diferentes
     * @param db Conexão com a base de dados
     * @param oldVersion Versão da base antiga (base local)
     * @param newVersion Versão da base atualizada
     */
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        DatabaseManagerUtils.DeleteAllTables(db);
        DatabaseManagerUtils.CreateAllTables(db);
    }

    /**
     * Criação de novo registro de unidade federativa
     * @param federalUnity Nova unidde federativa a ser registrada
     * @return Id da nova unidade federativa registrada
     */
    public long CreateFederalUnity(FederalUnity federalUnity)
    {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_NAME, federalUnity.getName());
        values.put(KEY_ABBREVIATION, federalUnity.getAbbreviation());

        long registerId = db.insert(DATABASE_TABLE, null, values);
        return registerId;
    }

    /**
     * Resgata todas as unidades federativas registradas no banco
     * @return Coleção de unidades federativas encontradas
     */
    public List<FederalUnity> getAll()
    {
        SQLiteDatabase db = this.getWritableDatabase();
        List<FederalUnity> federalUnityList = new ArrayList<FederalUnity>();

        String raw_query = "select " + KEY_ID           + ","
                                     + KEY_NAME         + ","
                                     + KEY_ABBREVIATION
                        + " from " + DATABASE_TABLE;

        /*
        String[] columns = {KEY_ID,
                            KEY_NAME,
                            KEY_ABBREVIATION};

        Cursor cursor = db.query(DATABASE_TABLE,
                                 columns,
                                 null,
                                 null,
                                 null,
                                 null,
                                 null);
        */

        Cursor cursor = db.rawQuery(raw_query, null);

        // Aqui capturo o resultado obtido
        // No pior dos casos, retorno uma lista vazia, indicador de que nenhum registro foi achado
        if(cursor != null && cursor.moveToFirst())
        {
            do
            {
                FederalUnity fUnity = getFederalUnityFromCursor(cursor);
                federalUnityList.add(fUnity);
            } while(cursor.moveToNext());
        }

        return federalUnityList;
    }

    /**
     * Busca unidade federativa pelo ID
     * @param federalUnityId Identificador da unidade federativa que se deseja localizar
     * @return Unidade federativa encontrada
     */
    public FederalUnity getById(long federalUnityId)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        FederalUnity fUnity = null;

        String[] columns = {KEY_ID,
                            KEY_NAME,
                            KEY_ABBREVIATION};

        Cursor cursor = db.query(DATABASE_TABLE, // Nome da tabela
                                 columns, // Colunas a serem retornadas do SELECT
                                 KEY_ID + " = ?", // Cláusula WHERE
                                 new String[]{ String.valueOf(federalUnityId) }, // Parâmetros da cláusula WHERE
                                 null, // GROUP BY
                                 null, // HAVING
                                 KEY_NAME // ORDER BY
                        );

        if(cursor != null && cursor.moveToFirst())
        {
            fUnity = getFederalUnityFromCursor(cursor);
        }

        return fUnity;
    }

    /**
     * Busca unidade federativa pelo nome
     * @param name Nome da unidade federativa que se deseja encontrar
     * @return Unidade federativa encontrada
     */
    public FederalUnity getByName(String name)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        FederalUnity fUnity = null;

        String raw_query = "select " + KEY_ID + ","
                                     + KEY_NAME + ","
                                     + KEY_ABBREVIATION
                        + " from " + DATABASE_TABLE
                        + " where " + KEY_NAME + " = ?";

        String[] parameters = {name};

        /*
        String[] columns = {KEY_ID,
                            KEY_NAME,
                            KEY_ABBREVIATION};

        Cursor cursor = db.query(DATABASE_TABLE);
        */

        Cursor cursor = db.rawQuery(raw_query, parameters);

        if(cursor != null && cursor.moveToFirst())
        {
            fUnity = getFederalUnityFromCursor(cursor);
        }

        return fUnity;
    }

    /**
     * Busca unidade federativa pela sigla
     * @param abbreviation Sigla da unidade federativa que se deseja encontrar
     * @return Unidade federativa encontrada
     */
    public FederalUnity getByAbbreviation(String abbreviation)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        FederalUnity fUnity = null;

        String raw_query = "select " + KEY_ID           + ","
                                     + KEY_NAME         + ","
                                     + KEY_ABBREVIATION
                        + " from " + DATABASE_TABLE
                        + " where " + KEY_ABBREVIATION + " = ?";

        String[] parameters = {abbreviation};

        /*
        String[] columns = {KEY_ID,
                            KEY_NAME,
                            KEY_ABBREVIATION};
        */

        Cursor cursor = db.rawQuery(raw_query, parameters);

        if(cursor != null && cursor.moveToFirst())
        {
            fUnity = getFederalUnityFromCursor(cursor);
        }

        return fUnity;
    }

    /**
     * Atualiza registro de unidade federativa
     * @param federalUnity Dados atualizados da unidade federativa
     * @return Número de registros afetados (0 ou 1)
     */
    public int update(FederalUnity federalUnity)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_NAME, federalUnity.getName());
        values.put(KEY_ABBREVIATION, federalUnity.getAbbreviation());

        int affectedRows = db.update(DATABASE_TABLE,
                                     values,
                                     KEY_ID + " = ?",
                                     new String[]{ String.valueOf(federalUnity.getId())} );

        return affectedRows;
    }

    /**
     * Apaga registro de unidade federativa do banco
     * @param federalUnityId Id do registro de unidade federativa a ser deletado do banco
     * @return Total de registros afetados (0 ou 1)
     */
    public int delete(long federalUnityId)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        int affectedRows = db.delete(DATABASE_TABLE,
                                     KEY_ID + " = ?",
                                     new String[]{ String.valueOf(federalUnityId) });

        return affectedRows;
    }

    /**
     * Recupera dados de unidade federativa de resultado de consulta no banco
     * @param cursor Stream de resultado de consulta no banco
     * @return Dados da unidade federativa recuperada
     */
    public FederalUnity getFederalUnityFromCursor(Cursor cursor)
    {
        FederalUnity federalUnity = new FederalUnity();
        federalUnity.setId(cursor.getLong(cursor.getColumnIndex(KEY_ID)));
        federalUnity.setName(cursor.getString(cursor.getColumnIndex(KEY_NAME)));
        federalUnity.setAbbreviation(cursor.getString(cursor.getColumnIndex(KEY_ABBREVIATION)));

        return federalUnity;
    }
}