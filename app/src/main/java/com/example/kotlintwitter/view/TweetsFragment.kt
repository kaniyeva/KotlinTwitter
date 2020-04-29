package com.example.kotlintwitter.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.ViewPager
import com.example.kotlintwitter.FragmentInterface
import com.example.kotlintwitter.R
import com.example.kotlintwitter.util.RecyclerViewAdapter
import com.google.android.material.tabs.TabLayout


class TweetsFragment : Fragment(), FragmentInterface {
    var favouriteButton: ImageView? = null
    var viewPager: ViewPager? = null
    var tabLayout: TabLayout? = null
    var adapter: RecyclerViewAdapter? = null
    var state = 0
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? { // Inflate the layout for this fragment
        val view123 =
            inflater.inflate(R.layout.fragment_tweets, container, false)
        val rc: RecyclerView = view123.findViewById(R.id.listTxeets)
        val lc = LinearLayoutManager(activity)

        adapter = RecyclerViewAdapter(
            activity!!,
            MainActivity.list!!
        )
        /*val dividerItemDecoration = DividerItemDecoration(
            rc.context,
            lc.orientation
        )*/
        rc.addItemDecoration(
            DividerItemDecoration(
                rc.context,
                lc.orientation
            )
        )
        rc.adapter = adapter
        rc.layoutManager = lc
        rc.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrollStateChanged(
                recyclerView: RecyclerView,
                newState: Int
            ) {
                state = newState
                super.onScrollStateChanged(recyclerView, newState)
            }

            override fun onScrolled(
                recyclerView: RecyclerView,
                dx: Int,
                dy: Int
            ) {
                super.onScrolled(recyclerView, dx, dy)
            }
        })
        if (state != 0) {
            rc.verticalScrollbarPosition = state
        }
        return view123
    }

    override fun fragmentBecameVisible() {}
}

