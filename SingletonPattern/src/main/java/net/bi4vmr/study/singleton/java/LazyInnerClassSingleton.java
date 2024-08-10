package net.bi4vmr.study.singleton.java;

import java.util.UUID;

/**
 * Name        : net.bi4vmr.study.singleton.kt.LazySingleton
 * <p>
 * Author      : BI4VMR
 * <p>
 * Email       : bi4vmr@outlook.com
 * <p>
 * Date        : 2023-09-29 21:45
 * <p>
 * Description : 单例模式 - 懒汉式（延迟加载、线程安全、不支持初始化参数）。
 */
public class LazyInnerClassSingleton {

    // 对象标识符，构造对象时赋值，用于区分不同的对象。
    private final String id = UUID.randomUUID().toString();

    // 将构造函数设置为私有，禁止外部直接创建对象。
    private LazyInnerClassSingleton() {
        // 初始化操作...
    }

    // 对外公开的方法，供外界获取当前类的实例。
    public static LazyInnerClassSingleton getInstance() {
        return SingletonHolder.INSTANCE;
    }

    // 获取当前对象的标识符
    public String getID() {
        return id;
    }

    // 静态内部类，用于承载单例对象。
    private static class SingletonHolder {
        private static final LazyInnerClassSingleton INSTANCE = new LazyInnerClassSingleton();
    }
}
