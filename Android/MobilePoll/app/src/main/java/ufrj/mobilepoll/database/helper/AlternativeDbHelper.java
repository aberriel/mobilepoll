package ufrj.mobilepoll.database.helper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import ufrj.mobilepoll.model.Alternative;
import ufrj.mobilepoll.utils.BooleanUtils;
import ufrj.mobilepoll.utils.DatabaseManagerUtils;

/**
 * Adaptador do banco de dados específico para a tabela de alternativas das questões
 * Created by alira on 09/10/15.
 */
public class AlternativeDbHelper extends BaseDbHelper
{
    /** Nome da tabela que registra as alternativas das questões */
    public static final String DATABASE_TABLE = "MOB_Alternativa";

    private static final String KEY_ID = "M_Id";
    private static final String KEY_ID_TYPE = "integer";

    private static final String KEY_QUESTION = "M_Questao";
    private static final String KEY_QUESTION_TYPE = "integer";

    private static final String KEY_NUMBER = "M_Numero";
    private static final String KEY_NUMBER_TYPE = "varchar";

    private static final String KEY_VALUE = "M_Valor";
    private static final String KEY_VALUE_TYPE = "varchar";

    private static final String KEY_NEXT_QUESTION = "M_ProximaQuestao";
    private static final String KEY_NEXT_QUESTION_TYPE = "integer";

    private static final String KEY_REQUIRE_EXPLANATION = "M_FLG_JustificativaObrigatoria";
    private static final String KEY_REQUIRE_EXPLANATION_TYPE = "integer";

    /** Comando de criação da tabela das alternativas das questões */
    public static final String CREATE_TABLE = "create table " + DATABASE_TABLE
                                            + "("
                                            +       KEY_ID + " " + KEY_ID_TYPE + " not null primary key autoincrement,"
                                            +       KEY_QUESTION + " " + KEY_QUESTION_TYPE + " not null,"
                                            +       KEY_NUMBER + " " + KEY_NUMBER_TYPE + " not null,"
                                            +       KEY_VALUE + " " + KEY_VALUE_TYPE + " not null,"
                                            +       KEY_NEXT_QUESTION + " " + KEY_NEXT_QUESTION_TYPE + ","
                                            +       KEY_REQUIRE_EXPLANATION + " " + KEY_REQUIRE_EXPLANATION_TYPE
                                            + ")";

    /** Comando de exclusão da tabela das alternativas das questões */
    public static final String DELETE_TABLE = "drop table " + DATABASE_TABLE;

    /** Comando de limpeza da tabela das alternativas das questões (exclusão de todos os registros) */
    public static final String CLEAR_TABLE = "delete from " + DATABASE_TABLE;

    public AlternativeDbHelper(Context context)
    {
        super(context);
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        DatabaseManagerUtils.CreateAllTables(db);
        DatabaseManagerUtils.CreateInitData(db);
    }

