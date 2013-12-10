package com.wagnerandpei.incubate;

import com.googlecode.objectify.annotation.*;
import java.util.ArrayList;

@Entity
public class Lecturer {

	@Id String lecturerID;
	
	String classes;
	ArrayList<String> classArray;
	
	private Lecturer () {}
	
	public Lecturer (String newLecturerID) {
		this.lecturerID = newLecturerID;
		this.classes = "";
		this.classArray = new ArrayList<String>();
	}
	
	public Lecturer (String newLecturerID, String className) {
		this.lecturerID = newLecturerID;
		this.classes = className;
		this.classArray = new ArrayList<String>();
		this.classArray.add(className);
	}
	
	public void addClass (String newClass) {
		this.classes += " " + newClass;
		this.classArray.add(newClass);
	}
	
	public String getClasses() {
		return this.classes;
	}
	
	public ArrayList<String> getClassArray() {
		return this.classArray;
	}
	
}
