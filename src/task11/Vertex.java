import java.util.*;

class Vertex {
    public int Value;
    public boolean Hit;
    public Vertex Parent;

    public Vertex(int val) {
        Value = val;
        Hit = false;
        Parent = null;
    }
}

class SimpleGraph {
    Vertex[] vertex;
    int[][] m_adjacency;
    int max_vertex;

    public SimpleGraph(int size) {
        max_vertex = size;
        m_adjacency = new int[size][size];
        vertex = new Vertex[size];
    }

    public void AddVertex(int value) {
        Vertex vertex1 = new Vertex(value);
        for (int i = 0; i < vertex.length; i++) {
            if (vertex[i] == null) {
                vertex[i] = vertex1;
                return;
            }
        }
    }

    public void RemoveVertex(int v) {
        vertex[v] = null;
        m_adjacency[v][v] = 0;
        if (v + 1 < max_vertex) {
            m_adjacency[v][v + 1] = 0;
            m_adjacency[v + 1][v] = 0;
        }
        if (v - 1 >= 0) {
            m_adjacency[v - 1][v] = 0;
            m_adjacency[v][v - 1] = 0;
        }
    }

    public boolean IsEdge(int v1, int v2) {
        return m_adjacency[v1][v2] == 1;
    }

    public void AddEdge(int v1, int v2) {
        m_adjacency[v1][v2] = 1;
        m_adjacency[v2][v1] = 1;
    }

    public void RemoveEdge(int v1, int v2) {
        m_adjacency[v1][v2] = 0;
        m_adjacency[v2][v1] = 0;
    }

    public ArrayList<Vertex> DepthFirstSearch(int VFrom, int VTo) {
        Stack<Vertex> stack = new Stack<>();
        for (Vertex vertex1 : vertex) {
            vertex1.Hit = false;
        }
        return depthFirstSearch(VFrom, VTo, stack);
    }

    private ArrayList<Vertex> depthFirstSearch(int currentIndex, int VTo, Stack<Vertex> stack) {
        vertex[currentIndex].Hit = true;
        if (!stack.contains(vertex[currentIndex])) {
            stack.push(vertex[currentIndex]);
        }
        ArrayList<Vertex> adjacents = findAdjacents(currentIndex);
        if (adjacents.contains(vertex[VTo])) {
            stack.push(vertex[VTo]);
            return new ArrayList<>(stack);
        }
        Vertex notHitVertex = findNotHitAdjacent(adjacents);
        if (notHitVertex != null) {
            int index = findIndexOfVertex(notHitVertex);
            return depthFirstSearch(index, VTo, stack);
        }
        stack.pop();
        if (stack.isEmpty()) return new ArrayList<>();
        return depthFirstSearch(findIndexOfVertex(stack.get(0)), VTo, stack);
    }

    private ArrayList<Vertex> findAdjacents(int index) {
        ArrayList<Vertex> adjacents = new ArrayList<>();
        for (int i = 0; i < max_vertex; i++) {
            if (m_adjacency[index][i] == 1) adjacents.add(vertex[i]);
        }
        return adjacents;
    }

    private Vertex findNotHitAdjacent(ArrayList<Vertex> adjacents) {
        for (Vertex adjacent : adjacents) {
            if (!adjacent.Hit) return adjacent;
        }
        return null;
    }

    private int findIndexOfVertex(Vertex vertex1) {
        for (int i = 0; i < max_vertex; i++) {
            if (vertex[i].equals(vertex1)) return i;
        }
        return -1;
    }

    public ArrayList<Vertex> BreadthFirstSearch(int VFrom, int VTo) {
        Queue<Vertex> queue = new Queue();
        for (Vertex vertex1 : vertex) {
            vertex1.Hit = false;
        }
        vertex[VFrom].Hit = true;
        vertex[VFrom].Parent = null;
        return breadthFirstSearch(null, VFrom, VTo, queue);
    }

    private ArrayList<Vertex> breadthFirstSearch(Integer parentIndex, int currentIndex, int VTo, Queue<Vertex> queue) {
        if (parentIndex != null && vertex[currentIndex].Parent == null)
            vertex[currentIndex].Parent = vertex[parentIndex];
        ArrayList<Vertex> adjacents = findAdjacents(currentIndex);
        Vertex notHitVertex = findNotHitAdjacent(adjacents);
        if (notHitVertex == null && queue.size() == 0) {
            return new ArrayList<>();
        }
        if (notHitVertex == null) {
            parentIndex = currentIndex;
            currentIndex = findIndexOfVertex(queue.dequeue());
        } else if (notHitVertex.equals(vertex[VTo])) {
            notHitVertex.Parent = vertex[currentIndex];
            ArrayList<Vertex> path = createListFromParents(notHitVertex);
            path.add(notHitVertex);
            return path;
        }
        if (notHitVertex != null) {
            notHitVertex.Hit = true;
            queue.enqueue(notHitVertex);
        }

        return breadthFirstSearch(parentIndex, currentIndex, VTo, queue);
    }

    private ArrayList<Vertex> createListFromParents(Vertex vertex) {
        ArrayList<Vertex> vertexArrayList = new ArrayList<>();
        while (vertex.Parent != null) {
            vertexArrayList.add(vertex.Parent);
            vertex = vertex.Parent;
        }
        Collections.reverse(vertexArrayList);
        return vertexArrayList;
    }
}

class Queue<T> {

    private final ArrayList<T> elements;

    public Queue() {
        elements = new ArrayList<>();
    }

    public void enqueue(T item) {
        elements.add(0, item);
    }

    public T dequeue() {
        if (size() == 0) return null;
        T element = elements.get(elements.size() - 1);
        elements.remove(element);
        return element;
    }

    public int size() {
        return elements.size();
    }
}