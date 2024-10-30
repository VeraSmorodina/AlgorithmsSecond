package task4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class test4 {
    @Test
    public void createTreeTest(){
        aBST aBST = new aBST(3);
        Assertions.assertEquals(15, aBST.Tree.length);
    }

    @Test
    public void findTest(){
        aBST aBST = new aBST(5);
        aBST.Tree[0] = 5;
        aBST.Tree[1] = 3;
        aBST.Tree[2] = 6;
        int result0 = aBST.FindKeyIndex(5);
        int result1 = aBST.FindKeyIndex(3);
        int result2 = aBST.FindKeyIndex(6);
        int result4 = aBST.FindKeyIndex(8);
        int result5 = aBST.FindKeyIndex(4);
        Assertions.assertEquals(0, result0);
        Assertions.assertEquals(1, result1);
        Assertions.assertEquals(2, result2);
        Assertions.assertEquals(-6, result4);
        Assertions.assertEquals(-4, result5);
    }

    @Test
    public void addTest(){
        aBST aBST = new aBST(3);
        int index0 = aBST.AddKey(5);
        int index1 = aBST.AddKey(3);
        int index2 = aBST.AddKey(7);
        int index3 = aBST.AddKey(999);
        int index4 = aBST.AddKey(3);
        int index5 = aBST.AddKey(5);
        int index6 = aBST.AddKey(7);
        Assertions.assertEquals(0, index0);
        Assertions.assertEquals(1, index1);
        Assertions.assertEquals(2, index2);
        Assertions.assertEquals(6, index3);
        Assertions.assertEquals(1, index4);
        Assertions.assertEquals(0, index5);
        Assertions.assertEquals(2, index6);
    }




    @Test
    void testFindLCA() {
        // Создаем бинарное дерево с глубиной 3
        aBST bst = new aBST(3);
        bst.AddKey(10); // Корень
        bst.AddKey(5); // Левый дочерний узел корня
        bst.AddKey(15); // Правый дочерний узел корня
        bst.AddKey(3); // Левый дочерний узел узла 2
        bst.AddKey(8); // Правый дочерний узел узла 2
        bst.AddKey(13); // Левый дочерний узел узла 3
        bst.AddKey(18); // Правый дочерний узел узла 3

        Assertions.assertEquals(10, bst.FindLCA(5, 15));
//        Assertions.assertEquals(1, bst.FindLCA(4, 6)); // LCA для 4 и 6 - это 1
//        Assertions.assertEquals(3, bst.FindLCA(6, 7)); // LCA для 6 и 7 - это 3
//        Assertions.assertEquals(1, bst.FindLCA(2, 3)); // LCA для 2 и 3 - это 1
    }

    @Test
    void testFindLCAWithNonExistentNodes() {
        // Создаем бинарное дерево с глубиной 3
        aBST bst = new aBST(3);
        bst.AddKey(1); // Корень
        bst.AddKey(2); // Левый дочерний узел корня
        bst.AddKey(3); // Правый дочерний узел корня
        bst.AddKey(4); // Левый дочерний узел узла 2
        bst.AddKey(5); // Правый дочерний узел узла 2
        bst.AddKey(6); // Левый дочерний узел узла 3
        bst.AddKey(7); // Правый дочерний узел узла 3

        Assertions.assertNull(bst.FindLCA(8, 9)); // Узлы не существуют в дереве, результат должен быть null

        Assertions.assertEquals(-1, bst.AddKey(8)); // Добавляем новый ключ и проверяем его добавление
        Assertions.assertEquals(1, bst.FindLCA(1, 8)); // LCA для корня и нового узла должен быть корень (1)
    }

    @Test
    void testFindLCAWithSameNode() {
        // Создаем бинарное дерево с глубиной 3
        aBST bst = new aBST(3);
        bst.AddKey(1); // Корень
        bst.AddKey(2); // Левый дочерний узел корня
        bst.AddKey(3); // Правый дочерний узел корня

        Assertions.assertEquals(4, bst.FindLCA(4, 4)); // LCA для одного и того же узла должен быть этот узел (4)
    }
}
