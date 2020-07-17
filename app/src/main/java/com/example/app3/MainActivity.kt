package com.example.app3

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val login = findViewById<EditText>(R.id.Login)
        val password = findViewById<EditText>(R.id.Password)
        val btnLog = findViewById<Button>(R.id.btnLog)
        val btnReg = findViewById<Button>(R.id.btnReg)

        val preference = getSharedPreferences("Preference", Context.MODE_PRIVATE)
        val pref1 = getSharedPreferences("Pref1", Context.MODE_PRIVATE)


        btnReg.setOnClickListener {
            val text = login.editableText.toString()
            val text1 = password.editableText.toString()
            pref1.edit().putString("text", text).apply()
            preference.edit().putString("text1", text1).apply()
            Toast.makeText(applicationContext,"Данные сохранены", Toast.LENGTH_LONG).show()
        }

        btnLog.setOnClickListener {
            val logTex = pref1.getString("text", "")
            val preference1 = preference.getString("text1", "")
            val intent = Intent(this, ProfileActivity::class.java)
            intent.putExtra("LoginText", logTex)
            intent.putExtra("PasswordText", preference1)

            if(logTex == login.editableText.toString() && preference1 == password.editableText.toString()) {
                Toast.makeText(applicationContext, "Вход выполнен", Toast.LENGTH_LONG).show()
                startActivity(intent)
            }
            else {
                Toast.makeText(applicationContext,"Вход не выполнен", Toast.LENGTH_LONG).show()
            }

        }
    }
}