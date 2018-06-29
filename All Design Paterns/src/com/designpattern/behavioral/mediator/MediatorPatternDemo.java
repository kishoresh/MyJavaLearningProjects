package com.designpattern.behavioral.mediator;

class ChatRoom{
	public static void showmessage(User usr, String msg){
		System.out.println();
	}
}

class User{
	private String name;
	public User(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void sendmessage(String msg){
		System.out.println("Messabe by " + getName());
	}
}

public class MediatorPatternDemo {

	public static void main(String[] args) {
		User user1 = new User("Kishore");
		User user2 = new User("Milli");
		User user3 = new User("Prisha");

	}

}
