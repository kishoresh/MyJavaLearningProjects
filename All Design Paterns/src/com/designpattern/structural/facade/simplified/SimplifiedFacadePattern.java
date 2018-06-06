package com.designpattern.structural.facade.simplified;
/*
 * Wanted to simplify the existing Mobile-Shop facade demo
 */
import java.util.HashMap;
import java.util.Map;

interface Mobile{	
	public void price(String modelNo);
}

class Samsung implements Mobile{
	Map<String, Double> modelList = new HashMap<>();
	@Override
	public void price(String modelNo) {
		// TODO Auto-generated method stub
		
	}
}

class IPhone implements Mobile{
	@Override
	public void price(String modelNo) {
		// TODO Auto-generated method stub
		
	}
}

public class SimplifiedFacadePattern {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
