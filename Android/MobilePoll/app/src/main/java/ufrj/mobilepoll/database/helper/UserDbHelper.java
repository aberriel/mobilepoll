package ufrj.mobilepoll.database.helper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import ufrj.mobilepoll.model.User;
import ufrj.mobilepoll.utils.DatabaseManagerUtils;

/**
 * Adaptador de banco de dados exclusivo para a tabela de usuários
 * Created by alira on 09/10/15.
 */
public class UserDbHelper extends BaseDbHelper
{
    /** Nome da tabela de usuários */
    public static final String DATABASE_TABLE = "MOB_Usuario";

    /** Nome da coluna da tabela de identificação do registro */
    private static final String KEY_ID = "M_Id";
    /** Tipo de dado da coluna de identificação do registro */
    private static final String KEY_ID_TYPE = "integer";

    /** Nome da coluna da tabela de login do usuário */
    private static final String KEY_LOGIN = "M_Login";
    /** Tipo de dado da coluna de login do usuário */
    private static final String KEY_LOGIN_TYPE = "varchar";

    /** Nome da coluna da tabela de senha do usuário */
    private static final String KEY_PASSWORD = "M_Senha";
    /** Tipo de dado da coluna de senha do usuário */
    private static final String KEY_PASSWORD_TYPE = "varchar";

    /** Comando de criação da tabela de usuários */
    public static final String CREATE_TABLE = "create table " + DATABASE_TABLE
                                            + "("
                                            +       KEY_ID + " " + KEY_ID_TYPE + " not null primary key,"
                                            +       KEY_LOGIN + " " + KEY_LOGIN_TYPE + " not null,"
                                            +       KEY_PASSWORD + " " + KEY_PASSWORD_TYPE + " not null"
                                            + ")";

    /** Comando de exclusão da tabela de usuários */
    public static final String DELETE_TABLE = "drop table " + DATABASE_TABLE;

    /** Comando de limpeza da tabela de usuário (exclusão de todos os registros */
    public static final String CLEAR_TABLE = "delete from " + DATABASE_TABLE;

    /** Construtor */
    public UserDbHelper(Context context)
    {
        super(context);
    }

    /**
     * Evento de criação do banco de dados, quando este não existir
     * @param db Conexão com o banco de dados
     */
    @Override
    public void onCreate(SQLiteDatabase db)
    {
        DatabaseManagerUtils.CreateAllTables(db);
    }

    /**
     * Evento de atualização da base de dados, quando as versões diferirem.
     * @param db Conexão com o banco de dados
     * @param oldVersion Versão da base presente no dispositivo
     * @param newVersion Versão nova
     */
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        DatabaseManagerUtils.DeleteAllTables(db);
        DatabaseManagerUtils.CreateAllTables(db);
    }

    /**
     * Registra novo usuário
     * @param user Dados do novo usuário
     * @return Identificador do usuário novo na tabela
     */
    public long create(User user)
    {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_ID, user.getId());
        values.put(KEY_LOGIN, user.getLogin());
        values.put(KEY_PASSWORD, user.getPassword());
        long idRegister = db.insert(DATABASE_TABLE, null, values);

        return idRegister;
    }

    /**
     * Busca usuário pelo id
     * @param id Identificador do usuário na tabela
     * @return Usuário encontrado
     */
    public User getUserById(long id)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        String raw_query = "select " + KEY_ID       + ","
                                     + KEY_LOGIN    + ","
                                     + KEY_PASSWORD
                         + " from " + DATABASE_TABLE
                         + " where " + KEY_ID + " = ?";

        String[] parameters = new String[]{ String.valueOf(id) };

        Cursor cursor = db.rawQuery(raw_query, parameters);
        User user = null;

        if(cursor != null && cursor.moveToFirst())
        {
            user = new User();
            user.setId(id);
            user.setLogin(cursor.getString(cursor.getColumnIndex(KEY_LOGIN)));
            user.setPassword(cursor.getString(cursor.getColumnIndex(KEY_PASSWORD)));
        }

        return user;
    }

    /**
     * Busca usuário pelo login
     * @param login Login do usuário
     * @return Usuário encontrado com o login fornecido
     */
    public User getUserByLogin(String login)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        String raw_query = "select " + KEY_ID       + ","
                                     + KEY_LOGIN    + ","
                                     + KEY_PASSWORD
                        + " from " + DATABASE_TABLE
                        + " where " + KEY_LOGIN + " = ?";

        String[] parameters = {login};

        Cursor cursor = db.rawQuery(raw_query, parameters);
        User user = null;

        if(cursor != null && cursor.moveToFirst())
        {
            user = new User();
            user.setId(cursor.getLong(cursor.getColumnIndex(KEY_ID)));
            user.setLogin(login);
            user.setPassword(cursor.getString(cursor.getColumnIndex(KEY_PASSWORD)));
        }

        return user;
    }

    /**
     * Atualiza registro de usuário.
     * @param user Dados do usuário atualizados
     * @return Total de registros alterados.
     */
    public int update(User user)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_LOGIN, user.getLogin());
        values.put(KEY_PASSWORD, user.getPassword());

        int i = db.update(DATABASE_TABLE,
                          values,
                          KEY_ID + " = ?",
                          new String[] { String.valueOf(user.getId()) });

        return i;
    }

    /**
     * Apaga registro do banco
     * @param idUser Id do registro a ser excluído.
     */
    public void delete(long idUser)
    {
        SQLiteDatabase db = getWritableDatabase();
        db.delete(DATABASE_TABLE,
                  KEY_ID + " = ?",
                  new String[] { String.valueOf(idUser)});
    }

    public User getUserFromCursor(Cursor cursor)
    {
        User user = new User();
        user.setId(cursor.getLong(cursor.getColumnIndex(KEY_ID)));
        user.setLogin(cursor.getString(cursor.getColumnIndex(KEY_LOGIN)));
        user.setPassword(cursor.getString(cursor.getColumnIndex(KEY_PASSWORD)));

        return user;
    }
}