package com.example.BinarySearchTreeApp.controller;

// Imports.
import com.example.BinarySearchTreeApp.model.TreeRecord;
import com.example.BinarySearchTreeApp.service.BinaryTreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;

@Controller
public class BinaryTreeController {

    @Autowired
    private BinaryTreeService binaryTreeService;

    // Store numbers with error handling. 
    @PostMapping("/process-numbers")
    @ResponseBody
    public TreeRecord processNumbers(@RequestParam String input) {
        try {
            return binaryTreeService.buildAndSaveTree(input);
        } catch (Exception e) {
            throw new RuntimeException("Failed to process input: " + e.getMessage());
        }
    }

    // Loads HTML form.
    @GetMapping("/enter-numbers")
    public String enterNumbersPage() {
        return "enter-numbers";
    }
}
