package com.example.colormyviews

import android.graphics.Color

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setListeners()
    }

    private fun setListeners(){

        val box_one_text: TextView = findViewById(R.id.box_one_text)
        val box_two_text: TextView = findViewById(R.id.box_two_text)
        val box_three_text: TextView = findViewById(R.id.box_three_text)
        val box_four_text: TextView = findViewById(R.id.box_four_text)
        val box_five_text: TextView = findViewById(R.id.box_five_text)


        //using a listOf views to set the same click listeners on each view
        val clickableViews: List<View> =
            listOf(box_one_text, box_two_text, box_three_text,
               box_four_text, box_five_text)

        //listOf("box_one_text", "box_two_text", "box_three_text",
        //                "box_four_text", "box_five_text")

        //seting the listeners

//        for (item in clickableViews){
//            item.setOnClickListener( makeColored(it))
//        }
        clickableViews.forEach{ view ->
            view.setOnClickListener(makeColored())
        }
    }

    private fun makeColored():View.OnClickListener{
        return View.OnClickListener { view ->
            when (view.id) {
                // Boxes using Class colors for background
                R.id.box_one_text -> view.setBackgroundColor(Color.DKGRAY)
                R.id.box_two_text -> view.setBackgroundColor(Color.GRAY)

                //boes using Android color resources for background
                R.id.box_three_text -> view.setBackgroundResource(android.R.color.holo_green_light)
                R.id.box_four_text -> view.setBackgroundResource(android.R.color.holo_green_dark)
                R.id.box_five_text -> view.setBackgroundResource(android.R.color.holo_green_light)

                else -> view.setBackgroundColor(Color.LTGRAY)
            }
        }
    }
}