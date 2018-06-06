package com.designpattern.structural.facade;

import com.designpattern.structural.facade.Samsung;

public class ShopKeeper {
	private MobileShop iphone;
	private MobileShop samsung;
	private MobileShop blackberry;

	public ShopKeeper(){
		iphone     = new IPhone();
		samsung    = new Samsung();
		blackberry = new BlackBerry();
	}

	public void iphoneSale(){
		iphone.modelNo();
		iphone.price();
	}

	public void samsungSale(){
		samsung.modelNo();
		samsung.price();
	}

	public void blackBerrySale(){
		blackberry.modelNo();
		blackberry.price();
	}
}
