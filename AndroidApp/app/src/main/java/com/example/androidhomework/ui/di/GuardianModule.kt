package com.example.androidhomework.ui.di

import com.example.androidhomework.ui.contentnews.ContentNewsFragment
import com.example.androidhomework.ui.contentnews.ContentNewsViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module

val guardianModule = module {

//    scope(named<NewsActivity>()) {
//        viewModel { BaseNewsViewModel(get()) }
//    }

    scope(named<ContentNewsFragment>()) {
        viewModel { ContentNewsViewModel(get()) }
    }
}