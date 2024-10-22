package task2;

import java.util.*;

public class BSTNode<T> {
    public int NodeKey;
    public T NodeValue;
    public BSTNode<T> Parent;
    public BSTNode<T> LeftChild;
    public BSTNode<T> RightChild;

    public BSTNode(int key, T val, BSTNode<T> parent) {
        NodeKey = key;
        NodeValue = val;
        Parent = parent;
        LeftChild = null;
        RightChild = null;
    }
}

class BSTFind<T> {
    public BSTNode<T> Node;

    public boolean NodeHasKey;

    public boolean ToLeft;

    public BSTFind() {
        Node = null;
    }
}

class BST<T> {
    BSTNode<T> Root;
    private int levelMaxSum = -1;

    public BST(BSTNode<T> node) {
        Root = node;
    }

    public BSTFind<T> FindNodeByKey(int key) {
        if (Root == null) return new BSTFind<>();
        return findNode(key, Root);
    }

    private BSTFind<T> findNode(int key, BSTNode<T> currentNode) {
        if (key == currentNode.NodeKey) {
            BSTFind<T> bstFind = new BSTFind<>();
            bstFind.Node = currentNode;
            bstFind.NodeHasKey = true;
            return bstFind;
        }
        if (key < currentNode.NodeKey && currentNode.LeftChild != null) {
            currentNode = currentNode.LeftChild;
            return findNode(key, currentNode);
        }
        if (key > currentNode.NodeKey && currentNode.RightChild != null) {
            currentNode = currentNode.RightChild;
            return findNode(key, currentNode);
        }
        if (key < currentNode.NodeKey) {
            BSTFind<T> bstFind = new BSTFind<>();
            bstFind.Node = currentNode;
            bstFind.NodeHasKey = false;
            bstFind.ToLeft = true;
            return bstFind;
        }
        BSTFind<T> bstFind = new BSTFind<>();
        bstFind.Node = currentNode;
        bstFind.NodeHasKey = false;
        bstFind.ToLeft = false;
        return bstFind;
    }

    public boolean AddKeyValue(int key, T val) {
        if (Root == null) {
            Root = new BSTNode<>(key, val, null);
            return true;
        }
        BSTFind<T> bstFind = findNode(key, Root);
        if (bstFind.NodeHasKey) {
            return false;
        }
        if (bstFind.ToLeft) {
            bstFind.Node.LeftChild = new BSTNode<>(key, val, bstFind.Node);
        } else {
            bstFind.Node.RightChild = new BSTNode<>(key, val, bstFind.Node);
        }
        return true;
    }

    public BSTNode<T> FinMinMax(BSTNode<T> FromNode, boolean FindMax) {
        if (Root == null) return null;
        if (FindMax) {
            return findMax(FromNode);
        }
        return findMin(FromNode);
    }

    private BSTNode<T> findMin(BSTNode<T> FromNode) {
        BSTNode<T> nextNode = FromNode.LeftChild;
        if (nextNode == null) {
            return FromNode;
        }
        return findMin(nextNode);
    }

    private BSTNode<T> findMax(BSTNode<T> FromNode) {
        BSTNode<T> nextNode = FromNode.RightChild;
        if (nextNode == null) {
            return FromNode;
        }
        return findMax(nextNode);
    }


    public boolean DeleteNodeByKey(int key) {
        if (Root == null) return false;
        BSTFind<T> nodeForDelete = FindNodeByKey(key);
        if (key == Root.NodeKey || nodeForDelete.Node.Parent == null) {
            Root = null;
            return true;
        }
        if (nodeForDelete.Node.LeftChild == null && nodeForDelete.Node.RightChild == null) {
            removeLastNode(nodeForDelete.Node);
            return true;
        }
        BSTNode<T> nodeForReplace;
        if (nodeForDelete.Node.RightChild == null) {
            nodeForReplace = nodeForDelete.Node.LeftChild;
        } else {
            nodeForReplace = FinMinMax(nodeForDelete.Node.RightChild, false);
        }
        if (!nodeForDelete.NodeHasKey)
            return false;
        nodeForDelete.Node.NodeKey = nodeForReplace.NodeKey;
        nodeForDelete.Node.NodeValue = nodeForReplace.NodeValue;
        if (nodeForReplace.RightChild != null) {
            nodeForDelete.Node.RightChild = nodeForReplace.RightChild;
            return true;
        }
        removeLastNode(nodeForReplace);
        return true;
    }

