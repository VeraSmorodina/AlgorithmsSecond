package task5;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AlgorithmsDataStructures2Test {
    @Test
    public void testGenerateBBSTArray() {
        int[] resultArray = AlgorithmsDataStructures2.GenerateBBSTArray(new int[]{1, 2, 3, 4, 5});
        Assertions.assertEquals(3, resultArray[0]);
        Assertions.assertEquals(2, resultArray[1]);
        Assertions.assertEquals(5, resultArray[2]);
        Assertions.assertEquals(1, resultArray[3]);
        Assertions.assertEquals(0, resultArray[4]);
        Assertions.assertEquals(4, resultArray[5]);
        Assertions.assertEquals(0, resultArray[6]);
    }

    @Test
    public void testGenerateBBSTArray2() {
        int[] resultArray = AlgorithmsDataStructures2.GenerateBBSTArray(new int[]{1, 2, 3});
        Assertions.assertEquals(2, resultArray[0]);
        Assertions.assertEquals(1, resultArray[1]);
        Assertions.assertEquals(3, resultArray[2]);
    }

    @Test
    public void testGenerateBBSTArray3() {
        int[] resultArray = AlgorithmsDataStructures2.GenerateBBSTArray(new int[0]);
        Assertions.assertEquals(0, resultArray.length);
    }
}
