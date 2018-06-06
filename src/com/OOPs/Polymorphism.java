package com.OOPs;
/*
 * Note the write() method is static, so the polymorphic behaviour does not apply here and in this case write method for w will be Writer.write()
 */

abstract class Writer{
	public static void write(){
		System.out.println("Writing.....");
	}
}

class Author extends Writer{
	public static void write(){
		System.out.println("Writing Book....");
	}
}

class Programmer extends Writer{
	public static void write(){
		System.out.println("Writing code....");
	}
}

public class Polymorphism {

	public static void main(String[] args) {
		Writer w = new Programmer();
		w.write();

	}

}
