package com.chan9u.staggered.custom.glide

import android.content.Context
import com.bumptech.glide.Glide
import com.bumptech.glide.Registry
import com.bumptech.glide.annotation.GlideModule
import com.bumptech.glide.integration.okhttp3.OkHttpUrlLoader
import com.bumptech.glide.load.model.GlideUrl
import com.bumptech.glide.module.AppGlideModule
import com.chan9u.staggered.utils.API
import java.io.InputStream


/*------------------------------------------------------------------------------
 * NAME    : OkHttpAppGlideModule
 * DESC    : Glide4 기본모듈
 * AUTHOR  : chan9U
 *------------------------------------------------------------------------------
 *                            변         경         사         항
 *------------------------------------------------------------------------------
 *    DATE     AUTHOR                         DESCRIPTION
 * ----------  ------  ---------------------------------------------------------
 * 2020.12.30  chan9U  최초 프로그램 작성
 *------------------------------------------------------------------------------*/
@GlideModule
class OkHttpAppGlideModule : AppGlideModule() {
    override fun registerComponents(context: Context, glide: Glide, registry: Registry) {
        registry.replace(
            GlideUrl::class.java,
            InputStream::class.java,
            OkHttpUrlLoader.Factory(API.okHttpClient)
        )
    }
}