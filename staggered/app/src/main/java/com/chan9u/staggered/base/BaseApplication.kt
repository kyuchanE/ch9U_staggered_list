package com.chan9u.staggered.base

import android.app.Application
import com.facebook.stetho.Stetho
import com.orhanobut.hawk.Hawk

/*------------------------------------------------------------------------------
 * NAME    : BaseApplication
 * DESC    : 어플리케이션 기본 정의
 * AUTHOR  : chan9U
 *------------------------------------------------------------------------------
 *                            변         경         사         항
 *------------------------------------------------------------------------------
 *    DATE     AUTHOR                         DESCRIPTION
 * ----------  ------  ---------------------------------------------------------
 * 2020.12.30  chan9U  최초 프로그램 작성
 *------------------------------------------------------------------------------*/
class BaseApplication: Application() {

    override fun onCreate() {
        super.onCreate()

        // Hawk
        Hawk.init(this).build()

        // Stetho
        Stetho.initializeWithDefaults(this)
    }
}