    /**
     * Evento de atualização da base de dados, quando a versão mudar
     * @param db Conexão com o banco de dados
     * @param oldVersion Versão da base no dispositivo (antiga)
     * @param newVersion Versão da base na aplicação (nova)
     */
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        DatabaseManagerUtils.DeleteAllTables(db);
        DatabaseManagerUtils.CreateAllTables(db);
        DatabaseManagerUtils.CreateInitData(db);
    }

    /**
     * Registra nova alternativa no banco de dados
     * @param alternative Dados da alternativa
     * @return Identificador do registro gerado
     */
    public long create(Alternative alternative)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_QUESTION, alternative.getQuestionId());
        values.put(KEY_NUMBER, alternative.getNumber());
        values.put(KEY_VALUE, alternative.getValue());

        if(alternative.getNextQuestionId() != null)
        {
            values.put(KEY_NEXT_QUESTION, alternative.getNextQuestionId());
        }
        else
        {
            values.putNull(KEY_NEXT_QUESTION);
        }

        values.put(KEY_REQUIRE_EXPLANATION, BooleanUtils.convertBooleanToInteger(alternative.isRequiredExplanation()));

        long registerId = db.insert(DATABASE_TABLE, null, values);

        return registerId;
    }

    public Alternative getById(long alternativeId)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        Alternative alternative = null;

        String[] columns = {KEY_ID,
                            KEY_NUMBER,
                            KEY_VALUE,
                            KEY_QUESTION,
                            KEY_NEXT_QUESTION,
                            KEY_REQUIRE_EXPLANATION};

        Cursor cursor = db.query(DATABASE_TABLE,
                                 columns,
                                 KEY_ID + " = ?",
                                 new String[]{String.valueOf(alternativeId)},
                                 null,
                                 null,
                                 null);

        if(cursor != null && cursor.moveToFirst())
        {
            alternative = getDataByCursor(cursor);
        }

        return alternative;
    }

    public List<Alternative> getByQuestion(long questionId)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        List<Alternative> dataList = null;

        String[] columns = {KEY_ID,
                            KEY_QUESTION,
                            KEY_NUMBER,
                            KEY_VALUE,
                            KEY_REQUIRE_EXPLANATION,
                            KEY_NEXT_QUESTION};

        Cursor cursor = db.query(DATABASE_TABLE,
                                 columns,
                                 KEY_QUESTION + " = ?",
                                 new String[]{ String.valueOf(questionId) },
                                 null,
                                 null,
                                 null);

        if(cursor != null && cursor.moveToFirst())
        {
            dataList = new ArrayList<Alternative>();
            do
            {
                Alternative alternative = getDataByCursor(cursor);
                dataList.add(alternative);
            } while(cursor.moveToNext());
        }

        return dataList;
    }

    public Alternative getByQuestionAndNumber(long questionId, int number)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        Alternative alternative = null;

        String[] columns = {KEY_ID,
                            KEY_QUESTION,
                            KEY_NUMBER,
                            KEY_VALUE,
                            KEY_REQUIRE_EXPLANATION,
                            KEY_NEXT_QUESTION};

        Cursor cursor = db.query(DATABASE_TABLE,
                                 columns,
                                 KEY_QUESTION + " = ? and" + KEY_NUMBER + " = ?",
                                 new String[]{ String.valueOf(questionId), String.valueOf(number) },
                                 null,
                                 null,
                                 null);

        if(cursor != null && cursor.moveToFirst())
        {
            alternative = getDataByCursor(cursor);
        }

        return alternative;
    }

    public Alternative getByQuestionAndValue(long questionId, String value)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        Alternative alternative = null;

        String[] columns = {KEY_ID,
                            KEY_NUMBER,
                            KEY_VALUE,
                            KEY_QUESTION,
                            KEY_NEXT_QUESTION,
                            KEY_REQUIRE_EXPLANATION};

        Cursor cursor = db.query(DATABASE_TABLE,
                                 columns,
                                 KEY_QUESTION + " = ? and " + KEY_VALUE + " = ?",
                                 new String[]{ String.valueOf(questionId), value },
                                 null,
                                 null,
                                 null);

        if(cursor != null && cursor.moveToFirst())
        {
            alternative = getDataByCursor(cursor);
        }

        return alternative;
    }

    public Alternative getByResearchAndExplanationMandatory(long researchId, boolean explanationRequire)
    {
        SQLiteDatabase db = this.getWritableDatabase();
    }

    public int update(Alternative alternative)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
    }

    /**
     * Delete alternativa pelo id
     * @param alternativeId Id da alternativa a ser apagada
     * @return Total de registros afetados (no caso, 0 ou 1)
     */
    public int delete(long alternativeId)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        int affectedRows = db.delete(DATABASE_TABLE,
                                     KEY_ID + " = ?",
                                     new String[]{ String.valueOf(alternativeId) });

        return affectedRows;
    }

    /**
     * Deleta todas as alternativas de uma dada questão
     * @param questionId Id da questão cujas alternativas serão apagadas
     */
    public int deleteByQuestion(long questionId)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        int affectedRows = db.delete(DATABASE_TABLE,
                                     KEY_QUESTION + " = ?",
                                     new String[]{ String.valueOf(questionId) });

        return affectedRows;
    }

    public Alternative getDataByCursor(Cursor cursor)
    {
        Alternative alternative = new Alternative();
        alternative.setId(cursor.getLong(cursor.getColumnIndex(KEY_ID)));
        alternative.setNumber(cursor.getString(cursor.getColumnIndex(KEY_NUMBER)));
        alternative.setValue(cursor.getString(cursor.getColumnIndex(KEY_VALUE)));
        alternative.setQuestionId(cursor.getLong(cursor.getColumnIndex(KEY_QUESTION)));

        if(!cursor.isNull(cursor.getColumnIndex(KEY_NEXT_QUESTION)))
        {
            alternative.setNextQuestionId(cursor.getLong(cursor.getColumnIndex(KEY_NEXT_QUESTION)));
        }
        else
        {
            alternative.setNextQuestionId(null);
        }

        alternative.setRequiredExplanation(BooleanUtils.convertIntegerToBoolean(cursor.getInt(cursor.getColumnIndex(KEY_REQUIRE_EXPLANATION))));

        return alternative;
    }
}