package net.bi4vmr.study.singleton.kt

import java.util.*

/**
 * Name        : LazyDCLSingleton2
 *
 * Author      : BI4VMR
 *
 * Email       : bi4vmr@outlook.com
 *
 * Date        : 2023-10-01 16:43
 *
 * Description : 单例模式 - 双重校验锁式（包含初始化参数）。
 */
class LazyDCLSingleton2 private constructor(arg1: Any) {

    companion object {
        @Volatile
        private var instance: LazyDCLSingleton2? = null

        @JvmStatic
        fun getInstance(arg1: Any): LazyDCLSingleton2 {
            if (instance == null) {
                synchronized(this) {
                    if (instance == null) {
                        instance = LazyDCLSingleton2(arg1)
                    }
                }
            }
            return instance!!
        }
    }

    val id: String = UUID.randomUUID().toString()

    // 构造方法
    init {
        // 初始化操作...
        println("构造对象，读取初始化参数：$arg1")
    }
}
