package ufrj.mobilepoll.database.helper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Base para os adaptadores de banco de dados
 * Created by alira on 09/10/15.
 */
public abstract class BaseDbHelper extends SQLiteOpenHelper
{
    /** Nome da base de dados */
    protected static final String DATABASE_NAME = "MobilePoll";

    /** Cláusula de chave primária */
    protected static final String PRIMARY_KEY_CONSTRAINT = " primary key";

    /** Cláusula de coluna obrigatória (não nula) */
    protected static final String NOT_NULL_CONSTRAINT = " not null";

    /** Cláusula de coluna do tipo identidade (auto-incrementável) */
    protected static final String AUTO_INCREMENT_CONSTRAINT = " autoincrement";

    /** Versão da base de dados */
    protected static final int DATABASE_VERSION = 1;

    Context context;

    /**
     * Construtor
     * @param context
     */
    public BaseDbHelper(Context context)
    {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        context = context;
    }

    /** Encerra a conexão com o banco de dados */
    public void CloseDB()
    {
        SQLiteDatabase db = this.getReadableDatabase();
        if(db != null && db.isOpen())
        {
            db.close();
        }
    }
}