
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
 * Models a word in a dictionary. Word stored with a definition and references
 * to the left and right child of the word
 * 
 * @author Kylie Sampson
 *
 */
public class DictionaryWord {
	private final String word; // word that represents the search key for this dictionary word
	private final String meaning; // The meaning of the word that this dictionary node defines
	private DictionaryWord leftChild; // The leftChild of the the current WebPageNode
	private DictionaryWord rightChild; // The rightChild of the the current WebPageNode

	/**
	 * The following should be the only constructor for this class. Creates a new
	 * dictionary word with the provided word and its meaning pair. Throws
	 * IllegalArgumentException when the word or meaning are either references to an
	 * empty string or null references.
	 * 
	 * @param word    - the word
	 * @param meaning - the definition of the word
	 */
	public DictionaryWord(String word, String meaning) throws IllegalArgumentException {
		if (word == null || word.isEmpty()) {
			throw new IllegalArgumentException("You must enter a word to add a word!");
		}
		if (meaning == null || meaning.isEmpty()) {
			throw new IllegalArgumentException("WARNING: Syntax Error for [A <word> <meaning>] command line.");
		}
		this.word = word;
		this.meaning = meaning;
	}

	/**
	 * Getter for the left child of this dictionary word
	 * 
	 * @return leftChild of word
	 */
	public DictionaryWord getLeftChild() {
		return leftChild;
	}

	/**
	 * Setter for the left child of this dictionary word
	 * 
	 * @param leftChild - DictionaryWord to be assigned to leftChild
	 */
	public void setLeftChild(DictionaryWord leftChild) {
		this.leftChild = leftChild;
	}

	/**
	 * Getter for the right child of this dictionary word
	 * 
	 * @return rightChild of word
	 */
	public DictionaryWord getRightChild() {
		return rightChild;
	}

	/**
	 * Setter for the right child of this dictionary word
	 * 
	 * @param rightChild - DictionaryWord to be assigned to rightChild
	 */
	public void setRightChild(DictionaryWord rightChild) {
		this.rightChild = rightChild;
	}

	/**
	 * Getter for the word of this dictionary word
	 * 
	 * @return word - word of the object
	 */
	public String getWord() {
		return word;
	}

	/**
	 * Getter for the meaning of the word of this dictionary word
	 * 
	 * @return meaning - definition of this word
	 */
	public String getMeaning() {
		return meaning;
	}

	/**
	 * Returns a String representation of this DictionaryWord
	 * 
	 * @return dictionary word with definition
	 */
	public String toString() {
		return word + ": " + meaning; // Space is added here. Other spaces are trimmed prior to
	}
}
