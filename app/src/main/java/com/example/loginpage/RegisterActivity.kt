package com.example.loginpage

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import com.example.loginpage.viewmodel.UserViewModel
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_register.*


class RegisterActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        var userViewModel: UserViewModel? = null
        var emailText: EditText? = null
        var passwordText: EditText? = null
        var usernameText: EditText? = null
        var confirmpasswordText: EditText? = null
        var signUpButton: Button? = null


        signUpButton = findViewById<View>(R.id.btnRegister) as Button
        confirmpasswordText = findViewById<View>(R.id.inputConformPassword) as EditText
        usernameText = findViewById<View>(R.id.inputUsername) as EditText
        emailText = findViewById<View>(R.id.inputEmailRegister) as EditText
        passwordText = findViewById<View>(R.id.inputPasswordRegister) as EditText


        userViewModel = ViewModelProviders.of(this, UserViewModel.Factory(applicationContext))
            .get(UserViewModel::class.java)

        val signup = getSharedPreferences("PREFERENCE", Context.MODE_PRIVATE)
            .getBoolean("signup", true)

        if (signup) {

            signUpButton.visibility = View.VISIBLE

        }

         signUpButton.setOnClickListener {

            userViewModel.createUser(
                usernameText.text.toString(),
                emailText.text.toString(),
                passwordText.text.toString(),
                confirmpasswordText.text.toString()
            )
            getSharedPreferences("PREFERENCE", Context.MODE_PRIVATE)
                .edit()
                .putBoolean("signup", false)
                .apply()

            val emptyfield = usernameText.getText().isNullOrEmpty() || emailText.getText().isNullOrEmpty() || passwordText.getText().isNullOrEmpty() || confirmpasswordText.getText().isNullOrEmpty()
            val different_password = passwordText.getText().toString() != confirmpasswordText.getText().toString()


            if(emptyfield) {

                Toast.makeText(baseContext, "Please fill all the fields correctly", Toast.LENGTH_LONG).show()

            } else if(different_password) {

                Toast.makeText(baseContext, "Different Password", Toast.LENGTH_LONG).show()
            } else

                Toast.makeText(baseContext, "Successfully Created An Account!", Toast.LENGTH_LONG).show()
        }


        val btn = findViewById<TextView>(R.id.alreadyHaveAccount)
        btn.setOnClickListener {
            startActivity(
                Intent(
                    this@RegisterActivity,
                    LoginActivity::class.java
                )
            )
        }
    }
}