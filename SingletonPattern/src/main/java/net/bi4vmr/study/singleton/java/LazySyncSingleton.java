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
 * Description : 单例模式 - 懒汉式（延迟加载、线程安全、"getInstance"方法效率不高）。
 */
public class LazySyncSingleton {

    // 当前类的实例变量
    private static LazySyncSingleton instance = null;

    // 对象标识符，构造对象时赋值，用于区分不同的对象。
    private final String id = UUID.randomUUID().toString();

    // 将构造函数设置为私有，禁止外部直接创建对象。
    private LazySyncSingleton(int arg1) {
        // 初始化操作...
        System.out.println("构造对象，读取初始化参数：" + arg1);
    }

    // 新增"synchronized"关键字，每次只允许一个线程进行操作。
    public static synchronized LazySyncSingleton getInstance(int arg1) {
        // 当前对象为空时，创建实例。
        if (instance == null) {
            instance = new LazySyncSingleton(arg1);
        }
        return instance;
    }

    // 获取当前对象的标识符
    public String getID() {
        return id;
    }
}
