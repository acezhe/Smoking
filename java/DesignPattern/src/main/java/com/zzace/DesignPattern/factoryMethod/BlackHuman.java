package com.zzace.DesignPattern.factoryMethod;

public class BlackHuman implements Human {

	@Override
	public void getColor() {
		System.out.println("我有黑皮肤。");
	}

	@Override
	public void talk() {
		System.out.println("我说鬼话。");
	}

	@Override
	public void getSex() {
		System.out.println("我是人妖。");
	}

}
