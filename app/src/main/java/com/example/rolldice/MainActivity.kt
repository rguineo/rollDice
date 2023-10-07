package com.example.rolldice

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btnLanzar: Button = findViewById(R.id.btnLanzar)

        btnLanzar.setOnClickListener {
            tiempo()
            val mp = MediaPlayer.create(this, R.raw.dice_sound)
            mp.start()
        }
        rollDice()
    }

    private fun rollDice(){
        var numero: Int = lanzar(6)
        val txtResult: TextView = findViewById(R.id.txtNumero)
        txtResult.text = numero.toString()

        val drawableResult = when(numero){
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }

        val imgDice: ImageView = findViewById(R.id.imgDice)
        imgDice.setImageResource(drawableResult)

    }
    private fun lanzar(max: Int): Int{
        return (1..max).random()
    }

    private fun tiempo(){
        object: CountDownTimer(3000, 200){
            override fun onTick(p0: Long) {
                rollDice()
            }

            override fun onFinish() {

            }

        }.start()
    }
}