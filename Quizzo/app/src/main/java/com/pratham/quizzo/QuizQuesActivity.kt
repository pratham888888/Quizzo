package com.pratham.quizzo

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_quiz_ques.*

class QuizQuesActivity : AppCompatActivity(),View.OnClickListener {
    private var mCurrentPos:Int=1
    private var mQuestionsList:ArrayList<Question>?=null
    private var mSelectedOption:Int =0
    private var mCorrectAns=0
    private var mUsername:String?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_ques)
        mUsername= intent.getStringExtra(Constants.USER_NAME)
         mQuestionsList=Constants.getQuestions()
        setQuestion()
 tv_option_one.setOnClickListener(this)
        tv_option_two.setOnClickListener(this)
        tv_option_three.setOnClickListener(this)
        tv_option_four.setOnClickListener(this)
        btn_submit.setOnClickListener(this)
    }
    private fun setQuestion()
    {  
        val question = mQuestionsList!!.get(mCurrentPos-1)

        defaultOptionsView()
        if(mCurrentPos==mQuestionsList!!.size){
            btn_submit.text="Finish"
        }
        else{
            btn_submit.text="SUBMIT"
        }
        progress_bar.progress=mCurrentPos
        tv_progressBar.text="$mCurrentPos"+"/"+progress_bar.max
        tv_question.text=question!!.question
        tv_image.setImageResource(question.image)
        tv_option_one.text=question.optionOne
        tv_option_two.text=question.optionTwo
        tv_option_three.text=question.optionThree
        tv_option_four.text=question.optionFour}
private fun defaultOptionsView(){
    val options = ArrayList<TextView>()
    options.add(0,tv_option_one)
    options.add(1,tv_option_two)
    options.add(2,tv_option_three)
    options.add(3,tv_option_four)
    for(option in options){
        option.setTextColor(Color.parseColor("#7A8089"))
        option.typeface= Typeface.DEFAULT
        option.background=ContextCompat.getDrawable(this,R.drawable.default_option_border_bg)
    }
}

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.tv_option_one->{
                selectedOptionView(tv_option_one,1)
            }
            R.id.tv_option_two->{
                selectedOptionView(tv_option_two,2)
            }
            R.id.tv_option_three->{
                selectedOptionView(tv_option_three,3)
            }
            R.id.tv_option_four->{
                selectedOptionView(tv_option_four,4)
            }
            R.id.btn_submit -> {
                if (mSelectedOption == 0) {
                    mCurrentPos++
                    when {
                        mCurrentPos <= mQuestionsList!!.size -> {
                            setQuestion()
                        }
                        else -> {
                           val intent= Intent(this,ResultActivity::class.java)
                            intent.putExtra(Constants.USER_NAME,mUsername)
                            intent.putExtra(Constants.CORRECT_ANS,mCorrectAns)
                            intent.putExtra(Constants.TOTAL_QUESTIONS,mQuestionsList!!.size)
                            startActivity(intent)
                        }

                    }
                } else {
                    val question = mQuestionsList?.get(mCurrentPos - 1)
                    if (question!!.correctAns != mSelectedOption) {
                        answerView(mSelectedOption,R.drawable.wrong_option_border_bg)
                    }
                    else{
                        mCorrectAns+=1
                    }
                    answerView(question.correctAns,R.drawable.correct_option_border_bg)
                    if(mCurrentPos==mQuestionsList!!.size){
                        btn_submit.text="Finish"
                    }
                    else{
                        btn_submit.text="GO TO NEXT QUESTION"
                    }
                    mSelectedOption=0
                }
            }
        }
    }
    private fun selectedOptionView(tv:TextView,selectedOption:Int){
        defaultOptionsView()
        mSelectedOption= selectedOption
        tv.setTextColor(Color.parseColor("#363A43"))
        tv.setTypeface(tv.typeface,Typeface.BOLD)
        tv.background=ContextCompat.getDrawable(this,R.drawable.selected_option_border_bg)
    }
    private fun answerView(ans:Int,drawableView:Int){
        when(ans){
            1->{
                tv_option_one.background=ContextCompat.getDrawable(this,drawableView)
            }
            2->{
                tv_option_two.background=ContextCompat.getDrawable(this,drawableView)
            }
            3->{
                tv_option_three.background=ContextCompat.getDrawable(this,drawableView)
            }
            4->{
                tv_option_four.background=ContextCompat.getDrawable(this,drawableView)
            }
        }
    }

}

