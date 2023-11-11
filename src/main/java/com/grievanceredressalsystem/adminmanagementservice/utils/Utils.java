package com.grievanceredressalsystem.adminmanagementservice.utils;

import org.springframework.security.core.token.Sha512DigestUtils;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;

public class Utils {

    public static PasswordEncoder encoder = new PasswordEncoder() {
        String salt = "$2a$10$e9kAuRN/PARzXnNdnghiSO";
        @Override
        public String encode(CharSequence rawPassword) {
            final String finalSalt = salt != null ? salt.toString() : "";
            return Sha512DigestUtils.shaHex(finalSalt + rawPassword);
        }
        @Override
        public boolean matches(CharSequence rawPassword, String encodedPassword) {
            final String enteredPassword = encode(rawPassword);
            return encodedPassword.equals(enteredPassword);
        }
    };

    public static void main(String[] args) {
        System.out.println("pass : " + encoder.encode("Vishal@123"));
    }
}
