package com.chan9u.staggered.base

import android.view.View
import androidx.core.view.isVisible
import androidx.databinding.BindingAdapter


/*------------------------------------------------------------------------------
 * NAME    : BaseBindingAdapter
 * DESC    : DataBinding사용시 자동적용
 * AUTHOR  : chan9U
 *------------------------------------------------------------------------------
 *                            변         경         사         항
 *------------------------------------------------------------------------------
 *    DATE     AUTHOR                         DESCRIPTION
 * ----------  ------  ---------------------------------------------------------
 * 2020.12.31  chan9U  최초 프로그램 작성
 *------------------------------------------------------------------------------*/
object BaseBindingAdapter {

    @BindingAdapter("android:visibleIf")
    @JvmStatic
    fun View.setVisibleIf(value: Boolean) {
        isVisible = value
    }
}