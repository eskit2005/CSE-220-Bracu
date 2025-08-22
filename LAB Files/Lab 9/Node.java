class Edge {
    int from;
    int to;

    public Edge(int from, int to) {
        this.from = from;
        this.to = to;
    }
}

public class Node {
    public Edge edge;
    public Node next;

    public Node(Edge edge, Node next) {
        this.edge = edge;
        this.next = next;
    }

    public Node(Edge edge) {
        this.edge = edge;
        this.next = null;
    }

    public static void main(String[] args) {

        int[][] matrix = new int[8][8];
        matrix[0][1] = 1; matrix[1][0] = 1;
        matrix[0][2] = 1; matrix[2][0] = 1;
        matrix[1][3] = 1; matrix[3][1] = 1;
        matrix[1][2] = 1; matrix[2][1] = 1;
        matrix[2][3] = 1; matrix[3][2] = 1;
        matrix[2][4] = 1; matrix[4][2] = 1;
        matrix[2][5] = 1; matrix[5][2] = 1;
        matrix[2][6] = 1; matrix[6][2] = 1;
        matrix[2][7] = 1; matrix[7][2] = 1;
        matrix[3][4] = 1; matrix[4][3] = 1;
        matrix[3][6] = 1; matrix[6][3] = 1;
        matrix[4][5] = 1; matrix[5][4] = 1;
        matrix[4][6] = 1; matrix[6][4] = 1;
        matrix[5][6] = 1; matrix[6][5] = 1;
        matrix[5][7] = 1; matrix[7][5] = 1;
        matrix[6][7] = 1; matrix[7][6] = 1;

        
        Node[] graphList = new Node[8];

        graphList[0] = linkNodes(new int[][]{{0, 1}, {0, 2}});
        graphList[1] = linkNodes(new int[][]{{1, 3}, {1, 2}});
        graphList[2] = linkNodes(new int[][]{
            {2, 1}, {2, 3}, {2, 4}, {2, 5}, {2, 6}, {2, 7}
        });
        graphList[3] = linkNodes(new int[][]{{3, 1}, {3, 2}, {3, 4}, {3, 6}});
        graphList[4] = linkNodes(new int[][]{{4, 2}, {4, 3}, {4, 5}, {4, 6}});
        graphList[5] = linkNodes(new int[][]{{5, 2}, {5, 4}, {5, 6}, {5, 7}});
        graphList[6] = linkNodes(new int[][]{{6, 2}, {6, 3}, {6, 4}, {6, 5}, {6, 7}});
        graphList[7] = linkNodes(new int[][]{{7, 2}, {7, 5}, {7, 6}});

       
        System.out.println(maxDegreeList(graphList));
        System.out.println(maxDegreeMatrix(matrix));
    }

    
    public static Node linkNodes(int[][] edges) {
        Node head = null;
        for (int i = edges.length - 1; i >= 0; i--) {
            head = new Node(new Edge(edges[i][0], edges[i][1]), head);
        }
        return head;
    }

   
    public static String maxDegreeList(Node[] adjList) {
        int max = 0;
        int vertexWithMaxDegree = -1;

        for (int i = 0; i < adjList.length; i++) {
            int count = 0;
            Node current = adjList[i];
            while (current != null) {
                count++;
                current = current.next;
            }
            if (count > max) {
                max = count;
                vertexWithMaxDegree = i;
            }
        }

        return "Adjency list's max vertex " + vertexWithMaxDegree + " and its degree is " + max;
    }

   
    public static String maxDegreeMatrix(int[][] matrix) {
        int max = 0;
        int vertexWithMaxDegree = -1;

        for (int i = 0; i < matrix.length; i++) {
            int count = 0;
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 1) {
                    count++;
                }
            }
            if (count > max) {
                max = count;
                vertexWithMaxDegree = i;
            }
        }

        return "Adjency matrix's max vertex " + vertexWithMaxDegree + " and its degree is " + max;
    }
}
