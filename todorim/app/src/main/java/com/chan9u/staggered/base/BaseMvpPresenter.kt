package com.chan9u.staggered.base

import com.hannesdorfmann.mosby3.mvp.MvpBasePresenter
import com.hannesdorfmann.mosby3.mvp.MvpView
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

/*------------------------------------------------------------------------------
 * NAME    : BaseMvpPresenter
 * DESC    : MVP Presenter 기본 정의
 * AUTHOR  : chan9U
 *------------------------------------------------------------------------------
 *                            변         경         사         항
 *------------------------------------------------------------------------------
 *    DATE     AUTHOR                         DESCRIPTION
 * ----------  ------  ---------------------------------------------------------
 * 2020.12.31  chan9U  최초 프로그램 작성
 *------------------------------------------------------------------------------*/
open class BaseMvpPresenter<V: MvpView>: MvpBasePresenter<V>() {

    // RX 핸들러
    private var compositeDisposable = CompositeDisposable()

    override fun detachView() {
        clearDisposable()
        super.detachView()
    }

    /**
     * 뷰가 설정되면 액셜 실행
     *
     * @param action 요청 액션
     */
    fun ifViewAttached(action: V.() -> Disposable) {
        super.ifViewAttached {
            addDisposable(it.action())
        }
    }

    /**
     * super의 ifViewAttached를 사용하기 위해
     *
     * * @param action 요청 액션
     */
    fun withView(action: V.() -> Unit) {
        super.ifViewAttached {
            it.action()
        }
    }


    /**
     * Rx 동작을 관리목록에 추가
     *
     * @param disposable
     */
    fun addDisposable(disposable: Disposable) {
        compositeDisposable.add(disposable)
    }

    /**
     * 관리목록에 등록된 Rx 동작을 모두 취소
     *
     */
    fun clearDisposable() {
        compositeDisposable.clear()
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