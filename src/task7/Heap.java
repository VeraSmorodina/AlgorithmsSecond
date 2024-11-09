package task7;

class Heap {
    public int[] HeapArray;

    public Heap() {
        HeapArray = null;
    }

    public void MakeHeap(int[] a, int depth) {
        int length = (int) (Math.pow(2, depth + 1) - 1);
        HeapArray = new int[length];
        for (int key : a) {
            Add(key);
        }
    }

    public int GetMax() {
        if (HeapArray[0] == 0)
            return -1;
        int maxElement = HeapArray[0];
        int lastExistElementIndex = findLastExistElementIndex();
        int lastExistElement = HeapArray[lastExistElementIndex];
        HeapArray[0] = lastExistElement;
        HeapArray[lastExistElementIndex] = 0;
        changeDown(0);
        return maxElement;
    }

    private int findLastExistElementIndex() {
        for (int i = HeapArray.length - 1; i >= 0; i--) {
            int currentElement = HeapArray[i];
            if (currentElement != 0) return i;
        }
        return 0;
    }

    private void changeDown(int currentIndex) {
        int leftChildIndex = 2 * currentIndex + 1;
        int rightChildIndex = 2 * currentIndex + 2;
        if (leftChildIndex >= HeapArray.length || rightChildIndex >= HeapArray.length || currentIndex >= HeapArray.length)
            return;
        if (HeapArray[leftChildIndex] < HeapArray[currentIndex] && HeapArray[rightChildIndex] < HeapArray[currentIndex]) {
            return;
        }
        int leftChild = HeapArray[leftChildIndex];
        int rightChild = HeapArray[rightChildIndex];
        int currentElement = HeapArray[currentIndex];

        if (leftChild > currentElement && leftChild > rightChild) {
            int temp = HeapArray[leftChildIndex];
            HeapArray[leftChildIndex] = HeapArray[currentIndex];
            HeapArray[currentIndex] = temp;
            changeDown(leftChildIndex);
        } else if (rightChild > currentElement && rightChild > leftChild) {
            int temp = HeapArray[rightChildIndex];
            HeapArray[rightChildIndex] = HeapArray[currentIndex];
            HeapArray[currentIndex] = temp;
            changeDown(rightChildIndex);
        }
    }

    public boolean Add(int key) {
        if (HeapArray[0] == 0) {
            HeapArray[0] = key;
            return true;
        }
        if (checkHeapIsFilled()) return false;
        int firstFreeSlotIndex = findLastExistElementIndex() + 1;
        HeapArray[firstFreeSlotIndex] = key;
        changeUp(firstFreeSlotIndex);
        return true;
    }

    private boolean checkHeapIsFilled() {
        for (int element : HeapArray) {
            if (element == 0) return false;
        }
        return true;
    }

    private void changeUp(int currentIndex) {
        int parentIndex;
        if (currentIndex % 2 == 0) {
            parentIndex = currentIndex / 2 - 1;
        } else {
            parentIndex = currentIndex / 2;
        }
        if (currentIndex == 0 || HeapArray[parentIndex] > HeapArray[currentIndex]) {
            return;
        }
        int temp = HeapArray[parentIndex];
        HeapArray[parentIndex] = HeapArray[currentIndex];
        HeapArray[currentIndex] = temp;
        changeUp(parentIndex);
    }
}
