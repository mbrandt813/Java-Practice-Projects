package computerScience201Assignment2;

//I want to get input from the user so i will import the scanner class first.
import java.util.Scanner;

public class SearchTextAndString50States {
//To start I will make an array of the fifty states.
	public static final String[] fiftyStates = {
	   "Alabama", "Alaska", "Arizona", "Arkansas", "California", 
	   "Colorado", "Connecticut", "Delaware", "Florida", "Georgia",
	   "Hawaii", "Idaho", "Illinois", "Indiana", "Iowa",
	   "Kansas", "Kentucky", "Louisiana", "Maine", "Maryland",
	   "Massachusetts", "Michigan", "Minnesota", "Mississippi", "Missouri",
	   "Montana", "Nebraska", "Nevada", "New Hampshire", "New Jersey",
	   "New Mexico", "New York", "North Carolina", "North Dakota", "Ohio",
	   "Oklahoma", "Oregon", "Pennsylvania", "Rhode Island", "South Carolina",
	   "South Dakota", "Tennessee", "Texas", "Utah", "Vermont",
	   "Virginia", "Washington", "West Virginia", "Wisconsin", "Wyoming"
	};
	
	/* The first option in the menu will be to display all the states. I will make a
	method that will list out each state by iterating through the array.*/
	public static void listOutStates() {
		System.out.println("Fifty States of America:");
		for (String state : fiftyStates) {
			System.out.println(state);
		}
	}
	
//Now I will make my main class to start the program.
	public static void main(String[] args) {
	/*I'm getting input from a user so I need to make an instance of the scanner
	 class.*/
	    Scanner scanner = new Scanner(System.in);
	    
	    /*To allow the users to be able to search in the array I will make the array
	     * into one big text string. I want to make sure they do not run together 
	     * so I will add a space between them*/
	    StringBuilder statesString = new StringBuilder();
	    for (String state : fiftyStates) {
	    	statesString.append(state).append(" ");
	    }
	    //Here I will make a string object to hold the new combined block of text.
	    String statesTextBlock = statesString.toString();
	    
	  //I will have an exit option in the menu so I will make an exit instance.
    	boolean exitProgramStatus = false;

	    
	    /*The instructions say to make a menu to allow the user to display text, search
	    or exit the program.*/
    	
    	while (!exitProgramStatus) {
    		System.out.println("Welcome to the Fifty States Search program!");
    		System.out.println("Choose an option from the menu below.");
    		System.out.println("1. Display the text");
    		System.out.println("2. Search");
    		System.out.println("3. Exit program");
    		System.out.println("Your choice: ");
    		
    		//Here I will collect the number the user choose buy using the scanner.
    		int userChoice = scanner.nextInt();
    		
    		switch(userChoice) {
    		/*If the user picks menu item one I will use the listOutStates method to show
    		all fifty states.*/
    		case 1:
    			listOutStates();
    			break;
    			
    		//If the user picks menu item two I first need to ask them what they want to search for.
    		case 2:
    			System.out.println("Enter part of a state name that you want to search for: ");
    			String textSnippet = scanner.nextLine();
    			
    			}
    	}
	}
}
