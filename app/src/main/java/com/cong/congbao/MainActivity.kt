package com.cong.congbao

import android.net.Uri
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentTransaction
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.cong.congbao.homePage.GoodListDialogFragment
import com.cong.congbao.nearbyPage.NearbyStoresFragment
import com.cong.congbao.nearbyPage.dummy.DummyContent
import com.cong.congbao.userPage.UserFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), NearbyStoresFragment.OnListFragmentInteractionListener ,
        UserFragment.OnFragmentInteractionListener, GoodListDialogFragment.Listener {
    override fun onGoodClicked(position: Int) {
        Toast.makeText(this, "onGoodClicked 点击事件", Toast.LENGTH_SHORT)
    }

    override fun onFragmentInteraction(uri: Uri) {
        Toast.makeText(this, "onFragmentInteraction 点击事件", Toast.LENGTH_SHORT)
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onListFragmentInteraction(item: DummyContent.DummyItem?) {
        Toast.makeText(this, "onListFragmentInteraction 点击事件", Toast.LENGTH_SHORT)
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    private lateinit var ft: FragmentTransaction
    private  val nearbyFragment: NearbyStoresFragment by lazy {
        NearbyStoresFragment.newInstance(2)
    }
    private  val userFragment:UserFragment by lazy {
        UserFragment.newInstance("Hello", "World")
    }
    private  val goodsFragment: GoodListDialogFragment by lazy {
        GoodListDialogFragment.newInstance(2)
    }
    private val list = listOf(nearbyFragment, userFragment, goodsFragment)

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        //TODO 切换fragment
        when (item.itemId) {
            R.id.navigation_buy -> {
                displayFragment(goodsFragment)
//                message.setText(R.string.title_home)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_nearby -> {
                displayFragment(nearbyFragment)
//                message.setText(R.string.title_nearby)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_user -> {
                displayFragment(userFragment)
//                message.setText(R.string.title_user)
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    private fun displayFragment(fragment:Fragment) {
        ft = supportFragmentManager.beginTransaction()
        if (fragment.isAdded) {
            ft.show(fragment)

        } else {
            ft.add(R.id.mainFrameLayout, fragment, fragment::class.java.simpleName)
        }
        list.forEach{
            if (it != fragment && it.isAdded) {
                ft.hide(it)
            }
        }

        ft.commit()
    }



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        displayFragment(goodsFragment)
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
    }

//    fun displayNeabyFragment


}
