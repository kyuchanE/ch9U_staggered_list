package com.chan9u.staggered.utils

import android.content.Context
import android.os.Build
import android.webkit.WebSettings
import com.chan9u.staggered.BuildConfig
import com.facebook.stetho.okhttp3.StethoInterceptor
import okhttp3.OkHttpClient
import okhttp3.internal.platform.Platform
import java.util.concurrent.TimeUnit

/*------------------------------------------------------------------------------
 * NAME    : API
 * DESC    : RESTful 통신을 위한 Retrofit2를 설정하여 반환하는 API 클래스
 * AUTHOR  : chan9U
 *------------------------------------------------------------------------------
 *                            변         경         사         항
 *------------------------------------------------------------------------------
 *    DATE     AUTHOR                         DESCRIPTION
 * ----------  ------  ---------------------------------------------------------
 * 2021.01.04  chan9U  최초 프로그램 작성
 *------------------------------------------------------------------------------*/
object API {

    private const val CONNECT_TIMEOUT = 3000L // 커넥션 타임
    private const val WRITE_TIMEOUT = 3000L // 쓰기 타임
    private const val READ_TIMEOUT = 3000L // 읽기 타임

    lateinit var context: Context

    val okHttpClient by lazy {
        val okHttpClientBuilder = OkHttpClient().newBuilder()

        okHttpClientBuilder
//                .connectionSpecs(listOf(ConnectionSpec.COMPATIBLE_TLS)) // https 관련 보안 옵션
                .connectTimeout(CONNECT_TIMEOUT, TimeUnit.SECONDS)  // 쓰기 타임아웃 시간 설정
                .writeTimeout(WRITE_TIMEOUT, TimeUnit.SECONDS)      // 읽기 타임아웃 시간 설정
                .readTimeout(READ_TIMEOUT, TimeUnit.SECONDS)        // 연결 타임아웃 시간 설정
                .cache(null)                                 // 캐시사용 안함
                .addInterceptor { chain ->
                    chain.proceed(
                            chain.request()
                                    .newBuilder()
                                    .header("User-Agent", "")
                                    .header("devicemodel", Build.MODEL)
//                                    .header("key", "value")
                                    .build()
                    )
                }

        okHttpClientBuilder.build()
    }

    fun init(ctx: Context) {
        context = ctx
    }
}