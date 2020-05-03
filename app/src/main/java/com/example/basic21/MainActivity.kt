package com.example.basic21

import android.content.Context
import android.opengl.Visibility
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // button click
        findViewById<Button>(R.id.button_name).setOnClickListener {
            addNickname(it)
        }

        // below is to show button on change of text
        findViewById<EditText>(R.id.edit_text).addTextChangedListener(object : TextWatcher {
             override fun afterTextChanged(p0: Editable?) {
            }

            override  fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                findViewById<Button>(R.id.button_name).visibility = View.VISIBLE
            }
        })

        //text top name click
        findViewById<TextView>(R.id.name_text).setOnClickListener {
            val editText = findViewById<EditText>(R.id.edit_text)
            val nicknameTextView = findViewById<TextView>(R.id.name_text)
            editText.visibility = View.VISIBLE
            nicknameTextView.visibility = View.VISIBLE
            // Set the focus to the edit text.
            editText.requestFocus()
            // Show the keyboard.
            val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.showSoftInput(editText, 0)

        }


    }



    private fun addNickname(view: View) {
        val editText = findViewById<EditText>(R.id.edit_text)
        val nicknameTextView = findViewById<TextView>(R.id.name_text)
        nicknameTextView.text = editText.text
        editText.visibility=View.GONE
        view.visibility = View.GONE
        nicknameTextView.visibility = View.VISIBLE
        // to hide keyboard
        val inputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
    }
}
