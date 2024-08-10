package net.bi4vmr.study.singleton.java;

/**
 * Name        : net.bi4vmr.study.singleton.kt.SimpleSingleton
 * <p>
 * Author      : BI4VMR
 * <p>
 * Email       : bi4vmr@outlook.com
 * <p>
 * Date        : 2023-09-29 21:44
 * <p>
 * Description : 单例模式 - 饿汉式（非延迟加载、线程安全）。
 */
public class SimpleSingleton {

    // 当前类的实例变量，类加载时自动创建对象。
    private static final SimpleSingleton instance = new SimpleSingleton();

    // 将构造函数设置为私有，禁止外部直接创建对象。
    private SimpleSingleton() {
        // 初始化操作...
    }

    // 对外公开的方法，供外界获取当前类的实例。
    public static SimpleSingleton getInstance() {
        return instance;
    }

    // 业务方法
    public void function() {
        // 其他功能...
        System.out.println("net.bi4vmr.study.singleton.kt.SimpleSingleton:执行方法...");
    }
}
