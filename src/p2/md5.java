package p2;

import java.security.*;

public class md5 {
	StringBuffer hexString;
	public StringBuffer calc(String s)
	{
	String sessionid=s;
	        
	byte[] defaultBytes = sessionid.getBytes();
	try{
		MessageDigest algorithm = MessageDigest.getInstance("MD5");
		algorithm.reset();
		algorithm.update(defaultBytes);
		byte messageDigest[] = algorithm.digest();
	            
		hexString = new StringBuffer();
		for (int i=0;i<messageDigest.length;i++) {
			hexString.append(Integer.toHexString(0xFF & messageDigest[i]));
		}
	}
	catch(NoSuchAlgorithmException nsae)
	{
	            
	}
	return hexString;
	}

}
