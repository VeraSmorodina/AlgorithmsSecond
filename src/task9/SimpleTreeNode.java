import java.util.*;

class SimpleTreeNode<T> {
    public T NodeValue;
    public SimpleTreeNode<T> Parent;
    public List<SimpleTreeNode<T>> Children;
    public int level; // Уровень узла

    public SimpleTreeNode(T val, SimpleTreeNode<T> parent) {
        NodeValue = val;
        Parent = parent;
        Children = null;
    }
}

class SimpleTree<T> {
    public SimpleTreeNode<T> Root;

    public SimpleTree(SimpleTreeNode<T> root) {
        Root = root;
    }

    public void AddChild(SimpleTreeNode<T> ParentNode, SimpleTreeNode<T> NewChild) {
        if (ParentNode.Children == null) ParentNode.Children = new ArrayList<>();
        ParentNode.Children.add(NewChild);
        NewChild.Parent = ParentNode;
    }

    public void DeleteNode(SimpleTreeNode<T> NodeToDelete) {
        if (Root == null) return;
        deleteNode(NodeToDelete, Root);
    }

    private void deleteNode(SimpleTreeNode<T> nodeToDelete, SimpleTreeNode<T> currentNode) {
        if (currentNode.Children == null || currentNode.Children.size() == 0) {
            return;
        }
        if (currentNode.Children.contains(nodeToDelete)) {
            currentNode.Children.remove(nodeToDelete);
            if (currentNode.Children.size() == 0) currentNode.Children = null;
            return;
        }
        for (SimpleTreeNode<T> node : currentNode.Children)
            deleteNode(nodeToDelete, node);
    }

    public List<SimpleTreeNode<T>> GetAllNodes() {
        List<SimpleTreeNode<T>> list = new ArrayList<>();
        if (Root == null)
            return null;
        if (Root.Children == null) {
            list.add(Root);
            return list;
        }
        return traverse(Root, list);
    }

    private List<SimpleTreeNode<T>> traverse(SimpleTreeNode<T> node, List<SimpleTreeNode<T>> nodeList) {
        nodeList.add(node);
        if (node.Children == null || node.Children.size() == 0) {
            return nodeList;
        }
        for (SimpleTreeNode<T> node1 : node.Children) {
            traverse(node1, nodeList);
        }
        return nodeList;
    }

    public List<SimpleTreeNode<T>> FindNodesByValue(T val) {
        List<SimpleTreeNode<T>> nodeList = new ArrayList<>();
        return getNodesByValue(nodeList, Root, val);
    }

    private List<SimpleTreeNode<T>> getNodesByValue(List<SimpleTreeNode<T>> nodeList, SimpleTreeNode<T> currentNode, T value) {
        if (currentNode.NodeValue == value) {
            nodeList.add(currentNode);
            return nodeList;
        }
        if (currentNode.Children == null || currentNode.Children.size() == 0) return nodeList;
        for (SimpleTreeNode<T> node : currentNode.Children) {
            getNodesByValue(nodeList, node, value);
        }
        return nodeList;
    }

    public void MoveNode(SimpleTreeNode<T> OriginalNode, SimpleTreeNode<T> NewParent) {
        DeleteNode(OriginalNode);
        AddChild(NewParent, OriginalNode);
    }

    public int Count() {
        return GetAllNodes().size();
    }

    public int LeafCount() {
        return getLeafsCount(0, Root);
    }

    private int getLeafsCount(int count, SimpleTreeNode<T> currentNode) {
        if (currentNode.Children == null || currentNode.Children.size() == 0) {
            count += 1;
            return count;
        }
        for (SimpleTreeNode<T> node : currentNode.Children) {
            count = getLeafsCount(count, node);
        }
        return count;
    }

    private List<SimpleTreeNode<T>> getNodes(List<SimpleTreeNode<T>> nodeList, SimpleTreeNode<T> currentNode) {
        nodeList.add(currentNode);
        if (currentNode.Children == null || currentNode.Children.size() == 0) {
            return nodeList;
        }
        for (SimpleTreeNode<T> node : currentNode.Children) {
            getNodes(nodeList, node);
        }
        return nodeList;
    }

    public ArrayList<T> EvenTrees() {
        return evenTrees(Root, new ArrayList<>());
    }

    public ArrayList<T> evenTrees(SimpleTreeNode<T> element, ArrayList<T> resultNodes) {
        if (element.Children == null) return resultNodes;
        for (SimpleTreeNode<T> child : element.Children) {
            int childrenCount = getNodes(new ArrayList<>(), child).size();
            if (childrenCount % 2 == 0) {
                resultNodes.add(element.NodeValue);
                resultNodes.add(child.NodeValue);
            }
            evenTrees(child, resultNodes);
        }
        return resultNodes;
    }
}