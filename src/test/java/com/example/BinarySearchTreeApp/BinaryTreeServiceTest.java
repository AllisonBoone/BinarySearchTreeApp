package com.example.BinarySearchTreeApp;

// Imports.
import com.example.BinarySearchTreeApp.model.BinarySearchTree;
import com.example.BinarySearchTreeApp.model.TreeNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.*;

public class BinaryTreeServiceTest {

    // Test for correct placement in BST.
    @Test
    public void testTreeInsertion() {
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(5);
        bst.insert(3);
        bst.insert(7);

        TreeNode root = bst.getRoot();
        assertEquals(5, root.getValue());
        assertEquals(3, root.getLeft().getValue());
        assertEquals(7, root.getRight().getValue());
    }

    // Test for BTS to JSOn conversion.
    @Test
    public void testJsonConversion() throws Exception {
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(2);
        bst.insert(1);
        bst.insert(3);

        Map<String, Object> map = bst.toMap(bst.getRoot());

        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(map);

        assertTrue(json.contains("\"value\":2"));
        assertTrue(json.contains("\"value\":1"));
        assertTrue(json.contains("\"value\":3"));
    }

    // Test for JSON style map structure.
    @Test
    public void testTreeStructureFormat() {
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(10);
        bst.insert(5);

        Map<String, Object> tree = bst.toMap(bst.getRoot());
        assertEquals(10, tree.get("value"));
        assertNotNull(tree.get("left"));
        assertNull(tree.get("right"));

        Map<String, Object> left = (Map<String, Object>) tree.get("left");
        assertEquals(5, left.get("value"));
    }
}
