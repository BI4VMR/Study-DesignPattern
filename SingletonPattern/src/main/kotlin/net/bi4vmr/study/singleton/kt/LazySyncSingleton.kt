package net.bi4vmr.study.singleton.kt

import java.util.*

/**
 * Name        : LazySyncSingleton
 *
 * Author      : BI4VMR
 *
 * Email       : bi4vmr@outlook.com
 *
 * Date        : 2023-10-01 16:43
 *
 * Description : 单例模式 - 懒汉同步式。
 */
class LazySyncSingleton private constructor(arg1: Any) {

    /*
     * 伴生对象
     * Kotlin不支持"static"关键字，伴生对象相当于Java的静态内部类，用于组织静态变量与方法。
     */
    companion object {

        // 当前类的实例变量
        private var instance: LazySyncSingleton? = null

        // 对外公开的方法，供外界获取当前类的实例。
        @Synchronized
        @JvmStatic
        fun getInstance(arg1: Any): LazySyncSingleton {
            if (instance == null) {
                instance = LazySyncSingleton(arg1)
            }
            return instance!!
        }
    }

    // 对象标识符，构造对象时赋值，用于区分不同的对象。
    val id: String = UUID.randomUUID().toString()

    // 构造方法
    init {
        // 初始化操作...
        println("构造对象，读取初始化参数：$arg1")
    }
}
