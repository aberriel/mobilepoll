package ufrj.mobilepoll.database.helper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import ufrj.mobilepoll.model.Person;
import ufrj.mobilepoll.utils.DatabaseManagerUtils;
import ufrj.mobilepoll.utils.DateTimeUtils;

/**
 * Adaptador do banco de dados específico para a tabela de pessoa
 * Created by alira on 09/10/15.
 */
public class PersonDbHelper extends BaseDbHelper
{
    /** Nome da tabela do banco */
    public static final String DATABASE_TABLE = "MOB_Pessoa";

    /** Nome da coluna da tabela de identificação do registro */
    public static final String KEY_ID = "M_Id";
    /** Tipo de dado da coluna de identificação do registro */
    public static final String KEY_ID_TYPE = "integer";

    /** Nome da coluna da tabela do nome da pessoa */
    public static final String KEY_NAME = "M_Nome";
    /** Tipo de dado da coluna do nome da pessoa */
    public static final String KEY_NAME_TYPE = "varchar";

    public static final String KEY_DESCRIPTION = "M_Descricao";
    public static final String KEY_DESCRIPTION_TYPE = "varchar";

    /** Nome da coluna da tabela do e-mail principal */
    public static final String KEY_EMAIL1 = "M_Email1";
    /** Tipo de dado da coluna do e-mail principal */
    public static final String KEY_EMAIL1_TYPE = "varchar";

    /** Nome da coluna da tabela do e-mail secundário */
    public static final String KEY_EMAIL2 = "M_Email2";
    /** Tipo de dado da coluna do e-mail secundário */
    public static final String KEY_EMAIL2_TYPE = "varchar";

    /** Nome da coluna da tabela da data de nascimento da pessoa */
    public static final String KEY_BIRTHDAY = "M_DataNascimento";
    /** Tipo de dado da coluna da data de nascimento da pessoa */
    public static final String KEY_BIRTHDAY_TYPE = "datetime";

    /** Nome da coluna na tabela do telefone principal da pessoa */
    public static final String KEY_TELEPHONE1 = "M_Telefone1";
    /** Tipo de dado da coluna do telefone principal da pessoa (no caso, VARCHAR) */
    public static final String KEY_TELEPHONE1_TYPE = "varchar";

    /** Nome da coluna na tabela do telefone secundário da pessoa */
    public static final String KEY_TELEPHONE2 = "M_Telefone2";
    /** Tipo de dado da coluna do telefone secundário da pessoa (no caso, VARCHAR) */
    public static final String KEY_TELEPHONE2_TYPE = "varchar";

    /** Nome da coluna na tabela do logradouro do endereço da pessoa */
    public static final String KEY_STREET = "M_Logradouro";
    /** Tipo de dado da coluna do logradouro do endereço da pessoa (no caso, VARCHAR) */
    public static final String KEY_STREET_TYPE = "varchar";

    /** Nome da coluna na tabela do número do imóvel no endereço da pessoa */
    public static final String KEY_STREETNUMBER = "M_NumeroEndereco";
    public static final String KEY_STREETNUMBER_TYPE = "varchar";

    /** Nome da coluna na tabela do complemento do endereço da pessoa */
    public static final String KEY_COMPLEMENT = "M_Complemento";
    /** Tipo de dado da coluna do complemento do endereço da pessoa (no caso, VARCHAR) */
    public static final String KEY_COMPLEMENT_TYPE = "varchar";

    /** Nome da coluna na tabela do nome do bairro do endereço da pessoa */
    public static final String KEY_NEIGHBORHOOD = "M_Bairro";
    /** Tipo de dado da coluna do bairro do endereço da pessoa (no caso, VARCHAR) */
    public static final String KEY_NEIGHBORHOOD_TYPE = "varchar";

    /** Nome da coluna na tabela do nome do município do endereço da pessoa */
    public static final String KEY_CITY = "M_Cidade";
    /** Tipo de dado da coluna do nome do munic[ipio do endereço da pessoa (no caso, VARCHAR) */
    public static final String KEY_CITY_TYPE = "integer";

