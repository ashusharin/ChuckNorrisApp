package com.shusharin.chucknorrisapp.presentation

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.shusharin.chucknorrisapp.R
import com.shusharin.chucknorrisapp.core.Chuck

class ChuckAdapter : RecyclerView.Adapter<ChuckAdapter.JokeViewHolder>() {
    private var jokes = Chuck("куку", "куку", "куку", "куку")

    fun update(new: Chuck) {
//        jokes.clear()
//        jokes.addAll(new)
        jokes = new
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): JokeViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.chuck_layout, parent, false)
        return JokeViewHolder(view)
    }

    override fun onBindViewHolder(holder: JokeViewHolder, position: Int) {
        holder.bind(jokes)
    }

    override fun getItemCount() = 1


    inner class JokeViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bind(chuck: Chuck) {
            itemView.findViewById<TextView>(R.id.textView).text = chuck.value
        }
    }
}