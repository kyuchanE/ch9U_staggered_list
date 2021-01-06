package com.chan9u.staggered.utils

import java.text.SimpleDateFormat
import java.util.*


/*------------------------------------------------------------------------------
 * NAME    : C
 * DESC    : 공통
 * AUTHOR  : chan9U
 *------------------------------------------------------------------------------
 *                            변         경         사         항
 *------------------------------------------------------------------------------
 *    DATE     AUTHOR                         DESCRIPTION
 * ----------  ------  ---------------------------------------------------------
 * 2021.01.04  chan9U  최초 프로그램 작성
 *------------------------------------------------------------------------------*/
object C {

    // Today
    object Today{
        var currentDate = Calendar.getInstance().time
        var year: String = SimpleDateFormat("yyyy", Locale.getDefault()).format(currentDate)
        var month: String = SimpleDateFormat("MM", Locale.getDefault()).format(currentDate)
        var day: String = SimpleDateFormat("dd", Locale.getDefault()).format(currentDate)
        var weekDay: String = SimpleDateFormat("EE", Locale.getDefault()).format(currentDate)
    }

    // Hawk Key
    object Hawk{
        const val test: String = "test_hawk_key_name"
    }

}