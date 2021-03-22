package com.example.unittestingtutorial

import com.example.unittestingtutorial.util.EmailValidator
import junit.framework.Assert.assertFalse
import junit.framework.Assert.assertTrue
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class EmailValidatorTest {
    @Test
    fun emailValidator_correctEmail_true() {
        assertTrue(EmailValidator().isValid("test@gmail.com"))
    }
    @Test
    fun emailValidator_correctEmailSubDomain_true() {
        assertTrue(EmailValidator().isValid("test@gmail.co.uk"))
    }
    @Test
    fun emailValidator_blankEmail_false() {
        assertFalse(EmailValidator().isValid(""))
    }
    @Test
    fun emailValidator_EmailSubsDomains_true() {
        assertTrue(EmailValidator().isValid("test@gmail.co.me.uk"))
    }
    @Test
    fun emailValidator_emailWithoutSign_false() {
        assertFalse(EmailValidator().isValid("test.com"))
    }
    @Test
    fun emailValidator_emailWithoutDots_false() {
        assertFalse(EmailValidator().isValid("test@gmail"))
    }
    @Test
    fun emailValidator_emailWithDoubleSigns_false() {
        assertFalse(EmailValidator().isValid("test@@gmail.com"))
    }
    @Test
    fun emailValidator_emailWithDoubleDots_false() {
        assertFalse(EmailValidator().isValid("test@gmail..com"))
    }
}