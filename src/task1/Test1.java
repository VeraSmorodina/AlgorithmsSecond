package task1;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class Test1 {
    @Test
    public void addNodeTest() {
        SimpleTreeNode<Integer> root = new SimpleTreeNode<>(0, null);
        SimpleTree<Integer> simpleTree = new SimpleTree<Integer>(root);
        simpleTree.AddChild(root, new SimpleTreeNode<Integer>(1, root));
        simpleTree.AddChild(root, new SimpleTreeNode<Integer>(2, root));
        Assertions.assertEquals(3, simpleTree.Count());
    }


    @Test
    public void getCountTest() {
        SimpleTreeNode<Integer> root = new SimpleTreeNode<>(0, null);
        SimpleTree<Integer> simpleTree = new SimpleTree<Integer>(root);
        int count = simpleTree.Count();
        Assertions.assertEquals(1, count);
    }

    @Test
    public void getLeafsCountTest() {
        SimpleTreeNode<Integer> root = new SimpleTreeNode<>(0, null);
        SimpleTree<Integer> simpleTree = new SimpleTree<Integer>(root);
        SimpleTreeNode<Integer> firstNode = new SimpleTreeNode<Integer>(1, root);
        simpleTree.AddChild(root, new SimpleTreeNode<Integer>(1, root));
        simpleTree.AddChild(root, firstNode);
        simpleTree.AddChild(firstNode, new SimpleTreeNode<Integer>(2, root));
        int count = simpleTree.LeafCount();
        Assertions.assertEquals(2, count);
    }

    @Test
    public void deleteNodeTest() {
        SimpleTreeNode<Integer> root = new SimpleTreeNode<>(0, null);
        SimpleTree<Integer> simpleTree = new SimpleTree<Integer>(root);
        Assertions.assertEquals(1, simpleTree.Count());
        SimpleTreeNode<Integer> nodeToDelete = new SimpleTreeNode<Integer>(1, root);
        simpleTree.AddChild(root, nodeToDelete);
        Assertions.assertEquals(2, simpleTree.Count());
        simpleTree.AddChild(nodeToDelete, new SimpleTreeNode<Integer>(2, nodeToDelete));
        simpleTree.DeleteNode(nodeToDelete);
        Assertions.assertEquals(1, simpleTree.Count());
        Assertions.assertEquals(1, simpleTree.LeafCount());
    }

    @Test
    public void deleteNodeTest2() {
        SimpleTreeNode<Integer> root = new SimpleTreeNode<>(0, null);
        SimpleTree<Integer> simpleTree = new SimpleTree<Integer>(root);
        Assertions.assertEquals(1, simpleTree.Count());
        SimpleTreeNode<Integer> nodeToDelete = new SimpleTreeNode<Integer>(1, root);
        simpleTree.AddChild(root, nodeToDelete);
        Assertions.assertEquals(2, simpleTree.Count());
        simpleTree.AddChild(root, new SimpleTreeNode<Integer>(2, root));
        simpleTree.DeleteNode(nodeToDelete);
        Assertions.assertEquals(2, simpleTree.Count());
        Assertions.assertEquals(1, simpleTree.LeafCount());
    }

    @Test
    public void findNodesByValueTest() {
        SimpleTreeNode<Integer> root = new SimpleTreeNode<>(0, null);
        SimpleTree<Integer> simpleTree = new SimpleTree<Integer>(root);
        simpleTree.AddChild(root, new SimpleTreeNode<Integer>(1, root));
        simpleTree.AddChild(root, new SimpleTreeNode<Integer>(1, root));
        simpleTree.AddChild(root, new SimpleTreeNode<Integer>(2, root));
        int size = simpleTree.FindNodesByValue(1).size();
        Assertions.assertEquals(2, size);
    }

    @Test
    public void moveNodeTest() {
        SimpleTreeNode<Integer> root = new SimpleTreeNode<>(0, null);
        SimpleTree<Integer> simpleTree = new SimpleTree<Integer>(root);
        SimpleTreeNode<Integer> firstNode = new SimpleTreeNode<Integer>(1, root);
        simpleTree.AddChild(root, firstNode);
        SimpleTreeNode<Integer> secondNode = new SimpleTreeNode<Integer>(2, root);
        simpleTree.AddChild(firstNode, secondNode);
        SimpleTreeNode<Integer> thirdNode = new SimpleTreeNode<Integer>(3, root);
        simpleTree.AddChild(secondNode, thirdNode);
        simpleTree.MoveNode(secondNode, root);
        Assertions.assertEquals(secondNode.Parent, root);
        Assertions.assertEquals(1, secondNode.Children.size());
        Assertions.assertNull( firstNode.Children);
    }
}

