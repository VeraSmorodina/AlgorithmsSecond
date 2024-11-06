package task7;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class HeapTest {
    @Test
    public void MakeHeapTest() {
        Heap heap = new Heap();
        heap.MakeHeap(new int[]{1}, 3);
        Assertions.assertEquals(heap.HeapArray[0], 1);
    }

    @Test
    public void MakeHeapTest2() {
        Heap heap = new Heap();
        heap.MakeHeap(new int[]{2, 1}, 3);
        Assertions.assertEquals(heap.HeapArray[0], 2);
        Assertions.assertEquals(heap.HeapArray[1], 1);
    }

    @Test
    public void MakeHeapTest3() {
        Heap heap = new Heap();
        heap.MakeHeap(new int[]{2, 1, 3}, 3);
        Assertions.assertEquals(3, heap.HeapArray[0]);
        Assertions.assertEquals(1, heap.HeapArray[1]);
        Assertions.assertEquals(2, heap.HeapArray[2]);
    }

    @Test
    public void MakeHeapTest4() {
        Heap heap = new Heap();
        heap.MakeHeap(new int[]{1, 4, 3, 2}, 4);
        Assertions.assertEquals(4, heap.HeapArray[0]);
        Assertions.assertEquals(2, heap.HeapArray[1]);
        Assertions.assertEquals(3, heap.HeapArray[2]);
        Assertions.assertEquals(1, heap.HeapArray[3]);
    }

    @Test
    public void MakeHeapTest5() {
        Heap heap = new Heap();
        heap.MakeHeap(new int[]{11, 9, 4, 7, 8, 3, 1, 2, 5, 6}, 3);
        Assertions.assertEquals(11, heap.HeapArray[0]);
        Assertions.assertEquals(9, heap.HeapArray[1]);
        Assertions.assertEquals(4, heap.HeapArray[2]);
    }

    @Test
    public void AddTest() {
        Heap heap = new Heap();
        heap.MakeHeap(new int[]{1, 4, 3, 2}, 4);
        Assertions.assertTrue(heap.Add(333));
    }

    @Test
    public void AddTest2() {
        Heap heap = new Heap();
        heap.MakeHeap(new int[]{1, 4}, 4);
        Assertions.assertTrue(heap.Add(333));
        Assertions.assertEquals(heap.HeapArray[0], 333);
    }

    @Test
    public void getMaxTest() {
        Heap heap = new Heap();
        heap.MakeHeap(new int[]{1, 4}, 4);
        int max = heap.GetMax();
        Assertions.assertEquals(4, max);
        Assertions.assertEquals(1, heap.HeapArray[0]);
    }

    @Test
    public void getMaxTest2() {
        Heap heap = new Heap();
        heap.MakeHeap(new int[]{1, 4, 2}, 4);
        int max = heap.GetMax();
        Assertions.assertEquals(4, max);
        Assertions.assertEquals(2, heap.HeapArray[0]);
        Assertions.assertEquals(1, heap.HeapArray[1]);
    }

    @Test
    public void getMaxTest3() {
        Heap heap = new Heap();
        heap.MakeHeap(new int[]{1, 4, 2, 5}, 4);
        int max = heap.GetMax();
        Assertions.assertEquals(5, max);
        Assertions.assertEquals(4, heap.HeapArray[0]);
        Assertions.assertEquals(1, heap.HeapArray[1]);
        Assertions.assertEquals(2, heap.HeapArray[2]);
    }

    @Test
    public void getMaxTest4() {
        Heap heap = new Heap();
        heap.MakeHeap(new int[]{3, 4, 5, 8, 11}, 2);
        int max = heap.GetMax();
        Assertions.assertEquals(11, max);
    }

    @Test
    public void getMaxTest5() {
        Heap heap = new Heap();
        heap.MakeHeap(new int[]{1}, 1);
        int max = heap.GetMax();
        Assertions.assertEquals(1, max);
        Assertions.assertEquals(0, heap.HeapArray[0]);
    }

    @Test
    public void getMaxTest6() {
        Heap heap = new Heap();
        heap.MakeHeap(new int[]{11, 9, 4, 7, 8, 3, 1, 2, 5, 6}, 3);
        int max = heap.GetMax();
        Assertions.assertEquals(11, max);
        Assertions.assertEquals(9, heap.HeapArray[0]);
    }
}
