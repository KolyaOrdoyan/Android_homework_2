package com.guardian.guardian.news.di

import com.example.common.net.createWebService
import com.guardian.guardian.news.BaseNewsViewModel
import com.guardian.guardian.news.GuardianConstants
import com.guardian.guardian.news.api.NewsApi
import com.guardian.guardian.news.repasitory.NewsRepository
import com.guardian.guardian.news.repasitory.NewsRepositoryImpl
import org.koin.dsl.module

fun newsModule() = module {

    scope<NewsApi> {
        scoped { createWebService<NewsApi>(GuardianConstants.BASE_URL) }
    }

    single<NewsRepository> { NewsRepositoryImpl(get()) }

    single { BaseNewsViewModel(get()) }
}