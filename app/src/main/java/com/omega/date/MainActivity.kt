package com.omega.date

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.omega.date.structrue.MyLinkedList

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val myLinkedList = MyLinkedList<String>()
        myLinkedList.add(0,"lili4")
        myLinkedList.add(1,"lili3")
        myLinkedList.add(2,"lili2")
        myLinkedList.add(1,"lili1")

        Log.i("MainActivity",myLinkedList.toString())
    }
}
