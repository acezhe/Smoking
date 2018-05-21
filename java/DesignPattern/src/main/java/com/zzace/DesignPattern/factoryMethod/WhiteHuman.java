package com.zzace.DesignPattern.factoryMethod;

public class WhiteHuman implements Human {

	@Override
	public void getColor() {
		System.out.println("我有百皮肤。");
	}

	@Override
	public void talk() {
		System.out.println("我说乱语。");
	}

	@Override
	public void getSex() {
		System.out.println("我是女的。");
	}

}
