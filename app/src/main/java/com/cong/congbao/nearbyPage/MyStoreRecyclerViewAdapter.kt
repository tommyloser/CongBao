package com.cong.congbao.nearbyPage

import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import com.cong.congbao.R


import com.cong.congbao.nearbyPage.dummy.DummyContent.VendingMachine
import de.hdodenhof.circleimageview.CircleImageView

import kotlinx.android.synthetic.main.fragment_store.view.*

/**
 * 附近售货机 adapter
 * [RecyclerView.Adapter] that can display a [VendingMachine] and makes a call to the
 * specified [OnListFragmentInteractionListener].
 * TODO: Replace the implementation with code for your data type.
 */
class MyStoreRecyclerViewAdapter(
        private val mValues: List<VendingMachine>
        )
    : RecyclerView.Adapter<MyStoreRecyclerViewAdapter.ViewHolder>() {

    private val mOnClickListener: View.OnClickListener

    init { //初始化监听器
        mOnClickListener = View.OnClickListener { v ->
            val item = v.tag as VendingMachine
            // Notify the active callbacks interface (the activity, if the fragment is attached to
            // one) that an item has been selected.
//            mListener?.onListFragmentInteraction(item)
            //TODO 打开售货机商品页面
            Toast.makeText(v.context, "售货机点击事件", Toast.LENGTH_SHORT).show()
//            v.context.startActivity(Intent(v.context, ScrollingActivity::class.java))
        }
    }

    //创建ViewHolder
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.fragment_store, parent, false)
        return ViewHolder(view)
    }

    //绑定数据
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = mValues[position]
        holder.mNameView.text = item.name
        holder.mAddressView.text = item.address
        holder.mDistanceView.text = item.distance
//        holder.mImgView TODO 头像
//        holder.mImgView.setBackgroundResource(R.drawable.img_vending1)
        holder.mImgView.let {
            if (position % 2 == 1) {
                it.setImageResource(R.drawable.img_vending1)
            } else {
                it.setImageResource(R.drawable.img_vending2)
            }
        }
        holder.mPhoneView.text = item.phone

        with(holder.mView) {//itemView
            tag = item //绑定数据
            setOnClickListener(mOnClickListener)
        }
    }

    override fun getItemCount(): Int = mValues.size

    /**
     * 内部类
     */
    inner class ViewHolder(val mView: View) : RecyclerView.ViewHolder(mView) {
        val mNameView: TextView = mView.vendingName //item_number 是xml id
        val mAddressView: TextView = mView.vendingAddress
        val mPhoneView: TextView = mView.vendingPhone
        val mImgView: CircleImageView = mView.userImg
        val mDistanceView: TextView = mView.vendingDistance

    }
}
