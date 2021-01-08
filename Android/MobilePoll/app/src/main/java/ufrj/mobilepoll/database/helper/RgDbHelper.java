package ufrj.mobilepoll.database.helper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import ufrj.mobilepoll.model.RG;
import ufrj.mobilepoll.utils.DatabaseManagerUtils;
import ufrj.mobilepoll.utils.DateTimeUtils;

/**
 * Adaptador do banco de dados específico para a tabela de documento de identificação de pessoa
 * Created by alira on 09/10/15.
 */
public class RgDbHelper extends BaseDbHelper
{
    /** Nome da tabela do banco de dados de documento de identificação */
    public static final String DATABASE_TABLE = "MOB_RG";

    /** Nome da coluna de identificação do registro */
    private static final String KEY_ID = "M_Id";
    /** Tipo de dado da coluna de identificação do registro */
    private static final String KEY_ID_TYPE = "integer";

    /** Nome da coluna do número do documento de identificação */
    private static final String KEY_NUMBER = "M_Numero";
    /** Tipo de dado da coluna de número do documento de identificação */
    private static final String KEY_NUMBER_TYPE = "varchar";

    /** Nome da coluna de informação do órgão expeditor do documento */
    private static final String KEY_ISSUING_INSTITUTION = "OrgaoExpeditor";
    /** Tipo de dado da coluna de informação do órgão emissor do documento */
    private static final String KEY_ISSUING_INSTITUTION_TYPE = "varchar";

    /** Nome da coluna de data de emissão do documento */
    private static final String KEY_ISSUE_DATE = "M_DataEmissaoDocumento";
    /** Tipod e dado da coluna de data de emissão do documento */
    private static final String KEY_ISSUE_DATE_TYPE = "datetime";

    /** Nome da coluna da unidade federativa onde ocorreu a emissão do documento */
    private static final String KEY_FEDERATIVE_UNIT_ISSUER = "M_UnidadeFederativaEmissora";
    /** Tipo de dado da coluna da unidade federativa onde ocorreu a emissão do documento */
    private static final String KEY_FEDERATIVE_UNIT_ISSUER_TYPE = "integer";

    /** Comando de criação da tabela no banco */
    public static final String CREATE_TABLE = "create table " + DATABASE_TABLE
                                            + "("
                                            +       KEY_ID                     + " " + KEY_ID_TYPE                     + " primary key not null autoincrement,"
                                            +       KEY_NUMBER                 + " " + KEY_NUMBER_TYPE                 + " not null,"
                                            +       KEY_ISSUING_INSTITUTION    + " " + KEY_ISSUING_INSTITUTION_TYPE    + ","
                                            +       KEY_ISSUE_DATE             + " " + KEY_ISSUE_DATE_TYPE             + ","
                                            +       KEY_FEDERATIVE_UNIT_ISSUER + " " + KEY_FEDERATIVE_UNIT_ISSUER_TYPE + " not null"
                                            + ")";

    /** Comando de exclusão da tabela de RG */
    public static final String DELETE_TABLE = "drop table " + DATABASE_TABLE;

    /** Comando de limpeza da tabela de RG */
    public static final String CLEAR_TABLE = "delete from " + DATABASE_TABLE;

    /** Construtor */
    public RgDbHelper(Context context)
    {
        super(context);
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        DatabaseManagerUtils.CreateAllTables(db);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        DatabaseManagerUtils.DeleteAllTables(db);
        DatabaseManagerUtils.CreateAllTables(db);
    }

