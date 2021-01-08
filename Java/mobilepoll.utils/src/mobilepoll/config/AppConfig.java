package mobilepoll.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

/**
 *
 * @author anselmolira
 */
public class AppConfig
{
    /** Configurações da aplicação obtidas do arquivo */
    Properties props;
    /** GET para as configurações da aplicação obtidas do arquivo */
    public Properties getProps() { return this.props; }
    /** SET para as configurações da aplicação obtidas do arquivo */
    public void setProps(Properties props) { this.props = props; }
    
    private void loadConfigsFromFile(String path)
    {
        this.props = new Properties();
        InputStream is = null;
        path = "/opt/globo/newmedia/app.properties";
            
        try
        {
            if(path == null)
            {
                ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
                is = classLoader.getResourceAsStream("app.properties");
            }
            else
            {
                is = new FileInputStream(path);
            }
            
            props.load(is);
        }
        catch(IOException iex)
        {
            iex.printStackTrace();
        }
        finally
        {
            if(is != null)
            {
                try
                {
                    is.close();
                }
                catch(IOException ex)
                {
                    ex.printStackTrace();
                }
            }
        }
    }
    
    /** Construtor */
    public AppConfig()
    {
        this.loadConfigsFromFile(null);
    }
    
    public AppConfig(String propFilePath)
    {
        this.loadConfigsFromFile(propFilePath);
    }
    
    
    // <editor-fold defaultstate="collapsed" desc="Database Configurations">
    /** GET para tipo do banco a ser utilizado */
    public DbType getDbType()
    {
        String dbTypeStr = this.getDbTypeStr();
        DbType dType = DbType.getDbTypeByDbName(dbTypeStr);
        return dType;
    }
    /** SET para tipo do banco a ser utilizado */
    public void setDbType(DbType dbType)
    {
        this.setDbTypeStr(dbType.getInternalName());
    }

    public String getDbTypeStr()
    {
        String dbType = "";
        if(this.props != null && !this.props.isEmpty())
        {
            dbType = this.props.getProperty("db.type");
        }
        
        return dbType;
    }
    public void setDbTypeStr(String dbType)
    {
        if(this.props == null)
        {
            this.props = new Properties();
        }
        this.props.setProperty("db.type", dbType);
    }

    /** GET para endereço do banco de dados */
    public String getDbUrl()
    {
        String dbUrl = "";
        if(this.props != null && !this.props.isEmpty())
        {
            dbUrl = this.props.getProperty("db.url");
        }
        
        return dbUrl;
    }
    /** SET para endereço do banco de dados */
    public void setDbUrl(String dbUrl)
    {
        if(this.props == null)
        {
            this.props = new Properties();
        }
        this.props.setProperty("db.url", dbUrl);
    }

    /** GET para número da porta do banco de dados */
    public String getDbPort()
    {
        String dbPort = "";
        if(this.props != null && !this.props.isEmpty())
        {
            dbPort = this.props.getProperty("db.port");
        }
        
        return dbPort;
    }
    /** SET para o número da porta do banco de dados */
    public void setDbPort(String dbPort)
    {
        if(this.props == null)
        {
            this.props = new Properties();
        }
        this.props.setProperty("db.port", dbPort);
    }
    
    /** GET para base default */
    public String getSchema()
    {
        String schema = "";
        if(this.props != null && !this.props.isEmpty())
        {
            schema = this.props.getProperty("db.schema");
        }
        
        return schema;
    }
    /** SET para base default */
    public void setSchema(String schema)
    {
        if(this.props == null)
        {
            this.props = new Properties();
        }
        this.props.setProperty("db.schema", schema);
    }

    /** GET para login do usuário no banco */
    public String getDbUsername()
    {
        String dbLogin = "";
        if(this.props != null && !this.props.isEmpty())
        {
            dbLogin = this.props.getProperty("db.username");
        }
        
        return dbLogin;
    }
    /** SET para login do usuário no banco */
    public void setDbUsername(String dbLogin)
    {
        if(this.props == null)
        {
            this.props = new Properties();
        }
        this.props.setProperty("db.username", dbLogin);
    }

    /** GET para senha do usuário no banco */
    public String getDbPassword()
    {
        String dbPassword = "";
        if(this.props != null && !this.props.isEmpty())
        {
            dbPassword = this.props.getProperty("db.password");
        }
        
        return dbPassword;
    }
    /** SET para senha do usuário no banco */
    public void setDbPassword(String passwd)
    {
        if(this.props == null)
        {
            this.props = new Properties();
        }
        this.props.setProperty("db.password", passwd);
    }

    public boolean getDbLogSql()
    {
        String logSql = "";
        if(this.props != null && !this.props.isEmpty())
        {
            logSql = this.props.getProperty("db.logsql");
        }
        
        return logSql != null && logSql == "true";
    }
    public void setDbLogSql(boolean logSql)
    {
        if(this.props == null)
        {
            this.props = new Properties();
        }
        
        if(logSql)
        {
            this.props.setProperty("db.logsql", "true");
        }
        else
        {
            this.props.setProperty("db.logsql", "false");
        }
    }
    
