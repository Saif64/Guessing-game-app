package com.saif.guessmynumber

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.random.Random

class MainActivity : AppCompatActivity(), View.OnClickListener {
    var number: Int = 5

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
            R.id.rightBtn -> {
                rightNumber_textView.visibility = View.VISIBLE
                question_textView.visibility = View.INVISIBLE
                rightNumber_textView.text = getString(R.string.correct_answer) + number.toString()
            }

            R.id.arrowDownBtn -> clickOnDownArrow()
            R.id.arrowUPBtn -> clickUpArrow()
            R.id.resetBtn -> {
                rightNumber_textView.visibility = View.INVISIBLE
                question_textView.visibility = View.VISIBLE
                number = 5
                printQuestion()
            }
        }
    }



    @SuppressLint("SetTextI18n")
    fun printQuestion(){
        question_textView.text = getString(R.string.is_your_number) + number.toString() + "?"
    }

    fun clickOnDownArrow(){
        if (number == 5){
            number = 3
            printQuestion()
        }
        else if (number == 3){
            number = 2
            printQuestion()
        }
        else if (number == 2){
            number = 1
            printQuestion()
        }
        else if (number == 8){
            number = 7
            printQuestion()
        }
        else if (number == 7){
            number = 6
            printQuestion()
        }
    }

    private fun clickUpArrow() {
        if (number == 3){
            number = 4
            printQuestion()
        }
        else if (number == 5){
            number = 6
            printQuestion()
        }
        else if (number == 6){
            number = 7
            printQuestion()
        }
        else if (number == 7){
            number = 8
            printQuestion()
        }
        else if (number == 4){
            number = 8
            printQuestion()
        }
        else if (number == 8){
            number = 9
            printQuestion()
        }
        else if (number == 9){
            number = 10
            printQuestion()
        }
    }
}