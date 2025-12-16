package com.example.loginandregistration

// object keyword makes it so all the functions are
// static functions
object RegistrationUtil {
    // use this in the test class for the is username taken test
    // make another similar list for some taken emails
    private var existingUsers = listOf("cosmicF", "cosmicY", "bob", "alice")
    private var existingEmails = listOf("og_john_smith@gmail.com", "real.jane.doe@yahoo.com")
    // you can use listOf<type>() instead of making the list & adding individually
    // List<String> blah = new ArrayList<String>();
    // blah.add("hi")
    // blah.add("hello")

    // isn't empty
    fun validateName(name: String): Boolean {
        return name.isNotEmpty()
    }

    // isn't empty
    // not already taken
    // minimum number of characters is 3
    fun validateUsername(username: String): Boolean {
        return username.length >= 3 && !existingUsers.any{it.equals(username, ignoreCase = true)} && !username.any{it.isWhitespace()}
    }

    // make sure meets security requirements (deprecated ones that are still used everywhere)
    // min length 8 chars
    // at least one digit
    // at least one capital letter
    // both passwords match
    // not empty
    fun validatePassword(password: String, confirmPassword: String): Boolean {
        return (password == confirmPassword && password.length >= 8 && password.any{it.isUpperCase()} && password.any{it.isDigit()} && !password.any{it.isWhitespace()})
    }

    // isn't empty
    // make sure the email isn't used
    // make sure it's in the proper email format user@domain.tld
    fun validateEmail(email: String): Boolean {
        if (email.length < 5 || existingEmails.any{it.equals(email, ignoreCase = true)} || email.any{it.isWhitespace()})
            return false

        val atIndex = email.indexOf("@")

        if (atIndex <= 0)
            return false

        val dotIndex = email.substring(atIndex).indexOf(".") + email.substring(0, atIndex).length

        if (atIndex != email.lastIndexOf("@") || dotIndex != email.lastIndexOf("."))
            return false

        return email[0] != '.' && email[atIndex - 1] != '.' && dotIndex > atIndex + 1 && dotIndex < email.length - 1
    }
}