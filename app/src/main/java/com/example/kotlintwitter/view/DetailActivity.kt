package com.example.kotlintwitter.view

import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.example.kotlintwitter.R
import com.example.kotlintwitter.model.User
import java.util.function.Predicate


class DetailActivity : AppCompatActivity() {
    var username: TextView? = null
    var login: TextView? = null
    var time: TextView? = null
    var date: TextView? = null
    var retweet1: TextView? = null
    var like: TextView? = null
    var group: TextView? = null
    var message: TextView? = null
    var image: ImageView? = null
    var avatar: ImageView? = null
    var likeButton: ImageView? = null
    var verify: ImageView? = null
    var goBack: ImageButton? = null
    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        val intent = intent
        val avatarIntent = intent.getIntExtra("avatar", 0)
        val usernameIntent = intent.getStringExtra("username")
        val loginIntent = intent.getStringExtra("login")
        val timeIntent = intent.getStringExtra("time")
        val imageIntent = intent.getIntExtra("image", 1)
        val dateIntent = intent.getStringExtra("date")
        Log.e("retweet", intent.getIntExtra("retweet", 0).toString())
        val retweetIntent = intent.getIntExtra("retweet", 0).toString()
        val likeIntent = intent.getIntExtra("like", 0).toString()
        val groupIntent = intent.getStringExtra("group")
        val index = intent.getIntExtra("index", 0)
        val verifyIntent = intent.getIntExtra("verify", 0)
        likeButton = findViewById(R.id.likeButton)
        if (MainActivity.list!![index].isFavourite) {
            likeButton?.tag = R.drawable.heart_icon
            likeButton?.setImageResource(R.drawable.heart_icon)
        } else {
            likeButton?.setTag(1)
        }
        val messageIntent = intent.getStringExtra("message")
        likeButton?.setOnClickListener(View.OnClickListener {
            if (likeButton?.tag as Int != R.drawable.heart_icon) {
                likeButton?.setImageResource(R.drawable.heart_icon)
                likeButton?.tag = R.drawable.heart_icon
                like!!.text = (like!!.text.toString().toInt() + 1).toString()
                MainActivity.list!![index].likes += 1
                MainActivity.list!![index].isFavourite = true
                MainActivity.favList!!.add(
                    User(
                        avatarIntent,
                        usernameIntent!!,
                        retweetIntent.toInt(),
                        verifyIntent,
                        loginIntent!!,
                        timeIntent!!,
                        messageIntent!!,
                        imageIntent,
                        10,
                        like!!.text.toString().toInt(),
                        dateIntent!!,
                        groupIntent!!,
                        true
                    )
                )
                Log.e("ARRAY", MainActivity.favList.toString())
            } else {
                likeButton?.setImageResource(R.drawable.icons8_love_24)
                likeButton?.tag = 1
                MainActivity.favList!!.removeIf(Predicate<User> { item ->
                    item.name == usernameIntent
                })
                like!!.text = (like!!.text.toString().toInt() - 1).toString()
                Log.e("ARRAY2", MainActivity.favList.toString())
                MainActivity.list!![index].likes -= 1
                MainActivity.list!![index].isFavourite = false
            }
        })
        username = findViewById(R.id.userName)
        username?.text = usernameIntent
        login = findViewById(R.id.userLogin)
        login?.text = loginIntent
        time = findViewById(R.id.time)
        time?.text = timeIntent
        goBack = findViewById(R.id.back)
        goBack?.setOnClickListener(View.OnClickListener { finish() })
        image = findViewById(R.id.userImage)
        avatar = findViewById(R.id.avatarList)
        avatar?.setImageResource(avatarIntent)
        if (imageIntent == 0) {
            image?.visibility = View.GONE
        } else {
            image?.visibility = View.VISIBLE
            image?.setImageResource(imageIntent)
        }
        date = findViewById(R.id.date)
        date!!.text = dateIntent
        retweet1 = findViewById(R.id.tweetsContain)
        Log.e("retweet1", retweet1.toString() + "")
        retweet1?.text = retweetIntent
        like = findViewById(R.id.likeContain)
        like?.text = likeIntent
        group = findViewById(R.id.group)
        group?.text = groupIntent
        verify = findViewById(R.id.verify)
        if (verifyIntent != 0) {
            verify?.setImageResource(verifyIntent)
        }
        message = findViewById(R.id.userMessageDetail)
        message?.text = messageIntent
    }
}



