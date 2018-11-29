package com.cong.congbao.homePage


import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.cong.congbao.R
import kotlinx.android.synthetic.main.fragment_good__list.*


/**
 * A simple [Fragment] subclass.
 * Use the [GoodTabFragment.newInstance] factory method to
 * create an instance of this fragment.
 *
 */
class GoodTabFragment : Fragment() {


//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_good__list, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = SectionsPagerAdapter(childFragmentManager)

        // Set up the ViewPager with the sections adapter.
        container.adapter = mSectionsPagerAdapter

        //互相监听 Tablayout 和 viewpager
        container.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tabs))
        tabs.addOnTabSelectedListener(TabLayout.ViewPagerOnTabSelectedListener(container))
        tabs.setupWithViewPager(container)
    }


    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @return A new instance of fragment GoodTabFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance() = GoodTabFragment()
    }

    /**
     * The [android.support.v4.view.PagerAdapter] that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * [android.support.v4.app.FragmentStatePagerAdapter].
     */
    private var mSectionsPagerAdapter: SectionsPagerAdapter? = null


    val titles = arrayOf("热销", "饮料", "零食", "百货", "快餐")


    /**
     * A [FragmentPagerAdapter] that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    inner class SectionsPagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {

        override fun getItem(position: Int): Fragment {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).
            return GoodsFragment.newInstance(titles[position])
        }

        override fun getCount(): Int {
            // Show 3 total pages.
            return titles.size
        }

        override fun getPageTitle(position: Int): CharSequence? {
            return titles[position]
        }
    }

    /**
     * A placeholder fragment containing a simple view.
     */
//    class PlaceholderFragment : Fragment() {
//
//        override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
//                                  savedInstanceState: Bundle?): View? {
//            val rootView = inflater.inflate(R.layout.fragment_good__list_, container, false)
//            rootView.section_label.text = getString(R.string.section_format, arguments?.getInt(ARG_SECTION_NUMBER))
//            return rootView
//        }
//
//        companion object {
//            /**
//             * The fragment argument representing the section number for this
//             * fragment.
//             */
//            private val ARG_SECTION_NUMBER = "section_number"
//
//            /**
//             * Returns a new instance of this fragment for the given section
//             * number.
//             */
//            fun newInstance(sectionNumber: Int): PlaceholderFragment {
//                val fragment = PlaceholderFragment()
//                val args = Bundle()
//                args.putInt(ARG_SECTION_NUMBER, sectionNumber)
//                fragment.arguments = args
//                return fragment
//            }
//        }
//    }
}
