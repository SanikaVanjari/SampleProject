package com.example.sampleproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Message
import android.util.Patterns
import android.widget.Toast
import androidx.core.widget.doAfterTextChanged
import com.google.android.material.textfield.TextInputEditText
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.Theme_SampleProject)
        setContentView(R.layout.activity_main)


        logIn.setOnClickListener {

            if (editTextEmailAddress.text.isNullOrEmpty() || editTextEmailAddress.text.toString()
                    .trim() != getString(R.string.test_email)
            ) {
                Toast.makeText(this, getString(R.string.email_error), Toast.LENGTH_LONG).show()
            } else if (editTextTextPassword.text.isNullOrEmpty() || editTextTextPassword.text.toString()
                    .trim() != getString(R.string.test_password)
            ) {
                Toast.makeText(this, getString(R.string.password_error), Toast.LENGTH_LONG).show()
            } else {
                logInSuccess()
            }
        }

    }

    private fun logInSuccess() {
        startActivity(Intent(this, ListActivity::class.java))
        finish()
    }
}
