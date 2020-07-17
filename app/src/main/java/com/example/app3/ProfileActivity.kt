package com.example.app3

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class ProfileActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.profile)

        val preference = getSharedPreferences("Preference", Context.MODE_PRIVATE)
        val pref1 = getSharedPreferences("Pref1", Context.MODE_PRIVATE)

        val profLog = findViewById<EditText>(R.id.ProfLog)
        val fromMain = intent.getStringExtra("LoginText")
        profLog.setText(fromMain)


        val profPass = findViewById<EditText>(R.id.ProfPass)
        val fromMain1 = intent.getStringExtra("PasswordText")
        profPass.setText(fromMain1)

        val btnRef = findViewById<Button>(R.id.btnRef)
        val btnOut = findViewById<Button>(R.id.btnOut)

        btnRef.setOnClickListener {
            val text = profLog.editableText.toString()
            val text1 = profPass.editableText.toString()
            pref1.edit().putString("text", text).apply()
            preference.edit().putString("text1", text1).apply()
            Toast.makeText(applicationContext, "Данные обновлены", Toast.LENGTH_LONG).show()

        }
        btnOut.setOnClickListener {
            val sig = Intent(applicationContext, MainActivity::class.java)
            pref1.edit().clear().apply()
            preference.edit().clear().apply()
            startActivity(sig)

        }
    }
}


