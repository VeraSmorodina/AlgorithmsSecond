package task1;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
//        SimpleTreeNode<Integer> tree1 = new SimpleTreeNode<>(1, null);
//        SimpleTree<Integer> per = new SimpleTree<>(tree1);
//
//
//        SimpleTreeNode<Integer> tree21 = new SimpleTreeNode<>(2, tree1);
//        per.Root.Children.add(tree21);
//        SimpleTreeNode<Integer> tree22 = new SimpleTreeNode<>(3, tree1);
//        per.Root.Children.add(tree22);
//
//        SimpleTreeNode<Integer> tree31 = new SimpleTreeNode<>(4, tree21);
//        per.Root.Children.get(0).Children.add(tree31);
//
//        SimpleTreeNode<Integer> tree32 = new SimpleTreeNode<>(4, tree21);
//        per.Root.Children.get(0).Children.add(tree32);
//
//        List<SimpleTreeNode<Integer>> list = per.GetAllNodes();
//        System.out.println("Список всех узлов в дереве:");
//        for (SimpleTreeNode<Integer> node : list) {
//            System.out.println(node.NodeValue);
//        }

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


//        SimpleTree<Integer> tree = new SimpleTree<>();
//        tree.Root = new SimpleTreeNode<>(1);
//        tree.Root.Children.add(new SimpleTree<>(2));
//        tree.Root.Children.add(new SimpleTree<>(3));
//        tree.Root.Children.get(0).Children.add(new SimpleTree<>(4));
//        tree.Root.Children.get(0).Children.add(new SimpleTree<>(5));
//
//        List<SimpleTreeNode<Integer>> nodeList = tree.GetAllNodes(); // Запускаем обход дерева
//
//        System.out.println("Список всех узлов в дереве:");
//        for (SimpleTreeNode<Integer> node : nodeList) {
//            System.out.println(node.NodeValue);
//        }
    }
}
