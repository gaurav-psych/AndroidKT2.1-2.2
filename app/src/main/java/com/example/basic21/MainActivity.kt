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
import androidx.databinding.DataBindingUtil
import com.example.basic21.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val myName: MyName = MyName("Aleks Haecky")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
//        setContentView(R.layout.activity_main)

        binding.myName  = myName
        // button click
       binding.buttonName.setOnClickListener {
            addNickname(it)
        }

        // below is to show button on change of text
       binding.editText.addTextChangedListener(object : TextWatcher {
             override fun afterTextChanged(p0: Editable?) {
            }

            override  fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                findViewById<Button>(R.id.button_name).visibility = View.VISIBLE
            }
        })

        //text top name click
       binding.nameText.setOnClickListener {
            val editText = binding.editText
            val nicknameTextView =  binding.nameText
            editText.visibility = View.VISIBLE
            nicknameTextView.visibility = View.VISIBLE
            // Set the focus to the edit text.
            editText.requestFocus()
            // Show the keyboard.
            val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.showSoftInput(editText, 0)

           binding.invalidateAll()

        }


    }



    private fun addNickname(view: View) {
        val editText = binding.editText
        val nicknameTextView =  binding.nameText
        nicknameTextView.text = editText.text.toString()
        editText.visibility=View.GONE
        binding.buttonName.visibility = View.GONE
        nicknameTextView.visibility = View.VISIBLE
        // to hide keyboard
        val inputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
    }
}
