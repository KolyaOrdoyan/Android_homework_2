package com.example.common.net


import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

inline fun <reified T> createWebService(baseUrl: String): T {
    val retrofit = Retrofit.Builder()
        .baseUrl(baseUrl)
//        .client(createOkHttpClient())
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    return retrofit.create(T::class.java)
}

//fun createOkHttpClient(): OkHttpClient = OkHttpClient.Builder()
//    .connectTimeout(60L, TimeUnit.SECONDS)
//    .addInterceptor(HttpLoggingInterceptor())
//    .readTimeout(60L, TimeUnit.SECONDS)
//    .build()

interface ResultCallback<T> {

    fun onSuccess(data: T)

    fun onError(msg: String) {}
}