    private void removeLastNode(BSTNode<T> nodeForDelete) {
        if (nodeForDelete.Parent == null) return;
        if (nodeForDelete.Parent.LeftChild != null && nodeForDelete.Parent.LeftChild.equals(nodeForDelete)) {
            nodeForDelete.Parent.LeftChild = null;
        }
        if (nodeForDelete.Parent.RightChild != null && nodeForDelete.Parent.RightChild.equals(nodeForDelete)) {
            nodeForDelete.Parent.RightChild = null;
        }
    }

    public int Count() {
        if (Root == null) return 0;
        return getNodes(new ArrayList<>(), Root).size();
    }

    public List<BSTNode<T>> getNodes(List<BSTNode<T>> nodeList, BSTNode<T> currentNode) {
        nodeList.add(currentNode);
        if (currentNode.LeftChild == null && currentNode.RightChild == null) {
            return nodeList;
        }
        if (currentNode.LeftChild != null) {
            getNodes(nodeList, currentNode.LeftChild);
        }
        if (currentNode.RightChild != null) {
            getNodes(nodeList, currentNode.RightChild);
        }
        return nodeList;
    }


    //    Задание 1
    public boolean isIdentical(BST<T> otherTree) {
        return isIdentical(this.Root, otherTree.Root);
    }

    private boolean isIdentical(BSTNode<T> node1, BSTNode<T> node2) {
        if (node1 == null && node2 == null) {
            return true;
        }
        if (node1 == null || node2 == null) {
            return false;
        }
        if (node1.NodeKey != node2.NodeKey || !node1.NodeValue.equals(node2.NodeValue)) {
            return false;
        }
        return isIdentical(node1.LeftChild, node2.LeftChild) &&
                isIdentical(node1.RightChild, node2.RightChild);
    }

    //    Задание 2
    public List<BSTNode<T>> findPathsOfLength(int length) {
        List<BSTNode<T>> paths = new ArrayList<>();
        findPathsOfLength(Root, new ArrayList<>(), paths, length);
        return paths;
    }

    private void findPathsOfLength(BSTNode<T> currentNode, List<BSTNode<T>> currentPath,
                                   List<BSTNode<T>> paths, int length) {
        if (currentNode == null) return;
        currentPath.add(currentNode);
        if (currentNode.LeftChild == null && currentNode.RightChild == null && currentPath.size() == length) {
            paths.addAll(new ArrayList<>(currentPath));
        } else {
            findPathsOfLength(currentNode.LeftChild, currentPath, paths, length);
            findPathsOfLength(currentNode.RightChild, currentPath, paths, length);
        }
        currentPath.remove(currentPath.size() - 1);
    }


    //    Задание 3
    public List<BSTNode<T>> findMaxSumPath() {
        List<BSTNode<T>> maxPath = new ArrayList<>();
        findMaxSumPath(Root, new ArrayList<>(), maxPath, 0);
        return maxPath;
    }

    private void findMaxSumPath(BSTNode<T> currentNode, List<BSTNode<T>> currentPath,
                                List<BSTNode<T>> maxPath, int currentSum) {
        if (currentNode == null) return;
        currentPath.add(currentNode);
        if (currentNode.NodeValue instanceof Integer) {
            currentSum += (Integer) currentNode.NodeValue;
        } else {
            currentSum += currentNode.NodeValue.hashCode();
        }

        if (currentNode.LeftChild == null && currentNode.RightChild == null && (maxPath.isEmpty() || currentSum > getCurrentMaxSum(maxPath))) {
            maxPath.clear();
            maxPath.addAll(new ArrayList<>(currentPath)); // Сохраняем новый путь
        } else {
            findMaxSumPath(currentNode.LeftChild, currentPath, maxPath, currentSum);
            findMaxSumPath(currentNode.RightChild, currentPath, maxPath, currentSum);
        }
        currentPath.remove(currentPath.size() - 1);
    }

