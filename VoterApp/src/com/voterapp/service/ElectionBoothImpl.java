package com.voterapp.service;

import com.voterapp.exception.InValidVoterException;
import com.voterapp.exception.LocalityNotFoundException;
import com.voterapp.exception.NoVoterIDException;
import com.voterapp.exception.UnderAgeException;

public class ElectionBoothImpl implements IElectionBooth {

	@Override
	public boolean checkEligibility(int age, String locality, int vid) throws InValidVoterException {
		return checkAge(age);
		
	}
	private boolean checkAge(int age) throws Exception  {
		try {
			if(age<18) {
				throw new UnderAgeException("Age restricted");
			}else {
				System.out.println("Not eligible");
			}
		}catch(Exception e) {
			System.out.println(e);
			throw e;
		}
		return false;
	}
	private boolean checkLocality(String locality) throws LocalityNotFoundException {
		
		String[] street = {"Rajaginagar","pennya","vijayangar","basavnagudi","vidyanagar"};
		boolean error = false;
		try {
        for(String name:street) {
        	if(name.equals(street)) {
        		error=true;
        	}
        }
		}
        catch(Exception e) {
        	System.out.println(e);
        	throw e;
        }
        if(error) {
        	throw new LocalityNotFoundException("Not Eligiblepri....");
        }
        else {
        	System.out.println("Eligible");
        }
		return error;
	}
	private boolean checkVoterId(int voterId) throws NoVoterIDException{
		try {
		if(voterId>1000 || voterId<9999) {
			System.out.println("Eligible");
		}
		else {
			throw new NoVoterIDException();
		}
		
		}catch (Exception e) {
			System.out.println(e);
			throw e;
		}
		
		return false;	
	}

}
