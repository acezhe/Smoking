package com.zzace.DesignPattern.factoryMethod;

public class YellowHuman implements Human {

	@Override
	public void getColor() {
		System.out.println("我有黄皮肤。");

	}

	@Override
	public void talk() {
		System.out.println("我说正常话。");
	}

	@Override
	public void getSex() {
		System.out.println("我还是男的。");
	}

}
