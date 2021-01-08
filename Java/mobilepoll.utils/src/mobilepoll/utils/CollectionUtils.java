/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mobilepoll.utils;

import java.util.List;

/**
 * Métodos utilitários relativos a listas e arrays
 * @author alira
 */
public class CollectionUtils
{
    public static String StringListToString(List<String> strList)
    {
        String result = "";
        if(strList != null && strList.isEmpty() == false)
        {
            for(int i = 0; i < strList.size(); i++)
            {
                result = result + strList.get(i);
                if(i != strList.size() - 1)
                {
                    result = result + "|";
                }
            }
        }
        
        return result;
    }
}
