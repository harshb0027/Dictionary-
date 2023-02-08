/**
 * Student Number: 041005659
 * Assessment: Assignment03(Last assignment of the semester)
 * Student name: Harsh Bansal
 * Professor Name: James Mwangi
 * Due Date: August 01, 2021
 * Description: Maintaining the dictionary of in the form of treemap of type string and integer
 * and then using some of the collection classes and the methods to search for the element, display
 * the total number of elements, diaplay the number of unique words, and perform the operations 
 * ignoring the definite and indefinite articles of the file and finally quitting the program. It as to 
 * be demoed with the Test plan and the java doc to prof. mwangi.
 */

//Imported classes
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;


/**
 * This class has all the methods to read the whole file, to search for an element in the treemap,
 * to count the number of words in the treemap and display the number of unique words in the 
 * treemap and thenperforming the above operations including or excluding the articles such as a, an
 * and the.
 * @author hp
 *
 */
public class Dictionary {
	private boolean articleValue = false;	//boolean value for articles
	String choice;	
	Scanner input = new Scanner(System.in);	//scanner object
	TreeMap<String, Integer> dictionary = new TreeMap<>();	//treemap object of type string and integer
	
	
	/**
	 * The method reads the whole file from the object folder of the workspace. It reads the file and 
	 * stores each word in the map by first putting into the list and arrays.
	 * @throws IOException -- throwing the IO exception
	 */
	public void readTheFile() throws IOException{
		List<String> lines = Files.readAllLines(Paths.get("Raven.txt"), StandardCharsets.UTF_8);
						// iterate over lines
		lines.forEach(line -> {
			line = line.toLowerCase();	// convert line to lower case
			String[] words = line.split(" ");
			Arrays.stream(words).forEach(key -> {
								// put key-value pair into dictionary if doesn't exists otherwise update value by 1
				dictionary.put(key, dictionary.getOrDefault(key, 0) + 1); //putting into sictionary
			});
		});
		System.out.println("Program has read the file\n"); //verifying that program has read the file.......
	}//end method
	
	
	/**
	 * The method searched for the word whose input is taken from the keyboard. In this method, it
	 * uses the method from the collection classes -- getOrDefault 
	 */
	public void searchTheWord() {
		System.out.print("Enter the word you want to search : ");
		String search = input.next();	//search for word
		int occurs = 0;			//there are no occurs
		if (articleValue) {		//if the article is set to true
			// search word don't belongs to articles
			if (!search.equalsIgnoreCase("a") && !search.equalsIgnoreCase("an")
					&& !search.equalsIgnoreCase("the")) {
									//occurs belong to the dictionary
				occurs = dictionary.getOrDefault(search, 0);	
			}
		}
		else {
			occurs = dictionary.getOrDefault(search, 0);// get value for search key
		}//printing that the search element occured for that much no. of times.......
		System.out.println(search + " occurs " + occurs + " times.\n");			
	}
	
	/**
	 * Displaying the unique words -- This method display the number of words that occured ofr only a 
	 * single time. It is iterated over type  referred from api till the dictionary
	 * and then prompting if there is any if conditions, then directly increment the number of words otherwise
	 * otherwise directly incrementing the words.
	 * This is only happened when we have converted the elements of a map into the set view.....because
	 * of the method named as entrySet()
	 */
	public void displayUniqueWords() {
		int words = 0;
		// iterate over map
		for (Map.Entry<String, Integer> el : dictionary.entrySet()) {
			// check word is unique
			if (el.getValue() == 1) {

				if (articleValue) {
					// key is not article
					//prompting that if the element is not a or an or the and then directly incrementing 
					if (!el.getKey().equalsIgnoreCase("a") && !el.getKey().equalsIgnoreCase("an")
							&& !el.getKey().equalsIgnoreCase("the")) {
						words++;// update words
					}
				}
				if (!articleValue) {
					words++;// update words
				}
			}
		} //printing that the dictionary has this much unique words.......
		System.out.println("Dictionary has " + words + " unique words\n");
	}
	
	/**
	 * This is the method that calculates the total number of words in the dictionary, This is done
	 * with the help of the iterating through the map again and again till it becomes null.
	 */
	public void numWordsInDictionary() {
		int size = 0;// store number of all words in dictionary
		// iterate over dictionary
		for (Map.Entry<String, Integer> el : dictionary.entrySet()) {
			if (!articleValue) {
				size = size + el.getValue(); //adding size to the value
			}
			// definite/indefinite articles are ignored
			if (articleValue) {
				// key is not article
				if (!el.getKey().equalsIgnoreCase("a") && !el.getKey().equalsIgnoreCase("an")
						&& !el.getKey().equalsIgnoreCase("the")) {
					size = size + el.getValue();// add word count
				}
			}
		}
		System.out.println("Dictionary has " + size + " words\n"); //finally printing the size.
	
	}//end method
	
	
	/**
	 * This method resets the map as it changes the elements of the tree map to null. This is done
	 * with the clear() method of the tree map class.......
	 * 
	 */
	public void resetDictionary() {
		dictionary.clear();// clear all words from dictionary
		System.out.println("Program has removed all the words\n");
		
	}
	
	/**
	 * This method changes the value of articleValue as for the whole functioning of the program 
	 * accordingly.... If the value of srticles is true then change to false otherwise vhange to 
	 * false......
	 */
	public void trueArticles() {
		if(articleValue == false) {		//if the value of article is false
			articleValue = true;// set articleValue to true
		}
		else {			//else set to false
			articleValue = false;
		}
		//end statement
		System.out.println("Ignore definite and indefinite articles has been set to " + articleValue + "\n");
	}
	
	/**
	 * Getter for the value of the articles as it returns the value true or false
	 * @return -- boolean value of the articles.
	 */
	public boolean getArticle() {
		return articleValue;			//return article.....
	}

}
