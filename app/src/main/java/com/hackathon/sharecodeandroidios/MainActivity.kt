package com.hackathon.sharecodeandroidios

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private var emailText: EditText? = null
    private var passwordText: EditText? = null
    private var submitButton: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<TextView>(R.id.main_text).text = createApplicationScreenMessage()
        initUi()
    }

    private fun initUi() {
        emailText = findViewById(R.id.main_email)
        passwordText = findViewById(R.id.main_password)
        submitButton = findViewById(R.id.main_submit)
        submitButton?.setOnClickListener {
            if (checkFields())
                Toast.makeText(this, R.string.err_empty_field, Toast.LENGTH_LONG).show()
            else
                submit()
        }
    }

    private fun submit() {

    }

    private fun checkFields(): Boolean {
        val email = emailText?.text!!
        val password = passwordText?.text!!

        return email.isEmpty() || password.isEmpty()
    }
}