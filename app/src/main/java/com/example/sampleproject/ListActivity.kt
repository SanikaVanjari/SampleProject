package com.example.sampleproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class ListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.Theme_SampleProject)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)
    }
}