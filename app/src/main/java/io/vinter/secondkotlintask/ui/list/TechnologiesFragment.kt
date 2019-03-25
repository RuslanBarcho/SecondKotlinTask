package io.vinter.secondkotlintask.ui.list

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import io.vinter.secondkotlintask.R
import io.vinter.secondkotlintask.entity.Technology
import io.vinter.secondkotlintask.ui.main.MainActivity
import io.vinter.secondkotlintask.utils.RecyclerAdapter
import kotlinx.android.synthetic.main.fragment_technologies.*



class TechnologiesFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_technologies, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter = RecyclerAdapter(arguments!!.getParcelableArrayList<Technology>("data")!!, context!!) {
            if (activity is MainActivity) (activity as MainActivity).showDescriptionFragment(it)
        }
        val recycler = technologies_recycler
        recycler.layoutManager = LinearLayoutManager(context)
        recycler.adapter = adapter
    }

}
