package com.priyam.coolnews.presentation.viewmodelFactory

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.priyam.coolnews.domain.usecase.GetHeadlinesUseCase
import com.priyam.coolnews.presentation.viewmodel.NewsViewModel

class NewsViewModelFactory(
    private val app: Application,
    private val getNewsHeadlinesUseCase: GetHeadlinesUseCase
) : ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return NewsViewModel(
            app,
            getNewsHeadlinesUseCase
        ) as T
    }
}