public class Adjency{
    private int[][] matrix=new int[8][8];
    public void addedge(int from,int to){
        matrix[from][to]=1;

    }
    public void addedge_undirected(int from,int to){
        matrix[from][to]=1;
        matrix[to][from]=1;

    }
    public void addedge_undirected_weight(int from,int to,int value){
        matrix[from][to]=value;
        matrix[to][from]=value;
    }
    public int[][]get_array(){
        return matrix;
    }

}