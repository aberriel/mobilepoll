package ufrj.mobilepoll.database.helper;

/**
 * Created by alira on 09/10/15.
 */
public class MandatoryIdentifierFieldDbHelper
{
    /** Nome da tabela, no SQLite, de campos identificadores obrigatórios de entrevistados para pesquisa */
    public static final String DATABASE_TABLE = "MOB_CampoIdentificadorObrigatorio";

    /** Nome da coluna de identificador de registro */
    private static final String KEY_ID = "M_Id";
    /** Tipo de dado da coluna de identificador único do registro */
    private static final String KEY_ID_TYPE = "integer";

    /** Nome da coluna do nome do campo identificador */
    private static final String KEY_NAME = "M_Nome";
    /** Tipo de dado da coluna do nome do campo identificador */
    private static final String KEY_NAME_TYPE = "varchar";

    /** Nome da coluna do identificador da pesquisa à qual o campo identificador pertence */
    private static final String KEY_RESEARCH = "M_Pesquisa";
    /** Tipo de dado da coluna de identificação da pesquisa à qual o campo identificador pertence */
    private static final String KEY_RESEARCH_TYPE = "integer";

    public static final String CREATE_TABLE = "create table " + DATABASE_TABLE
                                            + "("
                                            +       KEY_ID       + " " + KEY_ID_TYPE       + " primary key not null autoincrement,"
                                            +       KEY_NAME     + " " + KEY_NAME_TYPE     + " not null,"
                                            +       KEY_RESEARCH + " " + KEY_RESEARCH_TYPE + " not null"
                                            + ")";

    /** Comando para exclusão de tabela de campos identificadores obrigatórios de entrevistado para pesquisa */
    public static final String DELETE_TABLE = "drop table " + DATABASE_TABLE;

    /**
     * Comando de limpeza (exclusão de todos os registros) de tabela de
     * campos identificadores obrigatórios de entrevistado para pesquisa
     * */
    public static final String CLEAR_TABLE = "delete from " + DATABASE_TABLE;
}