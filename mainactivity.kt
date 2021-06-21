package com.ulas.teklif

import android.content.Intent
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    var girisAdı: String = "admin@gmail.com"
    var parola = "123456"

    lateinit var testedtpassword: EditText
    lateinit var testedtemail: EditText
    lateinit var testbtnregister: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        testedtpassword=findViewById(R.id.edtpassword) as EditText
        testedtemail=findViewById(R.id.edtemail) as EditText
        testbtnregister=findViewById(R.id.btnregister) as Button

        testbtnregister.setOnClickListener {
            loginControl()
            val intent = Intent(this,ilanlar::class.java)
            startActivity(intent)
        }

    }
    fun loginControl() {
        val userName = testedtemail.text.toString()
        val password = testedtpassword.text.toString()
        if (userName == girisAdı && password == parola) {
            Toast.makeText(this, "Giriş Başarılı", Toast.LENGTH_SHORT).show()
        }
        else if (password.trim().length >= 6) {
            Toast.makeText(applicationContext, ">Giriş Başarılı", Toast.LENGTH_SHORT).show()
        }
        else if (password.trim().length < 6) {
            Toast.makeText(applicationContext, "Yetersiz Karakter..", Toast.LENGTH_SHORT).show()
        }
        else if (testedtemail.text.toString().isNotEmpty()) {
            Toast.makeText(this, "Boş dosya girilemez...", Toast.LENGTH_SHORT).show()
        }
        else {
            Toast.makeText(applicationContext, "Tekrar Deneyiniz", Toast.LENGTH_SHORT).show()
        }
    }
}

