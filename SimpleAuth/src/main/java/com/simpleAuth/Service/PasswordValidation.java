package com.simpleAuth.Service;

import org.springframework.stereotype.Service;

@Service
public class PasswordValidation {
	public static boolean validate(String s1,String s2) {
		return s1.equals(s2);
	}
}
