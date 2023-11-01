package com.example.final_news_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso

class NewsDetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news_details)

        val img=findViewById<ImageView>(R.id.newsImage)
        val newsTitle=findViewById<TextView>(R.id.newsHeading)
        val content=findViewById<TextView>(R.id.newsContent)

        val image=intent.getStringExtra("image")
        val title=intent.getStringExtra("title")
        val newsContent=intent.getStringExtra("content")

        newsTitle.text=title
        content.text=newsContent
        Picasso.get().load(image).into(img)
    }
}