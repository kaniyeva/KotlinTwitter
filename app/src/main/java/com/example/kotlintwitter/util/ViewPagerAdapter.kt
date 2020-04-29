package com.example.kotlintwitter.util

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.kotlintwitter.view.FavouriteFragment
import com.example.kotlintwitter.view.TweetsFragment


class ViewPagerAdapter(manager: FragmentManager) :
    FragmentPagerAdapter(manager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {
    private val tabTitles =
        arrayOf("Tweets", "Favourite")

    override fun getItem(position: Int): Fragment {
        when (position) {
            0 -> return TweetsFragment()
            1 -> return FavouriteFragment()
        }
        return TweetsFragment()
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return tabTitles[position]
    }

    override fun getCount(): Int {
        return tabTitles.size
    }
}
