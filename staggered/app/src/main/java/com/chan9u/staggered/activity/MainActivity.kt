package com.chan9u.staggered.activity

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.GridLayoutManager
import com.chan9u.staggered.R
import com.chan9u.staggered.activity.adapter.StaggeredAdapter
import com.chan9u.staggered.activity.adapter.StaggeredListData
import com.chan9u.staggered.base.BaseActivity
import com.chan9u.staggered.utils.C
import com.chan9u.staggered.utils.L
import com.chan9u.staggered.databinding.ActivityMainBinding
import java.util.*

/*------------------------------------------------------------------------------
 * NAME    : MainActivity
 * DESC    : 메인 화면
 * AUTHOR  : chan9U
 *------------------------------------------------------------------------------
 *                            변         경         사         항
 *------------------------------------------------------------------------------
 *    DATE     AUTHOR                         DESCRIPTION
 * ----------  ------  ---------------------------------------------------------
 * 2020.12.30  chan9U  최초 프로그램 작성
 *------------------------------------------------------------------------------*/
class MainActivity : BaseActivity<ActivityMainBinding>() {

    override val layoutId: Int = R.layout.activity_main

    private var adapterStaggered: StaggeredAdapter = StaggeredAdapter()
    private var staggeredItemList: MutableList<StaggeredListData> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initViews()
    }

    override fun initViews() {
        super.initViews()

        staggeredItemList.apply {
            add(StaggeredListData("https://img.appstory.co.kr/@files/monthly.appstory.co.kr/thum/Bdatafile/Board/dir_135/13534.jpg"))
            add(StaggeredListData("https://www.econovill.com/news/photo/201601/278657_85141_1631.jpg"))
            add(StaggeredListData("https://static.hubzum.zumst.com/hubzum/2019/08/05/10/1ae62cbcc6ff4861946cd32c438a0813_780x780.jpg"))
            add(StaggeredListData("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSm4OpE-hVvlKTwBRWofqckJuBehi0V8BjxVg&usqp=CAU"))
            add(StaggeredListData("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQkTjdLqGMyulLc9H30SbrQVqHS5C4W_ULsLg&usqp=CAU"))
            add(StaggeredListData("https://lh3.googleusercontent.com/proxy/CTMaXccLUn6WjROANqdMK7Ou5kbsVO3eTvrp8_ijJi1VIPIH7i1cBH7JICGrnUG1Ox3ywqAVq1UKOzTdycIQtBHy_vDZOFoneAkDU-aFozfGQtUuYfMQTmqRIeM"))
            add(StaggeredListData("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRIiZC8fMpThz3gMQm9ayW_G7mSIryCzatG_g&usqp=CAU"))
            add(StaggeredListData("https://lh3.googleusercontent.com/proxy/wJHvISeaH3w2RyO9-6cFn5-rZbQNBvZN7Be7BX4iIuJJfcAeEf0jurnGXuReeJOGKPdqZtpd9ljcc9SaBfltAB6uMk717cNs1Wwuwrk320RT-OybPyAtL6PCp3S02w"))
            add(StaggeredListData("https://upload.wikimedia.org/wikipedia/commons/thumb/2/26/Android_Oreo_8.1_logo.svg/1200px-Android_Oreo_8.1_logo.svg.png"))
            add(StaggeredListData("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTtpk2KbX2HUAZGKfeNR0OKbk54g5IpkaLE5w&usqp=CAU"))
            add(StaggeredListData("https://www.bloter.net/wp-content/uploads/2018/12/Android-Ice-Cream-Sandwich-800x450.jpg"))
            add(StaggeredListData("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR8HngRoiFXkErdOk6-lp9yfUJj-RgLio3Y6g&usqp=CAU"))
            add(StaggeredListData("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSKlsXucpE80p4WX7RTu9xkAzzrxv0BZAskPg&usqp=CAU"))

        }

        adapterStaggered.apply {
            addItemList(staggeredItemList)
        }
        binding.rvStaggered.apply {
            adapter = adapterStaggered
            layoutManager = GridLayoutManager(this@MainActivity, 3)
        }

    }

}