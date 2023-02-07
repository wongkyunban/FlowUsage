package com.example.myapplication.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.model.CommentModel
import com.example.myapplication.network.GetCommentService
import com.example.myapplication.repository.CommentRepository
import com.google.gson.GsonBuilder
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class CommentViewModel : ViewModel() {

    private val BASE_URL = "https://jsonplaceholder.typicode.com/"


    private val apiService = Retrofit.Builder().baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
        .build()
        .create(GetCommentService::class.java)

    private val repository = CommentRepository(apiService)

    private val commentMutableStateFlow = MutableStateFlow<CommentModel?>(null)
    val commentStateFlow: StateFlow<CommentModel?> = commentMutableStateFlow

    init {

        getACommentWithId(1)
    }


    fun getACommentWithId(id: Int) {
       val job = viewModelScope.launch {
           repository.getCommentWithId(id).catch {
               commentMutableStateFlow.value = null
           }.collect {
               commentMutableStateFlow.value = it
           }
       }
    }
}