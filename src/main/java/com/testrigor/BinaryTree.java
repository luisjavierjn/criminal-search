package com.testrigor;

public class BinaryTree {
    private Node root;

    private Node addRecursive(Node current, String key, String value) throws Exception {
        if(key == null || key.isEmpty()) {
            throw new Exception("key cannot be null");
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
}