    /**
     * Registra novo documento de identificação de pessoa no banco
     * @param rg Dados do documento identificador
     * @return Id do registro criado
     */
    public long createRG(RG rg)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_ISSUE_DATE, DateTimeUtils.GetDateTimeInDatabaseStringFormat(rg.getIssueDate()));
        values.put(KEY_NUMBER, rg.getNumber());
        values.put(KEY_ISSUING_INSTITUTION, rg.getIssuingInstitution());

        if(rg.getDispatcherStateId() != null)
        {
            values.put(KEY_FEDERATIVE_UNIT_ISSUER, rg.getDispatcherStateId());
        }

        long registerId = db.insert(DATABASE_TABLE, null, values);

        return registerId;
    }

    public List<RG> getAll()
    {
        SQLiteDatabase db = this.getWritableDatabase();
        List<RG> rgList = null;

        String raw_query = "select " + KEY_ID + ","
                                     + KEY_NUMBER + ","
                                     + KEY_ISSUING_INSTITUTION + ","
                                     + KEY_ISSUE_DATE + ","
                                     + KEY_FEDERATIVE_UNIT_ISSUER
                        + " from " + DATABASE_TABLE;

        Cursor cursor = db.rawQuery(raw_query, null);

        if(cursor != null && cursor.moveToFirst())
        {
            rgList = new ArrayList<RG>();
            do
            {
                RG rg = getRgFromCursor(cursor);
                rgList.add(rg);
            } while (cursor.moveToNext());
        }

        return rgList;
    }

    /**
     * Localiza dados de documento identificador pelo ID
     * @param rgId Id do documento identificador que se deseja localizar
     * @return Dados do documento identificador encontrado
     */
    public RG getById(long rgId)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        RG rg = null;

        String raw_query = "select " + KEY_ID + ","
                                     + KEY_NUMBER + ","
                                     + KEY_ISSUING_INSTITUTION + ","
                                     + KEY_FEDERATIVE_UNIT_ISSUER + ","
                                     + KEY_ISSUE_DATE
                        + " from " + DATABASE_TABLE
                        + " where " + KEY_ID + " = ?";

        String[] parameters = {String.valueOf(rgId)};

        String[] columns = {KEY_ID,
                            KEY_NUMBER,
                            KEY_ISSUING_INSTITUTION,
                            KEY_FEDERATIVE_UNIT_ISSUER,
                            KEY_ISSUE_DATE};

        Cursor cursor = db.query(DATABASE_TABLE, // Tabela do SELECT
                                 columns, // Colunas do SELECT
                                 KEY_ID + " = ?", // Cláusula WHERE
                                 new String[]{ String.valueOf(rgId) }, // Parâmetros do WHERE
                                 null, // GROUP BY
                                 null, // HAVING
                                 null // ORDER BY
                                );

        if(cursor != null && cursor.moveToFirst())
        {
            rg = getRgFromCursor(cursor);
        }

        return rg;
    }

    /**
     * Atualiza dados de documento identificador
     * @param rg Dados atualizados do documento identificador de pessoa
     * @return Total de registros afetados (0 ou 1)
     */
    public int updateRG(RG rg)
    {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_NUMBER, rg.getNumber());

        if(rg.getDispatcherStateId() != null)
        {
            values.put(KEY_FEDERATIVE_UNIT_ISSUER, rg.getDispatcherStateId());
        }
        else
        {
            values.putNull(KEY_FEDERATIVE_UNIT_ISSUER);
        }

        values.put(KEY_ISSUING_INSTITUTION, rg.getIssuingInstitution());
        values.put(KEY_ISSUE_DATE, DateTimeUtils.GetDateTimeInDatabaseStringFormat(rg.getIssueDate()));

        int affectedRows = db.update(DATABASE_TABLE,
                                     values,
                                     KEY_ID + " = ?",
                                     new String[] { String.valueOf(rg.getId()) });

        return affectedRows;
    }

    /**
     * Exclui registro de documento identificador do banco
     * @param rgId Id do registro a ser apagado
     * @return Total de registros afetados (0 ou 1)
     */
    public int deleteRG(long rgId)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        int affectedRows = db.delete(DATABASE_TABLE, // Nome da tabela onde se encontra o registro a apagar
                                     KEY_ID + " = ?", // Cláusula WHERE
                                     new String[] { String.valueOf(rgId) } // Parâmetros da cláusula WHERE
                                    );

        return affectedRows;
    }

    /**
     * Recupera dados de documento identificador a partirde resultado de consulta no banco de dados
     * @param cursor Stream de resultado de consulta com o banco
     * @return Dados de documento identificador
     */
    public RG getRgFromCursor(Cursor cursor)
    {
        RG rg = new RG();
        rg.setId(cursor.getLong(cursor.getColumnIndex(KEY_ID)));
        rg.setNumber(cursor.getString(cursor.getColumnIndex(KEY_NUMBER)));
        rg.setDispatcherStateId(cursor.getLong(cursor.getColumnIndex(KEY_FEDERATIVE_UNIT_ISSUER)));
        rg.setIssueDate(DateTimeUtils.GetDateTimeFromString(cursor.getString(cursor.getColumnIndex(KEY_ISSUE_DATE))));
        rg.setIssuingInstitution(cursor.getString(cursor.getColumnIndex(KEY_ISSUING_INSTITUTION)));

        return rg;
    }
}