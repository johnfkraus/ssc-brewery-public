package guru.sfg.brewery.web.controllers;

import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.password.LdapShaPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.StandardPasswordEncoder;
import org.springframework.util.DigestUtils;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class PasswordEncodingTests {
    static final String PASSWORD = "password";
    @Test
    void testSha256() {
        PasswordEncoder sha256 = new StandardPasswordEncoder();
        System.out.println("sha256.encode(PASSWORD) = " + sha256.encode(PASSWORD));
        System.out.println("sha256.encode(PASSWORD) = " + sha256.encode(PASSWORD));
    }

    @Test
    void testLdap() {
        PasswordEncoder ldap = new LdapShaPasswordEncoder();
        System.out.println("ldap.encode(PASSWORD) = " + ldap.encode(PASSWORD));
        System.out.println("ldap.encode(PASSWORD) = " + ldap.encode(PASSWORD));
        String encodedPwd = ldap.encode(PASSWORD);
        assertTrue(ldap.matches(PASSWORD, encodedPwd));
    }

    @Test
    void testNoOp() {
        PasswordEncoder noOp = NoOpPasswordEncoder.getInstance();
        System.out.println("noOp.encode(PASSWORD) = " + noOp.encode(PASSWORD));
    }

    @Test
    void hashingExample() {
        System.out.println("DigestUtils.md5DigestAsHex(PASSWORD.getBytes()) = " + DigestUtils.md5DigestAsHex(PASSWORD.getBytes()));
        String salted = PASSWORD + "ThisIsMySALTVALUE";
        System.out.println("DigestUtils.md5DigestAsHex(salted.getBytes()) = "+DigestUtils.md5DigestAsHex(salted.getBytes()));

    }
}
