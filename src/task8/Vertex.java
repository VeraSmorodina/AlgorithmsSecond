package task8;

class Vertex {
    public int Value;

    public Vertex(int val) {
        Value = val;
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
}
