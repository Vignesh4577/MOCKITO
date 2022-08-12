package com.voterapp.main;

import java.util.Scanner;

import com.voterapp.service.ElectionBoothImpl;
import com.voterapp.service.IElectionBooth;

public class Voter {

	public static void main(String[] args) {
		
		IElectionBooth booth = new ElectionBoothImpl();
		
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter age");
		int age=scan.nextInt();
		
		System.out.println("Enter Locality");
		String local = scan.next();
		
		System.out.println("Enter voter Id");
		int voterId=scan.nextInt();
		
		try{
			if(booth.checkEligibility(age, local, voterId)) {
				System.out.println("Eligible");
			}
		}catch (Exception e) {
			e.printStackTrace();
		}

	}

}
