package ufrj.mobilepoll.utils;

import java.math.BigInteger;
import java.security.MessageDigest;

/**
 * Utilitários relativos à autenticação e segurança
 * Created by alira on 08/10/15.
 */
public class AuthenticationUtils
{
    /**
     * Gera hash MD5 de string
     * @param textToEncrypt String a ser calculado o hash
     * @return Hash MD5 no formato de string do texto fornecido
     * @throws Exception
     */
    public static String getMd5(String textToEncrypt) throws Exception
    {
        MessageDigest messageDigest = MessageDigest.getInstance("MD5");
        messageDigest.reset();
        messageDigest.update(textToEncrypt.getBytes(), 0, textToEncrypt.length());

        BigInteger bI = new BigInteger(1, messageDigest.digest());
        String result = bI.toString(32);

        return result;
    }
}