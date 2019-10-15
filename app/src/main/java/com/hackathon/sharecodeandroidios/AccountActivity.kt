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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_account)
    }


}