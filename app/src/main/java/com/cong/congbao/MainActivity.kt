package com.cong.congbao

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentTransaction
import android.support.v7.app.AppCompatActivity
import com.cong.congbao.homePage.GoodTabFragment
import com.cong.congbao.homePage.GoodsFragment
import com.cong.congbao.nearbyPage.NearbyStoresFragment
import com.cong.congbao.userPage.UserFragment
import kotlinx.android.synthetic.main.activity_main.*

/**
 * MainActivity
 * 实现了三个fragment的监听器
 */
class MainActivity : AppCompatActivity() {

//    /**
//     * 附近售货机列表 fragment 点击事件
//     */
//    override fun onListFragmentInteraction(item: DummyContent.VendingMachine?) {
//        Toast.makeText(this, "onListFragmentInteraction 点击事件", Toast.LENGTH_SHORT)
//        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
//    }

    private lateinit var ft: FragmentTransaction //fragment 事务类
    // 初始化三个fragments
    private  val nearbyFragment: NearbyStoresFragment by lazy {
        NearbyStoresFragment.newInstance()
    }
    private  val userFragment:UserFragment by lazy {
        UserFragment.newInstance()
    }
    private  val goodsFragment: GoodTabFragment by lazy {
        GoodTabFragment.newInstance()
    }
//    private  val goodsFragment: GoodsFragment by lazy {
//        GoodsFragment.newInstance(3)
//    }
    //fragment lists
    private val list = listOf(nearbyFragment, userFragment, goodsFragment)

    /**
     * 底部导航按钮监听器
     * 点击切换fragment
     */
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

    /**
     * 切换fragment
     * @fragment 要显示的fragment
     */
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


    /**
     * 初始化方法，
     * 加载xml
     * 显示fragment
     * 设置底部导航按钮监听
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        displayFragment(goodsFragment)
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
    }

//    fun displayNeabyFragment


}
