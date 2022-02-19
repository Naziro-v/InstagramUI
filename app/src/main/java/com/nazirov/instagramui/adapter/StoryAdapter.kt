package com.nazirov.instagramui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.nazirov.instagramui.R
import com.nazirov.instagramui.model.Story

class StoryAdapter(var context: Context, var items: ArrayList<Story>):RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        var view= LayoutInflater.from(parent.context).inflate(R.layout.item_story_view,parent,false)
        return StoryViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
       val story = items[position]

        if (holder is StoryViewHolder){
            var ivProfile = holder.ivProfile
            var tvFullname = holder.tvFullname

            ivProfile.setImageResource(story.profile)
            tvFullname.text = story.fullname
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }
    class StoryViewHolder(view: View):RecyclerView.ViewHolder(view){
        var ivProfile: ImageView
        var tvFullname: TextView

        init {
            ivProfile = view.findViewById(R.id.iv_profile)
            tvFullname = view.findViewById(R.id.tv_fullname)
        }
    }
}