    public String getDbLogSqlStr()
    {
        String logSql = "";
        if(this.props != null && !this.props.isEmpty())
        {
            logSql = this.props.getProperty("db.logsql");
        }
        
        return logSql;
    }
    public void setDbLogSqlStr(String logSql)
    {
        if(this.props == null)
        {
            this.props = new Properties();
        }
        
        this.props.setProperty("db.logsql", logSql);
    }
    // </editor-fold>
    
    
    // <editor-fold defaultstate="collapsed" desc="Globo.com Definitions">
    public String getEpgToken() throws IOException 
    {
        String globoComToken = "";
        if(this.props != null && !this.props.isEmpty())
        {
            globoComToken = this.props.getProperty("globocom.token");
        }
        
        return globoComToken;
    }	

    public String getEPGurl() throws IOException 
    {
        String globoComUrl = "";
        if(this.props != null && !this.props.isEmpty())
        {
            globoComUrl = this.props.getProperty("globocom.url");
        }
        
        return globoComUrl;
    }
    
    public String getEpgEnvironment() throws IOException
    {
        String globoComEnvironment = "";
        if(this.props != null && !this.props.isEmpty())
        {
            globoComEnvironment = this.props.getProperty("globocom.environment");
        }
        
        return globoComEnvironment;
    }
    // </editor-fold>
    
    
    // <editor-fold defaultstate="collapsed" desc="Log Configurations">
    public String getLoggerName() throws IOException
    {
        String loggerName = "";
        if(this.props != null && !this.props.isEmpty())
        {
            loggerName = this.props.getProperty("logger.name");
        }
        
        return loggerName;
    }
    
    public String getLoggerDestinationFolder() throws IOException
    {
        String loggerDestDir = "";
        if(this.props != null && !this.props.isEmpty())
        {
            loggerDestDir = this.props.getProperty("logger.destdir");
        }
        
        return loggerDestDir;
    }
    
    public String getLoggerLevel() throws IOException
    {
        String loggerLevel = "";
        if(this.props != null && !this.props.isEmpty())
        {
            loggerLevel = this.props.getProperty("logger.level");
        }
        
        return loggerLevel;
    }
    
    public String getLoggerConfigFile() throws IOException
    {
        String loggerConfigFile = "";
        if(this.props != null && !this.props.isEmpty())
        {
            loggerConfigFile = this.props.getProperty("logger.configFile");
        }
        
        return loggerConfigFile;
    }
    // </editor-fold>
    
    
    // <editor-fold defaultstate="collapsed" desc="E-mail Configurations">
    public String getSmtpHost()
    {
        String host = "";
        if(this.props != null && !this.props.isEmpty())
        {
            host = this.props.getProperty("smtp.host");
        }
        
        return host;
    }
    
    public String getSmtpPort()
    {
        String port = "";
        if(this.props != null && !this.props.isEmpty())
        {
            port = this.props.getProperty("smtp.port");
        }
        
        return port;
    }
    
    public String getSmtpUsername()
    {
        String user = "";
        if(this.props != null && !this.props.isEmpty())
        {
            user = this.props.getProperty("smtp.user.login");
        }
        
        return user;
    }
    
    public String getSmtpUserPassword()
    {
        String password = "";
        if(this.props != null && !this.props.isEmpty())
        {
            password = this.props.getProperty("smtp.user.password");
        }
        
        return password;
    }
    
    public String getDefaultFrom()
    {
        String defaultFrom = "";
        if(this.props != null && !this.props.isEmpty())
        {
            defaultFrom = this.props.getProperty("mail.from.default");
        }
        
        return defaultFrom;
    }
    
    public String getDefaultTo()
    {
        String defaultTo = "";
        if(this.props != null && !this.props.isEmpty())
        {
            defaultTo = this.props.getProperty("mail.to.default");
        }
        
        return defaultTo;
    }
    
    public List<String> getDefaultToList()
    {
        String defaultTo = "";
        List<String> toList = new ArrayList<String>();
        
        if(this.props != null && !this.props.isEmpty())
        {
            defaultTo = this.props.getProperty("mail.to.default");
        }
        
        if(defaultTo != null && !defaultTo.isEmpty())
        {
            String[] toArr = defaultTo.split(",", 0);
            toList = Arrays.asList(toArr);
        }
        
        return toList;
    }
    // </editor-fold>
    
    
    // <editor-fold defaultstate="collapsed" desc="Globo.com Definitions">
    public int getGloboComTimeBetweenRetries()
    {
        String timeForRetry = "";
        if(this.props != null && !this.props.isEmpty())
        {
            timeForRetry = this.props.getProperty("servicebus.globocom.timebetweenretries");
        }
        
        int tfr = Integer.parseInt(timeForRetry);
        return tfr;
    }
    
    public int getGloboComMaxRetry()
    {
        String maxTryCount = "";
        if(this.props != null && !this.props.isEmpty())
        {
            maxTryCount = this.props.getProperty("servicebus.globocom.maxretries");
        }
        
        int mtc = Integer.parseInt(maxTryCount);
        return mtc;
    }
    // </editor-fold>
    
    
    /** GET para tamanho da página de resultados retornada do banco */
    public int getPageLength()
    {
        String pgLength = "";
        if(this.props != null && !this.props.isEmpty())
        {
            pgLength = this.props.getProperty("pag.length");
        }
        
        return Integer.getInteger(pgLength);
    }
    /** SET para tamanho da página de resultados retornada */
    public void setPageLength(int pgSize)
    {
        if(this.props == null)
        {
            this.props = new Properties();
        }
        
        this.props.setProperty("pag.length", Integer.toString(pgSize));
    }
}