package com.example.numberpositionactivity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

const val EXTRA_MESSAGE = "com.example.numberpositionactivity.MESSAGE"

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    fun evaluateNumbers(view: View){
        val fourDigits = findViewById<TextView>(R.id.fourDigits).text.toString().toCharArray()
        val guessDigit = findViewById<TextView>(R.id.guessDigit).text.toString().toCharArray()
        val position:Int = fourDigits.indexOf(guessDigit[0])+1
        var message = ""
        if (position>0){
            message = "El numero "+guessDigit[0]+" ocupa la posición "+position
        }else{
            message = "El numero "+guessDigit[0]+" no ocupa ninguna posición"
        }
        val intent = Intent(this,ResultActivity::class.java).apply {
            putExtra(EXTRA_MESSAGE, message)
        }
        startActivity(intent)
    }
}