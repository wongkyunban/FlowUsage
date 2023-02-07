package com.example.myapplication.repository

import com.example.myapplication.model.CommentModel
import com.example.myapplication.network.GetCommentService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class CommentRepository(private val apiService: GetCommentService) {

    suspend fun getCommentWithId(id: Int): Flow<CommentModel> {
        return flow {
            val data = apiService.getCommentWithId(id)
            emit(data)
        }.flowOn(Dispatchers.IO)
    }

}