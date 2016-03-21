package com.sogeti.upm.util;

import java.util.Random;

public class OTPUtil {

	private static final String symbols = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789$&@?<>~!%#";
	
	public static String genOTP() {
		Random r = new Random();
	    while(true) {
	        char[] password = new char[8];
	        boolean hasUpper = false, hasLower = false, hasDigit = false, hasSpecial = false;
	        for(int i=0; i<password.length; i++) {
	            char ch = symbols.charAt(r.nextInt(symbols.length()));
	            if(Character.isUpperCase(ch))
	                hasUpper = true;
	            else if(Character.isLowerCase(ch))
	                hasLower = true;
	            else if(Character.isDigit(ch))
	                hasDigit = true;
	            else
	                hasSpecial = true;
	            password[i] = ch;
	        }
	        if(hasUpper && hasLower && hasDigit && hasSpecial) {
	            return new String(password);
	        }
	    }

	}
	
	public static void main(String[] args) {
		System.out.println(genOTP());
	}
}
