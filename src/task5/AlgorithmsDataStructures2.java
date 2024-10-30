import java.util.*;

public class AlgorithmsDataStructures2 {
    public static int[] GenerateBBSTArray(int[] a) {
        Arrays.sort(a);

        int middleElementIndex = a.length / 2;

        int[] resultArray = new int[calculateLength(a)];
        resultArray[0] = a[middleElementIndex];

        generateL(Arrays.copyOfRange(a, 0, middleElementIndex), resultArray, 0);
        generateR(Arrays.copyOfRange(a, middleElementIndex + 1, a.length), resultArray, 0);
        return resultArray;
    }

    private static void generateL(int[] a, int[] resultArray, int currentIndex) {
        if (a.length == 0) return;
        int middleElementIndex = a.length / 2;
        int leftChildIndex = 2 * currentIndex + 1;
        resultArray[leftChildIndex] = a[middleElementIndex];
        generateL(Arrays.copyOfRange(a, 0, middleElementIndex), resultArray, leftChildIndex);
        generateR(Arrays.copyOfRange(a, middleElementIndex + 1, a.length), resultArray, leftChildIndex);
    }

    private static void generateR(int[] a, int[] resultArray, int currentIndex) {
        if (a.length == 0) return;
        int middleElementIndex = a.length / 2;
        int rightChildIndex = 2 * currentIndex + 2;
        resultArray[rightChildIndex] = a[middleElementIndex];
        generateL(Arrays.copyOfRange(a, 0, middleElementIndex), resultArray, rightChildIndex);
        generateR(Arrays.copyOfRange(a, middleElementIndex + 1, a.length), resultArray, rightChildIndex);
    }

    private static int calculateDepth(int[] a) {
        if (a.length == 1) return 0;
        int depth = 0;
        int x;
        do {
            depth++;
            x = 0;
            for (int i = 0; i <= depth; i++) {
                x = x * 2 + 1;
            }
        } while (x < a.length);
        return depth;
    }

    private static int calculateLength(int[] a) {
        int depth = calculateDepth(a);
        int length = (int) (Math.pow(2, depth + 1) - 1);
        return length;
    }
}
