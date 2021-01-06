package com.chan9u.staggered.custom

import com.chan9u.staggered.base.BaseActivity
import com.chan9u.staggered.base.BaseDialog
import com.chan9u.staggered.databinding.DefaultDialogBinding
import com.chan9u.staggered.R

/*------------------------------------------------------------------------------
 * NAME    : DefaultDialog
 * DESC    : 기본 다이얼로그
 * AUTHOR  : chan9U
 *------------------------------------------------------------------------------
 *                            변         경         사         항
 *------------------------------------------------------------------------------
 *    DATE     AUTHOR                         DESCRIPTION
 * ----------  ------  ---------------------------------------------------------
 * 2020.12.30  chan9U  최초 프로그램 작성
 *------------------------------------------------------------------------------*/
class DefaultDialog(activity: BaseActivity<*>): BaseDialog<DefaultDialogBinding>(activity) {

    override val layoutId: Int = R.layout.default_dialog

}