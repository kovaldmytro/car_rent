package com.epam.koval.carrent.bl.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Password hash generator.
 * 
 * @author Koval Dmitry
 * @version 1.0
 */
public final class Sha {
    /**
     * Hidden Constructor.
     */
    private Sha() {
    }

    /**
     * Hash generator.
     * 
     * @param input input string
     * @return hash string
     * @throws NoSuchAlgorithmException {@linkplain NoSuchAlgorithmException}
     */
    public static String md5(final String input)
	    throws NoSuchAlgorithmException {
	final String digest = "MD5";
	final int hex = 16;
	MessageDigest mDigest = MessageDigest.getInstance(digest);
	byte[] byteData = mDigest.digest(input.getBytes());
	StringBuffer sb = new StringBuffer();
	for (int i = 0; i < byteData.length; i++) {
	    sb.append(Integer.toString((byteData[i]), hex).substring(1));
	}
	return sb.toString();
    }
}
