package io.vinter.secondkotlintask.utils

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import io.vinter.secondkotlintask.entity.Technology
import io.vinter.secondkotlintask.ui.tech.TechFragment
import java.util.ArrayList

class TechViewPagerAdapter(fm: FragmentManager, private val teches: ArrayList<Technology>): FragmentStatePagerAdapter(fm){
    override fun getItem(position: Int): Fragment {
        val fragment = TechFragment()
        val dataBundle = Bundle()
        dataBundle.putParcelable("technology", teches[position])
        fragment.arguments = dataBundle
        return fragment
    }

    override fun getCount(): Int {
        return teches.size
    }

}