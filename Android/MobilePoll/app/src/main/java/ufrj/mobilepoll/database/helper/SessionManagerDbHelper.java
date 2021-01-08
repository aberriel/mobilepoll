package ufrj.mobilepoll.database.helper;

import android.content.ContentValues;
import android.content.Context;
import android.content.pm.PackageInstaller;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.provider.ContactsContract;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import ufrj.mobilepoll.model.SessionManager;
import ufrj.mobilepoll.utils.DatabaseManagerUtils;
import ufrj.mobilepoll.utils.DateTimeUtils;

/**
 * Adaptador de banco de dados exclusivo para a tabela de gerenciamento de sessão de usuário
 * Created by alira on 09/10/15.
 */
public class SessionManagerDbHelper extends BaseDbHelper
{
    /** Nome da tabela de gerenciamento de sessão de usuário no banco de dados */
    public static final String DATABASE_TABLE = "MOB_GerenciadorSessao";

    /** Nome da coluna do identificador do registro (primary key) */
    private static final String KEY_ID = "M_Id";
    /** Tipo de dado da coluna de identificação do registro (primary key) */
    private static final String KEY_ID_TYPE = "integer";

    /** Nome da coluna de identificação do usuário autenticado */
    private static final String KEY_USER_ID = "M_IdUsuario";
    /** Tipo de dado da coluna de identificação do usuário autenticado */
    private static final String KEY_USER_ID_TYPE = "integer";

    private static final String KEY_USERKEY = "M_ChaveUsuario";
    private static final String KEY_USERKEY_TYPE = "varchar";

    /** Nome da coluna da data e hora de início da sessão */
    private static final String KEY_INIT_DATETIME = "M_DataHoraInicio";
    /** Parâmetros complementares da coluna para sua criação */
    private static final String KEY_INIT_DATETIME_COMPLEMENT = "not null default CURRENT_TIMESTAMP";
    /** Tipo de dado da coluna da data e hora de início da sessão */
    private static final String KEY_INIT_DATETIME_TYPE = "datetime";

    /** Nome da coluna da data e hora da última ação executada pelo usuário na aplicação */
    private static final String KEY_LAST_ACTIVITY_DATETIME = "M_DataHoraUltimaAtividade";
    private static final String KEY_LAST_ACTIVITY_DATETIME_TYPE = "datetime";

    /** Nome da coluna da data e hora do término da sessão */
    private static final String KEY_FINISH_DATETIME = "M_DataHoraTermino";
    /** Tipo de dado da coluna da data e hora do término da sessão */
    private static final String KEY_FINISH_DATETIME_TYPE = "datetime";

    /** Nome da coluna do motivo de término da sessão */
    private static final String KEY_FINISH_REASON = "M_MotivoTerminoSessao";
    /** Tipo de dado da coluna do motivo do término da sessão */
    private static final String KEY_FINISH_REASON_TYPE = "varchar";

    /** Comando de criação da tabela de gerenciamento de sessão de usuário */
    public static final String CREATE_TABLE = "create table " + DATABASE_TABLE
                                            + "("
                                            +       KEY_ID                     + " " + KEY_ID_TYPE                      + " not null primary key autoincrement,"
                                            +       KEY_USER_ID                + " " + KEY_USER_ID_TYPE                 + " not null,"
                                            +       KEY_USERKEY                + " " + KEY_USERKEY_TYPE                 + " not null,"
                                            +       KEY_INIT_DATETIME          + " " + KEY_INIT_DATETIME_TYPE           + " not null default CURRENT_TIMESTAMP,"
                                            +       KEY_LAST_ACTIVITY_DATETIME + " " + KEY_LAST_ACTIVITY_DATETIME_TYPE  + " not null default CURRENT_TIMESTAMP,"
                                            +       KEY_FINISH_DATETIME        + " " + KEY_FINISH_DATETIME_TYPE         + ","
                                            +       KEY_FINISH_REASON          + " " + KEY_FINISH_REASON_TYPE
                                            + ")";

