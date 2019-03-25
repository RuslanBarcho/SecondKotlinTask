package io.vinter.secondkotlintask.utils

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import io.vinter.secondkotlintask.R
import io.vinter.secondkotlintask.entity.Technology
import kotlinx.android.synthetic.main.item_technology.view.*
import java.util.*

class RecyclerAdapter(private var items : ArrayList<Technology>, private val context: Context, val listener: (Int) -> Unit) :
        RecyclerView.Adapter<RecyclerAdapter.TechnologyViewHolder>() {

    override fun onBindViewHolder(holder: TechnologyViewHolder, index: Int) {
        holder.name.text = items[index].name
        GlideApp.with(context)
                .load("https://raw.githubusercontent.com/wesleywerner/ancient-tech/02decf875616dd9692b31658d92e64a20d99f816/src/images/tech/" + items[index].graphic)
                .placeholder(R.drawable.no_image)
                .override(300, 300)
                .transforms(CenterCrop(), RoundedCorners(30))
                .error(R.drawable.no_image)
                .into(holder.pic)
        holder.itemView.setOnClickListener {listener(index)}
    }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): TechnologyViewHolder {
        return TechnologyViewHolder(LayoutInflater.from(context).inflate(R.layout.item_technology, p0, false))
    }

    override fun getItemCount(): Int {
        return items.size
    }

    class TechnologyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val pic = itemView.item_pic!!
        val name = itemView.item_text!!
    }

}