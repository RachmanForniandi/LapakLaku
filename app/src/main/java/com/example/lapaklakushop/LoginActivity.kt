package com.example.lapaklakushop.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.lapaklakushop.R
import com.example.lapaklakushop.ui.ui.login.LoginFragment

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login_activity)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, LoginFragment.newInstance())
                .commitNow()
        }
    }

}
