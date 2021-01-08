package mobilepoll.config;

/**
 *
 * @author anselmolira
 */
public enum DbType
{
    /** Unknow database */
    None
    {
        @Override
        public int getValue() { return 0; }
        
        @Override
        public String getName() { return "Nenhum"; }
        
        @Override
        public String getInternalName() { return "none"; }
        
        @Override
        public String getDriverClass() { return null; }
        
        @Override
        public String getDialect() { return null; }
    },
    /** MySQL */
    MySQL
    {
        @Override
        public int getValue() { return 1; }
        
        @Override
        public String getName() { return "MySQL"; }
        
        @Override
        public String getInternalName() { return "mysql"; }
        
        @Override
        public String getDriverClass() { return "com.mysql.jdbc.Driver"; }
        
        @Override
        public String getDialect() { return "org.hibernate.dialect.MySQLDialect"; }
    },
    /** SQL Server */
    SqlServer
    {
        @Override
        public int getValue() { return 2; }
        
        @Override
        public String getName() { return "SQL Server"; }
        
        @Override
        public String getInternalName() { return "sqlserver"; }
        
        @Override
        public String getDriverClass() { return null; }
        
        @Override
        public String getDialect() { return null; }
    },
    /** Oracle */
    Oracle
    {
        @Override
        public int getValue() { return 3; }
        
        @Override
        public String getName() { return "Oracle"; }
        
        @Override
        public String getInternalName() { return "oracle"; }
        
        @Override
        public String getDriverClass() { return null; }
        
        @Override
        public String getDialect() { return null; }
    },
    /** Amazon Redshift */
    Redshift
    {
        @Override
        public int getValue() { return 4; }
        
        @Override
        public String getName() { return "Redshift"; }
        
        @Override
        public String getInternalName() { return "redshift"; }
        
        @Override
        public String getDriverClass() { return null; }
        
        @Override
        public String getDialect() { return null; }
    },
    /** PostgreSQL */
    PostgreSql
    {
        @Override
        public int getValue() { return 5; }
        
        @Override
        public String getName() { return "PostgreSQL"; }
        
        @Override
        public String getInternalName() { return "postgresql"; }
        
        @Override
        public String getDriverClass() { return null; }
        
        @Override
        public String getDialect() { return null; }
    },
    /** MariaDB */
    MariaDB
    {
        @Override
        public int getValue() { return 6; }
        
        @Override
        public String getName() { return "MariaDB"; }
        
        @Override
        public String getInternalName() { return "mariadb"; }
        
        @Override
        public String getDriverClass() { return null; }
        
        @Override
        public String getDialect() { return null; }
    },
    /** Banco de dados em arquivo HSQL */
    HSqlDB
    {
        @Override
        public int getValue() { return 7; }
        
        @Override
        public String getName() { return "HSQL DB"; }
        
        @Override
        public String getInternalName() { return "hsqldb"; }
        
        @Override
        public String getDriverClass() { return null; }
        
        @Override
        public String getDialect() { return null; }
    },
    /** Banco de dados não suportado (mas existe) */
    Other
    {
        @Override
        public int getValue() { return 8; }
        
        @Override
        public String getName() { return "Outro"; }
        
        @Override
        public String getInternalName() { return "other"; }
        
        @Override
        public String getDriverClass() { return null; }
        
        @Override
        public String getDialect() { return null; }
    };
    
    /** Restore numerical value of enumeration type */
    public abstract int getValue();
    
    /** Restore database name for display */
    public abstract String getName();
    
    /** Restore internal database name for internal process */
    public abstract String getInternalName();
    
    /** Restore full driver class name for JDBC connection */
    public abstract String getDriverClass();
    
    /** Restore database dialect for hibernate */
    public abstract String getDialect();
    
    public static DbType getDbTypeByDbName(String dbName)
    {
        DbType dType = DbType.None;
        
        if(dbName != null && !dbName.isEmpty())
        {
        	if(dbName.equals("mysql"))
        	{
        		dType = DbType.MySQL;
        	}
        	else if(dbName.equals("oracle"))
        	{
        		dType = DbType.Oracle;
        	}
        	else if(dbName.equals("postgresql"))
        	{
        		dType = DbType.PostgreSql;
        	}
        	else if(dbName.equals("mariadb"))
        	{
        		dType = DbType.MariaDB;
        	}
        	else if(dbName.equals("redshift"))
        	{
        		dType = DbType.Redshift;
        	}
        	else if(dbName.equals("sqlserver"))
        	{
        		
        	}
        	else if(dbName.equals("hsqldb"))
        	{
        		dType = DbType.HSqlDB;
        	}
        	else
        	{
        		dType = DbType.Other;
        	}
        }
        
        return dType;
    }
}