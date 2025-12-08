package com.example.loginandregistration

import com.google.common.truth.Truth.assertThat
import org.junit.Test

class RegistrationUtilUnitTest {

    @Test
    fun validatePassword_emptyPassword_isFalse() {
        val bothEmpty = RegistrationUtil.validatePassword("", "")
        assertThat(bothEmpty).isFalse()

        val firstEmpty = RegistrationUtil.validatePassword("", "Password1")
        assertThat(firstEmpty).isFalse()

        val secondEmpty = RegistrationUtil.validatePassword("Password1", "")
        assertThat(secondEmpty).isFalse()
    }

    @Test
    fun validatePassword_matchingPasswords_isTrue() {
        val matching1 = RegistrationUtil.validatePassword("Password1", "Password1")
        assertThat(matching1).isTrue()

        val matching2 = RegistrationUtil.validatePassword("Cyberpatriot123", "Cyberpatriot123")
        assertThat(matching2).isTrue()

        val noMatch = RegistrationUtil.validatePassword("Password1", "Cyberpatriot123")
        assertThat(noMatch).isFalse()
    }

}