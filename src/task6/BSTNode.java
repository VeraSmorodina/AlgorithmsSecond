import java.util.*;

class BSTNode {
    public int NodeKey;
    public BSTNode Parent;
    public BSTNode LeftChild;
    public BSTNode RightChild;
    public int Level;

    public BSTNode(int key, BSTNode parent) {
        NodeKey = key;
        Parent = parent;
        LeftChild = null;
        RightChild = null;
    }
}

class BalancedBST {
    public BSTNode Root;

    public BalancedBST() {
        Root = null;
    }

    public void GenerateTree(int[] a) {
        Arrays.sort(a);
        Root = generate(a, null);
    }

    private BSTNode generate(int[] a, BSTNode parent) {
        if (a.length == 0) return null;
        int middleElementIndex = a.length / 2;
        BSTNode bstNode = new BSTNode(a[middleElementIndex], parent);
        if (parent != null) bstNode.Level = parent.Level + 1;
        else bstNode.Level = 0;
        bstNode.LeftChild = generate(Arrays.copyOfRange(a, 0, middleElementIndex), bstNode);
        bstNode.RightChild = generate(Arrays.copyOfRange(a, middleElementIndex + 1, a.length), bstNode);
        return bstNode;
    }

    public boolean IsBalanced(BSTNode root_node) {
        if (root_node == null) return false;
        LinkedList<BSTNode> queue = new LinkedList<>();
        queue.add(root_node);
        while (queue.size() > 0) {
            BSTNode tempNode = queue.get(0);
            queue.remove(0);
            if (tempNode.LeftChild != null && tempNode.LeftChild.NodeKey >= tempNode.NodeKey) {
                return false;
            }
            if (tempNode.LeftChild != null) {
                queue.add(tempNode.LeftChild);
            }
            if (tempNode.RightChild != null && tempNode.RightChild.NodeKey < tempNode.NodeKey) {
                return false;
            }
            if (tempNode.RightChild != null) {
                queue.add(tempNode.RightChild);
            }
        }
        return true;
    }

    public boolean isLevelsBalanced(BSTNode root_node) {
        int levelL = calculateLevel(root_node.LeftChild);
        int levelR = calculateLevel(root_node.RightChild);
        int k = levelR - levelL;
        return k < 2 && k > -2;
    }

    private int calculateLevel(BSTNode root_node) {
        if (root_node == null) return 0;
        int currentLevel = root_node.Level;
        LinkedList<BSTNode> queue = new LinkedList<>();
        queue.add(root_node);
        while (queue.size() > 0) {
            BSTNode tempNode = queue.get(0);
            queue.remove(0);
            if (tempNode.LeftChild != null) {
                currentLevel = tempNode.LeftChild.Level;
                queue.add(tempNode.LeftChild);
            }
            if (tempNode.RightChild != null) {
                currentLevel = tempNode.RightChild.Level;
                queue.add(tempNode.RightChild);
            }
        }
        return currentLevel;
    }
}