package com.example.kotlincoroutines.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlincoroutines.R
import com.example.kotlincoroutines.model.Article
import kotlinx.android.synthetic.main.news_list_item.view.*

class NewsAdapter : RecyclerView.Adapter<NewsAdapter.ViewHolder>() {

    private var responseList = emptyList<Article>()

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
       val view = LayoutInflater.from(parent.context).inflate(R.layout.news_list_item,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val currentItem  = responseList[position]
        Log.e("TAG", "onBindViewHolder:========= ${responseList[position]}" )

        holder.itemView.tvTitle.text = currentItem.author
        holder.itemView.tvDescription.text =  currentItem.description

    }

    override fun getItemCount(): Int {
        return responseList.size
    }

    fun setData(response1: List<Article>){
        this.responseList = response1
        notifyDataSetChanged()
    }
}