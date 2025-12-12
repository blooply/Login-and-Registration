package com.example.loginandregistration

// object keyword makes it so all the functions are
// static functions
object RegistrationUtil {
    // use this in the test class for the is username taken test
    // make another similar list for some taken emails
    private var existingUsers = listOf("cosmicF", "cosmicY", "bob", "alice")
    private var existingEmails = listOf("awidjw@gmail.com", "aoiwjd@yahoo.com")
    // you can use listOf<type>() instead of making the list & adding individually
    // List<String> blah = new ArrayList<String>();
    // blah.add("hi")
    // blah.add("hello")
    //

    // isn't empty
    // not already taken
    // minimum number of characters is 3
    fun validateUsername(username: String) : Boolean {
        return username.length > 2 && !existingUsers.contains(username)
    }

    // make sure meets security requirements (deprecated ones that are still used everywhere)
    // min length 8 chars
    // at least one digit
    // at least one capital letter
    // both passwords match
    // not empty
    fun validatePassword(password : String, confirmPassword: String) : Boolean {
        return (password == confirmPassword && password.length > 7 && password.any{it.isUpperCase()} && password.any{it.isDigit()})
    }

    // isn't empty
    fun validateName(name: String) : Boolean {
        return name.isNotEmpty()
    }

    // isn't empty
    // make sure the email isn't used
    // make sure it's in the proper email format user@domain.tld
    fun validateEmail(email: String) : Boolean {
        return email != null && email.isNotEmpty() && !existingEmails.contains(email) && email.indexOf("@") > 0 && email.indexOf(".") > email.indexOf("@") + 1 && email.indexOf(".") == email.lastIndexOf(".") && email.indexOf(".") < email.length - 1
    }
}