package com.zzace.DesignPattern.factoryMethod;

public class NvWa {

	public static void main(String[] args) {

		HumanFactory factory = new HumanFactory();
		
		System.out.println("----烧过了");
		Human black = factory.createHuman(BlackHuman.class);
		black.getColor();
		black.talk();
		black.getSex();
		
		System.out.println("----没烧够");
		Human white = factory.createHuman(WhiteHuman.class);
		white.getColor();
		white.talk();
		white.getSex();
		
		System.out.println("----刚刚好");
		Human yellow = factory.createHuman(YellowHuman.class);
		yellow.getColor();
		yellow.talk();
		yellow.getSex();
	}

}
