package com.ulas.teklif

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.Button
import android.widget.TextView

class ilanlar : AppCompatActivity() {
    lateinit var testTvsayac:TextView
    lateinit var testtv: TextView
    lateinit var testbtn1: Button
    lateinit var testbtn2: Button
    lateinit var testbtn3 : Button

    var lastpriceps:Int=6000
    var lastpricepc:Int=5000
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ilanlar)
        testbtn1=findViewById(R.id.button)as Button
        testbtn2=findViewById(R.id.button2) as Button
        testbtn3=findViewById(R.id.button3) as Button
        testtv=findViewById(R.id.tvlastprice) as TextView
        testTvsayac=findViewById(R.id.tv_sayac) as TextView

        object : CountDownTimer(7200000, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                testTvsayac.setText("Kalan Süre: " + millisUntilFinished / 1000)
            }

            override fun onFinish() {
                testTvsayac.setText("Bitiş!")
            }
        }.start()
        testbtn1.setOnClickListener {
            lastpriceps++
            testtv.text=lastpriceps.toString()
        }

    }
}