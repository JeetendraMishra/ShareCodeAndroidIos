package com.hackathon.sharecodeandroidios

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class AccountActivity: AppCompatActivity() {

    companion object {
        const val LOGIN_RESPONSE: String = "login_response"

        fun newIntent(context: Context, response: String?): Intent {
            val intent = Intent(context, AccountActivity::class.java)
            intent.putExtra(LOGIN_RESPONSE, response)
            return intent
        }
    }

    var firstNameText: EditText? = null
    var lastNameText: EditText? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_account)

        initUi()
    }

    private fun initUi() {
        firstNameText = findViewById(R.id.et_account_first_name)
        lastNameText = findViewById(R.id.et_account_last_name)

        val response: String? = intent.getStringExtra(LOGIN_RESPONSE)

        if (response != null) {
            // do something
        }
    }
}