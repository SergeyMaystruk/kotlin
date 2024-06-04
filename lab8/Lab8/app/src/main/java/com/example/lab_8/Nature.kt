package com.example.lab_8

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.lab_8.databinding.NatureDetailsBinding

class NatureDetailsActivity : AppCompatActivity() {
    private lateinit var binding: NatureDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = NatureDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btn.text = intent.getStringExtra("nature")
    }
}
