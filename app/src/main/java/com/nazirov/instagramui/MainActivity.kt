package com.nazirov.instagramui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.nazirov.instagramui.adapter.FeedAdapter
import com.nazirov.instagramui.model.Feed
import com.nazirov.instagramui.model.Post
import com.nazirov.instagramui.model.Story

class MainActivity : AppCompatActivity() {

    lateinit var recyclerView: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViews()
    }

    private fun initViews() {
        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = GridLayoutManager(this, 1)

        refreshAdapter(gettAllFeeds())
    }

    private fun refreshAdapter(feeds: ArrayList<Feed>) {
        val adapter = FeedAdapter(this, feeds)
        recyclerView!!.adapter = adapter

    }

    fun gettAllFeeds(): ArrayList<Feed> {
        val stories: ArrayList<Story> = ArrayList()

        stories.add(Story(R.drawable.mine, "Nazirov"))
        stories.add(Story(R.drawable.ogabekdev, "Og`abek"))
        stories.add(Story(R.drawable.shakhriyor, "Shakhriyor"))
        stories.add(Story(R.drawable.mine5, "Nazirov"))
        stories.add(Story(R.drawable.mine, "Nazirov"))
        stories.add(Story(R.drawable.ogabekdev, "Og`abek"))
        stories.add(Story(R.drawable.shakhriyor, "Shakhriyor"))
        stories.add(Story(R.drawable.mine5, "Nazirov"))

        val feeds:ArrayList<Feed> = ArrayList()
        feeds.add(Feed(stories))
        feeds.add(Feed(Post(R.drawable.mine,"Nazirov",R.drawable.mosque)))
        feeds.add(Feed(Post(R.drawable.mine5,"Nazirov",R.drawable.forinsta)))
        feeds.add(Feed(Post(R.drawable.ogabekdev,"Og`abek",R.drawable.forinsta5)))
        feeds.add(Feed(Post(R.drawable.shakhriyor,"Nazirov",R.drawable.mosque)))
        feeds.add(Feed(Post(R.drawable.mine,"Nazirov",R.drawable.forinsta7)))
        feeds.add(Feed(Post(R.drawable.mine,"Nazirov",R.drawable.forinsta7)))

        return feeds

    }
}