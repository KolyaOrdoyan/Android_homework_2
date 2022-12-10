package com.example.androidhomework.ui.contentnews

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.androidhomework.R
import com.example.androidhomework.databinding.ActivityGuardianBinding
import com.example.common.BaseCommonActivity

class GuardianActivity : AppCompatActivity() {

    private lateinit var binding: ActivityGuardianBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGuardianBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportFragmentManager
            .beginTransaction()
            .replace(R.id.guardian_frame_layout, ContentNewsFragment.newInstance()).commit()

    }
}