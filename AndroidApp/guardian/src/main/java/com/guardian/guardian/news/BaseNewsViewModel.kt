package com.guardian.guardian.news

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.common.net.ResultCallback
import com.guardian.guardian.news.data.ContentNewsDto
import com.guardian.guardian.news.data.NewsResultDto
import com.guardian.guardian.news.model.ShowFieldsEnum
import com.guardian.guardian.news.repasitory.NewsRepository


open class BaseNewsViewModel(private val repository: NewsRepository) : ViewModel() {

    private val _resultsLiveData: MutableLiveData<List<NewsResultDto>> = MutableLiveData()
    val resultsLiveData: LiveData<List<NewsResultDto>>
        get() = _resultsLiveData

    fun getContentNews(
        pageNumber: Int = 20,
        showFieldsEnum: ShowFieldsEnum = ShowFieldsEnum.THUMBNAIL
    ) {
        repository.getContentNews(pageNumber, showFieldsEnum,
            object : ResultCallback<ContentNewsDto?> {
                override fun onSuccess(data: ContentNewsDto?) {
                    _resultsLiveData.value = data?.response?.results
                }
            })
    }
}
