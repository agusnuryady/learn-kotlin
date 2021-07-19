package com.android.learnkotlin.sign.signup

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.android.learnkotlin.R
import com.android.learnkotlin.sign.signin.User
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.activity_sign_up.*

class SignUpScreenActivity : AppCompatActivity() {

    lateinit var sUsername:String
    lateinit var sPassword:String
    lateinit var sName:String
    lateinit var sEmail:String

    lateinit var mDatabaseReference: DatabaseReference
    lateinit var mFirebaseInstance : FirebaseDatabase
    lateinit var mDatabase: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        mFirebaseInstance = FirebaseDatabase.getInstance("https://learn-kotlin-46088-default-rtdb.asia-southeast1.firebasedatabase.app/")
        mDatabase = FirebaseDatabase.getInstance().getReference()
        mDatabaseReference = mFirebaseInstance.getReference("User")

        btn_lanjutkan.setOnClickListener {

            sUsername = et_username.text.toString()
            sPassword = et_password.text.toString()
            sName = et_name.text.toString()
            sEmail = et_email.text.toString()

            if (sUsername.equals("")) {
                et_username.error = "username tidak boleh kosong"
                et_username.requestFocus()
            } else if (sPassword.equals("")) {
                et_password.error = "password tidak boleh kosong"
                et_password.requestFocus()
            } else if (sName.equals("")) {
                et_name.error = "nama tidak boleh kosong"
                et_name.requestFocus()
            } else if (sEmail.equals("")) {
                et_email.error = "email tidak boleh kosong"
                et_email.requestFocus()
            } else {
                saveUsername (sUsername, sPassword, sName, sEmail)
            }
        }
    }

    private fun saveUsername(sUsername: String, sPassword: String, sName: String, sEmail: String) {

        var user = User()
        user.email = sEmail
        user.username = sUsername
        user.nama = sName
        user.password = sPassword

        if (sUsername != null) {
            checkingUsername(sUsername, user)
        }
    }

    private fun checkingUsername(sUsername: String, data: User) {

        mDatabaseReference.child(sUsername).addValueEventListener(object : ValueEventListener{
            override fun onCancelled(databaseError: DatabaseError) {
                Toast.makeText(this@SignUpScreenActivity, ""+databaseError.message, Toast.LENGTH_LONG).show()
            }

            override fun onDataChange(dataSnapshot: DataSnapshot) {
                var user = dataSnapshot.getValue(User::class.java)
                if (user == null) {
                    mDatabaseReference.child(sUsername).setValue(data)

                    var goSignupPhotoScreen = Intent(this@SignUpScreenActivity,
                        SignUpPhotoScreenActivity::class.java).putExtra("name", data?.nama)
                    startActivity(goSignupPhotoScreen)
                } else {
                    Toast.makeText(this@SignUpScreenActivity, "User sudah digunakan", Toast.LENGTH_LONG).show()
                }
            }

        })

    }
}
