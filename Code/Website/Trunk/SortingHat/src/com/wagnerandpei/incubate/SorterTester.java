package com.wagnerandpei.incubate;

//import com.wagnerandpei.incubate.Individual;

public class SorterTester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Welcome to the sorter tester!");
		String studentDetails = "2345 des wagner 110 210 310 \n"
				+ "2354 craig smith 210 313 510 \n"
				+ "7865 dominic patterson 310 209 412 \n"
				+ "4575 manu low 310 212 110";
		String lecturerTimes = "110 210 310 313 510 209 412 212";
		
		Individual first = new Individual(studentDetails, lecturerTimes);
		
		System.out.println("number students: " +first.getNumberOfStudents() + "\n" +
				"number timeslots: " + first.getNumberOfTimeslots() + "\n" +
				"Students:");
		
		
		String [] students = first.getStudentDetails();
		for (String student : students) {
			System.out.println(student);
		}
		
		System.out.println("timeslots: ");
		Integer[] timeslots = first.getLecturerTimes();
		for (Integer timeslot : timeslots) {
			System.out.println(timeslot);
		}
		
		Integer[][]matrix = first.getMatrix();
		
		for (Integer[] line : matrix) {
			for (Integer number : line) {
				System.out.println(number);
			}
		}
		
		Individual second = new Individual(first);
		
		System.out.println("number students: " +second.getNumberOfStudents() + "\n" +
				"number timeslots: " + second.getNumberOfTimeslots() + "\n" +
				"Students:");
		
		
		String [] students2 = second.getStudentDetails();
		for (String student : students2) {
			System.out.println(student);
		}
		
		System.out.println("timeslots: ");
		Integer[] timeslots2 = second.getLecturerTimes();
		for (Integer timeslot : timeslots2) {
			System.out.println(timeslot);
		}
		
		Integer[][]matrix2 = second.getMatrix();
		
		for (Integer[] line : matrix2) {
			for (Integer number : line) {
				System.out.println(number);
			}
		}
		
		second.m_lecturerTimes = new Integer[] {110, 112, 209, 210, 212, 310, 311, 313, 412, 509, 510 };
		
		System.out.println("First timeslots: ");
		Integer[] timeslots1 = first.getLecturerTimes();
		for (Integer timeslot : timeslots1) {
			System.out.println(timeslot);
		}
		
		System.out.println("Second timeslots: ");
		Integer[] timeslots2a = first.getLecturerTimes();
		for (Integer timeslot : timeslots2a) {
			System.out.println(timeslot);
		}
		
	}

}
