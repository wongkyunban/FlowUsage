package com.example.myapplication.presentation

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.example.myapplication.R
import com.example.myapplication.viewmodel.CommentViewModel
import kotlinx.coroutines.flow.collect

class MainActivity : AppCompatActivity() {


    // create a CommentsViewModel
    // variable to initialize it later
    private lateinit var commentViewModel: CommentViewModel
    private var currentId = 1;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button = findViewById<Button>(R.id.button)
        val textView = findViewById<TextView>(R.id.textView)
        button.setOnClickListener {
            currentId += 1
            commentViewModel.getACommentWithId(currentId)
        }
        commentViewModel = ViewModelProvider(this).get(CommentViewModel::class.java)

        lifecycleScope.launchWhenStarted {
            commentViewModel.commentStateFlow.collect {
                it?.let { comment ->
                    textView.text = "${comment.id} \n\n ${comment.email} \n\n ${comment.body}"
                }
            }
        }
    }

}