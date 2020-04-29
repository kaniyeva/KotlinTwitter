package com.example.kotlintwitter.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlintwitter.R
import com.example.kotlintwitter.util.RecyclerViewAdapter


class FavouriteActivity : AppCompatActivity() {
    private var adapter: RecyclerViewAdapter? = null
    private var rc: RecyclerView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_favourite)
        rc = findViewById(R.id.favouriteList)
        val lc = LinearLayoutManager(this)
        rc!!.layoutManager = lc
        val dividerItemDecoration = DividerItemDecoration(
            rc!!.context,
            lc.orientation
        )
        rc!!.addItemDecoration(dividerItemDecoration)
    }

    override fun onResume() {
        super.onResume()
        adapter = MainActivity.favList?.let {
            RecyclerViewAdapter(
                this,
                it
            )
        }
        rc!!.adapter = adapter
    }
}
