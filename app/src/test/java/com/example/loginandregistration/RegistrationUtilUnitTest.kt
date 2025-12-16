package com.example.loginandregistration

import com.google.common.truth.Truth.assertThat
import org.junit.Test

class RegistrationUtilUnitTest {
    //Password

    //valid matching password works
    @Test
    fun validatePassword_goodMatchingPassword_isTrue() {
        val good1 = RegistrationUtil.validatePassword("Password1", "Password1")
        assertThat(good1).isTrue()
    }

    //neither are empty
    @Test
    fun validatePassword_emptyPassword_isFalse() {
        val bothEmpty = RegistrationUtil.validatePassword("", "")
        assertThat(bothEmpty).isFalse()
        val firstEmpty = RegistrationUtil.validatePassword("", "Password1")
        assertThat(firstEmpty).isFalse()
        val secondEmpty = RegistrationUtil.validatePassword("Password1","")
        assertThat(secondEmpty).isFalse()
    }

    //minimum length of 8
    @Test
    fun validatePassword_tooShort_isFalse() {
        val short1 = RegistrationUtil.validatePassword("Short1", "Short1")
        assertThat(short1).isFalse()
    }

    //has capital
    @Test
    fun validatePassword_emptyCapital_isFalse() {
        val capital1 = RegistrationUtil.validatePassword("password1", "password1")
        assertThat(capital1).isFalse()
    }

    //has number
    @Test
    fun validatePassword_emptyNumber_isFalse() {
        val number1 = RegistrationUtil.validatePassword("Password", "Password")
        assertThat(number1).isFalse()
    }

    //password and confirmPassword matches
    @Test
    fun validatePassword_notMatching_isFalse() {
        val match1 = RegistrationUtil.validatePassword("Password1", "Password2")
        assertThat(match1).isFalse()
    }

    //no whitespace
    @Test
    fun validatePassword_hasWhitespace_isFalse() {
        val whitespace1 = RegistrationUtil.validatePassword("Password 1", "Password 1")
        assertThat(whitespace1).isFalse()
    }

    //Name

    //valid name works
    @Test
    fun validName_isGood_isTrue() {
        val good1 = RegistrationUtil.validateName("John")
        assertThat(good1).isTrue()
    }

    //not empty
    @Test
    fun validateName_notEmpty_isFalse() {
        val emptyName1 = RegistrationUtil.validateName("")
        assertThat(emptyName1).isFalse()
    }

    //Username

    //valid username works
    @Test
    fun validateUsername_isGood_isTrue() {
        val good1 = RegistrationUtil.validateUsername("johnsmith")
        assertThat(good1).isTrue()
    }

    //not empty
    @Test
    fun validateUsername_notEmpty_isFalse() {
        val empty1 = RegistrationUtil.validateUsername("")
        assertThat(empty1).isFalse()
    }

    //minimum length of 3
    @Test
    fun validateUsername_tooShort_isFalse() {
        val short1 = RegistrationUtil.validateUsername("jo")
        assertThat(short1).isFalse()
    }

    //isn't taken (identical cases)
    @Test
    fun validateUsername_takenSameCase_isFalse() {
        val taken1 = RegistrationUtil.validateUsername("bob")
        assertThat(taken1).isFalse()
    }

    //isn't taken (different cases)
    @Test
    fun validateUsername_takenDifferentCase_isFalse() {
        val taken1 = RegistrationUtil.validateUsername("BOB")
        assertThat(taken1).isFalse()
    }

    //no whitespace
    @Test
    fun validateUsername_hasWhitespace_isFalse() {
        val whitespace1 = RegistrationUtil.validateUsername("john smith")
        assertThat(whitespace1).isFalse()
    }

    //Email

    //valid email works
    @Test
    fun validateEmail_goodEmail_isTrue() {
        val good = RegistrationUtil.validateEmail("johnsmith@gmail.com")
        assertThat(good).isTrue()
    }

    //not empty
    @Test
    fun validateEmail_empty_isFalse() {
        val empty = RegistrationUtil.validateEmail("")
        assertThat(empty).isFalse()
    }

    //no empty user
    @Test
    fun validateEmail_emptyLocal_isFalse() {
        val emptyLocal = RegistrationUtil.validateEmail("@yahoo.com")
        assertThat(emptyLocal).isFalse()
    }

    //no empty domain and tld
    @Test
    fun validateEmail_emptyDomain_isFalse() {
        val emptyDomain = RegistrationUtil.validateEmail("johnsmith@")
        assertThat(emptyDomain).isFalse()
    }

    //no empty tld
    @Test
    fun validateEmail_emptyTLD_isFalse() {
        val emptyDomain = RegistrationUtil.validateEmail("johnsmith@gmail.")
        assertThat(emptyDomain).isFalse()
    }

    //no @
    @Test
    fun validateEmail_noAt_isFalse() {
        val noAt = RegistrationUtil.validateEmail("johnsmithhotmail.com")
        assertThat(noAt).isFalse()
    }

    //more than one @
    @Test
    fun validateEmail_moreThanOneAt_isFalse() {
        val twoAt1 = RegistrationUtil.validateEmail("john@smith@gmail.com")
        assertThat(twoAt1).isFalse()

        val twoAt2 = RegistrationUtil.validateEmail("johnsmith@@gmail.com")
        assertThat(twoAt2).isFalse()
    }

    //no .
    @Test
    fun validateEmail_noDotAnywhere_isFalse() {
        val noDot = RegistrationUtil.validateEmail("john@outlookcom")
        assertThat(noDot).isFalse()
    }

    //more than one . in domain
    @Test
    fun validateEmail_moreThanOneDot_isFalse() {
        val twoDot1 = RegistrationUtil.validateEmail("janedoe@yahoo..net")
        assertThat(twoDot1).isFalse()

        val twoDot2 = RegistrationUtil.validateEmail("janedoe@yah.oo.net")
        assertThat(twoDot2).isFalse()

        val twoDot3 = RegistrationUtil.validateEmail("jane..doe@yahoo.net")
        assertThat(twoDot3).isTrue()
    }

    //user starts with .
    @Test
    fun validateEmail_userStartsWithDot_isFalse() {
        val localStartsDot = RegistrationUtil.validateEmail(".johnsmith@icloud.com")
        assertThat(localStartsDot).isFalse()
    }

    //user ends with .
    @Test
    fun validateEmail_userEndsWithDot_isFalse() {
        val localEndsDot = RegistrationUtil.validateEmail("johnsmith.@icloud.com")
        assertThat(localEndsDot).isFalse()
    }

    //domain starts with .
    @Test
    fun validateEmail_domainStartsWithDot_isFalse() {
        val domainStartsDot = RegistrationUtil.validateEmail("janedoe@.icloud.com")
        assertThat(domainStartsDot).isFalse()
    }

    //not taken
    @Test
    fun validateEmail_takenSameCase_isFalse() {
        val taken = RegistrationUtil.validateEmail("og_john_smith@gmail.com")
        assertThat(taken).isFalse()
    }

    @Test
    fun validateEmail_takenDifferentCase_isFalse() {
        val result = RegistrationUtil.validateEmail("REAL.JANE.DOE@YAHOO.COM")
        assertThat(result).isFalse()
    }

    //no whitespace
    @Test
    fun validateEmail_hasWhitespace_isFalse() {
        val whitespace1 = RegistrationUtil.validateEmail("john smith@gmail.com")
        assertThat(whitespace1).isFalse()
    }
}