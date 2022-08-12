package com.vfislk.training;

import java.util.Arrays;
import java.util.List;

public class Delivery {

	public List<String> showFood(String type) {

		if(type.equals("NorthIndian"))
			return Arrays.asList("BenneDosa","OpenDosa","Puri","Roti");

		if(type.equals("SouthIndian"))
			return Arrays.asList("Idli","Pulav","pongal","RagiBall");

		if(type.equals("Chinese"))
			return Arrays.asList("Nodeles","FrenchFries");
		return null;

	}

	public String greetMessage(String name) {
		return "Great Day"+name;

	}
}
