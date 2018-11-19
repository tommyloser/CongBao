package com.cong.congbao.homePage

import android.content.Context
import android.os.Bundle
import android.support.design.widget.BottomSheetDialogFragment
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.cong.congbao.R;
import kotlinx.android.synthetic.main.fragment_good_list_dialog.*
import kotlinx.android.synthetic.main.fragment_good_list_dialog_item.view.*

// TODO: Customize parameter argument names
const val ARG_ITEM_COUNT = "item_count"

/**
 *
 * A fragment that shows a list of items as a modal bottom sheet.
 *
 * You can show this modal bottom sheet from your activity like this:
 * <pre>
 *    GoodListDialogFragment.newInstance(30).show(supportFragmentManager, "dialog")
 * </pre>
 *
 * You activity (or fragment) needs to implement [GoodListDialogFragment.Listener].
 */
class GoodListDialogFragment : BottomSheetDialogFragment() {
    private var mListener: Listener? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_good_list_dialog, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        list.layoutManager = GridLayoutManager(context, 2)
       list.adapter = GoodAdapter(arguments?.getInt(ARG_ITEM_COUNT))
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        val parent = parentFragment
        if (parent != null) {
            mListener = parent as Listener
        } else {
            mListener = context as Listener
        }
    }

    override fun onDetach() {
        mListener = null
        super.onDetach()
    }

    interface Listener {
        fun onGoodClicked(position: Int)
    }

    private inner class ViewHolder internal constructor(inflater: LayoutInflater, parent: ViewGroup)
        : RecyclerView.ViewHolder(inflater.inflate(R.layout.fragment_good_list_dialog_item, parent, false)) {

        internal val text: TextView = itemView.text

        init {
            text.setOnClickListener {
                mListener?.let {
                    it.onGoodClicked(adapterPosition)
                    dismiss()
                }
            }
        }
    }

    private inner class GoodAdapter internal constructor(private val mItemCount: Int?) : RecyclerView.Adapter<ViewHolder>() {

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            return ViewHolder(LayoutInflater.from(parent.context), parent)
        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            holder.text.text = position.toString()
        }

        override fun getItemCount(): Int {
            return mItemCount?:0
        }
    }

    companion object {

        // TODO: Customize parameters
        fun newInstance(itemCount: Int): GoodListDialogFragment =
                GoodListDialogFragment().apply {
                    arguments = Bundle().apply {
                        putInt(ARG_ITEM_COUNT, itemCount)
                    }
                }

    }
}
