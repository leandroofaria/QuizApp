package com.example.quizapp.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import com.example.quizapp.R
import com.example.quizapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        window.setFlags(
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
        )

        binding.apply {
            singleBtn.setOnClickListener {

            }

            bottomMenu.setItemSelected(R.id.Home)
            bottomMenu.setOnItemSelectedListener {
                if(it== R.id.Board) {
                    startActivity(Intent(this@MainActivity, LeaderActivity::class.java))
                }
            }
        }
    }
}