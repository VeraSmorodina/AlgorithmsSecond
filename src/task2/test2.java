package task2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class test2 {
    @Test
    public void findExistingNodeByKey() {
        BSTNode<Integer> root = new BSTNode<>(0, 0, null);
        BST<Integer> bst = new BST<>(root);
        BSTFind<Integer> result = bst.FindNodeByKey(0);
        Assertions.assertEquals(root, result.Node);
    }

    @Test
    public void findExistingNodeByKey2() {
        BSTNode<Integer> root = new BSTNode<>(0, 0, null);
        BST<Integer> bst = new BST<>(root);
        BSTFind<Integer> result = bst.FindNodeByKey(0);
        Assertions.assertEquals(root, result.Node);
    }

    @Test
    public void findLeftAbsentNodeByKey() {
        BSTNode<Integer> root = new BSTNode<>(5, 0, null);
        BST<Integer> bst = new BST<>(root);
        BSTFind<Integer> result = bst.FindNodeByKey(1);
        Assertions.assertEquals(result.Node, root);
        Assertions.assertFalse(result.NodeHasKey);
        Assertions.assertTrue(result.ToLeft);
    }

    @Test
    public void findRightAbsentNodeByKey() {
        BSTNode<Integer> root = new BSTNode<>(5, 0, null);
        BST<Integer> bst = new BST<>(root);
        BSTFind<Integer> result = bst.FindNodeByKey(6);
        Assertions.assertEquals(result.Node, root);
        Assertions.assertFalse(result.NodeHasKey);
        Assertions.assertFalse(result.ToLeft);
    }

    @Test
    public void findNodeByKeyInEmptyTree() {
        BST<Integer> bst = new BST<>(null);
        BSTFind<Integer> result = bst.FindNodeByKey(0);
        Assertions.assertNull(result.Node);
    }

    @Test
    public void addRight() {
        BSTNode<Integer> root = new BSTNode<>(0, 0, null);
        BST<Integer> bst = new BST<>(root);
        boolean resultAdding = bst.AddKeyValue(1, 2);
        Assertions.assertTrue(resultAdding);
        BSTFind<Integer> resultSearching = bst.FindNodeByKey(1);
        Assertions.assertEquals(root.RightChild, resultSearching.Node);
    }

    @Test
    public void addLeft() {
        BSTNode<Integer> root = new BSTNode<>(6, 0, null);
        BST<Integer> bst = new BST<>(root);
        boolean resultAdding = bst.AddKeyValue(1, 2);
        Assertions.assertTrue(resultAdding);
        BSTFind<Integer> resultSearching = bst.FindNodeByKey(1);
        Assertions.assertEquals(root.LeftChild, resultSearching.Node);
    }

    @Test
    public void addExistingTest() {
        BSTNode<Integer> root = new BSTNode<>(0, 0, null);
        BST<Integer> bst = new BST<>(root);
        boolean resultAdding = bst.AddKeyValue(0, 2);
        Assertions.assertFalse(resultAdding);
    }

    @Test
    public void addExistingTest2() {
        BSTNode<Integer> root = new BSTNode<>(0, 0, null);
        BST<Integer> bst = new BST<>(root);
        boolean resultAddingT = bst.AddKeyValue(1, 0);
        boolean resultAddingT2 = bst.AddKeyValue(-1, 0);
        boolean resultAddingT3 = bst.AddKeyValue(2, 0);

        Assertions.assertTrue(resultAddingT);
        Assertions.assertEquals(root.LeftChild.NodeKey, -1);
        Assertions.assertTrue(resultAddingT2);
        Assertions.assertEquals(root.RightChild.NodeKey, 1);
        Assertions.assertTrue(resultAddingT3);
        Assertions.assertEquals(root.RightChild.RightChild.NodeKey, 2);
        Assertions.assertNull(root.RightChild.LeftChild);

        boolean resultAdding = bst.AddKeyValue(1, 1);
        boolean resultAdding2 = bst.AddKeyValue(-1, 1);
        boolean resultAdding3 = bst.AddKeyValue(0, 1);
        boolean resultAdding4 = bst.AddKeyValue(2, 1);

        Assertions.assertFalse(resultAdding);
        Assertions.assertFalse(resultAdding2);
        Assertions.assertFalse(resultAdding3);
        Assertions.assertFalse(resultAdding4);
    }

    @Test
    public void addExistingTest3() {
        BSTNode<Integer> root = new BSTNode<>(0, 0, null);
        BST<Integer> bst = new BST<>(root);
        boolean resultAddingT = bst.AddKeyValue(1, 0);
        boolean resultAddingT2 = bst.AddKeyValue(-1, 0);
        boolean resultAddingT3 = bst.AddKeyValue(2, 0);
        boolean resultAddingT4 = bst.AddKeyValue(3, 0);
        boolean resultAddingT5 = bst.AddKeyValue(4, 0);
        boolean resultAdding = bst.AddKeyValue(1, 0);
        boolean resultAdding2 = bst.AddKeyValue(-1, 0);
        boolean resultAdding3 = bst.AddKeyValue(0, 0);
        boolean resultAdding4 = bst.AddKeyValue(3, 0);
        boolean resultAdding5 = bst.AddKeyValue(4, 0);

        Assertions.assertTrue(resultAddingT);
        Assertions.assertTrue(resultAddingT2);
        Assertions.assertTrue(resultAddingT3);
        Assertions.assertTrue(resultAddingT4);
        Assertions.assertTrue(resultAddingT5);

        Assertions.assertFalse(resultAdding);
        Assertions.assertFalse(resultAdding2);
        Assertions.assertFalse(resultAdding3);
        Assertions.assertFalse(resultAdding4);
        Assertions.assertFalse(resultAdding5);
        Assertions.assertEquals(bst.Count(), 6);
    }

    @Test
    public void addExistingTest4() {
        BST<Integer> tree = new BST<Integer>(new BSTNode<Integer>(8, 0, null));
        boolean result = tree.AddKeyValue(8, 0);
        Assertions.assertFalse(result);
        Assertions.assertNull(tree.Root.LeftChild);
        Assertions.assertNull(tree.Root.RightChild);
    }

    @Test
    public void addExistingTest5() {
        BST<Integer> tree = new BST<Integer>(new BSTNode<Integer>(8, 0, null));
        tree.DeleteNodeByKey(8);
        boolean result = tree.AddKeyValue(8, 0);
        Assertions.assertTrue(result);
    }

    @Test
    public void addInEmptyTreeTest() {
        BST<Integer> bst = new BST<>(null);
        boolean resultAdding = bst.AddKeyValue(0, 2);
        Assertions.assertTrue(resultAdding);
    }

    @Test
    public void findMaxFromRootTest() {
        BSTNode<Integer> root = new BSTNode<>(10, 0, null);
        BST<Integer> bst = new BST<>(root);
        bst.AddKeyValue(5, 2);
        bst.AddKeyValue(11, 4);
        BSTNode<Integer> result = bst.FinMinMax(root, true);
        Assertions.assertEquals(11, result.NodeKey);
    }

    @Test
    public void findMaxFromChildTest() {
        BSTNode<Integer> root = new BSTNode<>(10, 0, null);
        BST<Integer> bst = new BST<>(root);
        bst.AddKeyValue(5, 2);
        bst.AddKeyValue(11, 4);
        bst.AddKeyValue(7, 4);
        BSTNode<Integer> result = bst.FinMinMax(root.LeftChild, true);
        Assertions.assertEquals(7, result.NodeKey);
    }

    @Test
    public void findMaxInEmptyTreeTest() {
        BST<Integer> bst = new BST<>(null);
        BSTNode<Integer> result = bst.FinMinMax(new BSTNode<>(10, 0, null), true);
        Assertions.assertNull(result);
    }

    @Test
    public void findMinFromRootTest() {
        BSTNode<Integer> root = new BSTNode<>(10, 0, null);
        BST<Integer> bst = new BST<>(root);
        bst.AddKeyValue(5, 2);
        bst.AddKeyValue(11, 4);
        BSTNode<Integer> result = bst.FinMinMax(root, false);
        Assertions.assertEquals(5, result.NodeKey);
    }

    @Test
    public void findMinFromChildTest() {
        BSTNode<Integer> root = new BSTNode<>(7, 0, null);
        BST<Integer> bst = new BST<>(root);
        bst.AddKeyValue(5, 2);
        bst.AddKeyValue(13, 4);
        bst.AddKeyValue(9, 4);
        BSTNode<Integer> result = bst.FinMinMax(root.RightChild, false);
        Assertions.assertEquals(9, result.NodeKey);
    }

    @Test
    public void deleteLeftChildTest() {
        BSTNode<Integer> root = new BSTNode<>(8, 0, null);
        BST<Integer> bst = new BST<>(root);
        bst.AddKeyValue(4, 2);
        bst.AddKeyValue(12, 4);
        boolean result = bst.DeleteNodeByKey(4);
        Assertions.assertNull(bst.Root.LeftChild);
        Assertions.assertTrue(result);

    }

    @Test
    public void deleteTest2() {
        BSTNode<Integer> root = new BSTNode<>(8, 0, null);
        BST<Integer> bst = new BST<>(root);
        bst.AddKeyValue(4, 2);
        bst.AddKeyValue(12, 4);
        bst.AddKeyValue(2, 4);
        boolean result = bst.DeleteNodeByKey(4);
        Assertions.assertTrue(result);
        Assertions.assertEquals(bst.Root.LeftChild.NodeKey, 2);
    }

    @Test
    public void deleteTest3() {
        BSTNode<Integer> root = new BSTNode<>(8, 0, null);
        BST<Integer> bst = new BST<>(root);
        bst.AddKeyValue(4, 2);
        bst.AddKeyValue(2, 4);
        bst.AddKeyValue(6, 4);
        boolean result = bst.DeleteNodeByKey(4);
        Assertions.assertTrue(result);
    }

    @Test
    public void deleteTest4() {
        BST<Integer> bst = new BST<>(null);
        boolean result = bst.DeleteNodeByKey(4);
        Assertions.assertFalse(result);
    }

    @Test
    public void countTest() {
        BSTNode<Integer> root = new BSTNode<>(7, 0, null);
        BST<Integer> bst = new BST<>(root);
        bst.AddKeyValue(5, 2);
        bst.AddKeyValue(13, 4);
        bst.AddKeyValue(9, 4);
        int count = bst.Count();
        Assertions.assertEquals(4, count);
    }

    @Test
    public void countTest2() {
        BST<Integer> bst = new BST<>(null);
        int count = bst.Count();
        Assertions.assertEquals(0, count);
    }

    @Test
    public void isIdenticalTest1() {
        BSTNode<Integer> root = new BSTNode<>(0, 0, null);
        BST<Integer> bst = new BST<>(root);
        bst.AddKeyValue(1, 1);
        bst.AddKeyValue(2, 2);
        bst.AddKeyValue(3, 3);
        bst.AddKeyValue(4, 4);


        BSTNode<Integer> root1 = new BSTNode<>(0, 0, null);
        BST<Integer> bst1 = new BST<>(root1);
        bst1.AddKeyValue(1, 1);
        bst1.AddKeyValue(2, 2);
        bst1.AddKeyValue(3, 3);
        bst1.AddKeyValue(4, 4);

        Assertions.assertTrue(bst.isIdentical(bst1));
        Assertions.assertTrue(bst.isIdentical(bst));
    }

    @Test
    public void isIdenticalTest2() {
        BSTNode<Integer> root = new BSTNode<>(0, 0, null);
        BST<Integer> bst = new BST<>(root);
        bst.AddKeyValue(1, 1);
        bst.AddKeyValue(2, 2);
        bst.AddKeyValue(3, 3);
        bst.AddKeyValue(4, 4);


        BSTNode<Integer> root1 = new BSTNode<>(0, 0, null);
        BST<Integer> bst1 = new BST<>(root1);
        bst1.AddKeyValue(1, 1);
        bst1.AddKeyValue(2, 2);
        bst1.AddKeyValue(3, 3);
        bst1.AddKeyValue(5, 5);

        Assertions.assertFalse(bst.isIdentical(bst1));
    }

    @Test
    public void findPathsOfLengthTest1() {
        BSTNode<Integer> root = new BSTNode<>(8, 0, null);
        BST<Integer> bst = new BST<>(root);
        bst.AddKeyValue(4, 12);
        bst.AddKeyValue(2, 2);
        bst.AddKeyValue(6, 3);
        bst.AddKeyValue(5, 5);

        List<BSTNode<Integer>> res = new ArrayList<>();
        res.add(bst.Root);
        res.add(bst.Root.LeftChild);
        res.add(bst.Root.LeftChild.RightChild);
        res.add(bst.Root.LeftChild.RightChild.LeftChild);

        Assertions.assertEquals(res, bst.findPathsOfLength(4));
    }

    @Test
    public void findMaxSumPathTest1() {
        BSTNode<Integer> root = new BSTNode<>(8, 10, null);
        BST<Integer> bst = new BST<>(root);
        bst.AddKeyValue(4, 20);
        bst.AddKeyValue(2, 300);
        bst.AddKeyValue(6, 40);
        bst.AddKeyValue(5, 100);

        List<BSTNode<Integer>> res = new ArrayList<>();
        res.add(bst.Root);
        res.add(bst.Root.LeftChild);
        res.add(bst.Root.LeftChild.LeftChild);

        Assertions.assertEquals(res, bst.findMaxSumPath());
    }
}

