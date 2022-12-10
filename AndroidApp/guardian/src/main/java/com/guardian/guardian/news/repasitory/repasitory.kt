package com.guardian.guardian.news.repasitory

import com.example.common.net.ResultCallback
import com.guardian.guardian.news.data.ContentNewsDto
import com.guardian.guardian.news.api.NewsApi
import com.guardian.guardian.news.model.ShowFieldsEnum
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

interface NewsRepository {
    fun getContentNews(
        pageNumber: Int,
        showFieldsEnum: ShowFieldsEnum,
        resultCallback: ResultCallback<ContentNewsDto?>,
    )
}

class NewsRepositoryImpl(private val newsApi: NewsApi) : NewsRepository {
    override fun getContentNews(
        pageNumber: Int,
        showFieldsEnum: ShowFieldsEnum,
        resultCallback: ResultCallback<ContentNewsDto?>,
    ) {

        newsApi.getContentNews(pageNumber, showFieldsEnum.fields)
            .enqueue(object : Callback<ContentNewsDto> {

                override fun onResponse(
                    call: Call<ContentNewsDto>,
                    response: Response<ContentNewsDto>,
                ) {
                    if (response.isSuccessful) {
                        resultCallback.onSuccess(response.body())
                    } else {
                        resultCallback.onError(response.message())
                    }
                }

                override fun onFailure(call: Call<ContentNewsDto>, t: Throwable) {
                    resultCallback.onError(t.message ?: "unknown failure")
                }
            })
    }
}