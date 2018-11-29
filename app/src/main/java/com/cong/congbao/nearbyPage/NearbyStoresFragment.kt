package com.cong.congbao.nearbyPage

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.cong.congbao.R

import com.cong.congbao.nearbyPage.dummy.DummyContent

/**
 * A fragment representing a list of Items.
 * Activities containing this fragment MUST implement the
 * [NearbyStoresFragment.OnListFragmentInteractionListener] interface.
 */
class NearbyStoresFragment : Fragment() {

    // TODO: Customize parameters
    private var columnCount = 1 //默认2列

//    private var listener: OnListFragmentInteractionListener? = null

    /**
     * 初始化，处理参数 columnCount
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

//        //arguments 可以直接用
//        arguments?.let {
//            columnCount = it.getInt(FRAGMENT_NAME)
//        }
    }

    /**
     * 初始化界面界面
     * 设置recyclerView 的layoutManager 和 adapter
     */
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_store_list, container, false)

        // Set the adapter
        if (view is RecyclerView) {
            with(view) { //with = view.apply,即 RecyclerView.()
                //set layoutManager
                layoutManager = when {//如果小于一列，就是LinearLayout, 否则是Gridlayout
                    columnCount <= 1 -> LinearLayoutManager(context)
                    else -> GridLayoutManager(context, columnCount)
                }
                //setAdapter, 初始化adapter , 模拟数据， 监听器
                adapter = MyStoreRecyclerViewAdapter(DummyContent.ITEMS)
            }
        }
        return view
    }

//    /**
//     * fragment 生命周期，比onCreate 前
//     * 绑定监听器
//     */
//    override fun onAttach(context: Context) {
//        super.onAttach(context)
//        if (context is OnListFragmentInteractionListener) {
//            listener = context
//        } else {
//            throw RuntimeException(context.toString() + " must implement OnListFragmentInteractionListener")
//        }
//    }
//
//    override fun onDetach() {
//        super.onDetach()
//        listener = null
//    }

//    /**
//     * This interface must be implemented by activities that contain this
//     * fragment to allow an interaction in this fragment to be communicated
//     * to the activity and potentially other fragments contained in that
//     * activity.
//     *
//     * 声明监听接口
//     *
//     * See the Android Training lesson
//     * [Communicating with Other Fragments](http://developer.android.com/training/basics/fragments/communicating.html)
//     * for more information.
//     */
//    interface OnListFragmentInteractionListener {
//        // TODO: Update argument type and name
//        fun onListFragmentInteraction(item: VendingMachine?)
//    }

    /**
     * 半生对象， 即静态变量
     */
    companion object {

        // TODO: Customize parameter argument names
//        const val FRAGMENT_NAME = "column-count"

        // TODO: Customize parameter initialization
        /**
         * 初始化本fragment
         * 传入参数 ，列数
         */
//        @JvmStatic
//        fun newInstance(columnCount: Int) =
//                NearbyStoresFragment().apply {
//                    arguments = Bundle().apply {//返回bundle
//                        putInt(FRAGMENT_NAME, columnCount)
//                    }
//                }

        fun newInstance() = NearbyStoresFragment()
    }
}
