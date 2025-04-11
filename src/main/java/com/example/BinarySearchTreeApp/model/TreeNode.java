package com.example.BinarySearchTreeApp.model;

public class TreeNode {
    private int value;
    private TreeNode left;
    private TreeNode right;

    // Constructors.
    public TreeNode(int value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }

    // Getters and Setters.
    public int getValue() {
        return value;
    }

    public TreeNode getLeft() {
        return left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }
}
