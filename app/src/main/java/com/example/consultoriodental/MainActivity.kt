package com.example.consultoriodental

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btniniciarseccion = findViewById<Button>(R.id.btniniciarseccionusuadm) as Button

        btniniciarseccion.setOnClickListener(){
            val intent=Intent (this@MainActivity, MainActivity2IniciarseccionAdministradorpant::class.java)
            startActivity(intent)
        }




    }

}