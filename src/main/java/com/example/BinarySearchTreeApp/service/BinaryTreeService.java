package com.example.BinarySearchTreeApp.service;

// Imports.
import com.example.BinarySearchTreeApp.model.*;
import com.example.BinarySearchTreeApp.repository.TreeRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class BinaryTreeService {

    @Autowired
    private TreeRecordRepository treeRecordRepository;

    private final ObjectMapper mapper = new ObjectMapper();

    public TreeRecord buildAndSaveTree(String input) throws Exception {
        // Parses and sorts the numbers.
        List<Integer> numberList = Arrays.stream(input.split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        BinarySearchTree bst = new BinarySearchTree();
        bst.buildBalancedTreeFromList(numberList);

        // Converts tree to JSON.
        Map<String, Object> treeMap = bst.toMap(bst.getRoot());
        String treeJson = mapper.writeValueAsString(treeMap);

        // Save to database.
        TreeRecord record = new TreeRecord(input, treeJson);
        return treeRecordRepository.save(record);
    }

    // Gets all previous trees.
    public List<TreeRecord> getAllTrees() {
        return treeRecordRepository.findAll();
    }
}

