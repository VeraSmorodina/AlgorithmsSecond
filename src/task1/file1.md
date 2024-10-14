Урок 1

Задание 1
```java
    // Рекурсивный метод для назначения уровней
    public void assignLevels() {
        assignLevels(Root, 0);
    }
    
    private void assignLevels(SimpleTreeNode<T> node, int level) {
        if (node == null) {
            return;
        }
        node.level = level;
        if (node.Children == null || node.Children.size() == 0) {
            return;
        }
        for (SimpleTreeNode<T> child : node.Children) {
            assignLevels(child, level + 1);
        }
    }

    // Метод для вывода уровней узлов в дереве
    public void printLevels() {
        printLevels1(Root);
    }

    private void printLevels1(SimpleTreeNode<T> node) {
        if (node == null) return;
        System.out.println("Узел: " + node.NodeValue + ", Уровень: " + node.level);
        if (node.Children == null || node.Children.size() == 0) return;
        for (SimpleTreeNode<T> child : node.Children) {
            printLevels1(child);
        }
    }
```
Задание 2

Чтобы организовать поддержку уровня узлов в дереве,
не анализируя всё дерево, можно использовать отдельное
поле  для хранения уровня в каждом узле. При добавлении
узла в дерево можно сразу устанавливать его уровень,
исходя из уровня родительского узла. Это позволит 
избежать повторного анализа дерева.