    /** Deleta tabela de gerenciamento de sessão de usuário */
    public static final String DELETE_TABLE = "drop table " + DATABASE_TABLE;

    /** Apaga todos os dados da tabela de gerenciamento de sessão de usuário */
    public static final String CLEAR_TABLE = "delete from " + DATABASE_TABLE;

    /** Construtor */
    public SessionManagerDbHelper(Context context)
    {
        super(context);
    }

    /**
     * Evento de criação da base de dados quando este não existir
     * @param db Conexão com o banco de dados
     */
    @Override
    public void onCreate(SQLiteDatabase db)
    {
        DatabaseManagerUtils.CreateAllTables(db);
        DatabaseManagerUtils.CreateInitData(db);
    }

    /**
     * Evento de atualização da base de dados quando esta for diferente
     * @param db Conexão com o banco de dados
     * @param oldVersion
     * @param newVersion
     */
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        DatabaseManagerUtils.DeleteAllTables(db);
        DatabaseManagerUtils.CreateAllTables(db);
        DatabaseManagerUtils.CreateInitData(db);
    }

    @Override
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        super.onDowngrade(db, oldVersion, newVersion);
        DatabaseManagerUtils.DeleteAllTables(db);
        DatabaseManagerUtils.CreateAllTables(db);
        DatabaseManagerUtils.CreateInitData(db);
    }

    /**
     * Registra nova sessão de usuário
     * @param sessionManager Dados da nova sessão a ser registrada
     * @return Chave de segurançao do usuário para esta sessão
     */
    public long create(SessionManager sessionManager)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_USER_ID, sessionManager.getIdUser());

        String user_key = UUID.randomUUID().toString();
        values.put(KEY_USERKEY, user_key);

        if(sessionManager.getInitDateTime() == null)
        {
            sessionManager.setInitDateTime(new Date());
        }

        values.put(KEY_INIT_DATETIME, DateTimeUtils.GetDateTimeInDatabaseStringFormat(sessionManager.getInitDateTime()));

        long registerId = db.insert(DATABASE_TABLE, null, values);

        return registerId;
    }

    /**
     * Recupera todas as sessões registradas no banco
     * @return Coleção de sessões de usuário encontradas
     */
    public List<SessionManager> getAll()
    {
        SQLiteDatabase db = this.getWritableDatabase();
        List<SessionManager> dataList = new ArrayList<SessionManager>();

        String raw_query = "select " + KEY_ID                     + ","
                                     + KEY_USER_ID                + ","
                                     + KEY_USERKEY                + ","
                                     + KEY_INIT_DATETIME          + ","
                                     + KEY_LAST_ACTIVITY_DATETIME + ","
                                     + KEY_FINISH_DATETIME        + ","
                                     + KEY_FINISH_REASON
                        + " from " + DATABASE_TABLE;

        Cursor cursor = db.rawQuery(raw_query, null);

        if(cursor != null && cursor.moveToFirst())
        {
            do
            {
                SessionManager sessionManager = getDataFromCursor(cursor);
                dataList.add(sessionManager);
            } while(cursor.moveToNext());
        }

        return dataList;
    }

    /**
     * Localiza registro de sessão pelo id da tabela
     * @param sessionId Id do registro de sessão a ser encontrado
     * @return
     */
    public SessionManager getById(long sessionId)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        SessionManager sessionManager = null;

        String[] columns = {KEY_ID,
                            KEY_USER_ID,
                            KEY_USERKEY,
                            KEY_INIT_DATETIME,
                            KEY_LAST_ACTIVITY_DATETIME,
                            KEY_FINISH_DATETIME,
                            KEY_FINISH_REASON};

        Cursor cursor = db.query(DATABASE_TABLE,
                columns,
                KEY_ID + " = ?",
                new String[]{KEY_ID},
                null,
                null,
                null);

        if(cursor != null && cursor.moveToFirst())
        {
            sessionManager = getDataFromCursor(cursor);
        }

        return sessionManager;
    }

    /**
     * Busca sessão pela chave pública da sessão
     * @param key Chave da sessão
     * @return Dados da sessão encontrada
     */
    public SessionManager getByKey(String key)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        SessionManager sessionManager = null;

        String[] columns = {KEY_ID,
                            KEY_USER_ID,
                            KEY_USERKEY,
                            KEY_INIT_DATETIME,
                            KEY_LAST_ACTIVITY_DATETIME,
                            KEY_FINISH_DATETIME,
                            KEY_FINISH_REASON};

        Cursor cursor = db.query(DATABASE_TABLE,
                columns,
                KEY_USERKEY + " = ?",
                new String[]{key},
                null,
                null,
                null);

        if(cursor != null && cursor.moveToFirst())
        {
            sessionManager = getDataFromCursor(cursor);
        }

        return sessionManager;
    }

    /**
     * Recupera dados do último acesso do usuário (o de início mais recente)
     * @param userId Id do usuário
     * @return Dados da sessão mais recente (a última) do usuário
     */
    public SessionManager getLastByUser(long userId)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        SessionManager sessionManager = null;

        String raw_query = "select " + KEY_ID                     + ","
                                     + KEY_USER_ID                + ","
                                     + KEY_USERKEY                + ","
                                     + KEY_INIT_DATETIME          + ","
                                     + KEY_LAST_ACTIVITY_DATETIME + ","
                                     + KEY_FINISH_DATETIME        + ","
                                     + KEY_FINISH_REASON
                         + " from " + DATABASE_TABLE
                         + " where " + KEY_USER_ID + " = ?"
                         + " order by " + KEY_INIT_DATETIME + " desc limit 1";

        String[] parameters = { String.valueOf(userId) };

        Cursor cursor = db.rawQuery(raw_query, parameters);

        if(cursor != null && cursor.moveToFirst())
        {
            sessionManager = getDataFromCursor(cursor);
        }

        return sessionManager;
    }

    /**
     * Recupera dados da sessão corrente, independente do usuário
     * @return Dados da sessão encontrada
     */
    public SessionManager getCurrent() throws Exception
    {
        SQLiteDatabase db = this.getWritableDatabase();
        SessionManager sessionManager = null;

        // Pego as sessões sem data e hora de encerramento nem motivo de encerramento
        String raw_query = "select " + KEY_ID                     + ","
                                     + KEY_USER_ID                + ","
                                     + KEY_USERKEY                + ","
                                     + KEY_INIT_DATETIME          + ","
                                     + KEY_LAST_ACTIVITY_DATETIME + ","
                                     + KEY_FINISH_DATETIME        + ","
                                     + KEY_FINISH_REASON
                         + " from " + DATABASE_TABLE
                         + " where " + KEY_FINISH_DATETIME + " is null and " + KEY_FINISH_REASON + " is null"
                         + " order by " + KEY_INIT_DATETIME + " desc limit 1";

        Cursor cursor = db.rawQuery(raw_query, null);

        if(cursor != null && cursor.moveToFirst())
        {
            if(cursor.getCount() > 1)
            {
                throw new Exception("Há mais de uma sessão ativa.");
            }

            sessionManager = getDataFromCursor(cursor);
        }

        return sessionManager;
    }

    /**
     * Retorna as sessões de um dado usuário.
     * @param userId
     * @return
     */
    public List<SessionManager> getAllByUser(long userId, Integer limit)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        List<SessionManager> dataList = null;

        String[] columns = {KEY_ID,
                            KEY_USER_ID,
                            KEY_USERKEY,
                            KEY_INIT_DATETIME,
                            KEY_LAST_ACTIVITY_DATETIME,
                            KEY_FINISH_DATETIME,
                            KEY_FINISH_REASON};

        String limit_str = null;
        if(limit != null && limit > 0)
        {
            limit_str = String.valueOf(limit);
        }

        Cursor cursor = db.query(DATABASE_TABLE,
                columns,
                KEY_USER_ID + " = ?",
                new String[]{String.valueOf(userId)},
                null,
                null,
                KEY_INIT_DATETIME + " DESC",
                limit_str);

        if(cursor != null && cursor.moveToFirst())
        {
            dataList = new ArrayList<SessionManager>();
            do
            {
                SessionManager sessionManager = getDataFromCursor(cursor);
                dataList.add(sessionManager);
            } while(cursor.moveToNext());
        }

        return dataList;
    }

    public List<SessionManager> getByReason(String reason, Integer limit)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        List<SessionManager> dataList = null;

        String[] columns = {KEY_ID,
                            KEY_USER_ID,
                            KEY_USERKEY,
                            KEY_INIT_DATETIME,
                            KEY_LAST_ACTIVITY_DATETIME,
                            KEY_FINISH_DATETIME,
                            KEY_FINISH_REASON};

        String limit_str = null;
        if(limit != null && limit > 0)
        {
            limit_str = String.valueOf(limit);
        }

        Cursor cursor = db.query(DATABASE_TABLE,
                columns,
                KEY_FINISH_REASON + " like ? collate nocase",
                new String[]{reason},
                null,
                null,
                KEY_INIT_DATETIME + " desc",
                limit_str);

        if(cursor != null && cursor.moveToFirst())
        {
            dataList = new ArrayList<SessionManager>();
            do
            {
                SessionManager sessionManager = getDataFromCursor(cursor);
                dataList.add(sessionManager);
            } while(cursor.moveToNext());
        }

        return dataList;
    }

    public List<SessionManager> getByReasonAndUser(String reason, long userId)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        List<SessionManager> dataList = null;

        String raw_query = "select " + KEY_ID                     + ","
                                     + KEY_USER_ID                + ","
                                     + KEY_USERKEY                + ","
                                     + KEY_INIT_DATETIME          + ","
                                     + KEY_LAST_ACTIVITY_DATETIME + ","
                                     + KEY_FINISH_DATETIME        + ","
                                     + KEY_FINISH_REASON
                         + " from " +  DATABASE_TABLE
                         + " where " + KEY_FINISH_REASON + " like ?"
                                    + " and " + KEY_USER_ID + " = ?"
                         + " order by " + KEY_INIT_DATETIME + " desc";

        String[] params = { reason, String.valueOf(userId) };

        Cursor cursor = db.rawQuery(raw_query, params);

        if(cursor != null && cursor.moveToFirst())
        {
            dataList = new ArrayList<SessionManager>();
            do
            {
                SessionManager sessionManager = getDataFromCursor(cursor);
                dataList.add(sessionManager);
            } while(cursor.moveToNext());
        }

        return dataList;
    }

    /**
     * Busca sessões pelo dia do acesso.
     * @param initDate Data do acesso, dentro do qual obterei todas as sessões.
     * @return Coleção de acessos de um dado dia.
     */
    public List<SessionManager> getByInitDate(Date initDate)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        List<SessionManager> dataList = null;

        String[] columns = {KEY_ID,
                            KEY_USER_ID,
                            KEY_USERKEY,
                            KEY_INIT_DATETIME,
                            KEY_LAST_ACTIVITY_DATETIME,
                            KEY_FINISH_DATETIME,
                            KEY_FINISH_REASON};

        Date initDate_query = new Date(initDate.getYear(), initDate.getMonth(), initDate.getDay(), 0, 0, 0);
        String initDate_query_str = DateTimeUtils.GetDateTimeInDatabaseStringFormat(initDate_query);

        Date finishDate_query = new Date(initDate.getYear(), initDate.getMonth(), initDate.getDay(), 23, 59, 59);
        String finishDate_query_str = DateTimeUtils.GetDateTimeInDatabaseStringFormat(finishDate_query);

        Cursor cursor = db.query(DATABASE_TABLE,
                                 columns,
                                 KEY_INIT_DATETIME + " > ? and " + KEY_INIT_DATETIME + " < ?",
                                 new String[]{initDate_query_str, finishDate_query_str},
                                 null,
                                 null,
                                 null);

        if(cursor != null && cursor.moveToFirst())
        {
            dataList = new ArrayList<SessionManager>();
            do
            {
                SessionManager sessionManager = getDataFromCursor(cursor);
                dataList.add(sessionManager);
            } while(cursor.moveToNext());
        }

        return dataList;
    }

    /**
     * Atualiza registro de sessão do usuário.
     *
     * Somente os seguintes atributos poderão ter o seu valor alterado:
     *
     *      1 - FinishDatetime (data e hora do término da sessão)
     *      2 - LastActivityDateTime (data e hora da última atividade do usuário na sessão)
     *      3 - FinishReason (causa do fim da sessão)
     * @param sessionManager Dados da sessão atualizados
     * @return Total de registros afetados (0 ou 1)
     */
    public int update(SessionManager sessionManager)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        if(sessionManager.getFinishDateTime() != null)
        {
            values.put(KEY_FINISH_DATETIME, DateTimeUtils.GetDateTimeInDatabaseStringFormat(sessionManager.getFinishDateTime()));
        }
        else
        {
            values.putNull(KEY_FINISH_DATETIME);
        }

        if(sessionManager.getSessionFinishReason() != null)
        {
            values.put(KEY_FINISH_REASON, sessionManager.getSessionFinishReason());
        }
        else
        {
            values.putNull(KEY_FINISH_REASON);
        }

        values.put(KEY_LAST_ACTIVITY_DATETIME, DateTimeUtils.GetDateTimeInDatabaseStringFormat(sessionManager.getLastActivityDateTime()));

        int affectedRows = db.update(DATABASE_TABLE,
                                     values,
                                     KEY_ID + " = ?",
                                     new String[]{ String.valueOf(sessionManager.getId()) });

        return affectedRows;
    }

    /**
     * Deleta registro de sessão do usuário do banco
     * @param sessionId Identificador do registro a ser apagado
     * @return Total de registros afetados (0 ou 1)
     */
    public int delete(long sessionId)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        int affectedRows = db.delete(DATABASE_TABLE,
                                     KEY_ID + " = ?",
                                     new String[]{ String.valueOf(sessionId) });

        return affectedRows;
    }

    public SessionManager getDataFromCursor(Cursor cursor)
    {
        SessionManager sessionManager = new SessionManager();
        sessionManager.setId(cursor.getLong(cursor.getColumnIndex(KEY_ID)));
        sessionManager.setIdUser(cursor.getLong(cursor.getColumnIndex(KEY_USER_ID)));
        sessionManager.setUserKey(cursor.getString(cursor.getColumnIndex(KEY_USERKEY)));
        sessionManager.setInitDateTime(DateTimeUtils.GetDateTimeFromString(cursor.getString(cursor.getColumnIndex(KEY_INIT_DATETIME))));
        sessionManager.setLastActivityDateTime(DateTimeUtils.GetDateTimeFromString(cursor.getString(cursor.getColumnIndex(KEY_LAST_ACTIVITY_DATETIME))));

        if(!cursor.isNull(cursor.getColumnIndex(KEY_FINISH_DATETIME)))
        {
            sessionManager.setFinishDateTime(DateTimeUtils.GetDateTimeFromString(cursor.getString(cursor.getColumnIndex(KEY_FINISH_DATETIME))));
        }
        else
        {
            sessionManager.setFinishDateTime(null);
        }

        if(!cursor.isNull(cursor.getColumnIndex(KEY_FINISH_REASON)))
        {
            sessionManager.setSessionFinishReason(cursor.getString(cursor.getColumnIndex(KEY_FINISH_REASON)));
        }

        return sessionManager;
    }
}