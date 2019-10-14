package com.hackathon.sharecodeandroidios

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private var emailText: EditText? = null
    private var passwordText: EditText? = null
    private var submitButton: Button? = null
    private var helpEmailButton: ImageView? = null
    private var helpPasswordButton: ImageView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<TextView>(R.id.main_text).text = createApplicationScreenMessage()
        initUi()
    }

    private fun initUi() {
        emailText = findViewById(R.id.et_main_email)
        passwordText = findViewById(R.id.et_main_password)
        submitButton = findViewById(R.id.bt_main_submit)
        submitButton?.setOnClickListener {
            if (checkFields())
                Toast.makeText(this, R.string.err_empty_field, Toast.LENGTH_LONG).show()
            else
                submit()
        }
        helpEmailButton = findViewById(R.id.iv_main_email_hint)
        helpPasswordButton = findViewById(R.id.iv_main_pw_hint)
        helpEmailButton?.setOnClickListener{

        }
        helpPasswordButton?.setOnClickListener{

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