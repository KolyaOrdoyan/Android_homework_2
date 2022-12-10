package com.example.androidhomework.navigationexample

import androidx.appcompat.app.AppCompatActivity
import com.example.androidhomework.databinding.ActivityNavigationExampleBinding
import android.os.Bundle

class NavigationExampleActivity : AppCompatActivity() {

    private lateinit var binding: ActivityNavigationExampleBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNavigationExampleBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }
}