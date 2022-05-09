package com.example.prueba.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.prueba.databinding.ItemUserViewBinding
import com.example.prueba.models.User


class UserAdapter(private val onUserClicked: (User) -> Unit) : RecyclerView.Adapter<UserAdapter
        .ViewHolder>() {

    private var userList = listOf<User>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemUserViewBinding.inflate(LayoutInflater
            .from(parent.context), parent, false)

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val user = userList[position]
        holder.bind(user)
        holder.itemView.setOnClickListener { onUserClicked(user) }
    }

    override fun getItemCount() = userList.size

    fun setItems(userResponse: List<User>) {
        userList = userResponse
        notifyDataSetChanged()
    }

    class ViewHolder(private val binding: ItemUserViewBinding) : RecyclerView
        .ViewHolder(binding.root){

        fun bind(user: User){
            binding.name.text = user.name
            binding.phone.text = user.phone
            binding.email.text = user.email
        }
    }
}