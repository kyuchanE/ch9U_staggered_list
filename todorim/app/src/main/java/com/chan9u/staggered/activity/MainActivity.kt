package com.chan9u.staggered.activity

import android.content.Intent
import android.os.Bundle
import android.util.Log
import com.chan9u.staggered.R
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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initViews()
    }

    override fun initViews() {
        super.initViews()

    }

}