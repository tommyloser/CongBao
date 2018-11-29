package com.cong.congbao.homePage

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.cong.congbao.R

import com.cong.congbao.homePage.dummy.DummyContent

/**
 * A fragment representing a list of Items.
 * Activities containing this fragment MUST implement the
 * [GoodsFragment.OnListFragmentInteractionListener] interface.
 */
class GoodsFragment : Fragment() {

    // TODO: Customize parameters
    private var columnCount = 3
    private var name = "热销"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {
            name = it.getString(FRAGMENT_NAME)
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_good_list, container, false)

        // Set the adapter
        if (view is RecyclerView) {
            with(view) {
                layoutManager = when {
                    columnCount <= 1 -> LinearLayoutManager(context)
                    else -> GridLayoutManager(context, columnCount)
                }
                adapter = MyGoodRecyclerViewAdapter(DummyContent.ITEMS)
            }
        }
        return view
    }



    companion object {

        const val FRAGMENT_NAME = "name"

        @JvmStatic
        fun newInstance(name: String) =
                GoodsFragment().apply {
                    arguments = Bundle().apply {
                        putString(FRAGMENT_NAME, name)
                    }
                }
    }
}
