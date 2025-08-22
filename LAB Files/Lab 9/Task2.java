class Link {
    int source;
    int destination;
    int cost;

    public Link(int source, int destination, int cost) {
        this.source = source;
        this.destination = destination;
        this.cost = cost;
    }
}

class ChainNode {
    public Link link;
    public ChainNode next;

    public ChainNode(Link link, ChainNode next) {
        this.link = link;
        this.next = next;
    }

    public ChainNode(Link link) {
        this(link, null);
    }
}

public class Task2 {

    public static void main(String[] args) {
       
        int[][] weightMatrix = new int[8][8];
        insertEdgeMatrix(weightMatrix, 0, 1, 2);
        insertEdgeMatrix(weightMatrix, 0, 4, 7);
        insertEdgeMatrix(weightMatrix, 1, 2, 3);
        insertEdgeMatrix(weightMatrix, 1, 5, 1);
        insertEdgeMatrix(weightMatrix, 2, 3, 6);
        insertEdgeMatrix(weightMatrix, 2, 6, 2);
        insertEdgeMatrix(weightMatrix, 3, 7, 4);
        insertEdgeMatrix(weightMatrix, 4, 5, 5);
        insertEdgeMatrix(weightMatrix, 4, 6, 3);
        insertEdgeMatrix(weightMatrix, 5, 6, 1);
        insertEdgeMatrix(weightMatrix, 5, 7, 2);
        insertEdgeMatrix(weightMatrix, 6, 7, 6);
        insertEdgeMatrix(weightMatrix, 3, 0, 1);
        insertEdgeMatrix(weightMatrix, 6, 1, 3);
        insertEdgeMatrix(weightMatrix, 7, 2, 4);
        insertEdgeMatrix(weightMatrix, 7, 4, 2);
        
        System.out.println("Matrix Result → " + maxWeightedVertexMatrix(weightMatrix));
        
        ChainNode[] graphList = new ChainNode[8];
        
        addLink(graphList, 0, 1, 2);
        addLink(graphList, 0, 4, 7);
        addLink(graphList, 1, 2, 3);
        addLink(graphList, 1, 5, 1);
        addLink(graphList, 2, 3, 6);
        addLink(graphList, 2, 6, 2);
        addLink(graphList, 3, 7, 4);
        addLink(graphList, 4, 5, 5);
        addLink(graphList, 4, 6, 3);
        addLink(graphList, 5, 6, 1);
        addLink(graphList, 5, 7, 2);
        addLink(graphList, 6, 7, 6);
        addLink(graphList, 3, 0, 1);
        addLink(graphList, 6, 1, 3);
        addLink(graphList, 7, 2, 4);
        addLink(graphList, 7, 4, 2);
        

        System.out.println("List Result → " + maxWeightedVertexList(graphList));
    }

    
    public static void insertEdgeMatrix(int[][] matrix, int a, int b, int w) {
        matrix[a][b] = w;
        matrix[b][a] = w;
    }

   
    public static void addLink(ChainNode[] list, int u, int v, int weight) {
        list[u] = new ChainNode(new Link(u, v, weight), list[u]);
        list[v] = new ChainNode(new Link(v, u, weight), list[v]);
    }

   
    public static String maxWeightedVertexMatrix(int[][] matrix) {
        int maxSum = 0;
        int heavyVertex = -1;

        for (int i = 0; i < matrix.length; i++) {
            int total = 0;
            for (int j = 0; j < matrix[i].length; j++) {
                total += matrix[i][j];
            }
            if (total > maxSum) {
                maxSum = total;
                heavyVertex = i;
            }
        }

        return "Vertex " + heavyVertex + " has max total weight of " + maxSum;
    }

    
    public static String maxWeightedVertexList(ChainNode[] list) {
        int maxSum = 0;
        int heavyVertex = -1;

        for (int i = 0; i < list.length; i++) {
            int total = 0;
            ChainNode pointer = list[i];
            while (pointer != null) {
                total += pointer.link.cost;
                pointer = pointer.next;
            }
            if (total > maxSum) {
                maxSum = total;
                heavyVertex = i;
            }
        }

        return "Vertex " + heavyVertex + " has max total weight of " + maxSum;
    }
}
