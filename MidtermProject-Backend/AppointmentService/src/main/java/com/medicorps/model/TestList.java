package com.medicorps.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class TestList {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int testListId;
	private String testName;
	private int testCost;
	
	public TestList() {
		super();
	}
	public int getTestListId() {
		return testListId;
	}
	public void setTestListId(int testListId) {
		this.testListId = testListId;
	}
	public String getTestName() {
		return testName;
	}
	public void setTestName(String testName) {
		this.testName = testName;
	}
	public int getTestCost() {
		return testCost;
	}
	public void setTestCost(int testCost) {
		this.testCost = testCost;
	}
	
	
}
