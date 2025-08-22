public class Task3 {

    public static void main(String[] args) {

        int[][] adjMatrix = new int[8][8];


        connectMatrix(adjMatrix, 0, 2, 5);
        connectMatrix(adjMatrix, 0, 4, 3);
        connectMatrix(adjMatrix, 0, 5, 1);
        connectMatrix(adjMatrix, 1, 2, 6);
        connectMatrix(adjMatrix, 1, 3, 2);
        connectMatrix(adjMatrix, 1, 6, 4);
        connectMatrix(adjMatrix, 2, 3, 5);
        connectMatrix(adjMatrix, 2, 7, 3);
        connectMatrix(adjMatrix, 3, 5, 4);
        connectMatrix(adjMatrix, 4, 6, 2);
        connectMatrix(adjMatrix, 4, 7, 1);
        connectMatrix(adjMatrix, 5, 6, 3);
        connectMatrix(adjMatrix, 5, 7, 6);
        connectMatrix(adjMatrix, 6, 0, 2);
        connectMatrix(adjMatrix, 6, 2, 1);
        connectMatrix(adjMatrix, 7, 1, 4);
        
        System.out.println("Matrix → Node with highest degree: " + getMaxDegreeFromMatrix(adjMatrix));
        System.out.println("Matrix → Node with highest weight sum: " + getMaxWeightFromMatrix(adjMatrix));
        
        ListNode[] adjList = new ListNode[8];
        connectList(adjList, 0, 2, 5);
        connectList(adjList, 0, 4, 3);
        connectList(adjList, 0, 5, 1);
        connectList(adjList, 1, 2, 6);
        connectList(adjList, 1, 3, 2);
        connectList(adjList, 1, 6, 4);
        connectList(adjList, 2, 3, 5);
        connectList(adjList, 2, 7, 3);
        connectList(adjList, 3, 5, 4);
        connectList(adjList, 4, 6, 2);
        connectList(adjList, 4, 7, 1);
        connectList(adjList, 5, 6, 3);
        connectList(adjList, 5, 7, 6);
        connectList(adjList, 6, 0, 2);
        
        System.out.println("List → Node with highest degree: " + getMaxDegreeFromList(adjList));
        System.out.println("List → Node with highest weight sum: " + getMaxWeightFromList(adjList));
    }

    public static void connectMatrix(int[][] matrix, int from, int to, int weight) {
        matrix[from][to] = weight;
    }


    public static String getMaxDegreeFromMatrix(int[][] matrix) {
        int maxDegree = 0, node = -1;

        for (int i = 0; i < matrix.length; i++) {
            int degree = 0;
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] > 0) degree++;
            }
            if (degree > maxDegree) {
                maxDegree = degree;
                node = i;
            }
        }
        return "Node " + node + ", Degree: " + maxDegree;
    }


    public static String getMaxWeightFromMatrix(int[][] matrix) {
        int maxWeight = 0, node = -1;

        for (int i = 0; i < matrix.length; i++) {
            int sum = 0;
            for (int j = 0; j < matrix[i].length; j++) {
                sum += matrix[i][j];
            }
            if (sum > maxWeight) {
                maxWeight = sum;
                node = i;
            }
        }
        return "Node " + node + ", Weight Sum: " + maxWeight;
    }

 
    public static void connectList(ListNode[] list, int from, int to, int weight) {
        ListNode newNode = new ListNode(new Connection(from, to, weight));
        newNode.next = list[from];
        list[from] = newNode;
    }


    public static String getMaxDegreeFromList(ListNode[] list) {
        int maxDegree = 0, node = -1;

        for (int i = 0; i < list.length; i++) {
            int degree = 0;
            ListNode current = list[i];
            while (current != null) {
                degree++;
                current = current.next;
            }
            if (degree > maxDegree) {
                maxDegree = degree;
                node = i;
            }
        }
        return "Node " + node + ", Degree: " + maxDegree;
    }


    public static String getMaxWeightFromList(ListNode[] list) {
        int maxSum = 0, node = -1;

        for (int i = 0; i < list.length; i++) {
            int total = 0;
            ListNode current = list[i];
            while (current != null) {
                total += current.connection.weight;
                current = current.next;
            }
            if (total > maxSum) {
                maxSum = total;
                node = i;
            }
        }
        return "Node " + node + ", Weight Sum: " + maxSum;
    }
}


class Connection {
    int from, to, weight;

    public Connection(int from, int to, int weight) {
        this.from = from;
        this.to = to;
        this.weight = weight;
    }
}


class ListNode {
    Connection connection;
    ListNode next;

    public ListNode(Connection connection) {
        this.connection = connection;
    }
}

