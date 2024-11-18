package task11;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class SimpleGraphTest {
    @Test
    public void breadthFirstSearchTest() {
        SimpleGraph simpleGraph = new SimpleGraph(5);
        simpleGraph.AddVertex(10);
        simpleGraph.AddVertex(20);
        simpleGraph.AddVertex(30);
        simpleGraph.AddVertex(40);
        simpleGraph.AddVertex(50);
        simpleGraph.AddEdge(0, 1);
        simpleGraph.AddEdge(0, 2);
        simpleGraph.AddEdge(1, 3);
        ArrayList<Vertex> result = simpleGraph.BreadthFirstSearch(0, 2);
        ArrayList<Vertex> result2 = simpleGraph.BreadthFirstSearch(2, 3);
        ArrayList<Vertex> result3 = simpleGraph.BreadthFirstSearch(2, 4);
        Assertions.assertTrue(result.size() != 0);
        Assertions.assertEquals(10, result.get(0).Value);
        Assertions.assertEquals(30, result.get(1).Value);
        Assertions.assertEquals(30, result2.get(0).Value);
        Assertions.assertEquals(10, result2.get(1).Value);
        Assertions.assertEquals(20, result2.get(2).Value);
        Assertions.assertEquals(40, result2.get(3).Value);
        Assertions.assertEquals(0, result3.size());
    }

    @Test
    public void breadthFirstSearchTest2() {
        SimpleGraph simpleGraph = new SimpleGraph(5);
        simpleGraph.AddVertex(10);
        simpleGraph.AddVertex(20);
        simpleGraph.AddVertex(30);
        simpleGraph.AddVertex(40);
        simpleGraph.AddVertex(50);
        simpleGraph.AddEdge(0, 1);
        simpleGraph.AddEdge(0, 2);
        simpleGraph.AddEdge(0, 3);
        simpleGraph.AddEdge(1, 3);
        simpleGraph.AddEdge(1, 4);
        simpleGraph.AddEdge(2, 3);
        simpleGraph.AddEdge(3, 4);
        ArrayList<Vertex> result = simpleGraph.BreadthFirstSearch(0, 4);
        ArrayList<Vertex> result2 = simpleGraph.BreadthFirstSearch(0, 3);
        ArrayList<Vertex> result3 = simpleGraph.BreadthFirstSearch(4, 2);
        Assertions.assertEquals(3, result.size());
        Assertions.assertEquals(10, result.get(0).Value);
        Assertions.assertEquals(20, result.get(1).Value);
        Assertions.assertEquals(50, result.get(2).Value);
        Assertions.assertEquals(2, result2.size());
        Assertions.assertEquals(10, result2.get(0).Value);
        Assertions.assertEquals(40, result2.get(1).Value);
        Assertions.assertEquals(3, result3.size());
    }
}
