package com.example.peoplenews

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import py.edu.uca.peoplenews.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        iniciar_sesion_button.setOnClickListener {
            val intento1= Intent(this,MainActivityMenu::class.java)
            startActivity(intento1)
        }

    }
}
