
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
 * An interface for creating a dictionary of words with definitions
 * 
 * @author Kylie Sampson
 *
 */
public interface Dictionary {
	/**
	 * Checks whether the dictionary is empty or not
	 * 
	 * @return true - if empty, false otherwise
	 */
	public boolean isEmpty();

	/**
	 * Adds this word definition (word and the provided meaning) to the dictionary.
	 * Returns true if the word was successfully added to this dictionary. Returns
	 * false if the word was already in the dictionary.
	 * 
	 * @param word    - word to be added to dictionary
	 * @param meaning - definition of word being added\
	 * @throws IllegalArgumentException - if either word or meaning is null or an
	 *                                  empty String
	 * @return true - word was successfully added, false if the word was not added
	 */
	public boolean addWord(String word, String meaning) throws IllegalArgumentException;

	/**
	 * Returns the meaning of the word s if it is present in this dictionary. Throws
	 * a NoSuchElementException if the word s was not found in this dictionary
	 * 
	 * @param s - the word thats definition is being found
	 * @return definition of string s
	 */
	public String lookup(String s);

	/**
	 * Returns the number of words in the dicitonary
	 * 
	 * @return the number of words stored in this dictionary
	 */
	public int size();
}
