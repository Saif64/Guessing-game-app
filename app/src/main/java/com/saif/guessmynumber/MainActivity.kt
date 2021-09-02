package com.saif.guessmynumber

import android.annotation.SuppressLint
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.random.Random

class MainActivity : AppCompatActivity(), View.OnClickListener {
    var number: Int = (1..100).random()
    var guess: Int = 0

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        arrowDownBtn.setOnClickListener(this)
        arrowUPBtn.setOnClickListener(this)
        resetBtn.setOnClickListener(this)
        rightBtn.setOnClickListener(this)




        question_textView.text = getString(R.string.what_number) + "?"

    }

    @SuppressLint("SetTextI18n")
    override fun onClick(v: View?) {
        when(v?.id){
            R.id.rightBtn  -> {
                resetBtn.text = getString(R.string.again)
                rightNumber_textView.visibility = View.VISIBLE
                question_textView.visibility = View.INVISIBLE
                rightNumber_textView.text = getString(R.string.correct_answer) + number.toString()
            }

            R.id.arrowDownBtn -> clickOnDownArrow()
            R.id.arrowUPBtn -> clickUpArrow()
            R.id.resetBtn -> {
                rightNumber_textView.visibility = View.INVISIBLE
                question_textView.visibility = View.VISIBLE
                number = 50
                printQuestion()
            }
        }
    }



    @SuppressLint("SetTextI18n")
    fun printQuestion(){
        question_textView.text = getString(R.string.is_your_number) + number.toString() + "?"
    }

    fun clickOnDownArrow(){
        number = (1..49).random()
        printQuestion()




    }

    private fun clickUpArrow() {
        number = (50..100).random()
        printQuestion()


    }
}