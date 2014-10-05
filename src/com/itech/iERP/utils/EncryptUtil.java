package com.itech.iERP.utils;

import java.security.Key;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

public class EncryptUtil {
	

	public static final String ALGORITHM = "AES";
	public static final byte[] keyValue  = new byte[] { '1', '2', '1', '3', '7', '1', 'B', 'S', 'e', 'c', 'r', 'e',  'K', 'e', 'Z','t' };


	
	 private static Key generateKey() throws Exception {
	        Key key = new SecretKeySpec(keyValue, ALGORITHM);
	        return key;
	}

	public static String encrypt(String valueToEnc) throws Exception {
        Key key = generateKey();
        Cipher c = Cipher.getInstance(ALGORITHM);
        c.init(Cipher.ENCRYPT_MODE, key);
        byte[] encValue = c.doFinal(valueToEnc.getBytes());
        String encryptedValue = new BASE64Encoder().encode(encValue);
        return encryptedValue;
    }

    public static String decrypt(String encryptedValue) throws Exception {
        Key key = generateKey();
        Cipher c = Cipher.getInstance(ALGORITHM);
        c.init(Cipher.DECRYPT_MODE, key);
        byte[] decordedValue = new BASE64Decoder().decodeBuffer(encryptedValue);
        byte[] decValue = c.doFinal(decordedValue);
        String decryptedValue = new String(decValue);
        return decryptedValue;
    }
	
    public static void main(String[] args) throws Exception {
		System.out.println(encrypt("vani"));
		System.out.println(decrypt("GwlBlumGoaUMlGHKjWpXOQ=="));
	}
	

}
