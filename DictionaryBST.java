
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
import java.util.ArrayList;
import java.util.NoSuchElementException;

/**
 * Models the BST tree that organizes the DictionaryWords in alphabetical order
 * 
 * @author Kylie Sampson
 *
 */
public class DictionaryBST implements Dictionary {
	private DictionaryWord root;

	/**
	 * This should be the only constructor of this class. Creates an empty
	 * dictionaryBST.
	 */
	public DictionaryBST() {
	}

	/**
	 * Checks if the dictionary has any words added.
	 * 
	 * @return true - if the node is empty and the dictionary has no words, false if
	 *         the node has been assigned to the word added first
	 */
	public boolean isEmpty() {
		if (root == null) {
			return true;
		}
		return false;
	}

	/**
	 * Creates new word using the arguments. This word is then passed to
	 * addWordHelper which finds the proper location to store the word in the tree
	 * 
	 * @return true if the word was added, false if there was an issue adding the
	 *         word
	 */
	public boolean addWord(String word, String meaning) {
		DictionaryWord addThisWord = new DictionaryWord(word, meaning);
		if (root == null) { // If no words had been previously added
			root = addThisWord;
			return true;
		}
		return addWordHelper(addThisWord, root);
	}

	/**
	 * Recursive helper method to add newWord in the subtree rooted at node
	 * 
	 * @param newWordNode a new DictionaryWord to be added to this dictionaryBST
	 * @param current     the current DictionaryWord that is the root of the subtree
	 *                    where newWord will be inserted
	 * @return true if the newWordNode is successfully added to this dictionary,
	 *         false otherwise
	 */
	private static boolean addWordHelper(DictionaryWord newWordNode, DictionaryWord current) {
		if (newWordNode.getWord().compareToIgnoreCase(current.getWord()) > 0) { // if current is less than newNode
			if (current.getRightChild() != null) { // if there is a node lower
				return addWordHelper(newWordNode, current.getRightChild()); // the sizes are compared again
			} else { // Once there are no children
				current.setRightChild(newWordNode); // the node is set
				return true;
			}
		}
		if (newWordNode.getWord().compareToIgnoreCase(current.getWord()) < 0) { // if current is greater
			if (current.getLeftChild() != null) {
				return addWordHelper(newWordNode, current.getLeftChild());
			} else {
				current.setLeftChild(newWordNode);
				return true;
			}
		}
		return false; // If they are equal, word cannot be added
	}

	/**
	 * Makes a call to lookupHelper, a recursive method that finds the corresponding
	 * word.
	 * 
	 * @return String- the definition of the word searched
	 */
	public String lookup(String s) {
		return lookupHelper(s, root);
	}

	/**
	 * Recursive helper method to lookup a word s in the subtree rooted at current
	 * 
	 * @param s       String that represents a word
	 * @param current pointer to the current DictionaryWord within this dictionary
	 * @return the meaning of the word s if it is present in this dictionary
	 * @throws NoSuchElementException if s is not found in this dictionary
	 */
	private static String lookupHelper(String s, DictionaryWord current) throws NoSuchElementException {
		if (current == null) {
			throw new NoSuchElementException("There are no definitions in this empty dictionary.");
		}
		if (s.compareToIgnoreCase(current.getWord()) == 0) { // base case
			return current.getMeaning();
		}
		if (s.compareToIgnoreCase(current.getWord()) > 0) {
			if (current.getRightChild() != null) {
				return lookupHelper(s, current.getRightChild()); // compares to child
			} else {
				throw new NoSuchElementException("No definition found for the word " + s);
			}
		} else if (s.compareToIgnoreCase(current.getWord()) < 0) {
			if (current.getLeftChild() != null) {
				return lookupHelper(s, current.getLeftChild()); // compares to child
			} else {
				throw new NoSuchElementException("No definition found for the word " + s);
			}
		}
		return null;
	}

	/**
	 * Makes a call to the recursive method that returns an int that counts the size
	 * of the tree
	 */
	public int size() {
		if (root == null) {
			return 0;
		}
		return sizeHelper(root);
	}

	/**
	 * Recursive helper method that returns the number of dictionary words stored in
	 * the subtree rooted at current
	 * 
	 * @param current current DictionaryWord within this dictionaryBST
	 * @return the size of the subtree rooted at current
	 */
	private static int sizeHelper(DictionaryWord current) {
		int count = 0;

		if (current.getLeftChild() != null) { // If the node has a child, the method is called again, searching for
												// either a right child to add to the count
			count += sizeHelper(current.getLeftChild());
		}
		count++;

		if (current.getRightChild() != null) {
			count += sizeHelper(current.getRightChild());
		}
		return count;
	}

	/**
	 * Computes and returns the height of this dictionaryBST, as the number of nodes
	 * from root to the deepest leaf DictionaryWord node.
	 * 
	 * @return the height of this Binary Search Tree counting the number of
	 *         DictionaryWord nodes
	 */
	public int height() {
		if (root == null) {
			return 0;
		}
		return heightHelper(root);
	}

	/**
	 * Recursive helper method that computes the height of the subtree rooted at
	 * current
	 * 
	 * @param current pointer to the current DictionaryWord within this
	 *                DictionaryBST
	 * @return height of the subtree rooted at current counting the number of
	 *         DictionaryWord nodes from the current node to the deepest leaf in the
	 *         subtree rooted at current
	 */
	private static int heightHelper(DictionaryWord current) {
		int count = 1;

		// if current has a right or left child the method is called again, adding 1 to
		// the height
		if (current.getLeftChild() != null) {
			count = heightHelper(current.getLeftChild()) + 1;
		}
		if (current.getRightChild() != null) {
			count = heightHelper(current.getLeftChild()) + 1;
		}
		return count;
	}

	/**
	 * Returns all the words within this dictionary sorted from A to Z
	 * 
	 * @return an ArrayList that contains all the words within this dictionary
	 *         sorted in the ascendant order
	 */
	public ArrayList<String> getAllWords() {
		if (root == null) {
			return new ArrayList<String>();
		}
		return getAllWordsHelper(root);
	}

	/**
	 * Recursive Helper method that returns a list of all the words stored in the
	 * subtree rooted at current
	 * 
	 * @param current pointer to the current DictionaryWord within this
	 *                dictionaryBST
	 * @return an ArrayList of all the words stored in the subtree rooted at current
	 */
	private static ArrayList<String> getAllWordsHelper(DictionaryWord current) {
		ArrayList<String> list = new ArrayList<String>();

		if (current.getLeftChild() != null) { // checks for left child first, if it contains one, it calls again
			list.addAll(getAllWordsHelper(current.getLeftChild()));
		}
		list.add(current.getWord()); // base case

		if (current.getRightChild() != null) { // once the most left has been added, moves up in the tree adding right
												// nodes
			list.addAll(getAllWordsHelper(current.getRightChild())); // If a right node is found, method called again
																		// and checks left before moving on
		}
		return list;
	}

}
