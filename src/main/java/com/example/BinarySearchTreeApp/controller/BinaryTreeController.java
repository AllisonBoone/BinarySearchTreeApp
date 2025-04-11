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
    public String processNumbers(@RequestParam String input, org.springframework.ui.Model model) {
        try {
            TreeRecord record = binaryTreeService.buildAndSaveTree(input);
            model.addAttribute("tree", record);
            return "result"; // loads result.html
        } catch (Exception e) {
            throw new RuntimeException("Failed to process input: " + e.getMessage());
        }
    }

    // Loads HTML page.
    @GetMapping("/enter-numbers")
    public String enterNumbersPage() {
        return "enter-numbers";
    }

    // Loads previous trees page.
    @GetMapping("/previous-trees")
    public String showPreviousTrees(org.springframework.ui.Model model) {
        model.addAttribute("trees", binaryTreeService.getAllTrees());
        return "previous-trees";
}

}
