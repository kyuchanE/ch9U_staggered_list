package com.chan9u.staggered.base

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.chan9u.staggered.base.BaseActivity
import io.github.luizgrp.sectionedrecyclerviewadapter.Section
import io.github.luizgrp.sectionedrecyclerviewadapter.SectionParameters


/*------------------------------------------------------------------------------
 * NAME    : BaseSection
 * DESC    : 기본 섹션
 * AUTHOR  : chan9U
 *------------------------------------------------------------------------------
 *                            변         경         사         항
 *------------------------------------------------------------------------------
 *    DATE     AUTHOR                         DESCRIPTION
 * ----------  ------  ---------------------------------------------------------
 * 2020.12.31  chan9U  최초 프로그램 작성
 *------------------------------------------------------------------------------*/
class BaseSection<A: BaseActivity<*>, D>(params: SectionParameters): Section(params) {

    var handler: A? = null // 기본 핸들러

    var isHeaderBind: Boolean = false // 헤더가 그려졌는지 여부
    var isFooterBind: Boolean = false // 푸터가 그려졌는지 여부

    var items: MutableList<D> = mutableListOf()
        set(value) {
            field.clear()
            field.addAll(value)
        }

    var totalCount: Int = 0 // 아이템 카운트

    constructor(params: SectionParameters, handler: A) : this(params) {
        this.handler = handler
    }

    constructor(params: SectionParameters, handler: A, items: List<D>) : this(params, handler) {
        this.items.addAll(items)
    }

    override fun getContentItemsTotal(): Int = items.size

    override fun onBindItemViewHolder(holder: RecyclerView.ViewHolder?, position: Int) = Unit

    override fun getItemViewHolder(view: View): RecyclerView.ViewHolder = object : RecyclerView.ViewHolder(view) {}

}