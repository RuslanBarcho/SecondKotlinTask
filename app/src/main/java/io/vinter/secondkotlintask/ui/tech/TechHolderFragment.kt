package io.vinter.secondkotlintask.ui.tech

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.view.ViewPager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import io.vinter.secondkotlintask.R
import io.vinter.secondkotlintask.entity.Technology
import io.vinter.secondkotlintask.ui.main.MainActivity
import io.vinter.secondkotlintask.utils.TechViewPagerAdapter
import kotlinx.android.synthetic.main.fragment_tech_holder.*

class TechHolderFragment : Fragment() {

    private lateinit var viewPager: ViewPager

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_tech_holder, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewPager = tech_holder

        val data = arguments!!.getParcelableArrayList<Technology>("data")!!
        val adapter = TechViewPagerAdapter(childFragmentManager, data)
        viewPager.offscreenPageLimit = 3
        viewPager.adapter = adapter

        descr_back.setOnClickListener{
            if (activity is MainActivity) (activity as MainActivity).showListFragment()
        }
    }

    fun setElement(index: Int) {
        viewPager.currentItem = index
    }

}
