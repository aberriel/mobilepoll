/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mobilepoll.utils;

import java.math.BigInteger;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Métodos utilitários relativos a data e hora
 * @author anselmoberriel
 */
public class DateTimeUtils
{
    /**
     * Obtêm data e hora corrente.
     * @return Data e hora no momento da solicitação.
     */
    public static Date GetCurrentDate()
    {
        Date date = new Date();
        return date;
    }
    
    /**
     * Gera data e hora corrente em formato texto no padrão do Brasil
     * @param date Data e hora
     * @return 
     */
    public static String GetDateInBrazillianFormat(Date date)
    {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        return dateFormat.format(date);
    }
    
    public static Date GetDateWithoutHour(Date date)
    {
        date.setHours(0);
        date.setMinutes(0);
        date.setSeconds(0);
        
        return date;
    }
    
    /**
     * Calcula a diferença entre duas datas em dias
     * @param d1 Primeira data da operação de subtração
     * @param d2 Segunda data da operação de subtração
     * @param calculateWithoutHours Flag indicador da remoção da data antes do cálculo
     * @return Diferença em dias entre as 2 datas
     */
    public static int DiffInDays(Date d1, Date d2, boolean calculateWithoutHours)
    {
        int millis_in_day = 86400000;
        
        if(calculateWithoutHours)
        {
            d1 = GetDateWithoutHour(d1);
            d2 = GetDateWithoutHour(d2);
        }
        
        Calendar c1 = Calendar.getInstance();
        c1.setTime(d1);
        
        Calendar c2 = Calendar.getInstance();
        c2.setTime(d2);
        
        return (int)((c1.getTimeInMillis() - c2.getTimeInMillis()) / millis_in_day);
    }
    
    /**
     * Calcula a diferença entre 2 datas em anos
     * @param d1 Primeira data do operando de diferença
     * @param d2 Segunda data do operando de diferença
     * @param calculateWithoutHours Flag indicador da remoção de horas antes do cálculo
     * @return Diferença em anos entre as datas
     */
    public static int DiffInYears(Date d1, Date d2, boolean calculateWithoutHours)
    {
        Long millis_in_year = new Long("31536000000");
        
        if(calculateWithoutHours)
        {
            d1 = GetDateWithoutHour(d1);
            d2 = GetDateWithoutHour(d2);
        }
        
        Calendar c1 = Calendar.getInstance();
        c1.setTime(d1);
        
        Calendar c2 = Calendar.getInstance();
        c2.setTime(d2);
        
        return (int)((c1.getTimeInMillis() - c2.getTimeInMillis()) / millis_in_year);
    }
}