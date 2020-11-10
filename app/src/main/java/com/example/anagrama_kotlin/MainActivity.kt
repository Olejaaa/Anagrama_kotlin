package com.example.anagrama_kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    lateinit var inputTextInput: EditText
    lateinit var inputTextIgnore: EditText
    lateinit var textViewOutput: TextView
    val calculationObject: Calculation = Calculation()

    private val inputTextWatcher = object : TextWatcher {
        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
        }

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
        }

        override fun afterTextChanged(s: Editable?) {
            val ignoreArray = inputTextIgnore.text.toString().toCharArray()
            val allWordsArray = inputTextInput.text.toString().split(" ")
            textViewOutput.text = calculationObject.calculationMethod(ignoreArray, allWordsArray)
        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        inputTextInput = findViewById(R.id.text_input)
        inputTextIgnore = findViewById(R.id.text_ignor)
        textViewOutput = findViewById(R.id.text_view_result)
        inputTextInput.addTextChangedListener(inputTextWatcher)
        inputTextIgnore.addTextChangedListener(inputTextWatcher)
    }

    override fun onStop(){
        super.onStop()
        delegate.onStop()

        inputTextInput.removeTextChangedListener(inputTextWatcher)
        inputTextIgnore.removeTextChangedListener(inputTextWatcher)
    }

}