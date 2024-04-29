package com.sufaka.heliosquizapp.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import androidx.core.content.ContextCompat
import com.sufaka.heliosquizapp.R
import com.sufaka.heliosquizapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var  binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(R.layout.activity_main)

        val window: Window= this@MainActivity.window
        window.statusBarColor= ContextCompat.getColor(this@MainActivity, R.color.grey)

        binding.apply {
            bottomMenu.setItemSelected(R.id.home)
            bottomMenu.setOnItemSelectedListener {
                if (it==R.id.Board){
                    startActivity(Intent(this@MainActivity,LeaderActivity::class.java))
                }


            }
        }
    }
}