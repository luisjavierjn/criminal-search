package com.testrigor;

public class BinaryTree {
    private Node root;

    private Node addRecursive(Node current, String key, String value) throws Exception {
        if(key == null || key.isEmpty()) {
            throw new Exception("key cannot be null or empty");
        }
        key = key.toLowerCase();
        if(value != null && !value.isEmpty()) {
            value = value.toLowerCase();
        }
        if (current == null) {
            return new Node(key, value);
        }

        if (key.compareTo(current.getKey()) < 0) {
            current.setLeft(addRecursive(current.getLeft(), key, value));
        } else if (key.compareTo(current.getKey()) > 0) {
            current.setRight(addRecursive(current.getRight(), key, value));
        } else {
            // value already exists
            return current;
        }

        return current;
    }

    public void add(String key, String value) throws Exception {
        root = addRecursive(root, key, value);
    }

    public void print() {
        traverseInOrder(root);
    }

    private void traverseInOrder(Node node) {
        if (node != null) {
            traverseInOrder(node.getLeft());
            System.out.print(node);
            traverseInOrder(node.getRight());
        }
    }

    private boolean containsNodeRecursive(Node current, String name) throws Exception {
        if(name == null || name.isEmpty()) {
            throw new Exception("name cannot be null or empty");
        }
        name = name.toLowerCase();
        if (current == null) {
            return false;
        }
        if (name.compareTo(current.getKey()) == 0) {
            return true;
        }
        return name.compareTo(current.getKey()) < 0
                ? containsNodeRecursive(current.getLeft(), name)
                : containsNodeRecursive(current.getRight(), name);
    }

    public boolean containsNode(String name) throws Exception {
        return containsNodeRecursive(root, name);
    }
}
