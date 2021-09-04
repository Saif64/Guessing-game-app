package com.saif.guessmynumber

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.random.Random

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private var mid:Int = Random.nextInt(0, 1000)
    private var low:Int = 0
    private var high:Int = 1000

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
                rightNumber_textView.text = " :) "
            }

            R.id.arrowDownBtn -> clickOnDownArrow()
            R.id.arrowUPBtn -> clickUpArrow()
            R.id.resetBtn -> {
                mid = Random.nextInt(0,1000)
                low = 0
                high = 1000
                printQuestion()
            }
        }
    }



    @SuppressLint("SetTextI18n")
    private fun printQuestion(){
        question_textView.text = mid.toString()
    }

    private fun clickOnDownArrow(){
        high = mid - 1
        mid = (low + high)/2
        printQuestion()
    }

    private fun clickUpArrow() {
        low = mid + 1
        mid = (low + high)/2
        printQuestion()


    }
}