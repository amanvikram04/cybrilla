package controller;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import sun.misc.BASE64Encoder;
import sun.misc.CharacterEncoder;

public class Check {

	private static CharacterEncoder text;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		String bank_ifsc_code="ICIC0000001";
		String bank_account_number="11111111";
		String amount="10000.00";
		String merchant_transaction_ref="txn001";
		String transcation_date="2014-11-14";
		String payment_gateway_merchant_reference="merc001";
		
		
		
	}
	
	public static String toSHA1(byte[] convertme)
	{
	MessageDigest md=null;
	
	try {
		
		md.getInstance("SHA-1");
		
	} catch (NoSuchAlgorithmException e) {
		e.printStackTrace();
		// TODO: handle exception
	}
	return new String (md.digest(convertme));
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
	 
	
	return BASE64ENCODE();
	}
	
	public static String BASE64ENCODE()
	{
		
		Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
		byte[] results = cipher.doFinal(text.getBytes("UTF-8"));
		BASE64Encoder encoder = new BASE64Encoder();
		return encoder.encode(results);
	}
}
