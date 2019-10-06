import java.util.ArrayList;

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
 * Tests the functionality of methods in program by running a series of test
 * 
 * @author Kylie Sampson
 *
 */
public class DictionaryTests {

	/**
	 * Calls various tests to ensure the functionality of the code is working as
	 * expected
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("testGetterMethods()   " + testGetterMethods());
		System.out.println("testAddandArrayList() " + testAddandArrayList());
		System.out.println("testSize()            " + testSize());
		System.out.println("testLookup()          " + testLookup());
		System.out.println("testHeight()          " + testHeight());
		System.out.println("testIsEmpty()         " + testIsEmpty());
	}

	/**
	 * Test the ability to retrieve the name and meaning of a DictionaryWord created
	 * 
	 * @return true if test is passed, false otherwise
	 */
	private static boolean testGetterMethods() {
		DictionaryWord test1 = new DictionaryWord("Kylie", "A fantastic programmer");

		if (!test1.getWord().equals("Kylie")) {
			return false;
		}
		if (!test1.getMeaning().equals("A fantastic programmer")) {
			return false;
		}
		return true;
	}

	/**
	 * Test the functionality of adding words to the dictionary, as well as the
	 * order they are returned in an arrayList. This also ensures that the words are
	 * stored in the proper tree location.
	 * 
	 * @return true if test is passed, false otherwise
	 */
	private static boolean testAddandArrayList() {
		DictionaryBST test2 = new DictionaryBST();
		test2.addWord("dog", "love");
		test2.addWord("cat", "scary");
		test2.addWord("rabbit", "cute");

		ArrayList<String> test2ArrayList = test2.getAllWords();

		// words should be in the array in alphabetical order
		if (!test2ArrayList.get(0).equals("cat"))
			return false;
		if (!test2ArrayList.get(1).equals("dog"))
			return false;
		if (!test2ArrayList.get(2).equals("rabbit"))
			return false;
		return true;
	}

	/**
	 * Test the size function of the array with various sizes. First checks with 0
	 * words, then 3, then 5.
	 * 
	 * @return true if test is passed, false otherwise
	 */
	private static boolean testSize() {
		DictionaryBST test3 = new DictionaryBST();

		// Size should be 0
		if (test3.size() != 0)
			return false;

		// Adds 3 words
		test3.addWord("word1", "definition");
		test3.addWord("word2", "definition");
		test3.addWord("word3", "definition");

		// Checks that size is now 3
		if (test3.size() != 3)
			return false;

		// Adds 2 words
		test3.addWord("word4", "definition");
		test3.addWord("word5", "definition");

		// Checks that the size is now 5
		if (test3.size() != 5)
			return false;

		return true;
	}

	/**
	 * Test the ability to look up a word, and have the correct definition be
	 * returned
	 * 
	 * @return true if test passed, false otherwise
	 */
	public static boolean testLookup() {
		DictionaryBST test4 = new DictionaryBST();

		test4.addWord("word1", "definition1");
		test4.addWord("word2", "definition2");
		test4.addWord("word3", "definition3");

		if (!test4.lookup("word1").equals("definition1"))
			return false;
		if (!test4.lookup("word3").equals("definition3"))
			return false;
		if (!test4.lookup("word2").equals("definition2"))
			return false;

		return true;
	}

	/**
	 * Test the height of the tree with various elements.
	 * 
	 * @return true if test passed, false otherwise
	 */
	public static boolean testHeight() {
		DictionaryBST test5 = new DictionaryBST();

		// Height with no words should be 0
		if (test5.height() != 0) {
			return false;
		}

		// The root node should have a height of 1
		test5.addWord("Koala", "root");
		if (test5.height() != 1) {
			return false;
		}

		// The height should now be 2
		test5.addWord("iguana", "koala left child");
		if (test5.height() != 2) {
			return false;
		}

		// The height should not change because monkey is on the same level
		test5.addWord("monkey", "koala right child");
		if (test5.height() != 2) {
			return false;
		}

		// Adds 3 words that are all less than the previous. Adds 3 to height
		test5.addWord("hippo", "iguana left child");
		test5.addWord("giraffe", "hippo left child");
		test5.addWord("fish", "giraffe left child");
		if (test5.height() != 5) {
			return false;
		}
		return true;
	}

	/**
	 * Test the functionality of the isEmpty method before and after words are
	 * added.
	 * 
	 * @return true if test passed, false otherwise
	 */
	public static boolean testIsEmpty() {
		DictionaryBST test6 = new DictionaryBST();
		if (!test6.isEmpty())
			return false;
		test6.addWord("word1", "definition");
		if (test6.isEmpty())
			return false;
		return true;
	}
}
