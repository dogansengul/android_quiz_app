package com.example.quizapp

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.graphics.Rect
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.ScrollView
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.example.quizapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    @SuppressLint("ClickableViewAccessibility")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        val view = findViewById<View>(R.id.activity_main) // View nesnesini bulun

        view.setOnTouchListener { v, event ->
            val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(view.windowToken, 0) // Klavyeyi gizle
            false
        }
        val scrollView = findViewById<ScrollView>(R.id.activity_main) // ScrollView nesnesini bulun

        scrollView.viewTreeObserver.addOnGlobalLayoutListener {
            val displayRect = Rect()
            scrollView.getWindowVisibleDisplayFrame(displayRect)
            val height = scrollView.rootView.height - displayRect.bottom
            if (height > 100) {
                scrollView.post {
                    scrollView.scrollTo(0, height)
                }
            } else {
                scrollView.post {
                    scrollView.scrollTo(0, 0)
                }
            }
        }

        binding.submitButton.setOnClickListener {
            if((binding.editText.text != null) && (binding.editText.text!!.isNotEmpty())){
                val playerName = binding.editText.text
                val intent = Intent(this, QuestionsActivity::class.java)
                intent.putExtra("a", playerName)
                startActivity(intent)
                //finish()
            }else{
                val toast = Toast.makeText(this, "Please Enter Your Name", Toast.LENGTH_SHORT)
                toast.setGravity(Gravity.TOP or Gravity.FILL_HORIZONTAL, 0, 0)
                toast.show()

            }
        }
    }
}