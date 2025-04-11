package com.example.BinarySearchTreeApp.service;

// Imports.
import com.example.BinarySearchTreeApp.model.*;
import com.example.BinarySearchTreeApp.repository.TreeRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.*;

@Service
public class BinaryTreeService {

    @Autowired
    private TreeRecordRepository treeRecordRepository;

    private final ObjectMapper mapper = new ObjectMapper();

    public TreeRecord buildAndSaveTree(String input) throws Exception {
        // Parses the numbers.
        String[] parts = input.split(",");
        BinarySearchTree bst = new BinarySearchTree();

        for (String part : parts) {
            int num = Integer.parseInt(part.trim());
            bst.insert(num);
        }

        // Converts tree to JSON string.
        Map<String, Object> treeMap = bst.toMap(bst.getRoot());
        String treeJson = mapper.writeValueAsString(treeMap);

        // Save to database.
        TreeRecord record = new TreeRecord(input, treeJson);
        return treeRecordRepository.save(record);
    }
}
