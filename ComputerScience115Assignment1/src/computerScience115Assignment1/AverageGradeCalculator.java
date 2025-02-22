package computerScience115Assignment1;

/*This program is for the assignment in CS-115.
  Program Author: Myranda Brandt*/

import java.util.Scanner;

public class AverageGradeCalculator {

	public static void main(String[] args) {
	
	/*The first step in the assignment is to print out the program 
	 * specifications for the project*/
	System.out.println("This program will create an average grade calculator.");
	System.out.println("The user will enter up to ten quiz scores.");
	System.out.println("The program will then calculate the average score.");
	System.out.println("The grade letter of the the average score will be displayed.");
	Scanner grade = new Scanner(System.in);	
	int gradeEntered = 0;
	
	while (gradeEntered != 999) {
	System.out.println("Enter a grade from a quiz:");
	gradeEntered = grade.nextInt();
	    if (gradeEntered == 999) {
	    	System.out.println("Thank you for submitting your grades!");
	    	break;
	    }
	System.out.println("Enter 999 to quit.");
	}
	
	}
	
}
