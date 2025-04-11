package com.example.BinarySearchTreeApp.model;

// Imports.
import java.util.*;

public class BinarySearchTree {
    private TreeNode root;

    public void insert(int value) {
        root = insertRecursive(root, value);
    }

    private TreeNode insertRecursive(TreeNode current, int value) {
        if (current == null) {
            return new TreeNode(value);
        }

        if (value < current.getValue()) {
            current.setLeft(insertRecursive(current.getLeft(), value));
        } else if (value > current.getValue()) {
            current.setRight(insertRecursive(current.getRight(), value));
        }

        return current;
    }

    public TreeNode getRoot() {
        return root;
    }

    // Returns as a nested map structure.
    public Map<String, Object> toMap(TreeNode node) {
        if (node == null) return null;

        Map<String, Object> map = new LinkedHashMap<>();
        map.put("value", node.getValue());
        map.put("left", toMap(node.getLeft()));
        map.put("right", toMap(node.getRight()));

        return map;
    }
}
