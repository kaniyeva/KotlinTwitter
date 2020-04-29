package com.example.kotlintwitter.view

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlintwitter.FragmentInterface
import com.example.kotlintwitter.R
import com.example.kotlintwitter.util.RecyclerViewAdapter


class FavouriteFragment : Fragment(),
    FragmentInterface {
    private var adapter: RecyclerViewAdapter? = null
    private var rc: RecyclerView? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? { // Inflate the layout for this fragment
        val view =
            inflater.inflate(R.layout.fragment_favourite, container, false)
        rc = view.findViewById(R.id.listFavour)
        val lc = LinearLayoutManager(activity)
        rc!!.layoutManager = lc
        val dividerItemDecoration = DividerItemDecoration(
            rc!!.context,
            lc.orientation
        )
        rc!!.addItemDecoration(dividerItemDecoration)
        Log.e("ONCREATE", "ONCREATE")
        return view
    }

    override fun onResume() {
        super.onResume()
        Log.e("ONRESUME", "ONRESUME")
        adapter = activity?.let { MainActivity.favList?.let { it1 ->
            RecyclerViewAdapter(
                it,
                it1
            )
        } }
        rc!!.adapter = adapter
    }

    override fun fragmentBecameVisible() {
        Log.e("ONRESUME", "ONRESUME")
        adapter = activity?.let { MainActivity.favList?.let { it1 ->
            RecyclerViewAdapter(
                it,
                it1
            )
        } }
        rc!!.adapter = adapter
    }
}
