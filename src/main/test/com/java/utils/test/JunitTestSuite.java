package com.java.utils.test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)

/**
 * 
 * super test class, just run
 * 
 * @author albertocerqueira
 *
 */
@Suite.SuiteClasses({ 
	TestArrayUtils.class, 
	TestDateUtils.class, 
	TestDoubleUtils.class, 
	TestIntegerUtils.class,
	TestStringUtils.class,
	TestValidationUtils.class,
	TetNumberUtils.class
})
public class JunitTestSuite {

	
}