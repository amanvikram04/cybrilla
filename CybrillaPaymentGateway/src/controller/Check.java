package controller;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;


import sun.misc.BASE64Encoder;
import sun.misc.CharacterEncoder;

public class Check {

	private static CharacterEncoder text;

	public static void main(String[] args) throws UnsupportedEncodingException {
		// TODO Auto-generated method stub

		
		String text ="bank_ifsc_code=ICIC0000001|bank_account_number=11111111|amount=10000.00|merchant_transaction_ref=txn001|transcation_date=2014-11-14|payment_gateway_merchant_reference=merc001";
		byte [] toConvert=text.getBytes();
		//System.out.println(toConvert);
		//System.out.println(Check.toSHA1(text));
					
	}
	
	public static String toSHA1(String text) throws UnsupportedEncodingException
	{
		MessageDigest md=null;
		StringBuffer sb = new StringBuffer();
			try {
				md.getInstance("SHA-1");
				 byte[] sha1hash = new byte[40];
				 
				 md.update(text.getBytes("iso-8859-1"), 0, text.length());
				// md.update(text.getBytes("UTF-8"), 0, text.length());
				 
				 sha1hash = md.digest(text.getBytes("UTF-8"));
				 
				 
			        for (int i = 0; i < sha1hash.length; i++) {
			            sb.append(Integer.toString((sha1hash[i] & 0xff) + 0x100, 16).substring(1));
			        }
			         
			                
				 } catch (NoSuchAlgorithmException e) {
				e.printStackTrace();
				// TODO: handle exception
				}
			return sb.toString();
		//return Base64.getEncoder().encodeToString((md.digest(convertme));
	}
	
		public static String AES128CBC(String text, String key, String iv) throws Exception {
		
		Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
		key = "Q9fbkBF8au24C9wshGRW9ut8ecYpyXye5vhFLtHFdGjRg3a4HxPYRfQaKutZx5N4";
		iv="test";
		byte[] keyBytes = new byte[16];
		byte[] keyBytesiv = new byte[16];
	
	SecretKeySpec keySpec = new SecretKeySpec(keyBytes, "AES");
    IvParameterSpec ivSpec = new IvParameterSpec(keyBytesiv);
	cipher.init(Cipher.ENCRYPT_MODE, keySpec, ivSpec);
	byte[] results = cipher.doFinal(text.getBytes("UTF-8"));
	BASE64Encoder encoder = new BASE64Encoder();
	return encoder.encode(results);
	
	
	}
	
}
