package com.example.loginpage

import android.R
import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import com.example.loginpage.data.User
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(com.example.loginpage.R.layout.activity_main)

        //fetching user details from intent object
        val UserDetials = intent.getSerializableExtra("UserDetails") as? User

        //show user details in the mainactivity screen ui
        tv_username.text = UserDetials?.username
        tv_email.text = UserDetials?.email
        tv_password.text = UserDetials?.password
    }
}


