package com.example.prueba.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.prueba.databinding.ItemPostViewBinding
import com.example.prueba.models.Post
import com.example.prueba.models.PostsResponse

class PostAdapter(private val onPostClicked: (Post) -> Unit) : RecyclerView.Adapter<PostAdapter
    .ViewHolder>() {

    private var postList = listOf<Post>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemPostViewBinding.inflate(LayoutInflater
            .from(parent.context), parent, false)

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val post = postList[position]
        holder.bind(post)
        holder.itemView.setOnClickListener { onPostClicked(post) }
    }

    override fun getItemCount() = postList.size

    fun setItems(postResponse: PostsResponse) {
        postList = postResponse
        notifyDataSetChanged()
    }

    class ViewHolder(private val binding: ItemPostViewBinding) : RecyclerView
        .ViewHolder(binding.root){

        fun bind(post: Post){
            binding.textPost.text = post.body
        }
    }
}