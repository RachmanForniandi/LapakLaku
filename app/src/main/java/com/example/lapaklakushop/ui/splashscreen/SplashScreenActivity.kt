package com.example.lapaklakushop.ui.splashscreen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.example.lapaklakushop.ui.main.MainActivity
import com.example.lapaklakushop.R
import com.example.lapaklakushop.ui.LoginActivity
import com.example.lapaklakushop.utilSupport.SessionManager
import org.jetbrains.anko.startActivity

class SplashScreenActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        var sesi = SessionManager(this)

        Handler().postDelayed(kotlinx.coroutines.Runnable {
            if(sesi.isLogin)startActivity<MainActivity>()
            else startActivity<LoginActivity>()
            finish()
        },4000)
    }
}
