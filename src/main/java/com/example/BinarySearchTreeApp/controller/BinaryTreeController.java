package com.example.BinarySearchTreeApp.controller;

// Imports.
import com.example.BinarySearchTreeApp.model.TreeRecord;
import com.example.BinarySearchTreeApp.service.BinaryTreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/process-numbers")
public class BinaryTreeController {

    @Autowired
    private BinaryTreeService binaryTreeService;

    // Error handling. 
    @PostMapping
    public TreeRecord processNumbers(@RequestParam String input) {
        try {
            return binaryTreeService.buildAndSaveTree(input);
        } catch (Exception e) {
            throw new RuntimeException("Failed to process input: " + e.getMessage());
        }
    }
}
