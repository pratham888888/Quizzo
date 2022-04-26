package com.pratham.quizzo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_result.*

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)
        window.decorView.systemUiVisibility=View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
        val username=intent.getStringExtra(Constants.USER_NAME)
        tv_name.text=username
        val correctans=intent.getIntExtra(Constants.CORRECT_ANS,0)
        val totalques=intent.getIntExtra(Constants.TOTAL_QUESTIONS,0)
        tv_score.text="Your score is $correctans out of $totalques"
        if(correctans<=8&&correctans>=6){
            tv_congratulations.text="Nice try!"
        }
        if(correctans<=5&&correctans>=4){
            tv_congratulations.text="You did good"
        }
        if(correctans<4){
            tv_congratulations.text="Better luck next time"
        }
        btn_finish.setOnClickListener {
            startActivity(Intent(this,MainActivity::class.java))
            finish()
        }

    }
}