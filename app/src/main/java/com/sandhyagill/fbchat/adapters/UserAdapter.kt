package com.sandhyagill.fbchat.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sandhyagill.fbchat.R
import com.sandhyagill.fbchat.databinding.UserItemBinding
import com.sandhyagill.fbchat.module.User

class UserAdapter(var userList: MutableList<User>) : RecyclerView.Adapter<UserAdapter.ViewHolder>() {
    class ViewHolder(var binding : UserItemBinding) : RecyclerView.ViewHolder(binding.root){}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(UserItemBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
       holder.apply {
           binding.apply{
                 userImg.setImageResource(userList.size)
                 tvUserName.text = userList.toString()
           }
       }
    }
}