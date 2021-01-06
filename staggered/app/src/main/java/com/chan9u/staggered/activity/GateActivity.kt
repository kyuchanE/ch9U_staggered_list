package com.chan9u.staggered.activity

import android.content.Intent
import android.os.Bundle
import com.chan9u.staggered.R
import com.chan9u.staggered.base.BaseActivity
import com.chan9u.staggered.databinding.ActivityGateBinding
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import java.util.concurrent.TimeUnit

/*------------------------------------------------------------------------------
 * NAME    : GateActivity
 * DESC    : 게이트 화면 (Splash)
 * AUTHOR  : chan9U
 *------------------------------------------------------------------------------
 *                            변         경         사         항
 *------------------------------------------------------------------------------
 *    DATE     AUTHOR                         DESCRIPTION
 * ----------  ------  ---------------------------------------------------------
 * 2020.12.30  chan9U  최초 프로그램 작성
 *------------------------------------------------------------------------------*/
class GateActivity : BaseActivity<ActivityGateBinding>() {

    override val layoutId: Int = R.layout.activity_gate

    private var timerDisposable: Disposable? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initViews()

    }

    override fun initViews() {
        super.initViews()

        splashTimer()

    }

    // 테스트 스플레쉬 타이머 (메인 이동)
    private fun splashTimer() {
        timerDisposable = io.reactivex.Observable
                .interval(500, TimeUnit.MILLISECONDS)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe {
                    startActivity(Intent(this, MainActivity::class.java))
                    overridePendingTransition(R.anim.anim_activity_splash_show, 0)
                    finish()
                    overridePendingTransition(0, R.anim.anim_activity_splash_gone)
                    removeDisposable(timerDisposable!!)
                }
        addDisposable(timerDisposable!!)
    }
}