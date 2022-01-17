package com.example.sharedelementsample

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityOptionsCompat
import com.example.sharedelementsample.databinding.ActivityMainBinding
import androidx.core.util.Pair as UtilPair

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.image.setOnClickListener {
            openDetail()
        }
    }

    private fun openDetail() {
        val intent = Intent(this, DetailActivity::class.java)
        val options = ActivityOptionsCompat.makeSceneTransitionAnimation(
            this,
            UtilPair.create(binding.image, "image"),
            UtilPair.create(binding.bottomBackgroundView, "background")
        )
        startActivity(intent, options.toBundle())
    }
}