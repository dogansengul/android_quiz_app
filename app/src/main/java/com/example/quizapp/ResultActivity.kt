package com.example.quizapp

import android.annotation.SuppressLint
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import com.example.quizapp.databinding.ActivityResultBinding

class ResultActivity : AppCompatActivity() {

    private lateinit var binding: ActivityResultBinding
    private lateinit var sharedPreferences: SharedPreferences
    @SuppressLint("SetTextI18n", "CommitPrefEdits")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_result)
        sharedPreferences = getSharedPreferences("com.example.quizapp", MODE_PRIVATE)

        val intent = intent
        val playerName = intent.getCharSequenceExtra("Player Name")
        val trueAnswerCount = intent.getIntExtra("True Answer Count", 0)

        binding.score.text = playerName.toString() + "'s score is: " + trueAnswerCount.toString() + "/5"
        val score = "${trueAnswerCount}/5"

        if(trueAnswerCount > sharedPreferences.getInt("score", 0)){
            sharedPreferences.edit().putInt("score", trueAnswerCount).apply()
            binding.highestScore.text = "${trueAnswerCount}/5"
            binding.highestView.visibility = View.VISIBLE
            binding.highestView.text = "New Highest!"
        } else {
            binding.highestScore.text = "${sharedPreferences.getInt("score", 0)}/5"

        }


        binding.option4.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
        binding.reset.setOnClickListener { reset() }

    }
    private fun reset(){
        sharedPreferences.edit().putInt("score", 0).apply()
        binding.highestView.text = "Highest score was reseted."
        binding.highestScore.text = "0/5"
    }
}