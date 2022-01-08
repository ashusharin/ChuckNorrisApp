package com.shusharin.chucknorrisapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.RecyclerView
import com.shusharin.chucknorrisapp.core.ChuckApp
import com.shusharin.chucknorrisapp.presentation.ChuckAdapter

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val viewModel = (application as ChuckApp).mainViewModel
        val adapter = ChuckAdapter()
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.adapter = adapter
        viewModel.observe(this, Observer {
            adapter.update(it)
        })
        viewModel.fetchJoke()
    }
    // TODO: 09.01.2022  observe fail
}