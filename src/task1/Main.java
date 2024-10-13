package task1;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        SimpleTreeNode<Integer> tree1 = new SimpleTreeNode<>(1, null);
        SimpleTree<Integer> per = new SimpleTree<>(tree1);

        SimpleTreeNode<Integer> tree21 = new SimpleTreeNode<>(2, tree1);
        per.AddChild(tree1,tree21);

        SimpleTreeNode<Integer> tree22 = new SimpleTreeNode<>(3, tree1);
        per.AddChild(tree1,tree22);

        SimpleTreeNode<Integer> tree31 = new SimpleTreeNode<>(4, tree21);
        per.AddChild(tree21,tree31);

        SimpleTreeNode<Integer> tree32 = new SimpleTreeNode<>(5, tree21);
        per.AddChild(tree21,tree32);

        System.out.println(per.Count());
//        List<SimpleTreeNode<Integer>> list = per.GetAllNodes();
//        System.out.println("Список всех узлов в дереве:");
//        for (SimpleTreeNode<Integer> node : list) {
//            System.out.println(node.NodeValue);
//        }
    }
}
