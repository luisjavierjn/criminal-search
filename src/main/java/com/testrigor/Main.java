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

		System.out.println("\nBinaryTree");
		BinaryTree binaryTree = new BinaryTree();
		criminals.forEach(binaryTree::add);
		binaryTree.print();

		System.out.println("\nCriminalTreeMap");
		CriminalTreeMap criminalTreeMap = new CriminalTreeMap();
        criminalTreeMap.putAll(criminals);
		System.out.println(criminalTreeMap);

		// Add as many as you want
		System.out.println("\nResultados de binaryTree");
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
		System.out.println();

		System.out.println("\nResultados de criminals");
		System.out.println(findCriminal(criminals, "paul White"));
		System.out.println(findCriminal(criminals, "Roger"));
		System.out.println(findCriminal(criminals, "Ross"));
		System.out.println(findCriminal(criminals, "white jr."));
		System.out.println(findCriminal(criminals, "Red "));
		System.out.println(findCriminal(criminals, "Roger"));
		System.out.println(findCriminal(criminals, "Red"));
		System.out.println(findCriminal(criminals, null));
		System.out.println(findCriminal(criminals, "Ford"));
		System.out.println(findCriminal(criminals, ""));
		System.out.println(findCriminal(criminals, "Gregory"));

		System.out.println("\nResultados de criminalTreeMap");
		System.out.println(findCriminalNew(criminalTreeMap, "paul White"));
		System.out.println(findCriminalNew(criminalTreeMap, "Roger"));
		System.out.println(findCriminalNew(criminalTreeMap, "Ross"));
		System.out.println(findCriminalNew(criminalTreeMap, "white jr."));
		System.out.println(findCriminalNew(criminalTreeMap, "Red "));
		System.out.println(findCriminalNew(criminalTreeMap, "Roger"));
		System.out.println(findCriminalNew(criminalTreeMap, "Red"));
		System.out.println(findCriminalNew(criminalTreeMap, null));
		System.out.println(findCriminalNew(criminalTreeMap, "Ford"));
		System.out.println(findCriminalNew(criminalTreeMap, ""));
		System.out.println(findCriminalNew(criminalTreeMap, "Gregory"));
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

	public static String findCriminalNew(Map<String, String> criminals, String possibleName) {
		System.out.print("Searching: " + possibleName + " => ");
        return criminals.get(possibleName);
	}

	public static String findCriminal(Map<String, String> criminals, String possibleName) {
		if (possibleName == null || possibleName.isEmpty())
			return "No match";

		possibleName = possibleName.toLowerCase();
		String bestMatch = null;
		int maxScore = 0;

		for (Map.Entry<String, String> entry : criminals.entrySet()) {
			String actualName = entry.getKey().toLowerCase();
			String aliases = entry.getValue();

			int score;
			if (actualName.contains(possibleName)) {
				boolean exactMatch = actualName.equals(possibleName);
				score = 2;
				if(exactMatch) {
					bestMatch = entry.getKey();
					break;
				} else if (score > maxScore) {
					maxScore = score;
					bestMatch = entry.getKey();
				}
			} else if (aliases != null && aliases.toLowerCase().contains(possibleName)) {
				score = 1;
				if (score > maxScore) {
					maxScore = score;
					bestMatch = entry.getKey();
				}
			}
		}

		if (bestMatch != null) {
			StringBuilder result = new StringBuilder("First name: ");
			result.append(bestMatch).append(". ");
			if (criminals.get(bestMatch) != null)
				result.append("Aliases: ").append(criminals.get(bestMatch));
			else
				result.append("No aliases found.");
			return result.toString();
		} else {
			return "No match";
		}
	}
}