    // Метод для получения текущей максимальной суммы из пути
    private double getCurrentMaxSum(List<BSTNode<T>> path) {
        double sum = 0;
        for (BSTNode<T> node : path) {
            if (node.NodeValue instanceof Integer) {
                sum += (Integer) node.NodeValue;
            } else {
                sum += node.NodeValue.hashCode();
            }
        }
        return sum;
    }


    //    Урок 3
    //    Задание 1
    public List<BSTNode> WideAllNodes() {
        if (Root == null) return new ArrayList<>();
        List<BSTNode> nodeArrayList = new ArrayList<>();
        LinkedList<BSTNode<T>> queue = new LinkedList<>();
        queue.add(Root);
        int maxSum = Integer.MIN_VALUE;
        int levelWithMaxSum = 0;
        int currentLevel = 0;

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            int currentSum = 0;
            for (int i = 0; i < levelSize; i++) {
                BSTNode<T> tempNode = queue.poll();
                nodeArrayList.add(tempNode);
                currentSum += tempNode.NodeKey;
                if (tempNode.LeftChild != null) {
                    queue.add(tempNode.LeftChild);
                }
                if (tempNode.RightChild != null) {
                    queue.add(tempNode.RightChild);
                }
            }
            if (currentSum > maxSum) {
                maxSum = currentSum;
                levelWithMaxSum = currentLevel;
            }
            currentLevel++;
        }
        levelMaxSum = levelWithMaxSum;
        return nodeArrayList;
    }

    // Задание 2
    public ArrayList<BSTNode> DeepAllNodes(int parameter) {
        ArrayList<BSTNode> nodes = new ArrayList<>();
        switch (parameter) {
            case 0 -> {
                return inOrder(nodes, Root);
            }
            case 1 -> {
                return postOrder(nodes, Root);
            }
            case 2 -> {
                return preOrder(nodes, Root);
            }
        }
        return null;
    }

    private ArrayList<BSTNode> preOrder(ArrayList<BSTNode> list, BSTNode currentNode) {
        if (currentNode == null) return list;
        list.add(currentNode);
        preOrder(list, currentNode.LeftChild);
        preOrder(list, currentNode.RightChild);
        return list;
    }

    private ArrayList<BSTNode> inOrder(ArrayList<BSTNode> list, BSTNode currentNode) {
        if (currentNode == null) return list;
        inOrder(list, currentNode.LeftChild);
        list.add(currentNode);
        inOrder(list, currentNode.RightChild);
        return list;
    }

    private ArrayList<BSTNode> postOrder(ArrayList<BSTNode> list, BSTNode currentNode) {
        if (currentNode == null) return list;
        postOrder(list, currentNode.LeftChild);
        postOrder(list, currentNode.RightChild);
        list.add(currentNode);
        return list;
    }

    // Задание 3
    public void invertTree() {
        Root = invertTree(Root);
    }

    private BSTNode<T> invertTree(BSTNode<T> node) {
        if (node == null) return null;
        BSTNode<T> left = invertTree(node.LeftChild);
        BSTNode<T> right = invertTree(node.RightChild);
        node.LeftChild = right;
        node.RightChild = left;
        return node;
    }

    // Задание 4
    public int maxLevelSum() {
        WideAllNodes();
        return levelMaxSum;
    }


    //    Задание 5
    public void buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer, Integer> inorderIndexMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderIndexMap.put(inorder[i], i);
        }
        Root = buildTreeHelper(preorder, 0, preorder.length - 1, 0, inorderIndexMap);
    }

    private BSTNode<T> buildTreeHelper(int[] preorder, int preStart, int preEnd, int inStart,
                                       HashMap<Integer, Integer> inorderIndexMap) {
        if (preStart > preEnd) return null;
        int rootValue = preorder[preStart];
        BSTNode<T> root = new BSTNode<>(rootValue, null, null);
        int inRootIndex = inorderIndexMap.get(rootValue);
        int leftSize = inRootIndex - inStart;
        root.LeftChild = buildTreeHelper(preorder, preStart + 1, preStart + leftSize, inStart, inorderIndexMap);
        root.RightChild = buildTreeHelper(preorder, preStart + leftSize + 1, preEnd, inRootIndex + 1, inorderIndexMap);
        return root;
    }
}
