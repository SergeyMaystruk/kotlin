package com.example.lab5

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.lab5.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button1.setOnClickListener { showText("Button 1 clicked") }

        binding.button2.setOnClickListener { showText("Button 2 clicked") }

        binding.editText1.setOnFocusChangeListener { v, hasFocus ->
            if (hasFocus) showText("EditText focuses")
            else showText("EditText unfocused")
        }

        binding.editText2.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                showText("Before text changed! | s: $s | start: $start | count: $count | after: $after")
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                showText("Before text changed! | s: $s | start: $start | count: $count | before: $before")
            }

            override fun afterTextChanged(s: Editable?) {
                binding.textView.text = s
            }
        })
    }

    private fun showText(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}