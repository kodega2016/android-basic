package com.kodega.roll_dice

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlin.math.roundToInt
import kotlin.random.Random

class MainActivity:AppCompatActivity(){

    lateinit var diceImage:ImageView;


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        diceImage=findViewById(R.id.dice_image);

        var button:Button=findViewById(R.id.roll_button);

        button.setOnClickListener{
            rollDice();
        }
    }

    fun rollDice(){
        var dice:Int= Random.nextInt(6)+1;
        var drawableResource=when(dice){
            1->R.drawable.dice_1
            2->R.drawable.dice_2
            3->R.drawable.dice_3
            4->R.drawable.dice_4
            5->R.drawable.dice_5
            else->R.drawable.dice_6
        }

        diceImage.setImageResource(drawableResource);

    }
}