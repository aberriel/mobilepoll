package ufrj.mobilepoll.utils;

import android.database.sqlite.SQLiteDatabase;

import ufrj.mobilepoll.database.helper.CityDbHelper;
import ufrj.mobilepoll.database.helper.PersonDbHelper;
import ufrj.mobilepoll.database.helper.ResearchGroupDbHelper;
import ufrj.mobilepoll.database.helper.RgDbHelper;
import ufrj.mobilepoll.database.helper.UserDbHelper;
import ufrj.mobilepoll.model.Person;

/**
 * Utilitários relacionados ao gerenciamento do banco de dados
 * Created by alira on 11/10/15.
 */
public class DatabaseManagerUtils
{
    /**
     * Cria todas as tabelas do banco de dados.
     * @param db Conexão com o banco
     */
    public static void CreateAllTables(SQLiteDatabase db)
    {
        db.execSQL(PersonDbHelper.CREATE_TABLE);
        db.execSQL(UserDbHelper.CREATE_TABLE);
        db.execSQL(CityDbHelper.CREATE_TABLE);
        db.execSQL(RgDbHelper.CREATE_TABLE);
        db.execSQL(ResearchGroupDbHelper.CREATE_TABLE);
    }

    /**
     * Deleta todas as tabelas do banco de dados
     * @param db Conexão com o banco.
     */
    public static void DeleteAllTables(SQLiteDatabase db)
    {
        db.execSQL(PersonDbHelper.DELETE_TABLE);
        db.execSQL(UserDbHelper.DELETE_TABLE);
        db.execSQL(CityDbHelper.DELETE_TABLE);
        db.execSQL(RgDbHelper.DELETE_TABLE);
        db.execSQL(ResearchGroupDbHelper.DELETE_TABLE);
    }

    /**
     * Criação dos dados necessários para inicialização da aplicação
     * @param db Conexão com o banco de dados
     */
    public static void CreateInitData(SQLiteDatabase db)
    {

    }

    /**
     * Limpa o banco (apaga todos os registros de todas as tabelas)
     * @param db Conexão com o banco de dados
     * @return Total de registros apagados
     */
    public static int ClearAllTables(SQLiteDatabase db)
    {
        db.delete(PersonDbHelper.DATABASE_TABLE, null, null);

        return 0;
    }
}