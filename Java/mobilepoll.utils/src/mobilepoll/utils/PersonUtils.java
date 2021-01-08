/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mobilepoll.utils;

import java.util.Date;
import java.util.InputMismatchException;

/**
 * Métodos utilitários relativos a pessoas
 * @author anselmoberriel
 */
public class PersonUtils
{
    /** Construtor */
    public PersonUtils() { }
    
    /**
     * Realiza a validação de CPF segundo as normas do governo federal
     * @param cpf Número do CPF a ser validado
     * @return Flag indicando se CPF é válido ou não
     */
    public static boolean ValidateCpf(String cpf)
    {
        if (cpf.equals("00000000000") || cpf.equals("11111111111") ||
            cpf.equals("22222222222") || cpf.equals("33333333333") ||
            cpf.equals("44444444444") || cpf.equals("55555555555") ||
            cpf.equals("66666666666") || cpf.equals("77777777777") ||
            cpf.equals("88888888888") || cpf.equals("99999999999") ||
            (cpf.length() != 11))
        {
            return(false);
        }
        
        char dig10, dig11;
        int sm, i, r, num, peso;
        
        try
        {
            // Cálculo do 1º dígito verificador
            sm = 0;
            peso = 10;
            for(i = 0; i < 9; i++)
            {
                // Converte o caractere do CPF em número
                // 48 é a posição do zero (0) na tabela ASCII
                num = (int)(cpf.charAt(i) - 48);
                sm = sm + (num * peso);
                peso = peso - 1;
            }
            
            r = 11 - (sm % 11);
            if((r == 10) || (r == 11))
            {
                dig10 = '0';
            }
            else
            {
                // Converte no respectivo caracetere numérico
                dig10 = (char)(r + 48);
            }
            
            // Cálculo do 2º dígito verificador
            sm = 0;
            peso = 11;
            for(i = 0; i < 10; i++)
            {
                num = (int)(cpf.charAt(i) - 48);
                sm = sm + (num * peso);
                peso = peso - 1;
            }
            
            r = 11 - (sm % 11);
            if((r == 10) || (r == 11))
            {
                dig11 = '0';
            }
            else
            {
                dig11 = (char)(r + 48);
            }
            
            // Verifica se os dígitos calculados conferem com os digitados
            if((dig10 == cpf.charAt(9)) && dig11 == cpf.charAt(10))
            {
                return true;
            }
            else
            {
                return false;
            }
        }
        catch(InputMismatchException ex)
        {
            return false;
        }
    }
    
    /**
     * Implementação da máscara de CPF
     * @param cpf Número do CPF a ser formatado
     * @return CPF no formato xxx.xxx.xxx-xx
     * @throws Exception Exceção por CPF inválido
     */
    public static String CpfMask(String cpf) throws Exception
    {
        // Máscara do CPF: 999.999.999-99
        
        if(cpf.contains(".") || cpf.contains("-"))
        {
            cpf.replace(".", "");
            cpf.replace("-", "");
        }
        
        if(ValidateCpf(cpf) == false)
        {
            throw new Exception("CPF fornecido é inválido");
        }
        
        return cpf.substring(0, 3) + "." +
               cpf.substring(3, 6) + "." +
               cpf.substring(6, 9) + "-" +
               cpf.substring(9, 11);
    }
    
    /**
     * Realiza a validação de CNPJ segundo as normas do governo federal
     * @param cnpj Número do CNPJ a ser validado
     * @return Flag indicando se CNPJ é válido ou não
     */
    public static boolean ValidateCnpj(String cnpj)
    {
        if(cnpj == null ||
           cnpj.length() != 14 ||
           cnpj.matches("^(0{14}|1{14}|2{14}|3{14}|4{14}|5{14}|6{14}|7{14}|8{14}|9{14})$"))
        {
            return (false);
        }
        
        char dig13, dig14;
        int sm, i, r, num, peso;
        
        try
        {
            // Cálculo do 1º dígito verificador
            sm = 0;
            peso = 2;
            for(i = 11; i >= 0; i--)
            {
                // Converte o i-ésimo caractere do CNPJ em número
                // 48 é a posição de '0' na tabela ASCII
                num = (int)(cnpj.charAt(i) - 48);
                sm = sm + (num * peso);
                peso = peso + 1;
                
                if(peso == 10)
                {
                    peso = 2;
                }
            }
            
            r = sm % 11;
            if((r == 0) || (r == 1))
            {
                dig13 = '0';
            }
            else
            {
                dig13 = (char)((11 - r) + 48);
            }
            
            // Cálculo do 2º dígito verificador
            sm = 0;
            peso = 2;
            for(i = 12; i >= 0; i--)
            {
                num = (int)(cnpj.charAt(i) - 48);
                sm = sm + (num * peso);
                peso = peso + 1;
                
                if(peso == 10)
                {
                    peso = 2;
                }
            }
            
            r = sm % 11;
            if((r == 0) || (r == 1))
            {
                dig14 = '0';
            }
            else
            {
                dig14 = (char)((11 - r) + 48);
            }
            
            // Verifica se os dígitos calculados conferem com os informados
            if((dig13 == cnpj.charAt(12)) && (dig14 == cnpj.charAt(13)))
            {
                return true;
            }
            else
            {
                return false;
            }
        }
        catch(Exception ex)
        {
            return false;
        }
    }
    
    /**
     * Aplica máscara ao CNPJ
     * @param cnpj Número do CNPJ a ser validado
     * @return CNPJ formatado, no padrão 99.999.999.9999-99
     * @throws Exception Exceção de CNPJ inválido
     */
    public static String CnpjMask(String cnpj) throws Exception
    {
        if(ValidateCnpj(cnpj) == false)
        {
            throw new Exception("CNPJ fornecido é inválido.");
        }
        
        if(cnpj.contains(".") || cnpj.contains("-"))
        {
            cnpj.replace(".", "");
            cnpj.replace("-", "");
        }
        
        return cnpj.substring(0, 2) + "." +
               cnpj.substring(2, 5) + "." +
               cnpj.substring(5, 8) + "." +
               cnpj.substring(8, 12) + "-" +
               cnpj.substring(12, 14);
    }
    
    /**
     * Validação de data de nascimento
     * @param birthDate Data de nascimento fornecida
     * @param minAge Idade mínima definida para uso do sistema
     * @return Booleano indicando se data de nascimento é válida ou permitida
     * @throws Exception Exceção por data de nascimento inválida ou não permitida
     */
    public static void ValidateBirthDate(Date birthDate, int minAge) throws Exception
    {
        Date currentDate = new Date();
        currentDate = DateTimeUtils.GetDateWithoutHour(currentDate);
        
        birthDate = DateTimeUtils.GetDateWithoutHour(birthDate);
        
        if(birthDate.equals(currentDate) || birthDate.after(currentDate))
        {
            throw new Exception("Data de nascimento deve ser inferior à data corrente");
        }
        
        if(minAge > 0)
        {
            if(DateTimeUtils.DiffInYears(currentDate, birthDate, true) < minAge)
            {
                throw new Exception("Idade mínima permitida: " + minAge);
            }
        }
    }
}