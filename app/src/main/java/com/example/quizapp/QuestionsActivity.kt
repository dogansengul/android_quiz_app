package com.example.quizapp

import android.content.Intent
import android.content.res.ColorStateList
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.view.View
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import com.example.quizapp.databinding.ActivityQuestionsBinding

class QuestionsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityQuestionsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_questions)
        val currentIntent = intent
        val playerName = currentIntent.getCharSequenceExtra("a")
        binding.textView.text = "${playerName}'s first question is:"
        val questionList = QuestionObjects.getQuestions()
        Log.i("Question list size is: ${questionList.size}","${questionList.size}")
        var currentQuestionIndex = 0
        binding.qNumber.text = "${currentQuestionIndex+1}/5"
        binding.progressBar.progress = currentQuestionIndex + 1
        binding.flag.setImageResource(questionList[currentQuestionIndex].image)
        binding.question.text = questionList[currentQuestionIndex].quesiton
        binding.option1.text = questionList[currentQuestionIndex].option1
        binding.option2.text = questionList[currentQuestionIndex].option2
        binding.option3.text = questionList[currentQuestionIndex].option3
        binding.option4.text = questionList[currentQuestionIndex].option4

        var trueAnswerCount = 0

        var optionClickEnable: Boolean = true
        binding.option1.setOnClickListener {
            while (optionClickEnable) {
                if (binding.option1.text.equals(questionList[currentQuestionIndex].correctOpt)) {
                    binding.option1.backgroundTintList = ColorStateList.valueOf(Color.GREEN)
                    optionClickEnable = false
                    trueAnswerCount += 1

                } else {
                    binding.option1.backgroundTintList = ColorStateList.valueOf(Color.RED)
                    optionClickEnable = false
                }
                if(currentQuestionIndex == 4){
                    binding.nextQuestionButton.text = "FINISH"
                }
            }
            binding.nextQuestionButton.visibility = View.VISIBLE
        }
        binding.option2.setOnClickListener {

            while (optionClickEnable) {
                if (binding.option2.text.equals(questionList[currentQuestionIndex].correctOpt)) {
                    binding.option2.backgroundTintList = ColorStateList.valueOf(Color.GREEN)
                    optionClickEnable = false
                    trueAnswerCount += 1
                } else {
                    binding.option2.backgroundTintList = ColorStateList.valueOf(Color.RED)
                    optionClickEnable = false
                }
                if(currentQuestionIndex == 4){
                    binding.nextQuestionButton.text = "FINISH"
                }
            }
            binding.nextQuestionButton.visibility = View.VISIBLE

        }
        binding.option3.setOnClickListener {

            while (optionClickEnable) {
                if (binding.option3.text.equals(questionList[currentQuestionIndex].correctOpt)) {
                    binding.option3.backgroundTintList = ColorStateList.valueOf(Color.GREEN)
                    optionClickEnable = false
                    trueAnswerCount += 1
                } else {
                    binding.option3.backgroundTintList = ColorStateList.valueOf(Color.RED)
                    optionClickEnable = false
                }
                if(currentQuestionIndex == 4){
                    binding.nextQuestionButton.text = "FINISH"
                }
            }
            binding.nextQuestionButton.visibility = View.VISIBLE
        }
        binding.option4.setOnClickListener {

            while (optionClickEnable) {
                if (binding.option4.text.equals(questionList[currentQuestionIndex].correctOpt)) {
                    binding.option4.backgroundTintList = ColorStateList.valueOf(Color.GREEN)
                    optionClickEnable = false
                    trueAnswerCount += 1
                } else {
                    binding.option4.backgroundTintList = ColorStateList.valueOf(Color.RED)
                    optionClickEnable = false
                }
                if(currentQuestionIndex == 4){
                    binding.nextQuestionButton.text = "FINISH"
                }
            }
            binding.nextQuestionButton.visibility = View.VISIBLE
        }

        binding.nextQuestionButton.setOnClickListener {
            if(currentQuestionIndex == 4){
                val intent = Intent(this, ResultActivity::class.java)
                intent.putExtra("Player Name", playerName)
                intent.putExtra("True Answer Count", trueAnswerCount)
                startActivity(intent)
                finish()
            }else{
                currentQuestionIndex += 1
                optionClickEnable = true
                binding.nextQuestionButton.visibility = View.INVISIBLE

                binding.qNumber.text = "${currentQuestionIndex+1}/5"
                binding.progressBar.progress = currentQuestionIndex + 1
                binding.flag.setImageResource(questionList[currentQuestionIndex].image)
                binding.question.text = questionList[currentQuestionIndex].quesiton
                binding.option1.text = questionList[currentQuestionIndex].option1
                binding.option1.backgroundTintList = ContextCompat.getColorStateList(this, R.color.ButtonDefaultColor)
                binding.option2.backgroundTintList = ContextCompat.getColorStateList(this, R.color.ButtonDefaultColor)
                binding.option3.backgroundTintList = ContextCompat.getColorStateList(this, R.color.ButtonDefaultColor)
                binding.option4.backgroundTintList = ContextCompat.getColorStateList(this, R.color.ButtonDefaultColor)
                binding.option2.text = questionList[currentQuestionIndex].option2
                binding.option3.text = questionList[currentQuestionIndex].option3
                binding.option4.text = questionList[currentQuestionIndex].option4
            }



        }
    }
}