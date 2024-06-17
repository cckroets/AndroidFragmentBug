package com.example.myapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)
        supportFragmentManager.beginTransaction()
            .add(binding.fragmentContainer.id, FirstTopLevelFragment())
            .commitNow()

        binding.fab.setOnClickListener {
            supportFragmentManager.beginTransaction()
                .replace(binding.fragmentContainer.id, SecondTopLevelFragment())
                .addToBackStack(null)
                .commit()
        }
    }
}
