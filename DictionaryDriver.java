import java.util.ArrayList;
import java.util.Scanner;

//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title:           P9 Dictionary Using BST
// Files:           DictionaryTests.java, Dictionary.java, DictionaryWord.java, 
//					DictionaryBST.java, DictionaryDriver.java
// Course:          006, Spring, 2019
//
// Author:          Kylie Sampson
// Email:           kpsampson@wisc.edu 
// Lecturer's Name: Mouna Ayari Ben Hadj Kacem 
//
//////////////////// PAIR PROGRAMMERS COMPLETE THIS SECTION ///////////////////
//
// Partner Name:    NONE
// Partner Email:   NONE
// Partner Lecturer's Name: NONE
// 
// VERIFY THE FOLLOWING BY PLACING AN X NEXT TO EACH TRUE STATEMENT:
//   ___ Write-up states that pair programming is allowed for this assignment.
//   ___ We have both read and understand the course Pair Programming Policy.
//   ___ We have registered our team prior to the team registration deadline.
//
///////////////////////////// CREDIT OUTSIDE HELP /////////////////////////////
//
// Students who get help from sources other than their partner must fully 
// acknowledge and credit those sources of help here.  Instructors and TAs do 
// not need to be credited here, but tutors, friends, relatives, room mates, 
// strangers, and others do.  If you received no outside help from either type
//  of source, then please explicitly indicate NONE.
//
// Persons:         NONE
// Online Sources:  NONE
//
/////////////////////////////// 80 COLUMNS WIDE ///////////////////////////////

/**
 * Driver for the dictionary. Displays menu and organizes user input
 * 
 * @author Kylie Sampson
 *
 */
public class DictionaryDriver {
	/**
	 * Handles user input and makes call to proper method to perform desired action
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		DictionaryBST dictionary = new DictionaryBST();
		Scanner scnr = new Scanner(System.in);
		String input = "";
		char character = ' ';
		while (character != 'q') {
			try {
				printMenu();
				System.out.print("Please enter your command: ");
				input = scnr.next().toLowerCase(); //first char of first word used in determining action
				character = input.charAt(0);
				
				//Adds the word in correct location
				if (character == 'a' || character == 'A') {
					String word = scnr.next();
					String meaning = scnr.nextLine();
					boolean added = dictionary.addWord(word, meaning); 
					if (!added) {
						System.out.println("WARNING: failed to add duplicate word: " + word + " for duplicate entry");
					}
				}
				//Prints the word with its definition
				else if (character == 'l') {
					String word = scnr.next();
					String meaning = dictionary.lookup(word); 
					System.out.println(word + ":" + meaning);
				}
				//Prints the all words in order
				else if (character == 'g') {
					ArrayList<String> arrayToPrint = dictionary.getAllWords();
					if (arrayToPrint.isEmpty()) {
						System.out.println("Dictionary is empty.");
					} else {
						String print = "";
						for (String word : arrayToPrint) { 
							print = print + " " + word + ",";
						}
						print = print.substring(0, print.length() - 1).trim();
						System.out.println(print);
					}
				} 
				//Returns the number of words in the dictionary
				else if (character == 's') {
					System.out.println(dictionary.size());
				} 
				//Returns the height (in nodes)
				else if (character == 'h') {
					System.out.println(dictionary.height());
				} 
				//Quits the program
				else if (character == 'q') {
					System.out.println("============================== END ===================================");
					break;
				} 
				//If the user enters a command with no assigned operation
				else {
					System.out.println("Command not recognized. Please enter a valid command");
				}

			} catch (Exception e) { //Prints the message from various exceptions
				System.out.println(e.getLocalizedMessage());
			}
		}
		scnr.close();
	}

	/**
	 * Prints menu when called
	 */
	private static void printMenu() {
		System.out.println("=========================== Dictionary ============================\r\n"
				+ "Enter one of the following options:\r\n"
				+ "[A <word> <meaning>] to add a new word and its definition in the dictionary\r\n"
				+ "[L <word>] to search a word in the dictionary and display its definition\r\n"
				+ "[G] to print all the words in the dictionary in sorted order\r\n"
				+ "[S] to get the count of all words in the dictionary\r\n"
				+ "[H] to get the height of this dictionary implemented as a binary search tree\r\n"
				+ "[Q] to quit the program\r\n"
				+ "======================================================================");
	}
}
