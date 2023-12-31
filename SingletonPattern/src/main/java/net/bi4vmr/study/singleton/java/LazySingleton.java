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
 * Description : 单例模式 - 懒汉式（延迟加载、非线程安全）。
 */
public class LazySingleton {

    // 当前类的实例变量
    private static LazySingleton instance = null;

    // 对象标识符，构造对象时赋值，用于区分不同的对象。
    private final String id = UUID.randomUUID().toString();

    // 将构造函数设置为私有，禁止外部直接创建对象。
    private LazySingleton(int arg1) {
        // 初始化操作...
        System.out.println("构造对象，读取初始化参数：" + arg1);
    }

    // 对外公开的方法，供外界获取当前类的实例。
    public static LazySingleton getInstance(int arg1) {
        // 当前对象为空时，创建实例。
        if (instance == null) {
            instance = new LazySingleton(arg1);
        }
        return instance;
    }

    // 获取当前对象的标识符
    public String getID() {
        return id;
    }
}
