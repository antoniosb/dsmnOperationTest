package br.com.teltools.testsuite;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class TestRunner {
//	public static void main(String[] args) {
//		Result result = JUnitCore.runClasses(JUnitTestSuite.class);
//		for(Failure failure : result.getFailures()){
//			System.out.println(failure.toString());
//		}
//		System.out.println(result.wasSuccessful());
//	}
	
	@Test
	public void runAllTests(){
		Result result = JUnitCore.runClasses(JUnitTestSuite.class);
		for(Failure failure : result.getFailures()){
		System.out.println(failure.toString());
		}
		assertTrue(result.wasSuccessful());
	}
	
}//132requests
