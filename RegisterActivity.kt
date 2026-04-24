package com.example.swiggyclone

import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class RegisterActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        val name = findViewById<EditText>(R.id.nameEdit)
        val phone = findViewById<EditText>(R.id.phoneEdit)
        val email = findViewById<EditText>(R.id.emailEdit)
        val btn = findViewById<Button>(R.id.registerBtn)

        btn.setOnClickListener {

            val nameText = name.text.toString()
            val phoneText = phone.text.toString()
            val emailText = email.text.toString()

            if (nameText.isEmpty() || phoneText.isEmpty() || emailText.isEmpty()) {
                Toast.makeText(this, "Please fill all details", Toast.LENGTH_SHORT).show()
            } else {
                // ✅ GO TO ITEMS PAGE (MainActivity)
                val intent = Intent(this, MainActivity::class.java)

                startActivity(intent)
                finish()
            }
        }
    }
}