package com.android.learnkotlin.onboarding

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.android.learnkotlin.R
import com.android.learnkotlin.sign.signin.SignInScreenActivity
import com.android.learnkotlin.utils.Preferences
import kotlinx.android.synthetic.main.activity_on_boarding_one.*

class OnBoardingOneActivity : AppCompatActivity() {

    lateinit var preferences:Preferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_on_boarding_one)

        preferences = Preferences(this)

        if (preferences.getValues("onboarding").equals("1")) {
            finishAffinity()

            var intent = Intent(this@OnBoardingOneActivity, SignInScreenActivity::class.java)
            startActivity(intent)
        }

        btn_lanjutkan.setOnClickListener {
            var intent = Intent(this@OnBoardingOneActivity, OnBoardingTwoActivity::class.java)
            startActivity(intent)
        }

        btn_signin.setOnClickListener {
            var intent = Intent(this@OnBoardingOneActivity, SignInScreenActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}
