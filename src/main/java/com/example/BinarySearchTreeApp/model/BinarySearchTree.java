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

    // Creates balanced tree.
    public void buildBalancedTreeFromList(List<Integer> numbers) {
        Collections.sort(numbers);
        root = buildBalancedRecursive(numbers, 0, numbers.size() - 1);
    }

    private TreeNode buildBalancedRecursive(List<Integer> nums, int start, int end) {
        if (start > end) return null;

        int mid = (start + end) / 2;
        TreeNode node = new TreeNode(nums.get(mid));

        node.setLeft(buildBalancedRecursive(nums, start, mid - 1));
        node.setRight(buildBalancedRecursive(nums, mid + 1, end));

        return node;
    }
}
