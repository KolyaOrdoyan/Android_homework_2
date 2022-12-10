package com.example.androidhomework.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.androidhomework.databinding.ActivityDashBoardBinding
import com.example.androidhomework.navigationexample.NavigationExampleActivity
import com.example.androidhomework.ui.contentnews.GuardianActivity
import com.guardian.guardian.news.di.newsModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import org.koin.core.module.Module

class DashBoardActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDashBoardBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDashBoardBinding.inflate(layoutInflater)
        setContentView(binding.root)

        startKoin {
            androidContext(this@DashBoardActivity)
            modules(getKoinModules())
        }

        binding.dashBoardProjectOneButton.setOnClickListener {
            startActivity(Intent(this, GuardianActivity::class.java))
        }
        binding.dashBoardProjectTwoButton.setOnClickListener {
            startActivity(Intent(this, NavigationExampleActivity::class.java))
        }
    }

    private fun getKoinModules(): List<Module> {
        return listOf(newsModule())
    }

}