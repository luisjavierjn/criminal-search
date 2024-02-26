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
		binaryTree.add("Paul White Jr.", null);
		binaryTree.add("Paul White", "Roger Night, Peter Llong Jr.");
		binaryTree.add("Roger Fedexer", "Rob Ford, Pete Lord, Roger McWire");
		binaryTree.add("Red Fortress", "Roger Rabbit, Ross Winter");
		binaryTree.add("Redford Fort", "Red Strong, Red Fort");
		binaryTree.print();

		System.out.println(binaryTree.containsNode("Paul White Jr."));

		// Add as many as you want
//		System.out.println(findCriminal(criminals, "Red "));
//		System.out.println(findCriminal(criminals, "Roger"));
//		System.out.println(findCriminal(criminals, "Red"));
//		System.out.println(findCriminal(criminals, null));
//		System.out.println(findCriminal(criminals, "Ford"));
	}

	/**
	 * TODO: Implement
	 * @param criminals
	 * @param possibleName
	 * @return
	 */
	public static String findCriminal(BinaryTree criminals, String possibleName) {
		return null;
	}
}
