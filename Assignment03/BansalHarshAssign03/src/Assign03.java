import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * This class has the main class which is also the driver class for the whole project...It has the menu 
 * which calls the method to perform operations accordingly. It declares the object of tyoe Dictionary
 * and then use the object to invoke the methods. This class also catches the exceptions when the user
 * enters the string value instead of the integer value or when the user enters the wrong value...
 * @author hp
 *
 */
public class Assign03 {
	/**
	 * The main method is the driver method for the whole project of assignment03. It loops the user
	 * again and again till the user enter the option 7 or to exit the program. If the user enters option 1, 
	 * tehn the map is loaded with the contents of the file, At 2, it searches for the occurances
	 * of the word entered and then it prints the total and unique words of the map. This program also 
	 * resets the dictionary. and finally it sets the toggle on or off to use the articles 
	 * @param args -- string type arguments of main method
	 */
	public static void main(String[] args) {
		Dictionary d = new Dictionary();	//declaring the dictionary object
		boolean continueLoop = true;			//loop should be continues
		Scanner input = new Scanner(System.in);	//input scanner
		
		int option=0;	//option integer
		//loop to run the whole program
		while(option != 7 || continueLoop == true) {		
			try {	//try catch to catch input mismatch exceptions
				
				// display main menu
				System.out.println("*******************");
				System.out.println("Dictionary");
				System.out.println("*******************");
				System.out.println("1. Add words to the Dictionary from file");
				System.out.println("2. Search a word in the Dictionary");
				System.out.println("3. Display number of unique words in the Dictionary");
				System.out.println("4. Display number of all words in the Dictionary");
				System.out.println("5. Reset Dictionary");
				System.out.println("6. Ignore definite and indefinite articles (" + d.getArticle() + ") ");
				System.out.println("7. Exit");

				System.out.print("\nEnter your option : ");
				option = input.nextInt();// get user selection
				continueLoop = false; //value is good and in the range
				
				//If there are not any of the options
				if(option != 1 && option !=2 && option != 3 && option != 4 && option != 5 && option !=6 && option != 7&& option != 8) {
					System.out.println("Invalid option entered..try again>>>");
					continue;//continue the program after showing the invalid option
				}
				
				//if the option is 1
				if(option ==1) {
					try {//calling method to read the whole file
						d.readTheFile();
					}catch(Exception e) {
						e.printStackTrace();
						input.nextLine();
						
					}
					
				}
				
				//if the option is 2 then call the method to search the occurances of the word
				else if(option ==2) {
					d.searchTheWord();
				}
				
				//if the option is 3, then call the method to show the number of words without duplicacy
				else if(option ==3) {
					d.displayUniqueWords();
				}
				
				//if the option is 4 then call the method to show the total number of words in the dictionary
				else if(option == 4) {
					d.numWordsInDictionary();
				}
				
				//if the option is 5 then call the method that removes all the keys and set the map empty
				else if(option ==5) {
					d.resetDictionary();
				}
				
				//if the option is 6 then call the method to change the value of the article from true to flase or vice versa
				else if(option ==6) {
					d.trueArticles();
				}
				
				//if the option is 7 then call the methdo to say goodbye
				else if(option ==7) {
					System.out.println("Good bye.... hope to see you soon");
				}
				
				
			}catch(InputMismatchException e) {
				System.err.println("Input mismatch Eception, try agian");
				input.nextLine();
			}
	
		}
		//System.out.println("Good bye.... hope to see you soon");
		
	
		
		
		
		
		
		
		
	}

}
