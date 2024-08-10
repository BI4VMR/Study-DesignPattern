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
 * Description : 单例模式 - 懒汉式（延迟加载、线程安全、"getInstance"方法效率较高）。
 */
public class LazyDCLSingleton {

    // 使用"volatile"关键字禁止指令重排序，防止出现异常。
    private volatile static LazyDCLSingleton instance = null;

    // 对象标识符，构造对象时赋值，用于区分不同的对象。
    private final String id = UUID.randomUUID().toString();

    // 将构造方法设置为私有，禁止外部直接创建对象。
    private LazyDCLSingleton(int arg1) {
        // 初始化操作...
        System.out.println("构造对象，读取初始化参数：" + arg1);
    }

    // 对外公开的方法，供外界获取当前类的实例。
    public static LazyDCLSingleton getInstance(int arg1) {
        // 仅在实例未创建时进入同步区域
        if (instance == null) {
            synchronized (LazyDCLSingleton.class) {
                // 二次判断，防止当前线程通过判断后休眠，此时其他线程成功创建实例，当前线程再恢复导致异常。
                if (instance == null) {
                    instance = new LazyDCLSingleton(arg1);
                }
            }
        }
        return instance;
    }

    // 获取当前对象的标识符
    public String getID() {
        return id;
    }
}
