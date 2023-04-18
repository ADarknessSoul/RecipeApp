package com.example.recipeapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.LinearLayout

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var btnLightMode: Button
        btnLightMode = findViewById(R.id.view_togglebutton)

        btnLightMode.setOnClickListener(object : View.OnClickListener {

            override fun onClick(view: View?) {

                changeMode(btnLightMode)

            }

        })

    }

    fun changeMode(btnLightMode: Button) {

        var backgroundLayer: LinearLayout = findViewById(R.id.mainLayout)

        //if(btnLightMode.isActivated) backgroundLayer.setBackgroundColor()

    }



}