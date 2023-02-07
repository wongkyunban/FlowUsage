package com.example.myapplication.model

import androidx.annotation.Keep

@Keep
data class CommentModel(
    val body: String,
    val email: String,
    val id: Int,
    val name: String,
    val postId: Int
)