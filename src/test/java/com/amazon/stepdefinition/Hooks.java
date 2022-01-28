package com.amazon.stepdefinition;

import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks {

	@Before
	public void before() {
		System.out.println("Starts");
	}

	@After
	public void after() {
		System.out.println("The End");
	}
}
