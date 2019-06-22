package br.com.epidemic.util;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Encode {

	public static String MD5(String text) throws NoSuchAlgorithmException {
		MessageDigest m = MessageDigest.getInstance("MD5");
		m.update(text.getBytes());
		return new BigInteger(m.digest()).toString(16);
	}
}
