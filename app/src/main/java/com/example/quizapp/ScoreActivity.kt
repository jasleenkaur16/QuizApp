package com.example.quizapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.quizapp.databinding.ActivityScoreBinding

class ScoreActivity : AppCompatActivity() {
    private lateinit var binding: ActivityScoreBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityScoreBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.scores.setText("Congrats!!! your score is ${intent.getIntExtra("SCORE",0)}")

    }
}