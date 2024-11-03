package task6;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BalancedBSTTest {
      @Test
    public void isBalancedTest1(){
        BalancedBST balancedBST = new BalancedBST();
        balancedBST.GenerateTree(new int[]{1, 2, 3});
        Assertions.assertTrue(balancedBST.IsBalanced(balancedBST.Root));
    }

    @Test
    public void isBalancedTest2(){
        BalancedBST balancedBST = new BalancedBST();
        balancedBST.GenerateTree(new int[]{1, 2, 3, 4, 5});
        Assertions.assertTrue(balancedBST.IsBalanced(balancedBST.Root));
    }

    @Test
    public void isBalancedTest3(){
        BalancedBST balancedBST = new BalancedBST();
        balancedBST.GenerateTree(new int[]{0});
        Assertions.assertTrue(balancedBST.IsBalanced(balancedBST.Root));
    }

    @Test
    public void isBalancedTest4(){
        BalancedBST balancedBST = new BalancedBST();
        balancedBST.GenerateTree(new int[]{0, 1});
        Assertions.assertTrue(balancedBST.IsBalanced(balancedBST.Root));
    }

    @Test
    public void isBalancedTest5(){
        BalancedBST balancedBST = new BalancedBST();
        balancedBST.GenerateTree(new int[]{0, 1, 2, 3});
        Assertions.assertTrue(balancedBST.IsBalanced(balancedBST.Root));
    }

    @Test
    public void isNotBalancedTest(){
        BalancedBST balancedBST = new BalancedBST();
        BSTNode root = new BSTNode(50, null);
        root.Level = 0;
        root.LeftChild = new BSTNode(25, root);
        root.LeftChild.Level = 1;
        root.RightChild = new BSTNode(75, root);
        root.RightChild.Level = 1;
        root.LeftChild.RightChild = new BSTNode(37, root);
        root.LeftChild.RightChild.Level = 2;
        root.LeftChild.RightChild.LeftChild = new BSTNode(31, root);
        root.LeftChild.RightChild.LeftChild.Level = 3;
        root.LeftChild.RightChild.RightChild = new BSTNode(43, root);
        root.LeftChild.RightChild.RightChild.Level = 3;
        Assertions.assertFalse(balancedBST.IsBalanced(root));
    }

    @Test
    public void isNotBalancedTest2(){
        BalancedBST balancedBST = new BalancedBST();
        BSTNode root = new BSTNode(50, null);
        root.Level = 0;
        root.LeftChild = new BSTNode(25, root);
        root.LeftChild.Level = 1;
        root.RightChild = new BSTNode(75, root);
        root.RightChild.Level = 1;
        root.LeftChild.RightChild = new BSTNode(37, root);
        root.LeftChild.RightChild.Level = 2;
        root.LeftChild.RightChild.LeftChild = new BSTNode(31, root);
        root.LeftChild.RightChild.LeftChild.Level = 3;
        root.LeftChild.RightChild.RightChild = new BSTNode(43, root);
        root.LeftChild.RightChild.RightChild.Level = 3;
        Assertions.assertFalse(balancedBST.IsBalanced(root));
    }

    @Test
    public void isNotBalancedTest3(){
        BalancedBST balancedBST = new BalancedBST();
        BSTNode root = new BSTNode(50, null);
        root.Level = 0;
        root.LeftChild = new BSTNode(65, root);
        root.LeftChild.Level = 1;
        root.RightChild = new BSTNode(75, root);
        root.RightChild.Level = 1;
        Assertions.assertFalse(balancedBST.IsBalanced(root));
    }

    @Test
    public void isNotBalancedTest4(){
        BalancedBST balancedBST = new BalancedBST();
        BSTNode root = new BSTNode(10, null);
        root.Level = 0;
        root.LeftChild = new BSTNode(5, root);
        root.LeftChild.Level = 1;
        root.RightChild = new BSTNode(15, root);
        root.RightChild.Level = 1;
        root.LeftChild.LeftChild = new BSTNode(4, root.LeftChild);
        root.LeftChild.LeftChild.Level = 2;
        root.LeftChild.LeftChild.LeftChild = new BSTNode(3, root.LeftChild.LeftChild);
        root.LeftChild.LeftChild.LeftChild.Level = 3;
        Assertions.assertFalse(balancedBST.IsBalanced(root));
    }

    @Test
    public void isNotBalancedTest5(){
        BalancedBST balancedBST = new BalancedBST();
        BSTNode root = new BSTNode(10, null);
        root.Level = 0;
        root.LeftChild = new BSTNode(5, root);
        root.LeftChild.Level = 1;
        root.RightChild = new BSTNode(15, root);
        root.RightChild.Level = 1;
        root.RightChild.RightChild = new BSTNode(16, root.RightChild);
        root.RightChild.RightChild.Level = 2;
        root.RightChild.RightChild.RightChild = new BSTNode(18, root.RightChild.RightChild);
        root.RightChild.RightChild.RightChild.Level = 3;
        Assertions.assertFalse(balancedBST.IsBalanced(root));
    }

    @Test
    public void isNotBalancedTest6(){
        BalancedBST balancedBST = new BalancedBST();
        BSTNode root = new BSTNode(10, null);
        root.Level = 0;
        root.LeftChild = new BSTNode(5, root);
        root.LeftChild.Level = 1;
        root.LeftChild.LeftChild = new BSTNode(3, root.LeftChild);
        root.LeftChild.LeftChild.Level = 2;
        Assertions.assertFalse(balancedBST.IsBalanced(root));
    }

}
