package ufrj.mobilepoll.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Utilitários relacionados a data e hora
 * Created by alira on 14/10/15.
 */
public class DateTimeUtils
{
    /**
     * Gera representação textual de data e hora no formato do SQLite
     * @param dateTime Data e hora a ser formatada para o padrão do SQLite
     * @return String representativa de data e hora pronta para ser inserida em comando de inserção de dados
     */
    public static String GetDateTimeInDatabaseStringFormat(Date dateTime)
    {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(dateTime);
    }

    /**
     * Gera objeto de data e hora a partir de string de tempo obtida do banco
     * @param dateTime String contendo data e hora obtidas do banco
     * @return Data e hora obtidas
     */
    public static Date GetDateTimeFromString(String dateTime)
    {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        try
        {
            Date dt = sdf.parse(dateTime);
            return dt;
        }
        catch(ParseException ex)
        {
            return null;
        }
    }
}