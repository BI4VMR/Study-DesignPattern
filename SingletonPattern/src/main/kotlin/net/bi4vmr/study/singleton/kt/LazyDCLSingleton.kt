package net.bi4vmr.study.singleton.kt

import java.util.*

/**
 * Name        : LazyDCLSingleton
 *
 * Author      : BI4VMR
 *
 * Email       : bi4vmr@outlook.com
 *
 * Date        : 2023-10-01 16:43
 *
 * Description : 单例模式 - 双重校验锁式（不含初始化参数）。
 */
class LazyDCLSingleton private constructor() {

    /*
     * 伴生对象
     * Kotlin不支持"static"关键字，伴生对象相当于Java的静态内部类，用于组织静态变量与方法。
     */
    companion object {

        /*
         * 当前类的实例变量
         * 内置函数"lazy"设为同步模式后，自带DCL机制，无需自行编写。
         */
        private val instance: LazyDCLSingleton by lazy(mode = LazyThreadSafetyMode.SYNCHRONIZED) {
            LazyDCLSingleton()
        }

        // 对外公开的方法，供外界获取当前类的实例。
        @JvmName("getClassInstance")
        @JvmStatic
        fun getInstance(): LazyDCLSingleton {
            return instance
        }
    }

    // 对象标识符，构造对象时赋值，用于区分不同的对象。
    val id: String = UUID.randomUUID().toString()
}
