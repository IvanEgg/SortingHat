package com.wagnerandpei.incubate;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.nio.file.*;
import java.nio.charset.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;

import static com.wagnerandpei.incubate.OfyService.ofy;

@SuppressWarnings("serial")
public class ListGeneratorServlet extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		//resp.setContentType("text/plain");
		//resp.getWriter().println("Hello, world from list generator");
		HttpSession session = request.getSession();
		main(request, session);
		RequestDispatcher rd = request.getRequestDispatcher("classManagementPage.jsp");
		try {
		rd.forward(request, response);
		} catch (ServletException e) {
			e.getMessage();
		}
	}



public void main(HttpServletRequest request, HttpSession session) {
		// TODO Auto-generated method stub
//create list: student number, student name, meeting times
		//list of size n, determined by input argument
		//number of potential meeting times per student,
		//determined by input argument
		
		List<String> fullList = new ArrayList<String>();
		int numOfStudents = Integer.valueOf(request.getParameter("numberOfStudents"));
		//if (args.length > 0) numOfStudents = Integer.valueOf(args[0]);
		int numOfTimes = 3;
		//if (args.length > 1) numOfTimes = Integer.valueOf(args[1]);
		Student[] students = new Student[numOfStudents];
		
		String names = populateNames();
		String [] namesArray = names.split("\n");
		List<String> namesList = new ArrayList<String>(Arrays.asList(namesArray));

		
		List<Integer> lecturerTimes = new ArrayList<Integer> ();
		
			
		
		String className = (String) session.getAttribute("className");
		ClassTimes classinfo = ofy().load().type(ClassTimes.class).id(className).now();
		System.out.println("#"+className +"#");
		
		if (classinfo != null) {
			String lecturerTimesString = classinfo.getLecturerTimes();
			String [] times = lecturerTimesString.split(" ");
			for (String item: times) {
				Integer meetingTime = Integer.parseInt(item);
				lecturerTimes.add(meetingTime);
			}
			//System.out.println("class info: " + classinfo.getClassName());
		
		} 
		//session.setAttribute("class", classinfo);
		
		
		for (Student student : students) {
			String studentNumber ="";
			String firstName = "";
			String lastName = "";
			String fullName = "";
			Integer [] potentialTimes = new Integer[numOfTimes];
			//randomly generate student number
			studentNumber = generateStudentNumber();
			
			
			//randomly choose name
			fullName = generateStudentName(namesList);
			//randomly choose times from range specified in LecturerSelection.txt
			//and amount of times specified by args[1]
			potentialTimes = generateMeetingTimes(numOfTimes, lecturerTimes);
			
			
			student = new Student(studentNumber, fullName, potentialTimes);
			fullList.add(student.getDetails());
		}
		
		String studentList = fullList.toString();
		
		classinfo.replaceStudentList(studentList);
		
		ofy().save().entity(classinfo).now();
		
			
	}

	public static String generateStudentNumber() {
		String studentNumber = "";
		studentNumber = "a";
		int minStudentNumber = 1600000;
		int maxStudentNumber = 1900000;
		
		int newnum = minStudentNumber + (int)(Math.random() * 
				((maxStudentNumber - minStudentNumber) +1));
		String newnumber = String.valueOf(newnum);
		studentNumber += newnumber;		
		return studentNumber;
		
	}
	
	public static String generateStudentName(List<String> namesList) {
		String fullName = "";
		//open name file
		
		//choose name
		int numOfNames = namesList.size();
		//System.out.println(numOfNames);
		int indexOfName = (int)(Math.random() * numOfNames );
		//System.out.println(indexOfName);
		String nameString = namesList.get(indexOfName);
		String [] nameStringParts = nameString.split(" ");
		//for (String part : nameStringParts) {
			//System.out.println(part);
		//}
		fullName = nameStringParts[0] + " " + nameStringParts[1];
		
		return fullName;
	}
	
	public static Integer[] generateMeetingTimes(int numOfTimes, List<Integer> lecturerTimes) {
		Integer [] times = new Integer[numOfTimes];
		Integer [] choices = new Integer [numOfTimes];
		int numOfChoices = lecturerTimes.size();
		
		for (int i = 0; i < numOfTimes; i++ ) {
			boolean done = false;

			while (!done) {
				//randomly choose an unchosen time
				int choice = (int) (Math.random() * numOfChoices);
				boolean newChoice = true;
				/*for (int check : choices) {
					if (check == choice) newChoice = false;
				}*/

				if (newChoice) {
					times[i] = lecturerTimes.get(choice);
					choices[i] = choice;
					done = true;
				}
			}
		}
		
		
		return times;
	}
	
	public String populateNames() {
		String names = "Lennie Vicari  " + "\n" +
				"Alverta Talcott  " + "\n" +
				"Deirdre Mcnamara  " + "\n" +
				"Toshia Dorn  " + "\n" +
				"Sandy Laureano  " + "\n" +
				"Leandra Ulrich  " + "\n" +
				"Melida Krumm  " + "\n" +
				"Taina Mcglothin  " + "\n" +
				"Dominick Grist  " + "\n" +
				"Orpha Coomer  " + "\n" +
				"Carmelia Schiavone  " + "\n" +
				"Jo Kibby  " + "\n" +
				"Collen Emig  " + "\n" +
				"Dorathy Truss  " + "\n" +
				"Edelmira Mccrimmon  " + "\n" +
				"Diann Levert  " + "\n" +
				"Sondra Quon  " + "\n" +
				"Freddy Gigliotti  " + "\n" +
				"Lakeisha Durkin  " + "\n" +
				"Stuart Reali  " + "\n" +
				"Teddy Badilla  " + "\n" +
				"Alfredia Bazile  " + "\n" +
				"Rayford Hoerr  " + "\n" +
				"Jan Basaldua  " + "\n" +
				"Weston Nugent  " + "\n" +
				"Belva Classen  " + "\n" +
				"Linnea Botelho  " + "\n" +
				"Anette Siple  " + "\n" +
				"Edwardo Speirs  " + "\n" +
				"Emerald Luckett  " + "\n" +
				"Jacalyn Torbett  " + "\n" +
				"Marcell Kelson  " + "\n" +
				"Albertine Neill  " + "\n" +
				"Veronica Jacquemin  " + "\n" +
				"Darline Coday  " + "\n" +
				"Phillip Moloney  " + "\n" +
				"Carmela Degroff  " + "\n" +
				"Almeda Lykins  " + "\n" +
				"Treasa Harder  " + "\n" +
				"Roxann Weglarz  " + "\n" +
				"Cyril Skiba  " + "\n" +
				"Alla Harker  " + "\n" +
				"Ashly Newson  " + "\n" +
				"Tamela Devine  " + "\n" +
				"Conception Sturgeon  " + "\n" +
				"Lauran Zajicek  " + "\n" +
				"Paige Cheadle  " + "\n" +
				"George Cyphers  " + "\n" +
				"Deandra Araya  " + "\n" +
				"Brigette Atwood  " + "\n" +
				"Ria Sandell  " + "\n" +
				"Noriko Kamerer  " + "\n" +
				"Lorena Redel  " + "\n" +
				"Halley Lykins  " + "\n" +
				"Ji Giraud  " + "\n" +
				"Celestina Cousin  " + "\n" +
				"Rosalba Najera  " + "\n" +
				"Natacha Gloor  " + "\n" +
				"Amie Roquemore  " + "\n" +
				"Mariko Mabrey  " + "\n" +
				"Edda Haskin  " + "\n" +
				"Danielle Twitchell  " + "\n" +
				"Lakeshia Granda  " + "\n" +
				"Malka Haught  " + "\n" +
				"Ivana Marty  " + "\n" +
				"Tim Sproul  " + "\n" +
				"Carmelo Renaud  " + "\n" +
				"Krystyna Wickliffe  " + "\n" +
				"Heidi Douse  " + "\n" +
				"Edelmira Wetherington  " + "\n" +
				"Roger Rey  " + "\n" +
				"Marnie Batty  " + "\n" +
				"Jerilyn Eichhorn  " + "\n" +
				"Verline Corea  " + "\n" +
				"Maple Depaz  " + "\n" +
				"Denae Runnels  " + "\n" +
				"Shiela Cordray  " + "\n" +
				"Joetta Nordyke  " + "\n" +
				"Elissa Landaverde  " + "\n" +
				"Laree Sainz  " + "\n" +
				"Tamala Defazio  " + "\n" +
				"Marx Marcella  " + "\n" +
				"Phil Gillison  " + "\n" +
				"Clementine Flemons  " + "\n" +
				"Sheena Tyra  " + "\n" +
				"Kiesha Miramontes  " + "\n" +
				"Gilbert Kesten  " + "\n" +
				"Berenice Leighty  " + "\n" +
				"Nobuko Spencer  " + "\n" +
				"Elyse Shippee  " + "\n" +
				"Sommer Hoglund  " + "\n" +
				"Honey Brenes  " + "\n" +
				"Roderick Witherspoon  " + "\n" +
				"Shyla Faul  " + "\n" +
				"Tyrell Pettit  " + "\n" +
				"Norine Lecuyer  " + "\n" +
				"Arleen Branch  " + "\n" +
				"Harriette Degree  " + "\n" +
				"Leeanne Parrish  " + "\n" +
				"Elois Pua  " + "\n" +
				"Kala Kahl  " + "\n" +
				"Roma Widger  " + "\n" +
				"Ludivina Tavarez  " + "\n" +
				"Matilda Newingham  " + "\n" +
				"Gil Pacheo  " + "\n" +
				"Arnette Bross  " + "\n" +
				"Rodger Rask  " + "\n" +
				"Reynalda Bagdon  " + "\n" +
				"Marlys So  " + "\n" +
				"Velma Weidenbach  " + "\n" +
				"Vita Suazo  " + "\n" +
				"Valery Cude  " + "\n" +
				"Sanora Crampton  " + "\n" +
				"Annabelle Naslund  " + "\n" +
				"Perry Reali  " + "\n" +
				"Tanja Shrewsbury  " + "\n" +
				"Anibal Vickers  " + "\n" +
				"Latasha Mclaughin  " + "\n" +
				"Fernanda Nies  " + "\n" +
				"Verla Stancil  " + "\n" +
				"Tonya Cottone  " + "\n" +
				"Saul Moreton  " + "\n" +
				"Roxie Hester  " + "\n" +
				"Shenika Saterfiel  " + "\n" +
				"Hank Swartz  " + "\n" +
				"Donita Rabin  " + "\n" +
				"Maida Demers  " + "\n" +
				"Monika Plourde  " + "\n" +
				"Erline Devore  " + "\n" +
				"Lauretta Sturm  " + "\n" +
				"Yadira Raleigh  " + "\n" +
				"Kathyrn Milardo  " + "\n" +
				"Milly Algarin  " + "\n" +
				"Karleen Rasheed  " + "\n" +
				"Ron Stickles  " + "\n" +
				"Klara Brock  " + "\n" +
				"Jacqualine Lindow  " + "\n" +
				"Landon Lynes  " + "\n" +
				"Isa Neary  " + "\n" +
				"Ivy Schiefelbein  " + "\n" +
				"Izetta Burroughs  " + "\n" +
				"Jesus Eichner  " + "\n" +
				"Gilda Langhorne  " + "\n" +
				"Mafalda Zwart  " + "\n" +
				"Kandi Pagel  " + "\n" +
				"Earnest Auzenne  " + "\n" +
				"Lasonya Milano  " + "\n" +
				"Sandie Ebersole  " + "\n" +
				"Madison Hofman  " + "\n" +
				"Reina Husband  " + "\n" +
				"Kum Wetherby  " + "\n" +
				"Alexis Brekke  " + "\n" +
				"Layne Yamamoto  " + "\n" +
				"Erwin Pino  " + "\n" +
				"Star Nehls  " + "\n" +
				"Gonzalo Hiles  " + "\n" +
				"Keven Pier  " + "\n" +
				"Jeannie Skow  " + "\n" +
				"Carolyn Leib  " + "\n" +
				"Debra Dedios  " + "\n" +
				"Chasidy Woelfel  " + "\n" +
				"Chloe Emerson  " + "\n" +
				"Dusty Khalil  " + "\n" +
				"Ingeborg Arvie  " + "\n" +
				"Kenna Rippey  " + "\n" +
				"Margit Lockhart  " + "\n" +
				"Ciera Lincoln  " + "\n" +
				"Maricruz Garrick  " + "\n" +
				"Cathey Olguin  " + "\n" +
				"Elna Volker  " + "\n" +
				"Xiomara Caliendo  " + "\n" +
				"Francina Orlando  " + "\n" +
				"Ross Osterhoudt  " + "\n" +
				"Karly Chain  " + "\n" +
				"Claribel Munsey  " + "\n" +
				"Love Burrage  " + "\n" +
				"Felicitas Wein  " + "\n" +
				"Dollie Teegarden  " + "\n" +
				"Margurite Ackley  " + "\n" +
				"Leann Schippers  " + "\n" +
				"Alonzo Jager  " + "\n" +
				"Meridith Giglio  " + "\n" +
				"Jarrod Kok  " + "\n" +
				"Christal Luque  " + "\n" +
				"Yung Chynoweth  " + "\n" +
				"Miyoko Adrian  " + "\n" +
				"Dyan Laskowski  " + "\n" +
				"Luis Keever  " + "\n" +
				"Amie Gholston  " + "\n" +
				"Shondra Alire  " + "\n" +
				"Rozella Kittredge  " + "\n" +
				"Jenifer Newman  " + "\n" +
				"Pierre Cutshall  " + "\n" +
				"Karyl Savant  " + "\n" +
				"Seymour Spidle  " + "\n" +
				"Cara Huey  " + "\n" +
				"Kelsie Carol  " + "\n" +
				"Reyna Hodges  " + "\n" +
				"Lindsy Kirst  " + "\n" +
				"Merna Waguespack  " + "\n" +
				"Taylor Aguinaga  " + "\n" +
				"Elvin Gratton  " + "\n" +
				"Martha Nesbit  " + "\n" +
				"Mohammad Ranson  " + "\n" +
				"Mammie Creason  " + "\n" +
				"Keira Marcum  " + "\n" +
				"Cher Isler  " + "\n" +
				"Delores Agin  " + "\n" +
				"Rebbeca Shortt  " + "\n" +
				"Joni Usher  " + "\n" +
				"Sona Sklar  " + "\n" +
				"Sachiko Lauzon  " + "\n" +
				"Marta Lush  " + "\n" +
				"Avelina Maiden  " + "\n" +
				"Pinkie Randel  " + "\n" +
				"Dewayne Bellows  " + "\n" +
				"Salley Nelsen  " + "\n" +
				"Ashanti Poitras  " + "\n" +
				"Danille Fitzmaurice  " + "\n" +
				"Fawn Guttman  " + "\n" +
				"Emilia Bucci  " + "\n" +
				"Reggie Harton  " + "\n" +
				"Christene Soldner  " + "\n" +
				"Corrina Liverman  " + "\n" +
				"Samuel Foston  " + "\n" +
				"Kristopher Devine  " + "\n" +
				"Gricelda Kehoe  " + "\n" +
				"Raina Albarado  " + "\n" +
				"Harmony Thibeaux  " + "\n" +
				"Cecila Macdougall  " + "\n" +
				"Tashia Brezinski  " + "\n" +
				"Annamarie Countess  " + "\n" +
				"Rosio Farkas  " + "\n" +
				"Mona Hegwood  " + "\n" +
				"Mabelle Kessel  " + "\n" +
				"Joellen Richarson  " + "\n" +
				"Hiram Pettit  " + "\n" +
				"Susana Padgett  " + "\n" +
				"Warner Oglesby  " + "\n" +
				"Doris Northington  " + "\n" +
				"Lauri Yarborough  " + "\n" +
				"Madelyn Keith  " + "\n" +
				"Jeanne Broadwell  " + "\n" +
				"Ahmad Necessary  " + "\n" +
				"Stacia Crumble  " + "\n" +
				"Karan Stanforth  " + "\n" +
				"Mitzi Hartwell  " + "\n" +
				"Candie Innes  " + "\n" +
				"Delsie Lafferty  " + "\n" +
				"Earnestine Slovak  " + "\n";
			
		return names;
	}
	
}
