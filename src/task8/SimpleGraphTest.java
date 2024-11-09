package task8;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SimpleGraphTest {
    @Test
    public void isEdgeTest() {
        SimpleGraph simpleGraph = new SimpleGraph(2);
        simpleGraph.m_adjacency[0][1] = 1;
        simpleGraph.m_adjacency[1][0] = 1;
        boolean a = simpleGraph.IsEdge(0, 1);
        boolean b = simpleGraph.IsEdge(1, 0);
        Assertions.assertTrue(a);
        Assertions.assertTrue(b);
    }

    @Test
    public void addVertexTest() {
        SimpleGraph simpleGraph = new SimpleGraph(2);
        simpleGraph.AddVertex(5);
        boolean a = simpleGraph.IsEdge(0, 1);
        boolean b = simpleGraph.IsEdge(1, 0);
        Assertions.assertFalse(a);
        Assertions.assertFalse(b);
    }

    @Test
    public void addEdgeTest() {
        SimpleGraph simpleGraph = new SimpleGraph(2);
        simpleGraph.AddVertex(5);
        simpleGraph.AddVertex(10);
        simpleGraph.AddEdge(0, 1);
        Assertions.assertTrue(simpleGraph.IsEdge(0, 1));
        Assertions.assertTrue(simpleGraph.IsEdge(1, 0));
    }

    @Test
    public void removeEdgeTest() {
        SimpleGraph simpleGraph = new SimpleGraph(2);
        simpleGraph.AddVertex(5);
        simpleGraph.AddVertex(10);
        simpleGraph.AddEdge(0, 1);
        Assertions.assertTrue(simpleGraph.IsEdge(0, 1));
        Assertions.assertTrue(simpleGraph.IsEdge(1, 0));
        simpleGraph.RemoveEdge(0, 1);
        Assertions.assertFalse(simpleGraph.IsEdge(0, 1));
        Assertions.assertFalse(simpleGraph.IsEdge(1, 0));
    }

    @Test
    public void removeVertexTest() {
        SimpleGraph simpleGraph = new SimpleGraph(2);
        simpleGraph.AddVertex(5);
        simpleGraph.AddVertex(10);
        simpleGraph.AddEdge(0, 1);
        Assertions.assertTrue(simpleGraph.IsEdge(0, 1));
        Assertions.assertTrue(simpleGraph.IsEdge(1, 0));
        simpleGraph.RemoveVertex(0);
        Assertions.assertNull(simpleGraph.vertex[0]);
        Assertions.assertFalse(simpleGraph.IsEdge(0, 1));
        Assertions.assertFalse(simpleGraph.IsEdge(1, 0));
    }
}
