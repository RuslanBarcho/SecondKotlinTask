package io.vinter.secondkotlintask.ui.tech

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners

import io.vinter.secondkotlintask.R
import io.vinter.secondkotlintask.entity.Technology
import io.vinter.secondkotlintask.utils.GlideApp
import kotlinx.android.synthetic.main.fragment_tech.*

class TechFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_tech, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val data = arguments!!.getParcelable<Technology>("technology")!!
        val image = tech_pic
        val descr = tech_description
        GlideApp.with(context!!)
                .load("https://raw.githubusercontent.com/wesleywerner/ancient-tech/02decf875616dd9692b31658d92e64a20d99f816/src/images/tech/" + data.graphic)
                .placeholder(R.drawable.no_image)
                .override(300, 300)
                .transforms(CenterCrop(), RoundedCorners(30))
                .error(R.drawable.no_image)
                .into(image)
        if (data.helptext != null) descr.text = data.helptext
    }

}