    /** Nome da coluna na tabela do CEP do endereço da pessoa */
    public static final String KEY_POSTALCODE = "M_CEP";
    /** Tipo de dado da coluna do código postal do endereço da pessoa (no caso, VARCHAR) */
    public static final String KEY_POSTALCODE_TYPE = "varchar";

    /** Nome da coluna da tabela do nome da cidade de nascimento da pessoa */
    public static final String KEY_CITYOFBIRTH = "M_CidadeDeNascimento";
    /** Tipo de dado da coluna da cidade de nascimento da pessoa */
    public static final String KEY_CITYOFBIRTH_TYPE = "integer";

    /** Nome da coluna na tabela do identificador do registro do RG da pessoa */
    public static final String KEY_RG = "M_RG";
    /** Tipo de dado da coluna da tabela do identificador do registro do RG da pessoa */
    public static final String KEY_RG_TYPE = "integer";

    /** Nome da coluna da tabela do número do CPF da pessoa */
    public static final String KEY_CPF = "M_CPF";
    /** Tipo de dado da coluna do número do CPF da pessoa */
    public static final String KEY_CPF_TYPE = "varchar";

    /** Comando de criação da tabela de pessoa */
    public static final String CREATE_TABLE = "create table " + DATABASE_TABLE
                                            + "("
                                            +      KEY_ID           + " " + KEY_ID_TYPE            + " primary key autoincrement not null, "
                                            +      KEY_NAME         + " " + KEY_NAME_TYPE          + " not null,"
                                            +      KEY_DESCRIPTION  + " " + KEY_DESCRIPTION_TYPE   + ","
                                            +      KEY_EMAIL1       + " " + KEY_EMAIL1_TYPE        + ","
                                            +      KEY_EMAIL2       + " " + KEY_EMAIL2_TYPE        + ","
                                            +      KEY_BIRTHDAY     + " " + KEY_BIRTHDAY_TYPE      + ","
                                            +      KEY_TELEPHONE1   + " " + KEY_TELEPHONE1_TYPE    + ","
                                            +      KEY_TELEPHONE2   + " " + KEY_TELEPHONE2_TYPE    + ","
                                            +      KEY_STREET       + " " + KEY_STREET_TYPE        + ","
                                            +      KEY_STREETNUMBER + " " + KEY_STREETNUMBER_TYPE  + ","
                                            +      KEY_COMPLEMENT   + " " + KEY_COMPLEMENT_TYPE    + ","
                                            +      KEY_NEIGHBORHOOD + " " + KEY_NEIGHBORHOOD_TYPE  + ","
                                            +      KEY_CITY         + " " + KEY_CITY_TYPE          + ","
                                            +      KEY_POSTALCODE   + " " + KEY_POSTALCODE_TYPE    + ","
                                            +      KEY_CITYOFBIRTH  + " " + KEY_CITYOFBIRTH_TYPE   + ","
                                            +      KEY_RG           + " " + KEY_RG_TYPE            + ","
                                            +      KEY_CPF          + " " + KEY_CPF_TYPE
                                            + ")";

    /** Comando de exclusão da tabela de pessoa */
    public static final String DELETE_TABLE = "drop table " + DATABASE_TABLE;

    /** Comando de limpeza (exclusão de todos os registros) da tabela de Pessoa */
    public static final String CLEAR_TABLE = "delete from " + DATABASE_TABLE;

