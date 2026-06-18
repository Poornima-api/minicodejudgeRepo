package com.minicodejudge.service;

public class EvaluationService {
public String evaluate(String actualOutput,String expectedOutput) {
	if(actualOutput.trim().equals((expectedOutput).trim())){
		return "PASSED";
	}
		else
			return "FAILED";
	}
}

