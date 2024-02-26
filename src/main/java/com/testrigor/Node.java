package com.testrigor;

public class Node {
    private String key;
    private String value;
    private Node left;
    private Node right;

    Node(String key, String value) {
        this.key = key;
        this.value = value;
        right = null;
        left = null;
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
        return "Node{" +
                "key='" + key + '\'' +
                ", value='" + value + '\'' +
                "}\n";
    }
}
