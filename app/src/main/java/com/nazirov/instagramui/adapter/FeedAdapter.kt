package com.nazirov.instagramui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.nazirov.instagramui.R
import com.nazirov.instagramui.model.Feed
import com.nazirov.instagramui.model.Story

class FeedAdapter(var context: Context, var items: ArrayList<Feed>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    companion object {
        private val TYPE_ITEM_STORY = 0
        private val TYPE_ITEM_POST = 1
    }

    override fun getItemViewType(position: Int): Int {
        return if (items[position].stories.size > 0) TYPE_ITEM_STORY else TYPE_ITEM_POST
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        if (viewType == TYPE_ITEM_STORY) {
            val view =
                LayoutInflater.from(parent.context).inflate(R.layout.item_feed_story, parent, false)
            return StoryViewHolder(view)
        }
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_feed_post, parent, false)
        return PostViewHolder(view)

    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val feed = items[position]

        if (holder is StoryViewHolder) {
            var recyclerView = holder.recyclerView
            refreshFeedAdapter(feed.stories, recyclerView)
        }
        if (holder is PostViewHolder) {
            var ivProfile = holder.ivProfile
            var ivPhoto = holder.ivPhoto
            var tvFullname = holder.tvFullname

            ivPhoto.setImageResource(feed.post!!.photo)
            ivProfile.setImageResource(feed.post!!.profile)
            tvFullname.text = feed.post!!.fullname
        }

    }

    private fun refreshFeedAdapter(stories: ArrayList<Story>, recyclerView: RecyclerView) {
        val adapter = StoryAdapter(context, stories)
        recyclerView.adapter = adapter
    }

    override fun getItemCount(): Int {
        return items.size
    }

    class StoryViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var recyclerView: RecyclerView

        init {
            recyclerView = view.findViewById(R.id.recyclerView)
            recyclerView.layoutManager =
                LinearLayoutManager(view.context, LinearLayoutManager.HORIZONTAL, false)
        }

    }

    class PostViewHolder(var view: View) : RecyclerView.ViewHolder(view) {
        var ivProfile: ImageView
        var ivPhoto: ImageView
        var tvFullname: TextView

        init {
            ivProfile = view.findViewById(R.id.iv_profile)
            ivPhoto = view.findViewById(R.id.iv_photo)
            tvFullname = view.findViewById(R.id.tv_fullname)

        }

    }
}