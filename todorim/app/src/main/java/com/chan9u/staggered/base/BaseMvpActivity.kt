package com.chan9u.staggered.base

import android.os.Bundle
import android.os.PersistableBundle
import androidx.databinding.ViewDataBinding
import com.hannesdorfmann.mosby3.mvp.MvpView
import com.hannesdorfmann.mosby3.mvp.delegate.ActivityMvpDelegateImpl
import com.hannesdorfmann.mosby3.mvp.delegate.MvpDelegateCallback
import com.chan9u.staggered.base.BaseActivity
import com.chan9u.staggered.utils.isNull


/*------------------------------------------------------------------------------
 * NAME    : BaseMvpActivity
 * DESC    : MVP Activity 기본 정의
 * AUTHOR  : chan9U
 *------------------------------------------------------------------------------
 *                            변         경         사         항
 *------------------------------------------------------------------------------
 *    DATE     AUTHOR                         DESCRIPTION
 * ----------  ------  ---------------------------------------------------------
 * 2020.12.31  chan9U  최초 프로그램 작성
 *------------------------------------------------------------------------------*/
abstract class BaseMvpActivity<B : ViewDataBinding, V : MvpView, P : BaseMvpPresenter<V>> : BaseActivity<B>(), MvpView, MvpDelegateCallback<V, P> {

    private var mvpDelegate: ActivityMvpDelegateImpl<V, P>? = null
    private lateinit var presenter: P

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        getMvpDelegate().onCreate(savedInstanceState)
    }

    override fun onDestroy() {
        super.onDestroy()
        getMvpDelegate().onDestroy()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        getMvpDelegate().onSaveInstanceState(outState)
    }

    override fun onPause() {
        super.onPause()
        getMvpDelegate().onPause()
    }

    override fun onResume() {
        super.onResume()
        getMvpDelegate().onResume()
    }

    override fun onStart() {
        super.onStart()
        getMvpDelegate().onStart()
    }

    override fun onStop() {
        super.onStop()
        getMvpDelegate().onStop()
    }

    override fun onRestart() {
        super.onRestart()
        getMvpDelegate().onRestart()
    }

    override fun onContentChanged() {
        super.onContentChanged()
        getMvpDelegate().onContentChanged()
    }

    override fun onPostCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onPostCreate(savedInstanceState, persistentState)
        getMvpDelegate().onPostCreate(savedInstanceState)
    }

    /**
     * Get the mvp delegate. This is internally used for creating presenter, attaching and detaching
     * view from presenter.
     *
     *
     * **Please note that only one instance of mvp delegate should be used per Activity
     * instance**.
     *
     *
     *
     *
     * Only override this method if you really know what you are doing.
     *
     *
     * @return [ActivityMvpDelegateImpl]
     */
    protected fun getMvpDelegate(): ActivityMvpDelegateImpl<V, P> {
        if (mvpDelegate.isNull) {
            mvpDelegate = ActivityMvpDelegateImpl(this, this, true)
        }

        return mvpDelegate!!
    }

    override fun getPresenter(): P {
        return presenter
    }

    override fun setPresenter(presenter: P) {
        this.presenter = presenter
    }

    override fun getMvpView(): V {
        return this as V
    }
}