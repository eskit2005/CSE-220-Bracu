public class Task4 {

    public static void main(String[] args) {
        // 1. DIRECTED weighted matrix using a 2D array
        int[][] directedMatrix = new int[5][5];

        connectMatrix(directedMatrix, 0, 1, 4);
        connectMatrix(directedMatrix, 0, 2, 3);
        connectMatrix(directedMatrix, 1, 3, 5);
        connectMatrix(directedMatrix, 2, 3, 6);
        connectMatrix(directedMatrix, 3, 4, 7);


        int[][] undirectedMatrix = convertMatrixToUndirected(directedMatrix);

        Node[] directedList = new Node[5];
        addToList(directedList, 0, 1, 4);
        addToList(directedList, 0, 2, 3);
        addToList(directedList, 1, 3, 5);
        addToList(directedList, 2, 3, 6);
        addToList(directedList, 3, 4, 7);
        Node[] undirectedList = convertListToUndirected(directedList);

    }

    public static void connectMatrix(int[][] matrix, int from, int to, int weight) {
        matrix[from][to] = weight;
    }
   
    public static int[][] convertMatrixToUndirected(int[][] matrix) {
        int n = matrix.length;
        int[][] undirected = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] > 0) {
                    undirected[i][j] = matrix[i][j];
                    undirected[j][i] = matrix[i][j];
                }
            }
        }
        return undirected;
    }

    public static Node[] convertListToUndirected(Node[] directedList) {
        int n = directedList.length;
        Node[] undirected = new Node[n];
        boolean[][] visited = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            Node current = directedList[i];
            while (current != null) {
                int from = current.edge.from;
                int to = current.edge.to;
                int weight = current.edge.weight;

                if (!visited[from][to] && !visited[to][from]) {
                    Node n1 = new Node(new Edge(from, to, weight));
                    n1.next = undirected[from];
                    undirected[from] = n1;

                    Node n2 = new Node(new Edge(to, from, weight));
                    n2.next = undirected[to];
                    undirected[to] = n2;

                    visited[from][to] = true;
                    visited[to][from] = true;
                }
                current = current.next;
            }
        }

        return undirected;
    }


    public static void addToList(Node[] list, int from, int to, int weight) {
        Node newNode = new Node(new Edge(from, to, weight));
        newNode.next = list[from];
        list[from] = newNode;
    }

   

   
}

class Edge {
    int from, to, weight;

    public Edge(int from, int to, int weight) {
        this.from = from;
        this.to = to;
        this.weight = weight;
    }
}


class Node {
    Edge edge;
    Node next;

    public Node(Edge edge) {
        this.edge = edge;
        this.next = null;
    }

    public Node(Edge edge, Node next) {
        this.edge = edge;
        this.next = next;
    }
}

