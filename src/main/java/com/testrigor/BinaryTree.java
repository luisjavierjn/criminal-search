package com.testrigor;

public class BinaryTree {
    private Node root;

    private Node addRecursive(Node current, String key, String value) {
        if(key == null || key.isEmpty()) {
            System.out.println("key cannot be null or empty");
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

    public void add(String key, String value) {
        root = addRecursive(root, key, value);
    }

    public void print() {
        traverseInOrder(root);
    }

    private void traverseInOrder(Node node) {
        if (node != null) {
            traverseInOrder(node.getLeft());
            System.out.println(node);
            traverseInOrder(node.getRight());
        }
    }

    private boolean containsNodeRecursive(Node current, String name) {
        if(name == null || name.isEmpty()) {
            System.out.println("name cannot be null or empty");
            return false;
        }
        if (current == null) {
            return false;
        }
        if (name.toLowerCase().compareTo(current.getKey().toLowerCase()) == 0) {
            return true;
        }
        return name.toLowerCase().compareTo(current.getKey().toLowerCase()) < 0
                ? containsNodeRecursive(current.getLeft(), name)
                : containsNodeRecursive(current.getRight(), name);
    }

    public boolean containsNode(String name) {
        return containsNodeRecursive(root, name);
    }

    private boolean findBestMatchCriminal(BestMatch bestMatch, Node current, String possibleName) {
        if(possibleName == null || possibleName.isEmpty()) {
            System.out.println("possibleName cannot be null or empty");
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
                bestMatch.setMatch(current.toString());
                return true;
            } else {
                if (score > bestMatch.getScore()) {
                    bestMatch.setScore(score);
                    bestMatch.setMatch(current.toString());
                }
            }
        } else if (current.getValue() != null &&
                current.getValue().toLowerCase().contains(possibleName.toLowerCase())) {
            score = 1;
            if (score > bestMatch.getScore()) {
                bestMatch.setScore(score);
                bestMatch.setMatch(current.toString());
            }
        }

        return  findBestMatchCriminal(bestMatch, current.getLeft(), possibleName) ||
                findBestMatchCriminal(bestMatch, current.getRight(), possibleName);
    }

    public BestMatch findCriminal(String possibleName) {
        BestMatch bestMatch = new BestMatch();
        findBestMatchCriminal(bestMatch, root, possibleName);
        return bestMatch;
    }
}
