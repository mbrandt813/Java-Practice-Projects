package computerScience115Assignment1;

/*This program is for the assignment in CS-115.
  Program Author: Myranda Brandt*/

import java.util.Scanner;
import java.util.ArrayList;

public class AverageGradeCalculator {

	public static void main(String[] args) {
	
	/*The first step in the assignment is to print out the program 
	 * specifications for the project*/
	System.out.println("This program will create an average grade calculator.");
	System.out.println("The user will enter up to ten quiz scores.");
	System.out.println("The program will then calculate the average score.");
	System.out.println("The grade letter of the the average score will be displayed.");
	
	/*the second step in the assignment is to get input from the user to enter quiz
	 * grades. To do this I will create an instance of the Scanner class*/
	Scanner grade = new Scanner(System.in);	
	
	//Now I need something to hold the grade entered.
	int gradeEntered = 0;
	
	/*The third step in the assignment is to create an array to hold the quiz grades
	 * entered by the user. I will use an ArrayList since a normal array does not 
	 * allow things to be added after intilization and I would like to avoid having 
	 * zeros if the user does not enter all ten grades.*/
	ArrayList<Integer> gradeList = new ArrayList<Integer>();
	
	/*Here I have made a while loop that will continue to loop as long as the size of
	 * the array list is still less then 10. I choose ten because a value only gets 
	 * added to the array after the loop runs, so when the tenth value gets added it
	 * will stop looping. */
	while (gradeList.size() < 10) {
		//Ask the user to enter a grade.
	    System.out.println("Enter a grade from a quiz:");
	    //When the user enters a grade assign it to the gradeEntered instance.
	    gradeEntered = grade.nextInt();
	    /*If the grade entered was the code for stopping the program, display a
	     *display a message to the user letting them know the grade entering 
	     *process has stopped and break out of the while loop.*/
	        if (gradeEntered == 999) {
	    	    System.out.println("Thank you for submitting your grades!");
	    	    break;
	    /*If the user enters a grade higher than 100 OR less than 0 let them know that
	     * is an invalid grade and do not add the grade to the array.*/
	        } else if (gradeEntered > 100 || gradeEntered < 0){
	        	System.out.println("Error: That is an invalid quiz grade, try again!");
	        	continue;
	        }
	        
	    gradeList.add(gradeEntered);
	/*Now that at least one grade has been entered let the user know they can stop
	 *entering grades by typing 999.*/ 
	System.out.println("Enter 999 to quit.");
	//Add the valid grade to the ArrayList.
	System.out.println(gradeList.size());
	}

	/*The fourth step in the assignment is to print all grade that were entered.*/
	for (int i = 0; i < gradeList.size(); i++) {
		/*I want to display the number of the quiz in the print out but still use
		the correct index number so I will create an instance to hold the quiz number*/
		int quizNum = i + 1;
		System.out.println("Quiz " + quizNum + " Grade: " + gradeList.get(i)); 
		System.out.println(i);
	}
	}
	
}
