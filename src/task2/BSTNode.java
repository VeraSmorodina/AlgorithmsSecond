package task2;

import java.util.*;

public class BSTNode<T> {
    public int NodeKey; // ключ узла
    public T NodeValue; // значение в узле
    public BSTNode<T> Parent; // родитель или null для корня
    public BSTNode<T> LeftChild; // левый потомок
    public BSTNode<T> RightChild; // правый потомок

    public BSTNode(int key, T val, BSTNode<T> parent)
    {
        NodeKey = key;
        NodeValue = val;
        Parent = parent;
        LeftChild = null;
        RightChild = null;
    }
}

// промежуточный результат поиска
class BSTFind<T>
{
    // null если в дереве вообще нету узлов
    public BSTNode<T> Node;

    // true если узел найден
    public boolean NodeHasKey;

    // true, если родительскому узлу надо добавить новый левым
    public boolean ToLeft;

    public BSTFind() { Node = null; }
}

class BST<T>
{
    BSTNode<T> Root;

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
}
