package net.bi4vmr.study.singleton.kt

import kotlin.concurrent.thread

/**
 * Name        : TestSingleton
 *
 * Author      : BI4VMR
 *
 * Email       : bi4vmr@outlook.com
 *
 * Date        : 2023-10-01 13:38
 *
 * Description : 测试类 - 单例模式。
 */

fun main() {
    example06()
}

/*
 * 单例模式 - 饿汉式
 */
fun example01() {
    // 访问该对象的方法
    SimpleSingleton.function()
}

/*
 * 单例模式 - 懒汉式
 */
fun example02() {
    for (i in 1..3) {
        thread(start = true) {
            val instance: LazySingleton = LazySingleton.getInstance(0)
            println("线程" + i + "得到的对象ID：" + instance.id)
        }
    }
}

/*
 * 单例模式 - 懒汉同步式
 */
fun example03() {
    for (i in 1..3) {
        thread(start = true) {
            val instance: LazySyncSingleton = LazySyncSingleton.getInstance(0)
            println("线程" + i + "得到的对象ID：" + instance.id)
        }
    }
}

/*
 * 单例模式 - 双重校验锁式（不含初始化参数）
 */
fun example04() {
    for (i in 1..3) {
        thread(start = true) {
            val instance: LazyDCLSingleton = LazyDCLSingleton.getInstance()
            println("线程" + i + "得到的对象ID：" + instance.id)
        }
    }
}

/*
 * 单例模式 - 双重校验锁式（包含初始化参数）
 */
fun example05() {
    for (i in 1..3) {
        thread(start = true) {
            val instance: LazyDCLSingleton2 = LazyDCLSingleton2.getInstance(0)
            println("线程" + i + "得到的对象ID：" + instance.id)
        }
    }
}

/*
 * 单例模式 - 静态内部类式
 */
fun example06() {
    for (i in 1..3) {
        thread(start = true) {
            val instance: LazyInnerClassSingleton = LazyInnerClassSingleton.getInstance()
            println("线程" + i + "得到的对象ID：" + instance.id)
        }
    }
}