    /**
     * Construtor
     * @param context
     */
    public PersonDbHelper(Context context)
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
     * Evento de atualização do banco de dados, quando a versão é incrementada
     * @param db Conexão com o banco de dados
     * @param oldVersion Versão anterior (da base local)
     * @param newVersion Versão nova (da base atualizada )
     */
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        DatabaseManagerUtils.DeleteAllTables(db);
        DatabaseManagerUtils.CreateAllTables(db);
    }

    /**
     * Registra nova pessoa
     * @param person Dados da nova pessoa
     * @return Id da pessoa registrada
     */
    public long create(Person person)
    {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_NAME, person.getName());
        values.put(KEY_DESCRIPTION, person.getDescription());
        values.put(KEY_EMAIL1, person.getPrimaryEmail());
        values.put(KEY_EMAIL2, person.getSecondaryEmail());
        values.put(KEY_TELEPHONE1, person.getPrimaryTelephone());
        values.put(KEY_TELEPHONE2, person.getSecondaryTelephone());

        if(person.getBirthday() != null)
        {
            values.put(KEY_BIRTHDAY, DateTimeUtils.GetDateTimeInDatabaseStringFormat(person.getBirthday()));
        }

        values.put(KEY_STREET, person.getStreet());
        values.put(KEY_STREETNUMBER, person.getStreetNumber());
        values.put(KEY_COMPLEMENT, person.getComplement());
        values.put(KEY_NEIGHBORHOOD, person.getNeighborhood());

        if(person.getCityId() != null && person.getCityId() > 0)
        {
           values.put(KEY_CITY, person.getCityId());
        }

        if(person.getBirthCityId() != null && person.getBirthCityId() > 0)
        {
            values.put(KEY_CITYOFBIRTH, person.getBirthCityId());
        }

        values.put(KEY_POSTALCODE, person.getPostalCode());
        values.put(KEY_CPF, person.getCPF());

        long registerId = db.insert(DATABASE_TABLE, null, values);

        return registerId;
    }

    /**
     * Busca pessoa pelo id da tabela
     * @param personId Id da pessoa que se deseja encontrar
     * @return Dados da pessoa encontrada
     */
    public Person getPersonById(long personId)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        String raw_query = "select * from " + DATABASE_TABLE + " where " + KEY_ID + " = ?";
        String[] parameters = new String[] { String.valueOf(personId) };

        Cursor cursor = db.rawQuery(raw_query, parameters);
        Person person = null;

        if(cursor != null && cursor.moveToFirst())
        {
            person = getDataFromCursor(cursor);
        }

        return person;
    }

    /**
     * Busca pessoa pelo e-mail primário (principal)
     * @param email E-mail da pessoa a ser encontrada
     * @return Pessoa encontrada
     */
    public List<Person> getPersonByEmail(String email)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        List<Person> personList = new ArrayList<Person>();
        String[] columns = {KEY_ID,
                            KEY_NAME,
                            KEY_DESCRIPTION,
                            KEY_EMAIL1,
                            KEY_EMAIL2,
                            KEY_TELEPHONE1,
                            KEY_TELEPHONE2,
                            KEY_BIRTHDAY,
                            KEY_STREET,
                            KEY_STREETNUMBER,
                            KEY_COMPLEMENT,
                            KEY_NEIGHBORHOOD,
                            KEY_CITY,
                            KEY_POSTALCODE,
                            KEY_CITYOFBIRTH,
                            KEY_RG,
                            KEY_CPF};

        Cursor cursor = db.query(DATABASE_TABLE, // Tabela do SELECT
                                 columns, // Colunas do SELECT
                                 KEY_EMAIL1 + " = ?", // Cláusula WHERE
                                 new String[] { email }, // Parâmetros do WHERE
                                 null, // GROUP BY
                                 null, // HAVING
                                 KEY_NAME // ORDER BY
                                );

        if(cursor != null && cursor.moveToFirst())
        {
            do
            {
                Person person = getDataFromCursor(cursor);
                personList.add(person);
            } while(cursor.moveToNext());
        }

        return personList;
    }

    /**
     * Atualiza registro de pessoa no banco
     * @param person Dados da pessoa atualizados
     * @return Número de registros afetados
     */
    public int update(Person person)
    {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_NAME, person.getName());
        values.put(KEY_DESCRIPTION, person.getDescription());
        values.put(KEY_EMAIL1, person.getPrimaryEmail());
        values.put(KEY_EMAIL2, person.getSecondaryEmail());
        values.put(KEY_TELEPHONE1, person.getPrimaryTelephone());
        values.put(KEY_TELEPHONE2, person.getSecondaryTelephone());

        if(person.getBirthday() != null)
        {
            values.put(KEY_BIRTHDAY, DateTimeUtils.GetDateTimeInDatabaseStringFormat(person.getBirthday()));
        }

        values.put(KEY_STREET, person.getStreet());
        values.put(KEY_STREETNUMBER, person.getStreetNumber());
        values.put(KEY_COMPLEMENT, person.getComplement());
        values.put(KEY_NEIGHBORHOOD, person.getNeighborhood());

        if(person.getCityId() != null && person.getCityId() > 0)
        {
            values.put(KEY_CITY, person.getCityId());
        }

        if(person.getBirthCityId() != null && person.getBirthCityId() > 0)
        {
            values.put(KEY_CITYOFBIRTH, person.getBirthCityId());
        }

        values.put(KEY_POSTALCODE, person.getPostalCode());
        values.put(KEY_CPF, person.getCPF());

        return db.update(DATABASE_TABLE,
                         values,
                         KEY_ID + " = ?",
                         new String[]{ String.valueOf(person.getId()) });
    }

    /**
     * Apaga registro da tabela de pessoa
     * @param personId Identificador da pessoa a ser deletada
     */
    public void delete(long personId)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(DATABASE_TABLE,
                  KEY_ID + " = ?",
                  new String[]{ String.valueOf(personId) });
    }

    /**
     * Recupera dados da pessoa a partir de stream de resultado de consulta com o banco
     * @param cursor Stream de resultado de consulta realizada no banco
     * @return Dados da pessoa retornados pelo banco
     */
    public Person getDataFromCursor(Cursor cursor)
    {
        Person person = new Person();
        person.setId(cursor.getLong(cursor.getColumnIndex(KEY_ID)));
        person.setName(cursor.getString(cursor.getColumnIndex(KEY_NAME)));
        person.setDescription(cursor.getString(cursor.getColumnIndex(KEY_DESCRIPTION)));
        person.setPrimaryEmail(cursor.getString(cursor.getColumnIndex(KEY_EMAIL1)));
        person.setSecondaryEmail(cursor.getString(cursor.getColumnIndex(KEY_EMAIL2)));
        person.setPrimaryTelephone(cursor.getString(cursor.getColumnIndex(KEY_TELEPHONE1)));
        person.setSecondaryTelephone(cursor.getString(cursor.getColumnIndex(KEY_TELEPHONE2)));
        person.setCPF(cursor.getString(cursor.getColumnIndex(KEY_CPF)));

        if(!cursor.isNull(cursor.getColumnIndex(KEY_BIRTHDAY)))
        {
            String birthday_str = cursor.getString(cursor.getColumnIndex(KEY_BIRTHDAY));
            person.setBirthday(DateTimeUtils.GetDateTimeFromString(birthday_str));
        }

        person.setStreet(cursor.getString(cursor.getColumnIndex(KEY_STREET)));
        person.setStreetNumber(cursor.getString(cursor.getColumnIndex(KEY_STREETNUMBER)));
        person.setNeighborhood(cursor.getString(cursor.getColumnIndex(KEY_NEIGHBORHOOD)));
        person.setPostalCode(cursor.getString(cursor.getColumnIndex(KEY_POSTALCODE)));

        if(!cursor.isNull(cursor.getColumnIndex(KEY_CITY)))
        {
            person.setCityId(cursor.getLong(cursor.getColumnIndex(KEY_CITY)));
        }
        else
        {
            person.setCityId(null);
        }

        if(!cursor.isNull(cursor.getColumnIndex(KEY_RG)))
        {
            person.setIdentifierDocumentId(cursor.getLong(cursor.getColumnIndex(KEY_RG)));
        }
        else
        {
            person.setIdentifierDocumentId(null);
        }

        if(!cursor.isNull(cursor.getColumnIndex(KEY_CITYOFBIRTH)))
        {
            person.setBirthCityId(cursor.getLong(cursor.getColumnIndex(KEY_CITYOFBIRTH)));
        }
        else
        {
            person.setBirthCityId(null);
        }

        return person;
    }
}