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
}

