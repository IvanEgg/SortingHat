package com.wagnerandpei.incubate;

import com.googlecode.objectify.annotation.*;;


@Entity
public class ClassTimes {

	@Id String className;
	
	//lecturer times is a string separated by spaces of numbers
	//which indicate 1-7 for days of the week, followed by two numbers indicating hour of day
	// dhh
	String lecturerTimes;
	
	//students is a long string consisting of a series of entries of the format
	//student number, student name and times
	//times are of the same format as lecturer times with an additional digit indicating
	//the category of the selection (available, unavailable, preferred)
	String students;
	
	String lecturer;
	
	private ClassTimes() {}
	
	public ClassTimes(String newClassName, String newLecturerTimes) {
		this.className = newClassName;
		this.lecturerTimes = newLecturerTimes;
	}
	
	public ClassTimes(String newClassName, String newLecturerTimes, String newLecturer ) {
		this.className = newClassName;
		this.lecturerTimes = newLecturerTimes;
		this.lecturer = newLecturer;
	}
	
	public String getClassName() {
		return this.className;
	}
	
	public void addStudent (String studentDetails) {
		this.students += studentDetails;
	}
	
	public String getLecturerTimes () {
		return this.lecturerTimes;
	}
	
	public void replaceStudentList (String studentList) {
		this.students = studentList;
	}
	
}
