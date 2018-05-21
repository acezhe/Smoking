package com.zzace.DesignPattern.singleton;

/**
 * 懒汉单例
 * 
 * @author zhangzhe
 *
 */
public class LazySingleton {
	// 未初始化的实例
	private static LazySingleton singleton = null;

	// 禁止外部创建该对象
	private LazySingleton() {

	}

	// 返回单例实例，若实例未初始化，则初始化实例
	public synchronized static LazySingleton getSingleton() {
		if (null == singleton) {
			singleton = new LazySingleton();
		}
		return singleton;
	}

	// 类中其他方法，尽量是 static
	public static void doSomething() {

	}
}
