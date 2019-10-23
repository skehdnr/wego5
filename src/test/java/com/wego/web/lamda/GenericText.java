package com.wego.web.lamda;

import com.wego.web.usr.User;

public class GenericText {
	static class Box<T>{
		T item;
		void setItem(T item) {this.item = item;}
		T getItem() {return item;}
	}
	public static void main(String[] args) {
		GenericText s = new GenericText();
		GenericText.Box<String> s2 = new GenericText.Box<>();
		GenericText.Box<Integer> s3 = new GenericText.Box<>();
		GenericText.Box<User> uBox = new GenericText.Box<>();
	}
	
}
