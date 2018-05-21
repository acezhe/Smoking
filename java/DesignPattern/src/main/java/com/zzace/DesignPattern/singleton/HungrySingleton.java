package com.zzace.DesignPattern.singleton;

/**
 *  饿汉单例
 * @author zhangzhe
 *
 */
public class HungrySingleton {
	// 自动初始化一个实例
	private static final HungrySingleton singleton = new HungrySingleton();
	
	//  禁止外部对象创建该类实例
	private HungrySingleton() {
		
	}
	
	// 提供方法，始终返回初始化的实例
	public static HungrySingleton getSingleton() {
		return singleton;
	}
	
	// 类中其他方法，尽量是 static
	public static void doSomething() {
		
	}
}
