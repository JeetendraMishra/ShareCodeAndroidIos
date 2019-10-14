package com.hackathon.sharecodeandroidios

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.DialogFragment

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
            showHelpDialog()
        }
        helpPasswordButton?.setOnClickListener{
            showHelpDialog()
        }
    }

    private fun submit() {

    }

    private fun checkFields(): Boolean {
        val email = emailText?.text!!
        val password = passwordText?.text!!

        return email.isEmpty() || password.isEmpty()
    }

    private fun showHelpDialog() {

        // 1. Instantiate an <code><a href="/reference/android/app/AlertDialog.Builder.html">AlertDialog.Builder</a></code> with its constructor
        val builder: AlertDialog.Builder? = this.let {
            AlertDialog.Builder(it)
        }

        // 2. Chain together various setter methods to set the dialog characteristics
        builder?.setMessage(R.string.dialog_message)

        // 3. Get the <code><a href="/reference/android/app/AlertDialog.html">AlertDialog</a></code> from <code><a href="/reference/android/app/AlertDialog.Builder.html#create()">create()</a></code>
        val dialog: AlertDialog? = builder?.create()

        dialog?.show()
    }
}