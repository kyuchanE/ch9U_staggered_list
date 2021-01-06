package com.chan9u.staggered.utils

import android.app.Activity
import android.content.Context
import android.content.ContextWrapper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.orhanobut.hawk.Hawk
import com.chan9u.staggered.base.BaseActivity


/*------------------------------------------------------------------------------
 * NAME    : Ext
 * DESC    : 익스텐션
 * AUTHOR  : chan9U
 *------------------------------------------------------------------------------
 *                            변         경         사         항
 *------------------------------------------------------------------------------
 *    DATE     AUTHOR                         DESCRIPTION
 * ----------  ------  ---------------------------------------------------------
 * 2020.12.30  chan9U  최초 프로그램 작성
 *------------------------------------------------------------------------------*/

////////////////////////////// Any //////////////////////////////
val Any?.notNull get() = this != null
val Any?.isNull get() = this == null
val Any?.unit get() = null

fun Any?.save(key: String) {
    if (this.isNull) {
        Hawk.delete(key)
        L.d("Hawk delete : $key")
    } else {
        Hawk.put(key, this)
        L.d("Hawk save : $key = $this")
    }
}

////////////////////////////// DataBinding //////////////////////////////
val Context.layoutInflater: LayoutInflater get() = LayoutInflater.from(this)
val View.layoutInflater get() = context.layoutInflater

fun <T : ViewDataBinding> Activity.bind(layoutId: Int): T {
    return DataBindingUtil.setContentView(this, layoutId)
}
fun <T : ViewDataBinding> LayoutInflater.bind(layoutId: Int, parent: ViewGroup? = null, attachToParent: Boolean = false): T {
    return DataBindingUtil.inflate(this, layoutId, parent, attachToParent)
}
fun <T : ViewDataBinding> Activity.bindView(layoutId: Int, parent: ViewGroup? = null, attachToRoot: Boolean = false): T {
    return DataBindingUtil.inflate(layoutInflater, layoutId, parent, attachToRoot)
}

fun ViewDataBinding.setOnEvents(activity: BaseActivity<*>? = null) = root.setOnEvents(activity)


////////////////////////////// View //////////////////////////////
val View.isClick get() = tag == "click"

val View.activity: BaseActivity<*>?
    get() {
        var ctx = context
        while (ctx is ContextWrapper) {
            if (ctx is BaseActivity<*>) {
                return ctx
            }
            ctx = ctx.baseContext
        }
        return null
    }

val ViewGroup.views: List<View>
    get() {
        val views = mutableListOf<View>()
        val childCount = childCount
        for (i in 0 until childCount) {
            val child = getChildAt(i)
            if (child is ViewGroup) {
                views.addAll(child.views)
            }

            views.add(child)
        }
        return views
    }

val ViewGroup.eventViews: List<View>
    get() {
        val result = mutableListOf<View>()

        for (view in views) {
            when (view) {
                is Button,
                is ImageButton,
                is CompoundButton,
                is CheckedTextView,
                is RadioButton,
                is CheckBox
                -> result.add(view)
            }
            if (view.isClick) result.add(view)
        }
        return result
    }

fun View.setOnEvents(baseActivity: BaseActivity<*>? = null): View {
    var views = mutableListOf<View>()

    if (this is ViewGroup) views.addAll(eventViews)
    else views.add(this)

    val handler = baseActivity ?: activity
    handler?.let { h ->
        views.filter { it.id != View.NO_ID }.forEach {
            when (it) {
                is CompoundButton -> {
                    it.setOnCheckedChangeListener(h::onRxCheckedEvents)
                    it.setOnClickListener(h::onRxBtnEvents)
                }
                is Button, is ImageButton, is CheckedTextView -> it.setOnClickListener(h::onRxBtnEvents)
            }

            if (it.isClick) it.setOnClickListener(h::onRxBtnEvents)
        }
    }

    return this
}


////////////////////////////// Hawk //////////////////////////////
fun <T> hawk(key: String): T = Hawk.get(key)
fun <T> hawk(key: String, default: T): T = Hawk.get(key, default)
fun <T> flash(key: String): T = Hawk.get<T>(key).also { Hawk.delete(key) }
fun <T> flash(key: String, default: T): T = Hawk.get(key, default).also { Hawk.delete(key) }