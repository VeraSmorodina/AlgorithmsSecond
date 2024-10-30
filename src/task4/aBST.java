package task4;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

class aBST {
    public Integer Tree[];

    public aBST(int depth) {
        if (depth == 0) Tree = new Integer[1];
        else {
            int x = 1;
            for (int i = 0; i < depth; i++) {
                x = x * 2 + 1;
            }
            Tree = new Integer[x];
        }
        for (int i = 0; i < depth; i++) Tree[i] = null;
    }

    public Integer FindKeyIndex(int key) {
        return find(key, 0);
    }

    private Integer find(int key, int currentIndex) {

        if (currentIndex >= Tree.length) return null;

        int leftIndex = 2 * currentIndex + 1;
        int rightIndex = 2 * currentIndex + 2;

        if (Tree[currentIndex] == key) {
            return currentIndex;
        }
        if (key < Tree[currentIndex] && leftIndex < Tree.length && Tree[leftIndex] != null) {
            currentIndex = 2 * currentIndex + 1;
            return find(key, currentIndex);
        }
        if (key > Tree[currentIndex] && rightIndex < Tree.length && Tree[rightIndex] != null) {
            currentIndex = 2 * currentIndex + 2;
            return find(key, currentIndex);
        }
        if (key < Tree[currentIndex] && leftIndex < Tree.length) {
            return -1 * (2 * currentIndex + 1);
        }
        if (key > Tree[currentIndex] && rightIndex < Tree.length) {
            return -1 * (2 * currentIndex + 2);
        }
        return null;

    }

    public int AddKey(int key) {
        if (Tree.length == 0)
            return -1;
        if (Tree[0] == null) {
            Tree[0] = key;
            return 0;
        }
        Integer index = FindKeyIndex(key);
        if (index == null) return -1;
        if (index < 0) {
            index = index * (-1);
            Tree[index] = key;
            return index;
        }
        return index;
    }

//    Задание 2
public Integer FindLCA(int key1, int key2) {
    Integer index1 = FindKeyIndex(key1);
    Integer index2 = FindKeyIndex(key2);
    if (index1 == null || index2 == null) return null;

    List<Integer> path1 = new ArrayList<>();
    List<Integer> path2 = new ArrayList<>();

    while (index1 >= 0) {
        path1.add(index1);
        index1 = (index1 - 1) / 2;
    }

    while (index2 != null) {
        path2.add(index2);
        index2 = (index2 - 1) / 2;
    }

    // Находим последний общий элемент в путях
    Integer lcaIndex = null;

    int minLeng = 0;
    if (path1.size() >= path2.size())
        minLeng = path1.size();
    else {
        minLeng = path2.size();
    }
    for (int i = minLeng - 1; i >= 0; i--) {
        if (Objects.equals(path1.get(i), path2.get(i))){
            lcaIndex = i;
            break;
        }
    }
//    for (int i = 0; i < Math.min(path1.size(), path2.size()); i++) {
//        if (path1.get(path1.size() - 1 - i).equals(path2.get(path2.size() - 1 - i))) {
//            lcaIndex = path1.get(path1.size() - 1 - i);
//            break;
//        }
////        else {
////            break;
////        }
//    }

    return lcaIndex;
}
}

