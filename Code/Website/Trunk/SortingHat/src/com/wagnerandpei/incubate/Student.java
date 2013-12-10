package com.wagnerandpei.incubate;

import java.util.List;
import java.util.ArrayList;

public class Student {

	String studentNumber = "";
	String firstName = "";
	String lastName = "";
	
	List<Integer> availableTimes = new ArrayList<Integer>();
	
	public Student() {
		
	}
	
	public Student(String inStudentNumber, String inFirstName, String inLastName, Integer[] times) {
		studentNumber = inStudentNumber;
		firstName = inFirstName;
		lastName = inLastName;
		
		for (int i=0; i< times.length; i++) {
			availableTimes.add(times[i]);
		}
	}
	
	public Student(String inStudentNumber, String inFullName, Integer[] times) {
		studentNumber = inStudentNumber;
		String [] names = inFullName.split("\\s+");
		firstName = names[0];
		lastName = names[1];
		
		for (int i=0; i< times.length; i++) {
			availableTimes.add(times[i]);
		}
		
	}
	
	public void setStudentNumber(String newStudentNumber) {
		studentNumber = newStudentNumber;
	}
	
	public String getStudentNumber() {
		return studentNumber;
	}
	
	public void setFirstName(String inFirstName) {
		firstName = inFirstName;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setLastName(String inLastName) {
		lastName = inLastName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void addTime (Integer time) {
		availableTimes.add(time);
	}
	
	public void addTime (String time) {
		availableTimes.add(Integer.valueOf(time));
	}
	
	public String getDetails() {
		String details = getStudentNumber() + " " 
				+ getFirstName() + " " + getLastName();
		
		for (Integer time : availableTimes) {
			details += " ";
			details += time;
		}
		
		return details;
	}
}
