package com.wagnerandpei.incubate;

import java.util.ArrayList;
import java.util.Arrays;

public class Individual {

	final int AVAILABLE = 100;
	final int UNAVAILABLE = 50;
	
	int m_numberOfStudents;
	int m_numberOfTimeslots;
	Integer[] m_lecturerTimes;
	String[] m_studentDetails;
	Integer [][] m_matrix;
	Integer m_score;
	
	
	public Individual() {}
	
	public Individual(int numberOfStudents, int numberOfTimeSlots) {
		this.m_numberOfStudents = numberOfStudents;
		this.m_numberOfTimeslots = numberOfTimeSlots;
		this.m_matrix = new Integer [numberOfStudents][numberOfTimeSlots];
		this.m_score = 0;
	}
	
	public Individual(String studentDetailsList, String lecturerTimes) {
		//count names in list and times in list
		this.m_studentDetails = studentDetailsList.split("\\n+");
		this.m_numberOfStudents = this.m_studentDetails.length;
		String [] lecturerTimesArray = lecturerTimes.split(" ");
		this.m_numberOfTimeslots = lecturerTimesArray.length;
		this.m_lecturerTimes = new Integer[this.m_numberOfTimeslots];
		for (int i=0; i< this.m_numberOfTimeslots; i++) {
			this.m_lecturerTimes[i] = Integer.valueOf(lecturerTimesArray[i]);
		}
		Arrays.sort(this.m_lecturerTimes);
		//create matrix
		this.m_matrix = new Integer[this.m_numberOfStudents][this.m_numberOfTimeslots];
		//populate matrix from list
		for (int i=0; i<this.m_numberOfStudents; i++) {
			//get times and convert to ints
			String[] student = this.m_studentDetails[i].split(" ");
			ArrayList<Integer> times = new ArrayList<Integer>();
			for (int j = 3; j < student.length; j++ ) {
				times.add(Integer.valueOf(student[j]));
			}
			Integer[] IntegerTimes = new Integer[times.size()];
			IntegerTimes = times.toArray(IntegerTimes);
			//sort times
			Arrays.sort(IntegerTimes);
			//set matrix to 'Available' for each timeslot
			for (int j=0; j<this.m_lecturerTimes.length; j++) {
				boolean found = false;
				for (int k = 0; k < IntegerTimes.length; k++) {
					System.out.println("lecturer Time: " + this.m_lecturerTimes[j] + 
							" student time: " + IntegerTimes[k] +"!");
					
					if (this.m_lecturerTimes[j].equals(IntegerTimes[k])) {
						found = true;
						this.m_matrix[i][j] = AVAILABLE;
						System.out.println("Available time reached");
					}
					if (!found) this.m_matrix[i][j] = UNAVAILABLE;
				}
				
			}
		}
		
	}
	
	public Individual(int numberOfStudents, int numberOfTimeSlots, String[] studentDetailsList, 
			Integer [] lecturerTimes) {
		this.m_numberOfStudents = numberOfStudents;
		this.m_numberOfTimeslots = numberOfTimeSlots;
		this.m_studentDetails = new String[this.m_numberOfStudents];
		for (int i=0; i<studentDetailsList.length; i++) {
			this.m_studentDetails[i] = studentDetailsList[i];
		}
		this.m_lecturerTimes = new Integer[this.m_numberOfTimeslots];
		for (int i=0; i<this.m_numberOfTimeslots; i++) {
		this.m_lecturerTimes[i] = lecturerTimes[i];
		}
	}
	
	public Individual(int numberOfStudents, int numberOfTimeSlots, String[] studentDetailsList, 
			Integer [] lecturerTimes, Integer[][] matrix) {
		this.m_numberOfStudents = numberOfStudents;
		this.m_numberOfTimeslots = numberOfTimeSlots;
		this.m_studentDetails = new String[this.m_numberOfStudents];
		for (int i=0; i<studentDetailsList.length; i++) {
			this.m_studentDetails[i] = studentDetailsList[i];
		}
		this.m_lecturerTimes = new Integer[this.m_numberOfTimeslots];
		for (int i=0; i<this.m_numberOfTimeslots; i++) {
		this.m_lecturerTimes[i] = lecturerTimes[i];
		}
		this.m_matrix = new Integer [this.m_numberOfStudents][this.m_numberOfTimeslots];
		for (int i=0; i<this.m_numberOfStudents; i++) {
			for (int j=0; j<this.m_numberOfTimeslots; j++) {
				this.m_matrix[i][j] = matrix[i][j];
			}
		}
		
	}
	
	
	//copy constructor
	public Individual(Individual original) {
		this(original.getNumberOfStudents(), original.getNumberOfTimeslots(), 
				original.getStudentDetails(), original.getLecturerTimes(), original.getMatrix() );
	}
	
	public Integer getNumberOfStudents() {
		return this.m_numberOfStudents;
	}
	
	public Integer getNumberOfTimeslots() {
		return this.m_numberOfTimeslots;
	}
	
	public String[] getStudentDetails() {
		return this.m_studentDetails;
	}
	
	public Integer[] getLecturerTimes() {
		return this.m_lecturerTimes;
	}
	
	
	public Individual crossover (Individual otherParent, int cutPoint) {
		Individual child = new Individual(this.m_numberOfStudents, this.m_numberOfTimeslots, 
				this.m_studentDetails, this.m_lecturerTimes);
		Integer [][] childMatrix = new Integer[this.m_numberOfStudents][this.m_numberOfTimeslots];
		
		for (int i=0; i<cutPoint; i++) {
			childMatrix[i] = this.m_matrix[i];
		}
		for (int i = cutPoint; i<this.m_numberOfStudents; i++) {
			childMatrix[i] = otherParent.getLine(i);
		}
		child.addMatrix(childMatrix);
			
		return child;
	}
	
	public Integer[] getLine (int lineNumber) {
		return this.m_matrix[lineNumber];
	}
	
	public void addMatrix (Integer[][] matrix) {
		this.m_matrix = new Integer[matrix.length][matrix[0].length];
		for (int i=0; i<matrix.length; i++) {
			for (int j=0; j<matrix[i].length; j++) {
			this.m_matrix[i][j] = matrix[i][j];
			}
		}
	}
	
	public Integer[][] getMatrix() {
		return this.m_matrix;
	}
	
}
