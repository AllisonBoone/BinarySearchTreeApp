package com.example.BinarySearchTreeApp.repository;

// Imports.
import com.example.BinarySearchTreeApp.model.TreeRecord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TreeRecordRepository extends JpaRepository<TreeRecord, Long> {
}
