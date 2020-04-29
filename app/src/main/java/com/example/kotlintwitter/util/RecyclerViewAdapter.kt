package com.example.kotlintwitter.util

import android.content.Context
import android.content.Intent
import android.os.Build
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlintwitter.R
import com.example.kotlintwitter.model.User
import com.example.kotlintwitter.view.DetailActivity
import com.example.kotlintwitter.view.MainActivity
import java.util.function.Predicate


class RecyclerViewAdapter(
    context: Context,
    data: List<User>
) :
    RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {
    private val mData: List<User> = data
    private val mInflater: LayoutInflater = LayoutInflater.from(context)
    private var mClickListener: ItemClickListener? = null
    private val mContext: Context = context
    // inflates the row layout from xml when needed
    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val view = mInflater.inflate(R.layout.recyclerview_item, parent, false)
        return ViewHolder(view)
    }

    // binds the data to the TextView in each row
    override fun onBindViewHolder(
        holder: ViewHolder,
        position: Int
    ) { //String animal = mData.get(position);
//holder.myTextView.setText(animal);
        holder.avatarList!!.setImageResource(mData[position].avatarList)
        holder.username!!.text = mData[position].name
        if (mData[position].isFavourite) {
            holder.likeIcon!!.tag =
                R.drawable.heart_icon
            holder.likeIcon!!.setImageResource(R.drawable.heart_icon)
        } else {
            holder.likeIcon!!.tag = 1
        }
        holder.userlogin!!.text = mData[position].login
        holder.time!!.text = mData[position].lastActive
        holder.message!!.text = mData[position].message
        holder.commentContain!!.text = mData[position].comments.toString() + ""
        holder.retweet!!.text = mData[position].retweet.toString() + ""
        holder.likeContain!!.text = mData[position].likes.toString() + ""
        if (mData[position].image !== 0) {
            holder.userImage!!.visibility = View.VISIBLE
            //holder.userImage.setImageResource(mData.get(position).image);
            holder.userImage!!.setBackgroundResource(mData[position].image)
        } else {
            holder.userImage!!.visibility = View.GONE
        }
        if (mData[position].verify !== 0) {
            holder.verify!!.visibility = View.VISIBLE
            holder.verify!!.setImageResource(mData[position].verify)
        } else {
            holder.verify!!.visibility = View.GONE
        }
    }

    // total number of rows
    override fun getItemCount(): Int {
        return mData.size
    }

    // stores and recycles views as they are scrolled off screen
    @RequiresApi(Build.VERSION_CODES.N)
    inner class ViewHolder internal constructor(itemView: View) :
        RecyclerView.ViewHolder(itemView), View.OnClickListener {
        var username: TextView?
        var userlogin: TextView?
        var time: TextView?
        var message: TextView?
        var commentContain: TextView?
        var retweet: TextView?
        var likeContain: TextView?
        var date: TextView?
        var group: TextView?
        var avatarList: ImageView?
        var userImage: ImageView?
        var likeIcon: ImageView?
        var verify: ImageView?
        override fun onClick(view: View) {
            Log.e("YA", "TOJE ZDES")
            if (mClickListener != null) {
                mClickListener!!.onItemClick(view, adapterPosition)
            }
        }

        init {
            //myTextView = itemView.findViewById(R.id.tvAnimalName);
            likeIcon = itemView.findViewById(R.id.likeIcon)
            avatarList = itemView.findViewById(R.id.avatarList)
            username = itemView.findViewById(R.id.userName)
            verify = itemView.findViewById(R.id.verify)
            userlogin = itemView.findViewById(R.id.userLogin)
            time = itemView.findViewById(R.id.time)
            message = itemView.findViewById(R.id.userMessage)
            commentContain = itemView.findViewById(R.id.commentContain)
            retweet = itemView.findViewById(R.id.retweet)
            likeContain = itemView.findViewById(R.id.likeContain)
            userImage = itemView.findViewById(R.id.userImage)
            date = itemView.findViewById(R.id.date)
            group = itemView.findViewById(R.id.group)
            likeIcon!!.setOnClickListener {
                if (likeIcon!!.tag == null || likeIcon!!.tag as Int !== R.drawable.heart_icon) {
                    likeIcon!!.setImageResource(R.drawable.heart_icon)
                    likeIcon!!.tag =
                        R.drawable.heart_icon
                    likeContain!!.text = (likeContain!!.text.toString().toInt() + 1).toString()
                    MainActivity.list!![adapterPosition].isFavourite = true
                    MainActivity.favList!!.add(
                        User(
                            mData[adapterPosition].avatarList,
                            mData[adapterPosition].name,
                            mData[adapterPosition].retweet.toString().toInt(),
                            mData[adapterPosition].verify,
                            mData[adapterPosition].login,
                            mData[adapterPosition].lastActive,
                            mData[adapterPosition].message,
                            mData[adapterPosition].image,
                            10,
                            likeContain!!.text.toString().toInt(),
                            mData[adapterPosition].date,
                            mData[adapterPosition].group,
                            true
                        )
                    )
                } else {
                    likeIcon!!.setImageResource(R.drawable.icons8_love_24)
                    likeIcon!!.tag = 1
                    MainActivity.favList!!.removeIf(Predicate<User?> { item ->
                        item!!.name == mData[adapterPosition].name
                    })
                    likeContain!!.text = (likeContain!!.text.toString().toInt() - 1).toString()
                    MainActivity.list!![adapterPosition].isFavourite = false
                }
            }
            itemView.setOnClickListener {
                Log.e("YA", adapterPosition.toString() + "")
                val intent = Intent(mContext, DetailActivity::class.java)
                intent.putExtra("username", mData[adapterPosition].name)
                intent.putExtra("login", mData[adapterPosition].login)
                intent.putExtra("message", mData[adapterPosition].message)
                intent.putExtra("image", mData[adapterPosition].image)
                intent.putExtra("avatar", mData[adapterPosition].avatarList)
                intent.putExtra("time", mData[adapterPosition].lastActive)
                intent.putExtra("like", mData[adapterPosition].likes)
                intent.putExtra("retweet", mData[adapterPosition].retweet)
                intent.putExtra("date", mData[adapterPosition].date)
                intent.putExtra("group", mData[adapterPosition].group)
                intent.putExtra("index", adapterPosition)
                intent.putExtra("verify", mData[adapterPosition].verify)
                mContext.startActivity(intent)
            }
        }
    }

    // allows clicks events to be caught
    fun setClickListener(itemClickListener: ItemClickListener?) {
        mClickListener = itemClickListener
    }

    // parent activity will implement this method to respond to click events
    interface ItemClickListener {
        fun onItemClick(view: View?, position: Int)
    }

}
