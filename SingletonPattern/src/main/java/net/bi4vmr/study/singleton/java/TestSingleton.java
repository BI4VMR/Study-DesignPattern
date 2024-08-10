package net.bi4vmr.study.singleton.java;

/**
 * Name        : TestSingleton
 * <p>
 * Author      : BI4VMR
 * <p>
 * Email       : bi4vmr@outlook.com
 * <p>
 * Date        : 2023-09-29 21:44
 * <p>
 * Description : 测试类 - 单例模式。
 */
public class TestSingleton {

    public static void main(String[] args) {
        example05();
    }

    /*
     * 单例模式 - 饿汉式（非按需加载、线程安全）
     */
    static void example01() {
        // 调用SimpleSingleton的"getInstance"方法获取实例。
        SimpleSingleton instance = SimpleSingleton.getInstance();
        // 访问该对象的方法
        instance.function();
    }

    /*
     * 单例模式 - 懒汉式（按需加载、非线程安全）
     */
    static void example02() {
        // 使用多个线程获取实例
        for (int i = 1; i <= 3; i++) {
            final int index = i;
            new Thread(() -> {
                LazySingleton instance = LazySingleton.getInstance(0);
                System.out.println("线程" + index + "得到的对象ID：" + instance.getID());
            }).start();
        }
    }

    /*
     * 单例模式 - 懒汉式（按需加载、线程安全、"getInstance"方法效率不高）
     */
    static void example03() {
        // 使用多个线程获取实例
        for (int i = 1; i <= 3; i++) {
            final int index = i;
            new Thread(() -> {
                LazySyncSingleton instance = LazySyncSingleton.getInstance(0);
                System.out.println("线程" + index + "得到的对象ID：" + instance.getID());
            }).start();
        }
    }

    /*
     * 单例模式 - 懒汉式（按需加载、线程安全、"getInstance"方法效率较高）
     */
    static void example04() {
        // 使用多个线程获取实例
        for (int i = 1; i <= 3; i++) {
            final int index = i;
            new Thread(() -> {
                LazyDCLSingleton instance = LazyDCLSingleton.getInstance(0);
                System.out.println("线程" + index + "得到的对象ID：" + instance.getID());
            }).start();
        }
    }

    /*
     * 单例模式 - 懒汉式（按需加载、线程安全、实现简单、不支持初始化参数）
     */
    static void example05() {
        // 使用多个线程获取实例
        for (int i = 1; i <= 3; i++) {
            final int index = i;
            new Thread(() -> {
                LazyInnerClassSingleton instance = LazyInnerClassSingleton.getInstance();
                System.out.println("线程" + index + "得到的对象ID：" + instance.getID());
            }).start();
        }
    }
}
