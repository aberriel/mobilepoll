package ufrj.mobilepoll.database.helper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.provider.ContactsContract;

import java.util.ArrayList;
import java.util.List;

import ufrj.mobilepoll.model.ResearchGroup;
import ufrj.mobilepoll.utils.DatabaseManagerUtils;

/**
 * Adaptador do banco de dados específico para a tabela de grupos (categorias) de pesquisas
 * Created by alira on 09/10/15.
 */
public class ResearchGroupDbHelper extends BaseDbHelper
{
    /** Nome da tabela do banco de dados de categoria de pesquisa */
    public static final String DATABASE_TABLE = "MOB_GrupoPesquisa";

    /** Nome da coluna da tabela do identificador do registro */
    private static final String KEY_ID = "M_Id";
    private static final String KEY_ID_COMPLEMENT = "not null primary key autoincrement";
    /** Tipo de dado da coluna da tabela do identificador do registro */
    private static final String KEY_ID_TYPE = "integer";

    /** Nome da coluna da tabela do nome do grupo de pesquisas */
    private static final String KEY_NAME = "M_Nome";
    /** Parâmetros complementares da coluna a serem usados na criação da tabela */
    private static final String KEY_NAME_COMPLEMENT = "not null";
    /** Tipo de dado da coluna do nome do grupo de pesquisas */
    private static final String KEY_NAME_TYPE = "varchar";

    /** Nome da coluna da tabela do descritivo do grupo de pesquisas */
    private static final String KEY_DESCRIPTION = "M_Descricao";
    /** Tipo de dado da coluna da tabela de descritivo do grupo de pesquisas */
    private static final String KEY_DESCRIPTION_TYPE ="varchar";

    /** Comando de criação da tabela na base */
    public static final String CREATE_TABLE = "create table " + DATABASE_TABLE
                                            + "("
                                            +       KEY_ID + " " + KEY_ID_TYPE + " " + KEY_ID_COMPLEMENT + ","
                                            +       KEY_NAME + " " + KEY_NAME_TYPE + " " + KEY_NAME_COMPLEMENT + ","
                                            +       KEY_DESCRIPTION + " " + KEY_DESCRIPTION_TYPE
                                            + ")";

    /** Comando de exclusão da tabela */
    public static final String DELETE_TABLE = "drop table " + DATABASE_TABLE;

    /** Comando de limpeza da tabela (exclusão de todos os registros) */
    public static final String CLEAR_TABLE = "delete from " + DATABASE_TABLE;

    /** Construtor */
    public ResearchGroupDbHelper(Context context)
    {
        super(context);
    }

    /**
     * Evento de criação da base de dados quando esta não existir
     * @param db Conexão com o banco de dados local
     */
    @Override
    public void onCreate(SQLiteDatabase db)
    {
        DatabaseManagerUtils.CreateAllTables(db);
        DatabaseManagerUtils.CreateInitData(db);
    }

