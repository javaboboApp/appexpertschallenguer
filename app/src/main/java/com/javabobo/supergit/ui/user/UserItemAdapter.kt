package com.javabobo.supergit.ui.user

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

import com.javabobo.supergit.R
import com.javabobo.supergit.models.GitUser
import kotlinx.android.synthetic.main.item_adapter_user.view.*

class UserItemAdapter(val listener: UserItemsListener) :
    RecyclerView.Adapter<UserItemAdapter.ItemViewHolder>() {
    var list: List<GitUser> = listOf()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_adapter_user, parent, false)
        return ItemViewHolder(
            view
        )
    }

    fun remove(position: Int) {
        listener.remove(list[position],position)
    }

    fun removeAt(position: Int){
        list.toMutableList().removeAt(position)
        notifyItemRemoved(position)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    interface UserItemsListener {
        fun remove(user: GitUser, position: Int)
        fun onClickItem(user: GitUser)

    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.bind(user = list[position], listener = listener)
    }

    class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(user: GitUser, listener: UserItemsListener) = with(itemView) {

            username_textview.text= user.name
            Glide.with(context).load(user.photo)
                .into(logo_imageview)

        }
    }

}