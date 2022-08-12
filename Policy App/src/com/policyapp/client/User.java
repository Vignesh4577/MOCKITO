package com.policyapp.client;

import com.policy.exceptions.IdNotFoundException;
import com.policy.exceptions.PolicyNotFoundException;
import com.policy.service.IPolicyService;
import com.policy.service.PolicyServiceImpl;

public class User {

	public static void main(String[] args) {

		IPolicyService policyServices = new PolicyServiceImpl();

		try {
			
			policyServices.getAll().forEach(System.out::println);
			System.out.println();
			
			policyServices.getByType("singel").forEach(System.out::println);
			System.out.println();
			
			policyServices.getByCategory("marriage").forEach(System.out::println);
			System.out.println();
			
			policyServices.getByHighSumAssured(200000).forEach(System.out::println);
			System.out.println();
			
			policyServices.getByCoverage("endowment").forEach(System.out::println);
			System.out.println();
			
			policyServices.getByLessPremium(2000).forEach(System.out::println);
			System.out.println();
			
			System.out.println(policyServices.getById(188));

			
		} catch (PolicyNotFoundException | IdNotFoundException e) {
			System.out.println(e.getMessage());
		}

	}

}

