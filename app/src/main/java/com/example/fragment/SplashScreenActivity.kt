package com.example.fragment

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.fragment.R

class SplashScreenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen2)

        val buttonEnter = findViewById<Button>(R.id.buttonEnter)
        val editTextName = findViewById<EditText>(R.id.editTextName)

        buttonEnter.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            val name = editTextName.text.toString()
            intent.putExtra("user_name", name)
            startActivity(intent)
            finish()
        }
    }
}





