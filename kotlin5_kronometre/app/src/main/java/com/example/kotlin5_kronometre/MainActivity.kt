package com.example.kotlin5_kronometre

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var numara = 0
    var runnable: Runnable = Runnable { }//global değişken  // runnable oluşturma
    var handler = Handler(Looper.myLooper()!!)//global değişken // handler oluşturma //android olanı seç

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val sayilar = 1..5
        for (sayi in sayilar) {
            println(sayi)
            if (sayi == 2) break
        }
    }


    fun baslat(view: View) {
        numara = 0
        runnable = object : Runnable {
            override fun run() {
                numara = numara + 1
                textView.text = "SAYAC: ${numara}"
                handler.postDelayed(runnable, 1000)//kaç saniyede bir çalışsın
            }


        }
        handler.post(runnable)
    }

    fun durdur(view: View) {
        handler.removeCallbacks(runnable) //runnable değişkenini dururmaya yarar
        textView.text = "SAYAC : 0"
        numara = 0


    }
}
