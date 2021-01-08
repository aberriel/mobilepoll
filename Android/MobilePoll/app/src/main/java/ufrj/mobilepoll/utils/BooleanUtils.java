package ufrj.mobilepoll.utils;

import java.util.IllegalFormatException;

/**
 * Utilitários relativos a valores booleanos
 * Created by alira on 04/11/15.
 */
public class BooleanUtils
{
    public static String convertBooleanToString(boolean value)
    {
        String result = "";

        if(value == true)
        {
            result = "true";
        }
        else
        {
            result = "false";
        }

        return result;
    }

    public static boolean convertStringToBoolean(String boolean_str)
    {
        boolean result;

        if(boolean_str.equals("true"))
            result = true;
        else if(boolean_str.equals("false"))
            result = false;
        else
            throw new IllegalArgumentException("Impossible to convert string to boolean: unknow value.");

        return result;
    }

    public static int convertBooleanToInteger(boolean value)
    {
        int result = 0;

        if(value == true)
        {
            result = 1;
        }

        return result;
    }

    public static boolean convertIntegerToBoolean(int value)
    {
        boolean result;

        if(value == 0)
            result = false;
        else if(value == 1)
            result = true;
        else
            throw new IllegalArgumentException("Impossible to convert integer to boolean: unknow value.");

        return result;
    }
}