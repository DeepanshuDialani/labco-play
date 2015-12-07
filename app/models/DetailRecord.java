package models;

import java.util.ArrayList;

public class DetailRecord {
	private int patientId;

	private String patientName;
	
	private String gender;
	
	private String testName;
	
	private ArrayList<TestFieldData> fieldList;
	
	public DetailRecord(int patientId, String patientName, String gender, 
			String testName, ArrayList<TestFieldData> fieldList) {
		this.patientId = patientId;
		this.patientName = patientName;
		this.testName = testName;
		this.gender = gender;
		this.fieldList = fieldList;
	}
	
	public int getPatientId() {
		return patientId;
	}
	
	public String getPatientName() {
		return patientName;
	}
	
	public String getGender() {
		return gender;
	}
	
	public String getTestName() {
		return testName;
	}
	
	public ArrayList<TestFieldData> getFieldList() {
		return fieldList;
	}
}
