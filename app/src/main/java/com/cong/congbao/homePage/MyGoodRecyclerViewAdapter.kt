package com.cong.congbao.homePage

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.cong.congbao.R


import com.cong.congbao.homePage.dummy.DummyContent.GoodItem

import kotlinx.android.synthetic.main.fragment_good.view.*

/**
 * [RecyclerView.Adapter] that can display a [GoodItem] and makes a call to the
 * specified [OnListFragmentInteractionListener].
 * TODO: Replace the implementation with code for your data type.
 */
class MyGoodRecyclerViewAdapter(private val mValues: List<GoodItem>)
    : RecyclerView.Adapter<MyGoodRecyclerViewAdapter.ViewHolder>() {

    private val mOnClickListener: View.OnClickListener

    init {
        mOnClickListener = View.OnClickListener { v ->
            val item = v.tag as GoodItem
            // Notify the active callbacks interface (the activity, if the fragment is attached to
            // one) that an item has been selected.
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.fragment_good, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = mValues[position]
        holder.mName.text = item.name
        holder.mPrice.text = item.price
//        holder.mImg = TODO 加载图片
        holder.mType.visibility = when {
            item.isNew -> View.VISIBLE
            else -> View.GONE
        }


        with(holder.mView) {
            tag = item
            setOnClickListener(mOnClickListener)
        }
    }

    override fun getItemCount(): Int = mValues.size

    inner class ViewHolder(val mView: View) : RecyclerView.ViewHolder(mView) {
        val mName: TextView = mView.good_name
        val mPrice: TextView = mView.good_price
        val mImg: ImageView = mView.good_img
        val mType: ImageView = mView.good_type


    }
}
