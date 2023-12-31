package net.bi4vmr.study.singleton.kt

import java.util.*

/**
 * Name        : LazyInnerClassSingleton
 *
 * Author      : BI4VMR
 *
 * Email       : bi4vmr@outlook.com
 *
 * Date        : 2023-10-01 16:43
 *
 * Description : 单例模式 - 静态内部类式。
 */
class LazyInnerClassSingleton private constructor() {

    /*
     * 伴生对象
     * Kotlin不支持"static"关键字，伴生对象相当于Java的静态内部类，用于组织静态变量与方法。
     */
    companion object {
        // 对外公开的方法，供外界获取当前类的实例。
        fun getInstance(): LazyInnerClassSingleton {
            return SingletonHolder.INSTANCE
        }
    }

    // 静态内部类，用于承载单例对象。
    private object SingletonHolder {
        val INSTANCE: LazyInnerClassSingleton = LazyInnerClassSingleton()
    }

    // 对象标识符，构造对象时赋值，用于区分不同的对象。
    val id: String = UUID.randomUUID().toString()
}
