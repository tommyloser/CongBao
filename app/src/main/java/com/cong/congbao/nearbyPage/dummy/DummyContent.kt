package com.cong.congbao.nearbyPage.dummy

import java.util.ArrayList
import java.util.HashMap

/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards.
 *
 * TODO: Replace all uses of this class before publishing your app.
 */
object DummyContent {

    /**
     * An array of sample (dummy) items.
     * 数据
     */
    val ITEMS: MutableList<VendingMachine> = ArrayList()

    /**
     * A map of sample (dummy) items, by ID.
     * 数据
     */
    val ITEM_MAP: MutableMap<String, VendingMachine> = HashMap()

    private val COUNT = 25 //数据个数

    init {
        // Add some sample items.
        for (i in 1..COUNT) { //添加模拟数据
            addItem(createDummyItem(i))
        }
    }

    /**
     * 添加数据
     */
    private fun addItem(item: VendingMachine) {
        ITEMS.add(item)
        ITEM_MAP.put(item.name, item)
    }

    /**
     * 创建一个售货机数据
     * id = 1
     * content = Item 1
     * details = Details about Item: 1 More details information here * 1
     */
    private fun createDummyItem(position: Int): VendingMachine {
        return VendingMachine("","售货机" + position, "地址 " + position, "3km", "12345678")
    }

    /**
     * 创建售货机的细节
     */
    private fun makeDetails(position: Int): String {
        val builder = StringBuilder()
        builder.append("Details about Item: ").append(position)
        for (i in 0..position - 1) {
            builder.append("\nMore details information here.")
        }
        return builder.toString()
    }

    /**
     * A dummy item representing a piece of content.
     * 售货机 model
     */
    data class VendingMachine(val img:String, val name: String, val address: String, val distance: String, val phone: String) {
        override fun toString(): String {
            return "售货机：$name, 地址：$address, 距离：$distance, 电话：$phone"
        }
    }
}
