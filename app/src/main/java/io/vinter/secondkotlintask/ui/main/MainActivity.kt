package io.vinter.secondkotlintask.ui.main

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import io.vinter.secondkotlintask.R
import io.vinter.secondkotlintask.entity.Technology
import io.vinter.secondkotlintask.ui.list.TechnologiesFragment
import io.vinter.secondkotlintask.ui.tech.TechHolderFragment

class MainActivity : AppCompatActivity() {

    lateinit var data: ArrayList<Technology>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        data = intent.getParcelableArrayListExtra<Technology>("data")

        val fragmentManager = supportFragmentManager
        if (fragmentManager.findFragmentByTag("list") == null){
            val techListFragment = TechnologiesFragment()
            val dataListBundle = Bundle()
            dataListBundle.putParcelableArrayList("data", data)
            techListFragment.arguments = dataListBundle

            val techFragment = TechHolderFragment()
            val dataBundle = Bundle()
            dataBundle.putParcelableArrayList("data", data)
            techFragment.arguments = dataBundle
            supportFragmentManager.beginTransaction()
                    .add(R.id.container, techFragment, "description")
                    .add(R.id.container, techListFragment, "list")
                    .commit()
            fragmentManager.popBackStackImmediate()
        }
    }

    fun showDescriptionFragment(startPosition: Int){
        (supportFragmentManager.findFragmentByTag("description") as TechHolderFragment).setElement(startPosition)
        supportFragmentManager.beginTransaction()
                .show(supportFragmentManager.findFragmentByTag("description")!!)
                .hide(supportFragmentManager.findFragmentByTag("list")!!)
                .commit()
    }

    fun showListFragment(){
        supportFragmentManager.beginTransaction()
                .show(supportFragmentManager.findFragmentByTag("list")!!)
                .hide(supportFragmentManager.findFragmentByTag("description")!!)
                .commit()
    }

}
