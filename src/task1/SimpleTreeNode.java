package task1;
import java.util.*;


public class SimpleTreeNode <T> {
    public T NodeValue; // значение в узле
    public SimpleTreeNode<T> Parent; // родитель или null для корня
    public List<SimpleTreeNode<T>> Children; // список дочерних узлов или null

    public SimpleTreeNode(T val, SimpleTreeNode<T> parent) {
        NodeValue = val;
        Parent = parent;
        Children = null;
    }
}


class SimpleTree<T> {
    public SimpleTreeNode<T> Root; // корень, может быть null

    public SimpleTree(SimpleTreeNode<T> root) {
        Root = root;
    }

    public void AddChild(SimpleTreeNode<T> ParentNode, SimpleTreeNode<T> NewChild) {
        if (ParentNode.Children == null){
            ParentNode.Children =  new ArrayList<>();
        }
        ParentNode.Children.add(NewChild);
        NewChild.Parent = ParentNode;
        // ваш код добавления нового дочернего узла существующему ParentNode
    }

    public void DeleteNode(SimpleTreeNode<T> NodeToDelete) {
        NodeToDelete.Parent = null;
        // ваш код удаления существующего узла NodeToDelete
    }

    public List<SimpleTreeNode<T>> GetAllNodes() {
        List<SimpleTreeNode<T>> list = new ArrayList<>();
        traverse(Root, list);
        return list;
        // ваш код выдачи всех узлов дерева в определённом порядке
    }

    private void traverse(SimpleTreeNode<T> node, List<SimpleTreeNode<T>> nodeList) {
        if (node == null) return;
        nodeList.add(node);
        if (node.Children == null) return;
        for (SimpleTreeNode<T> child: node.Children) {
            traverse(child, nodeList);
        }
    }










    public List<SimpleTreeNode<T>> FindNodesByValue(T val) {
        // ваш код поиска узлов по значению
        return null;
    }

    public void MoveNode(SimpleTreeNode<T> OriginalNode, SimpleTreeNode<T> NewParent)
    {
        // ваш код перемещения узла вместе с его поддеревом --
        // в качестве дочернего для узла NewParent
    }

    public int Count() {
        return GetAllNodes().size();
//        int res = 0;
//        return countRec(Root,res);
        // количество всех узлов в дереве

    }

//    private int countRec(SimpleTreeNode<T> node, int res){
//        if (node == null) return res;
//        res++;
//        if (node.Children == null) return res;
//        for (SimpleTreeNode<T> child: node.Children) {
//            return countRec(child, res);
//        }
//        return res;
//    }

    public int LeafCount()
    {
        // количество листьев в дереве
        return 0;
    }
}