    /**
     * Evento de atualização da base de dados quando a versão constante na aplicação for superior à versão registrada na base
     * @param db Conexão com o banco de dados
     * @param oldVersion Versão da base no dispositivo (antiga, inferior)
     * @param newVersion Versão da base na aplicaçãp (nova, superior)
     */
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        DatabaseManagerUtils.DeleteAllTables(db);
        DatabaseManagerUtils.CreateAllTables(db);
        DatabaseManagerUtils.CreateInitData(db);
    }

    /**
     * Evento de downgrade da base de dados, quando a versão constante na aplicação for inferior à versão registrada na base
     * @param db Conexão com o banco de dados
     * @param oldVersion Versão da base no dispositivo (antiga porém mais nova, superior)
     * @param newVersion Versão da base na aplicação (atual porém mais antiga, inferior)
     */
    @Override
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        super.onDowngrade(db, oldVersion, newVersion);

        DatabaseManagerUtils.DeleteAllTables(db);
        DatabaseManagerUtils.CreateAllTables(db);
        DatabaseManagerUtils.CreateInitData(db);
    }

    /**
     * Registra novo grupo de pesquisas na base
     * @param group Dados do novo grupo de pesquisas
     * @return Id do novo grupo de pesquisa no banco
     */
    public long create(ResearchGroup group)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_NAME, group.getName());
        values.put(KEY_DESCRIPTION, group.getDescription());

        long registerId = db.insert(DATABASE_TABLE, null, values);

        return registerId;
    }

    /**
     * Recupera todas as categorias (grupos) de pesquisa registrados no banco.
     * @return Lista de grupos de pesquisa encontrados
     */
    public List<ResearchGroup> getAll()
    {
        SQLiteDatabase db = this.getWritableDatabase();
        List<ResearchGroup> resultList = null;

        String raw_query = "select " + KEY_ID           + ","
                                     + KEY_NAME         + ","
                                     + KEY_DESCRIPTION
                         + " from " + DATABASE_TABLE;

        Cursor cursor = db.rawQuery(raw_query, null);

        if(cursor != null && cursor.moveToFirst())
        {
            resultList = new ArrayList<ResearchGroup>();
            do
            {
                ResearchGroup researchGroup = getDataFromCursor(cursor);
                resultList.add(researchGroup);
            } while(cursor.moveToNext());
        }

        return resultList;
    }

    /**
     * Busca grupo de pesquisa pelo id do registro na tabela
     * @param groupId Id do grupo de pesquisa a ser encontrado
     * @return Dados do grupo de pesquisa encontrado com o id fornecido
     */
    public ResearchGroup getById(long groupId)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ResearchGroup researchGroup = null;

        String[] columns = {KEY_ID, KEY_NAME, KEY_DESCRIPTION};

        Cursor cursor = db.query(DATABASE_TABLE,
                columns,
                KEY_ID + " = ?",
                new String[]{String.valueOf(groupId)},
                null,
                null,
                KEY_NAME);

        if(cursor != null && cursor.moveToFirst())
        {
            researchGroup = getDataFromCursor(cursor);
        }

        return researchGroup;
    }

    /**
     * Busca grupo (categoria) de pesquisas pelo nome
     * @param name Nome do grupo de pesquisas a ser localizado
     * @return Grupo de pesquisas encontrado
     */
    public ResearchGroup getByName(String name)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ResearchGroup researchGroup = null;

        String[] columns = {KEY_ID, KEY_NAME, KEY_DESCRIPTION};
        Cursor cursor = db.query(DATABASE_TABLE, // TABELA
                                 columns, // Colunas a serem retornadas do SELECT
                                 KEY_NAME + " LIKE %?%", // Cláusula WHERE
                                 new String[]{ name }, // Parâmetros do WHERE
                                 null, // GROUP BY
                                 null, // HAVING
                                 null // ORDER BY
                        );

        if(cursor != null && cursor.moveToFirst())
        {
            researchGroup = getDataFromCursor(cursor);
        }

        return researchGroup;
    }

    /**
     * Atualiza registro de grupo de pesquisa
     * @param updatedGroup Dados atualizados do grupo de pesquisa
     * @return Total de registros afetados (0 ou 1)
     */
    public int update(ResearchGroup updatedGroup)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_NAME, updatedGroup.getName());

        if(updatedGroup.getDescription() == null)
        {
            values.putNull(KEY_DESCRIPTION);
        }
        else
        {
            values.put(KEY_DESCRIPTION, updatedGroup.getDescription());
        }

        int affectedRows = db.update(DATABASE_TABLE, // Tabela do registro a ser atualizado
                                     values, // Valores atualizados
                                     KEY_ID + " = ?", // Cláusula WHERE
                                     new String[]{ String.valueOf(updatedGroup.getId()) } // Parâmetros do WHERE
                           );

        return affectedRows;
    }

    /**
     * Exclui registro de grupo de pesquisa do banco
     * @param id Identificador do registro a ser apagado
     * @return Total de registros afetados (0 ou 1)
     */
    public int delete(long id)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        int affectedRows = db.delete(DATABASE_TABLE,
                                     KEY_ID + " = ?",
                                     new String[]{String.valueOf(id)});

        return affectedRows;
    }

    private ResearchGroup getDataFromCursor(Cursor cursor)
    {
        ResearchGroup researchGroup = new ResearchGroup();
        researchGroup.setId(cursor.getLong(cursor.getColumnIndex(KEY_ID)));
        researchGroup.setName(cursor.getString(cursor.getColumnIndex(KEY_NAME)));

        if(!cursor.isNull(cursor.getColumnIndex(KEY_DESCRIPTION)))
        {
            researchGroup.setDescription(cursor.getString(cursor.getColumnIndex(KEY_DESCRIPTION)));
        }
        else
        {
            researchGroup.setDescription(null);
        }

        return researchGroup;
    }
}