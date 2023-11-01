package com.example.final_news_app

import android.app.Activity
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.imageview.ShapeableImageView
import com.squareup.picasso.Picasso

class MyAdapter(val context: Activity, val articleArrayList: List<Article>):
RecyclerView.Adapter<MyAdapter.MyViewHolder>(){

    private lateinit var myListener: onItemClickListener

    interface onItemClickListener{
        fun onItemClick(position:Int)
    }

    fun setItemClickListener(listener: onItemClickListener){
        myListener=listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyAdapter.MyViewHolder {
        val itemView=LayoutInflater.from(context).inflate(R.layout.eachitem,parent,false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyAdapter.MyViewHolder, position: Int) {
        val currentItem=articleArrayList[position]
        holder.title.text=currentItem.title
        // load image in form of url
        Picasso.get().load(currentItem.urlToImage).into(holder.image)
        holder.itemView.setOnClickListener {
            val intent = Intent(context,NewsDetailsActivity::class.java)

            intent.putExtra("title",currentItem.title)
            intent.putExtra("image",currentItem.urlToImage)
            intent.putExtra("content",currentItem.content)
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return articleArrayList.size
    }
    class MyViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {

        var title:TextView
        var image:ShapeableImageView
        init{
            title=itemView.findViewById(R.id.newsHeading)
            image=itemView.findViewById(R.id.newsImage)
        }

    }
}