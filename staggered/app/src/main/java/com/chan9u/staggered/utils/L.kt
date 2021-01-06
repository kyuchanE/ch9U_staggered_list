package com.chan9u.staggered.utils

import com.google.gson.Gson
import com.orhanobut.logger.AndroidLogAdapter
import com.orhanobut.logger.Logger
import com.orhanobut.logger.PrettyFormatStrategy


/*------------------------------------------------------------------------------
 * NAME    : L
 * DESC    : 공통 로그
 * AUTHOR  : chan9U
 *------------------------------------------------------------------------------
 *                            변         경         사         항
 *------------------------------------------------------------------------------
 *    DATE     AUTHOR                         DESCRIPTION
 * ----------  ------  ---------------------------------------------------------
 * 2021.01.04  chan9U  최초 프로그램 작성
 *------------------------------------------------------------------------------*/
object L {

    private const val PRINT_LOG = true  // 로그출력 여부
    private const val LOG_TAG = "[TDR] LOG : "  // 로그 태그
    private const val NULL = "null"

    /**
     * 로그설정
     *
     */
    init {
        val formatStrategy = PrettyFormatStrategy.newBuilder()
                .tag(LOG_TAG)           // 로그태그
                .methodOffset(1)    // 메소드 노출 인덱스
                .methodCount(3)     // 메소드 노출 개수
                .build()

        Logger.addLogAdapter(object : AndroidLogAdapter(formatStrategy) {
            override fun isLoggable(priority: Int, tag: String?): Boolean {
                return PRINT_LOG
            }
        })
    }

    /**
     * verbose
     *
     * @param log
     */
    fun v(log: String?) = Logger.v(log ?: NULL)

    /**
     * info
     *
     * @param log
     */
    fun i(log: String?) = Logger.i(log ?: NULL)

    /**
     * debug
     *
     * @param log
     */
    fun d(log: Any?) = log?.let { Logger.json(Gson().toJson(it)) } ?: d(NULL)

    fun d(log: String?) = Logger.d(log ?: NULL)


    /**
     * debug
     *
     * @param titles
     * @param contents
     */
    fun d(titles: List<String>, contents: List<Any?>) {
        val logs = StringBuilder()

        val contentsSize = contents.size

        titles.forEachIndexed { index, item ->
            logs.append(item).append(" : ")
            if (contentsSize > index) logs.append(contents[index])
            logs.append("\n")
        }

        Logger.d(logs.toString())
    }

    /**
     * warning
     *
     * @param log
     */
    fun w(log: String?) = Logger.w(log ?: NULL)

    /**
     * error
     *
     * @param log
     */
    fun e(log: String?) = Logger.e(log ?: NULL)

    /**
     * error
     *
     * @param e
     */
    fun e(e: Throwable) = Logger.e(e, e.toString())

    /**
     * assert(What the FuXX)
     *
     * @param log
     */
    fun wtf(log: String?) = Logger.wtf(log ?: NULL)

    /**
     * Json 문자열을 포맷팅하여 보여줌
     *
     * @param json
     */
    fun js(json: String?) = Logger.json(json ?: NULL)

    /**
     * xml 문자열을 포맷팅하여 보여줌
     *
     * @param xml
     */
    fun xml(xml: String?) = Logger.xml(xml ?: NULL)

}