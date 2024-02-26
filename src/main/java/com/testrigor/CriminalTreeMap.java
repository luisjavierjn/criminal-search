package com.testrigor;

import java.util.AbstractMap;
import java.util.LinkedHashSet;
import java.util.Set;

public class CriminalTreeMap extends AbstractMap<String, String> {

    private Node root;

    private Node addRecursive(Node current, String key, String value) {
        if(key == null || key.isEmpty()) {
            return null;
        }
        if (current == null) {
            return new Node(key, value);
        }

        if (key.toLowerCase().compareTo(current.getKey().toLowerCase()) < 0) {
            current.setLeft(addRecursive(current.getLeft(), key, value));
        } else if (key.toLowerCase().compareTo(current.getKey().toLowerCase()) > 0) {
            current.setRight(addRecursive(current.getRight(), key, value));
        } else {
            // value already exists
            return current;
        }

        return current;
    }

    private void traverseInOrderEntrySet(Node node, Set<Entry<String, String>> entrySet) {
        if (node != null) {
            traverseInOrderEntrySet(node.getLeft(), entrySet);
            entrySet.add(new SimpleEntry<>(node.getKey(), node.getValue()));
            traverseInOrderEntrySet(node.getRight(), entrySet);
        }
    }

    @Override
    public Set<Entry<String, String>> entrySet() {
        Set<Entry<String, String>> entrySet = new LinkedHashSet<>();
        traverseInOrderEntrySet(root, entrySet);
        return entrySet;
    }

    @Override
    public String put(String key, String value) {
        root = addRecursive(root, key, value);
        return null;
    }

    private boolean findBestMatchCriminal(BestMatch bestMatch, Node current, String possibleName) {
        if(possibleName == null || possibleName.isEmpty()) {
            return false;
        }
        if (current == null) {
            return false;
        }
        String actualName = current.getKey().toLowerCase();
        int score;
        if (actualName.contains(possibleName.toLowerCase())) {
            boolean exactMatch = actualName.equals(possibleName.toLowerCase());
            score = exactMatch ? 3 : 2;
            if(exactMatch) {
                bestMatch.setScore(score);
                bestMatch.setName(current.getKey());
                bestMatch.setAliases(current.getValue());
                return true;
            } else if (score > bestMatch.getScore()) {
                bestMatch.setScore(score);
                bestMatch.setName(current.getKey());
                bestMatch.setAliases(current.getValue());
            }
        } else if (current.getValue() != null &&
                current.getValue().toLowerCase().contains(possibleName.toLowerCase())) {
            score = 1;
            if (score > bestMatch.getScore()) {
                bestMatch.setScore(score);
                bestMatch.setName(current.getKey());
                bestMatch.setAliases(current.getValue());
            }
        }

        return  findBestMatchCriminal(bestMatch, current.getLeft(), possibleName) ||
                findBestMatchCriminal(bestMatch, current.getRight(), possibleName);
    }

    @Override
    public String get(Object key) {
        String possibleName = (String) key;
        BestMatch bestMatch = new BestMatch();
        findBestMatchCriminal(bestMatch, root, possibleName);

        if (bestMatch.getScore() > 0) {
            StringBuilder result = new StringBuilder("First name: ");
            result.append(bestMatch.getName()).append(". ");
            if (bestMatch.getAliases() != null)
                result.append("Aliases: ").append(bestMatch.getAliases());
            else
                result.append("No aliases found.");
            return result.toString();
        } else {
            return "No match";
        }
    }

    private void traverseInOrder(Node node, StringBuilder strBuilder) {
        if (node != null) {
            traverseInOrder(node.getLeft(), strBuilder);
            strBuilder.append(node).append("\n");
            traverseInOrder(node.getRight(), strBuilder);
        }
    }

    @Override
    public String toString() {
        StringBuilder strBuilder = new StringBuilder();
        traverseInOrder(root, strBuilder);
        return strBuilder.toString();
    }

    private static class Node {
        private final String key;
        private final String value;
        private Node left;
        private Node right;

        Node(String key, String value) {
            this.key = key;
            this.value = value;
        }

        public String getKey() {
            return key;
        }

        public String getValue() {
            return value;
        }

        public Node getLeft() {
            return left;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public Node getRight() {
            return right;
        }

        public void setRight(Node right) {
            this.right = right;
        }

        @Override
        public String toString() {
            return "Node {" +
                    "key='" + key + '\'' +
                    ", value='" + value + '\'' +
                    '}';
        }
    }

    private static class BestMatch {
        private int score;
        private String name;
        private String aliases;

        public BestMatch() {
            this.score = 0;
            this.name = "";
        }

        public int getScore() {
            return score;
        }

        public void setScore(int score) {
            this.score = score;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getAliases() {
            return aliases;
        }

        public void setAliases(String aliases) {
            this.aliases = aliases;
        }

        @Override
        public String toString() {
            return "BestMath {" +
                    "score=" + score +
                    ", match='" + name + '\'' +
                    '}';
        }
    }
}
