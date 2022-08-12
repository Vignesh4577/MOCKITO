package com.voterapp.service;

import com.voterapp.exception.InvalidVoterException;

public interface IElectionBooth {

	boolean checkEligibility(int age,String locality,int vid)throws InvalidVoterException;
	
}
