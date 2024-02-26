package com.testrigor;

import java.util.HashMap;
import java.util.Map;

public class Main {

	/**
	 *
	 * Check README
	 */
	public static void main(String[] args) throws Exception {
		Map<String, String> criminals = new HashMap<>();
		criminals.put("Paul White Jr.", null);
		criminals.put("Paul White", "Roger Night, Peter Llong Jr.");
		criminals.put("Roger Fedexer", "Rob Ford, Pete Lord, Roger McWire");
		criminals.put("Red Fortress", "Roger Rabbit, Ross Winter");
		criminals.put("Redford Fort", "Red Strong, Red Fort");

		BinaryTree binaryTree = new BinaryTree();
		criminals.forEach(binaryTree::add);
		binaryTree.print();
		System.out.println();

		// Add as many as you want
		System.out.println(findCriminal(binaryTree, "paul White"));
		System.out.println(findCriminal(binaryTree, "Roger"));
		System.out.println(findCriminal(binaryTree, "Ross"));
		System.out.println(findCriminal(binaryTree, "white jr."));
		System.out.println(findCriminal(binaryTree, "Red "));
		System.out.println(findCriminal(binaryTree, "Roger"));
		System.out.println(findCriminal(binaryTree, "Red"));
		System.out.println(findCriminal(binaryTree, null));
		System.out.println(findCriminal(binaryTree, "Ford"));
		System.out.println(findCriminal(binaryTree, ""));
		System.out.println(findCriminal(binaryTree, "Gregory"));
	}

	/**
	 * TODO: Implement
	 * @param criminals
	 * @param possibleName
	 * @return
	 */
	public static String findCriminal(BinaryTree criminals, String possibleName) throws Exception {
		System.out.print("Searching: " + possibleName + " => ");
		BestMatch bestMatch = criminals.findCriminal(possibleName);
		return bestMatch.getScore() == 0 ? "possibleName not found" : bestMatch.toString();
	}
}
