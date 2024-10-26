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

}
