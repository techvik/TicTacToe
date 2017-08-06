package com.techvik.tictactoe

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    fun reset(v:View){
        Toast.makeText(this,"Will be updated soon!!",Toast.LENGTH_LONG).show()
    }

     fun bClick(view:View){
        var bSelected = view as Button
        var cID = 0
        when(bSelected.id){
            R.id.b11 -> cID = 1
            R.id.b12 -> cID = 2
            R.id.b13 -> cID = 3
            R.id.b21 -> cID = 4
            R.id.b22 -> cID = 5
            R.id.b23 -> cID = 6
            R.id.b31 -> cID = 7
            R.id.b32 -> cID = 8
            R.id.b33 -> cID = 9
        }

        //Toast.makeText(this, "CELL:$cID",Toast.LENGTH_SHORT).show()
        playGame(cID,bSelected)

    }

    var p1 = ArrayList<Int>()
    var p2 = ArrayList<Int>()
    var active = 1
    fun playGame(cID:Int, bSelected:Button){
        if(active == 1){
            bSelected.text = "X"
            bSelected.textSize = 30F
            bSelected.setBackgroundColor(Color.YELLOW)
            p1.add(cID)
            active = 2
            findWinner()
        }
        else{
            bSelected.text = "O"
            bSelected.textSize = 30F
            bSelected.setBackgroundColor(Color.CYAN)
            p2.add(cID)
            active = 1
            findWinner()
        }
        bSelected.isEnabled = false
    }

    fun findWinner(){
        var w = -1
        if(p1.contains(1) && p1.contains(2) && p1.contains(3))
            w = 1
        if(p1.contains(4) && p1.contains(5) && p1.contains(6))
            w = 1
        if(p1.contains(7) && p1.contains(8) && p1.contains(9))
            w = 1
        if(p1.contains(1) && p1.contains(4) && p1.contains(7))
            w = 1
        if(p1.contains(2) && p1.contains(5) && p1.contains(8))
            w = 1
        if(p1.contains(3) && p1.contains(6) && p1.contains(9))
            w = 1
        if(p1.contains(1) && p1.contains(5) && p1.contains(9))
            w = 1
        if(p1.contains(3) && p1.contains(5) && p1.contains(7))
            w = 1


        if(p2.contains(1) && p2.contains(2) && p2.contains(3))
            w = 2
        if(p2.contains(4) && p2.contains(5) && p2.contains(6))
            w = 2
        if(p2.contains(7) && p2.contains(8) && p2.contains(9))
            w = 2
        if(p2.contains(1) && p2.contains(4) && p2.contains(7))
            w = 2
        if(p2.contains(2) && p2.contains(5) && p2.contains(8))
            w = 2
        if(p2.contains(3) && p2.contains(6) && p2.contains(9))
            w = 2
        if(p2.contains(1) && p2.contains(5) && p2.contains(9))
            w = 2
        if(p2.contains(3) && p2.contains(5) && p2.contains(7))
            w = 2


        if(w == 1)
            display.text = "\'X\' wins"
            //Toast.makeText(this,"player 1",Toast.LENGTH_LONG).show()

        else if(w == 2)
            display.text = "\'O\' wins"
            //Toast.makeText(this,"player 2",Toast.LENGTH_LONG).show()
    }
}
