package com.example.colormyviews

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setListeners()
    }

    private fun setListeners() {
        val boxOneText = findViewById<TextView>(R.id.box_one_text)
        val boxTwoText = findViewById<TextView>(R.id.box_two_text)
        val boxThreeText = findViewById<TextView>(R.id.box_three_text)
        val boxFourText = findViewById<TextView>(R.id.box_four_text)
        val boxFiveText = findViewById<TextView>(R.id.box_five_text)
        val parentConstraintLayout = findViewById<ConstraintLayout>(R.id.parentConstraintLayout)
        val redButton = findViewById<Button>(R.id.red_button)
        val greenButton = findViewById<Button>(R.id.green_button)
        val yellowButton = findViewById<Button>(R.id.yellow_button)


        val clickableView: List<View> = listOf(boxOneText,  boxTwoText, boxThreeText, boxFourText, boxFiveText, parentConstraintLayout, redButton, greenButton, yellowButton)

        for (item in clickableView) {
            item.setOnClickListener { makeColored(it) }
        }

    }

    fun makeColored(view: View) {
        val boxThreeText = findViewById<TextView>(R.id.box_three_text)
        val boxFourText = findViewById<TextView>(R.id.box_four_text)
        val boxFiveText = findViewById<TextView>(R.id.box_five_text)
        when (view.id) {

            // Boxes using Color class colors for background
            R.id.box_one_text -> view.setBackgroundColor(Color.DKGRAY)
            R.id.box_two_text -> view.setBackgroundColor(Color.GRAY)

            // Boxes using Android color resources for background
            R.id.box_three_text -> view.setBackgroundResource(android.R.color.holo_green_light)
            R.id.box_four_text -> view.setBackgroundResource(android.R.color.holo_green_dark)
            R.id.box_five_text -> view.setBackgroundResource(android.R.color.holo_green_light)

            // Boxes using custom colors for background
            R.id.red_button -> boxThreeText.setBackgroundResource(R.color.my_red)
            R.id.yellow_button -> boxFourText.setBackgroundResource(R.color.my_yellow)
            R.id.green_button -> boxFiveText.setBackgroundResource(R.color.my_green)

            else -> view.setBackgroundColor(Color.LTGRAY)
        }
    }
}