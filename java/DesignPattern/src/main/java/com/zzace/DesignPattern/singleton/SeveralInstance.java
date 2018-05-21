package com.zzace.DesignPattern.singleton;

import java.util.ArrayList;
import java.util.Random;

/**
 * 单例扩展，限制实例数量的模式
 * 
 * @author zhangzhe
 *
 */
public class SeveralInstance {
	// 可生成的实例数
	private static final int maxNumOfInstance = 3;

	// 保存实例的 list
	private static ArrayList<SeveralInstance> instanceList = new ArrayList<>();

	private static final Random random = new Random();

	// 初始化所有实例，也可像懒汉单例那样按需初始化
	static {
		for (int i = 0; i < maxNumOfInstance; i++) {
			instanceList.add(new SeveralInstance());
		}
	}

	// 获取实例的方式，可以根据实际情况灵活更改
	public SeveralInstance getInstance() {
		return instanceList.get(random.nextInt(maxNumOfInstance));
	}
}
