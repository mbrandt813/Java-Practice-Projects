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
	
	/* If the user selects the second option in the menu I need to be able to search
	 * for the string of text they entered. I will create a block of text of the states
	 * from the array in the main method that will serve as a parameter for this method.*/
	public static void boyerMooreSearch(String textBlock , String textSnip) {
	/*To begin I need to create a reference to the bed character table method that I will
		create below.*/
		int[] badCharacter = buildBadCharTable(textSnip);
        
		//I am going to need the length of both of the arguments entered to compare.
		int textBlockLength = textBlock.length();
		int textSnipLength = textSnip.length();
		
		/*I will handle a case were the textSnip entered by the user might be empty. I 
		manually entered the states so there shouldn't be a case where that length is zero
		but I will check for it anyway.*/
		if (textBlockLength == 0 || textSnipLength == 0) {
			System.out.println("A search cannot be completed with the values entered.");
			return;
		}
		
		/*I'll create an object to determine if a match was found. It will be false until 
		a match is located.*/
		boolean matchFound = false;
		
		int position = 0;
		while(position <= (textBlockLength - textSnipLength)) {
			//I will start the comparisons from the end of textSnip entered.
			int letterN = textSnipLength - 1;
			
			/*while the letters are matching I will move through them, going from the last letter
			until we get to the first.*/
			while(letterN >= 0 && textSnip.charAt(letterN) == textBlock.charAt(position + letterN)) {
				letterN--;
			}
			
			//If I find that letterN is greater then 0, we found a match.
			if (letterN < 0) {
				matchFound = true;
				System.out.println("Your input was found at: " + position);
				
				if(position + textSnipLength < textBlockLength) {
					position += textSnipLength - badCharacter[textBlock.charAt(position + textSnipLength)];
				} else {
					position += 1;
				}
				
			} else {
				int charInText = textBlock.charAt(position + letterN);
				int moveBy = letterN - badCharacter[charInText];
				
				//I should make sure we always move by at least one.
				if (moveBy < 1) {
					moveBy = 1;
				}
				position += moveBy;
			}
		}
		//If what the user entered was not found in the block of text, I will let them know.
		if (!matchFound) {
			System.out.println("No match was found for what you entered.");
		}
;    
	}
	
	/*Here I have the buildBadCharTable method I referenced in the previous method. This will return
	an array that will help determine how far to move the string over when a mismatch happens.*/
	public static int[] buildBadCharTable(String textSnip) {
		//Since there is a total of 265 ASCII character I will use that as the size of my array.
		int[] badChar = new int[256];
		
		/*For each character that we do not see in the text entered by the user, I will 
		set it to -1 to correctly label it as such.*/
		for (int i = 0; i < 256; i++) {
			badChar[i] = -1;
		}
		/*Here I am going through the user inputed string and determining the last
		position of the character in the string.*/
		for (int i = 0; i < textSnip.length(); i++) {
			badChar[textSnip.charAt(i)] = i;
		}
	return badChar;
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
    		//I need to get ride of the new line that was created by next()
    		scanner.nextLine();
    		
    		switch(userChoice) {
    		/*If the user picks menu item one I will use the listOutStates method to show
    		all fifty states.*/
    		case 1:
    			listOutStates();
    			break;
    			
    		//If the user picks menu item two I first need to ask them what they want to search for.
    		case 2:
    			System.out.println("Enter part of a state name that you want to search for: ");
    			System.out.println("Please note, this is case sensitive.");
    			String textSnippet = scanner.nextLine();
    			
    			//I will use the boyerMooreSearch method to find the string in the text block.
    			boyerMooreSearch(statesTextBlock, textSnippet);
    			break;
    		case 3:
    			exitProgramStatus = true;
    			System.out.println("Thank you for searching the states!");
    		default:
    			System.out.println("That was not a correct input, try again!");
    			
    			}
    	}
	}
}
