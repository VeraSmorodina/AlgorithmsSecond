package task10;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class SimpleGraphTest {
    @Test
    public void depthFirstSearchTest() {
        SimpleGraph simpleGraph = new SimpleGraph(5);
        simpleGraph.AddVertex(10);
        simpleGraph.AddVertex(20);
        simpleGraph.AddVertex(30);
        simpleGraph.AddVertex(40);
        simpleGraph.AddVertex(50);
        simpleGraph.AddEdge(0, 1);
        simpleGraph.AddEdge(0, 2);
        simpleGraph.AddEdge(1, 3);
        ArrayList<Vertex> result = simpleGraph.DepthFirstSearch(0, 2);
        ArrayList<Vertex> result2 = simpleGraph.DepthFirstSearch(2, 3);
        ArrayList<Vertex> result3 = simpleGraph.DepthFirstSearch(2, 4);
        Assertions.assertTrue(result.size() != 0);
        Assertions.assertEquals(10, result.get(0).Value);
        Assertions.assertEquals(30, result.get(1).Value);
        Assertions.assertTrue(result.size() != 0);
        Assertions.assertEquals(30, result2.get(0).Value);
        Assertions.assertEquals(10, result2.get(1).Value);
        Assertions.assertEquals(20, result2.get(2).Value);
        Assertions.assertEquals(40, result2.get(3).Value);
        Assertions.assertEquals(0, result3.size());
    }
}
