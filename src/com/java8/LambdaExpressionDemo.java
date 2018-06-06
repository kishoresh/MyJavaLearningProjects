package com.java8;
/*
 * 1. Using Lambda expression w/o parameter
 * 2. Using Lambda expression with parameter
 * 3. Using Lambda expression forEach loop.
 * 4. Thread Using Lambda expression
 * 5. Comparator for sorting a list using Lambda expression
 * 6. Filtering a list using Lambda expression
 * 7. Using Stream - Get the sum of the total product list for products having ProductID > 1
 * > You may not use the return keyword if there is only one line in body, requires only for multiple line in the body. 
 */
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

interface Drawable{
	void draw();
}

interface Sayable{
	String Say(String name);
}

interface Addable{
	int Add(int a1, int a2);
}

class Product{
	int ProductID;
	String ProductName;
	float price;
	public Product(int a, String b, float c){
		this.ProductID = a;
		this.ProductName = b;
		this.price = c;		
	}
}

public class LambdaExpressionDemo {

	public static void main(String[] args) {
		int width = 10;
		
		//Without Lambda, Drawable implementation using Anonymous class
		Drawable d = new Drawable() {			
			@Override
			public void draw() {
				System.out.println("Drawing w/o Lambda : " + width);				
			}			
		};
		d.draw();
		
		//1. Using Lambda expression w/o parameter
		Drawable d2=()->{
			System.out.println("Drawing with Lambda : " + width);
		};
		d2.draw();
		
		//2. Using Lambda expression with parameter
		Sayable say = (name)->{
			return "Hello " + name;
		};
		System.out.println(say.Say("Kishore"));
		
		//2. Using Lambda expression with parameter
		Addable a = (a1,a2)->(a1+a2);
		System.out.println("Addition result =  " + a.Add(20, 30));
		
		//3. Using Lambda expression forEach loop.
		List<String> list = new ArrayList<String>();
		list.add("Kishore");
		list.add("Milli");
		list.add("Priyakshi");
		
		list.forEach(
				(n)->{					
					System.out.println("Hello "+n);					
				});
		
		//Thread Example w/o Lambda
		Runnable r1 = new Runnable() {			
			@Override
			public void run() {
				System.out.println("Thread is running....");				
			}
		};
		Thread t1 = new Thread(r1);
		t1.start();
		
		//4. Thread Using Lambda expression
		Runnable r2=()->{
			System.out.println("Thread is running from Lambda Expression ....");
		};
		Thread t2 = new Thread(r2);
		t2.start();
		
		//5. Comparator for sorting a list using Lambda expression
		List<Product> productList = new ArrayList<Product>();
		productList.add(new Product(1, "HP Laptop", 100.40F));
		productList.add(new Product(2, "Dell Laptop", 200.45F));
		productList.add(new Product(3, "Samsung Laptop", 234.90F));
		
		//Instead of Comparator class ref, LI for Comparator.compare() is implemented.
		System.out.println("Sorting of the Product List");
		Collections.sort(productList, (p1,p2)->{    
			return p1.ProductName.compareTo(p2.ProductName);
		});
		
		productList.forEach(
				(m)->{
					System.out.println(m.ProductID + " " + m.ProductName + " " + m.price);
				});
		
		//6. Filtering a list using Lambda expression. Filter for all products whose price > 200.00		
		Stream<Product> filteredProduct = productList.stream()
				                                             .filter(p->p.price > 200.00);		 
		System.out.println("Filtering of the Product List");
		filteredProduct.forEach(
				prod -> System.out.println(prod.ProductID + " " + prod.ProductName + " " + prod.price)
				);
		
		//7. Using Stream - Get the sum of the total product list for products having ProductID > 1
		Double totPrice = productList.stream().filter(p -> p.ProductID > 1)   //here p is Product the type contained by productList
				                              .mapToDouble(p -> p.price)                  
				                              .sum();
		System.out.println("Total Price (for productID > 2) = " + totPrice);
		
	}

}
