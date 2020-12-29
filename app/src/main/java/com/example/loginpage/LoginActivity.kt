package com.example.loginpage

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import com.example.loginpage.viewmodel.UserViewModel


class LoginActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        var userViewModel: UserViewModel? = null
        var loginButton: TextView? = null
        var emailText: EditText? = null
        var passwordText: EditText? = null

        loginButton = findViewById<View>(R.id.btnlogin) as Button
        emailText = findViewById<View>(R.id.inputEmailLogin) as EditText
        passwordText = findViewById<View>(R.id.inputPasswordLogin) as EditText

        userViewModel = ViewModelProviders.of(this, UserViewModel.Factory(applicationContext)).get(UserViewModel::class.java)


        loginButton.setOnClickListener {

            val isValid = userViewModel.checkValidLogin(emailText.text.toString(), passwordText.text.toString())

            if (isValid) {

                Toast.makeText(baseContext, "Successfully Logged In!", Toast.LENGTH_LONG).show()
                Log.i("Successful_Login", "Login was successful")

            } else {

                Toast.makeText(baseContext, "Invalid Login!", Toast.LENGTH_SHORT).show()
                Log.i("Unsuccessful_Login", "Login was not successful")
            }
        }

        val btn = findViewById<TextView>(R.id.textViewSignUp)
        btn.setOnClickListener {
            startActivity(
                Intent(
                    this@LoginActivity,
                    RegisterActivity::class.java
                )
            )
        }

    }

    fun googleLoginPage(view: View) {

        val googlebrowserIntent = Intent(
            Intent.ACTION_VIEW,
            Uri.parse("https://accounts.google.com/signin/v2/identifier?hl=fr&passive=true&continue=https%3A%2F%2Fwww.google.fr%2F&ec=GAZAAQ&flowName=GlifWebSignIn&flowEntry=ServiceLogin")
        )
        startActivity(googlebrowserIntent)
    }

    fun facebookLoginPage(view: View) {

        val facebookbrowserIntent = Intent(
            Intent.ACTION_VIEW,
            Uri.parse("https://fr-fr.facebook.com/")
        )
        startActivity(facebookbrowserIntent)

    }
}

