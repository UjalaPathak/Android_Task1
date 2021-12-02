package com.example.helloworld

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.google.android.material.textfield.TextInputLayout

class MainActivity : AppCompatActivity() {
    var clickcount =0;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val mytextDisplayValue= findViewById<TextView>(R.id.mytextview);
        val clickmeButton = findViewById<TextView>(R.id.clickmeview);
        val userNametextInputView = findViewById<TextInputLayout>(R.id.name);
        val nameMap = mutableMapOf<String,Int>()

        clickmeButton.setOnClickListener{

            val userName = userNametextInputView.editText?.text?.toString()
            val markedUserName = if (userName.isNullOrEmpty()) "somebody"
            else userName
            if (markedUserName in nameMap) {
                clickcount = nameMap[markedUserName.toString()]!!
                nameMap[markedUserName.toString()] = clickcount + 1
            }
            else
            {
                nameMap.put(markedUserName.toString(),+1)
            }

            mytextDisplayValue.text= "$markedUserName clicked ${nameMap[markedUserName]} times"
        }
    }
}