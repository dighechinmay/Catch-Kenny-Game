package com.chinmay.catchthekennygame

import android.R.attr.left
import android.R.attr.right
import android.os.Bundle
import android.os.CountDownTimer
import android.os.Handler
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.random.Random


class MainActivity : AppCompatActivity() {




    var score: Int = 0
    lateinit var imageArray: ArrayList<ImageView>
    var handler: Handler = Handler()
    var runnable:Runnable = Runnable {  }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        imageArray = arrayListOf(imageView,imageView1,imageView2,imageView3,imageView4,imageView5,imageView6,imageView7,imageView8,imageView9,imageView10,imageView11,imageView12,imageView13,imageView14,imageView15,imageView16,imageView17,imageView18,imageView19,imageView20)


        hidekenny()

        object: CountDownTimer(20000,1000){
            override fun onFinish() {
                        timer_counter.text = "Time's Up!"
                        handler.removeCallbacks(runnable)
                        for(image in imageArray){
                             image.visibility = View.INVISIBLE
                        }
            }

            override fun onTick(p0: Long) {

                        timer_counter.text = "Left : " + p0/1000
            }
        }.start()



    }


    fun hidekenny() {

        runnable = object: Runnable {
            override fun run() {
                for(image in imageArray){
                    image.visibility = View.INVISIBLE
                }


                val index = Random.nextInt(0,19)
                imageArray[index].visibility = View.VISIBLE

                handler.postDelayed(runnable,800)
            }
        }

        handler.post(runnable)

    }


    fun updateScore(view: View){
        score = score+1
        score_view.text = "Score : " + score.toString()
    }

}
