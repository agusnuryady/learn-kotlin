package com.android.learnkotlin.onboarding

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.RequiresApi
import com.android.learnkotlin.R
import com.android.learnkotlin.sign.signin.SignInScreenActivity
import kotlinx.android.synthetic.main.activity_on_boarding_two.*

class OnBoardingTwoActivity : AppCompatActivity() {

    @RequiresApi(Build.VERSION_CODES.JELLY_BEAN)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_on_boarding_two)

        btn_lanjutkan.setOnClickListener {
            finishAffinity()

            var intent = Intent(this@OnBoardingTwoActivity, SignInScreenActivity::class.java)
            startActivity(intent)

        }
    }
}
