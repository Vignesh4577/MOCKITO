package com.vfislk.training;
import java.util.List;

public class Demo {

	public static void main(String[] args) {

		Delivery delivery = new Delivery();
		String msg=delivery.greetMessage(" jack");
		System.out.println(msg);
		List<String> dishs=delivery.showFood("NorthIndian");
		System.out.println(dishs);

	}

}
