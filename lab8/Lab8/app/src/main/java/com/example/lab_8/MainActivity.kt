package com.example.lab_8

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.lab_8.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)

        binding.recyclerViewVert.layoutManager = LinearLayoutManager(this)
        val nature = listOf(
            Pair("Mountain", "https://images.unsplash.com/photo-1454496522488-7a8e488e8606"),
            Pair("River", "https://plus.unsplash.com/premium_photo-1671363188581-d33b349e82ce"),
            Pair("Valley", "https://images.unsplash.com/photo-1590664216212-62e763768cae"),
            Pair("Field", "https://images.unsplash.com/photo-1422466654108-5e533f591881"),
        )

        val adapter = NatureAdapter(nature){ position: Int ->
            val intent = Intent(this, NatureDetailsActivity::class.java)
            intent.putExtra("nature", nature[position].first)
            startActivity(intent)
        }

        binding.recyclerViewVert.adapter = adapter
        binding.recyclerViewHor.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        val natureNames = listOf(
            "Mountain",
            "River",
            "Valley",
            "Field",
        )
        val adapterSecond = HorizontalViewAdapter(natureNames)
        binding.recyclerViewHor.adapter = adapterSecond
    }
}