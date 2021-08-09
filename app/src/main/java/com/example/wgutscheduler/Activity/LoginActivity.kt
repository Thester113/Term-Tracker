package com.example.wgutscheduler.Activity

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.wgutscheduler.DB.DataBase
import com.example.wgutscheduler.R
import java.math.BigInteger
import java.security.MessageDigest
import java.security.NoSuchAlgorithmException

class LoginActivity : AppCompatActivity() {
    private lateinit var btnSubmit: Button
    private lateinit var userName: EditText
    private lateinit var etPassword: EditText
    private lateinit var btnReset: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        btnSubmit = findViewById(R.id.btn_submit)
        userName =findViewById(R.id.et_user_name)
        etPassword = findViewById(R.id.et_password)
        btnReset = findViewById(R.id.btn_reset)
        btnSubmit.setOnClickListener {

            val userName = userName.text
            val password = etPassword.text
            if(userName.toString() == "test" &&  hash(password.toString()) == "098F6BCD4621D373CADE4E832627B4F6") {
                val intent = Intent(applicationContext, MainPage::class.java)
                startActivity(intent)
                finish()

            }

            Toast.makeText(this@LoginActivity, userName, Toast.LENGTH_LONG).show()
        }
        btnReset.setOnClickListener {
            userName.setText("")
            etPassword.setText("")

        }



    }
    fun hash(input: String): String? {
        return try {
            val md: MessageDigest = MessageDigest.getInstance("MD5")
            val md5Data = BigInteger(1, md.digest(input.toByteArray()))
            java.lang.String.format("%032X", md5Data)
        } catch (e: NoSuchAlgorithmException) {
            e.printStackTrace()
            null
        }
    }
}




