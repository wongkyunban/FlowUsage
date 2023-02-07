package com.example.myapplication.network

import com.example.myapplication.model.CommentModel
import retrofit2.http.GET
import retrofit2.http.Path

interface GetCommentService {
    @GET("comments/{id}")
    suspend fun getCommentWithId(@Path("id") id: Int): CommentModel
}