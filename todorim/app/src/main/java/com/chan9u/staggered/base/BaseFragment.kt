package com.chan9u.staggered.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import com.chan9u.staggered.base.BaseActivity
import com.chan9u.staggered.utils.bind
import com.chan9u.staggered.utils.setOnEvents
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe

/*------------------------------------------------------------------------------
 * NAME    : BaseFragment
 * DESC    : 프래그먼트 기본 정의
 * AUTHOR  : chan9U
 *------------------------------------------------------------------------------
 *                            변         경         사         항
 *------------------------------------------------------------------------------
 *    DATE     AUTHOR                         DESCRIPTION
 * ----------  ------  ---------------------------------------------------------
 * 2020.12.30  chan9U  최초 프로그램 작성
 *------------------------------------------------------------------------------*/
abstract class BaseFragment<B: ViewDataBinding>: Fragment() {

    protected lateinit var binding: B
    abstract val layoutId: Int

    // Rx 핸들러
    private val compositeDisposable = CompositeDisposable()

    val baseActivity: BaseActivity<B>
        get() = activity as BaseActivity<B>

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = inflater.bind(layoutId, container)
        binding.setOnEvents()

        // 이벤트 버스 등록
        EventBus.getDefault().register(this)

        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onDestroyView() {
        // 이벤트 버스 해제
        EventBus.getDefault().unregister(this)

        compositeDisposable.clear()
        super.onDestroyView()
    }

    fun <T> getParentActivity(): T = activity as T

    /**
     * 이벤트 버스 버그를 막기위한 메소드
     * greenrobot 이벤트 버스는 기본적으로 Subscribe 메소드가 하나라도 작성되어있어야 함
     *
     * @param fragment
     */
    @Subscribe
    fun eventbus(fragment: BaseFragment<B>) {
    }

    /**
     * Rx 핸들을 핸들러에 등록
     *
     * @param disposable Rx 핸들
     */
    fun addDisposable(disposable: Disposable) {
        compositeDisposable.add(disposable)
    }

    /**
     * Rx 핸들을 핸들러에 제외
     *
     * @param disposable Rx 핸들
     */
    fun deleteDisposable(disposable: Disposable) {
        compositeDisposable.delete(disposable)
    }

    /**
     * Rx 핸들을 중지하고 핸들러에서 제외
     *
     * @param disposable Rx 핸들
     */
    fun removeDisposable(disposable: Disposable) {
        compositeDisposable.remove(disposable)
    }

}