// Task 04: Matrix Compression
class Task4{

    //Complete this method so that it gives the Expected Output
    public static Integer[][] compressMatrix( Integer[][] matrix ){
        int row_len=matrix.length;
        int col_len=matrix[0].length;

        Integer [][] result=new Integer[row_len/2][col_len/2];
        int row_pointer=0,col_pointer=0;

        for(int i=0;i<row_len;i+=2){
            col_pointer=0;
            int y=1;
            for(int x=0;x<col_len;x+=2,y+=2){
                int temp=matrix[i][x];
                int temp1=matrix[i][y];
                int temp2=matrix[i+1][x];
                int temp3=matrix[i+1][y];
                int sum=temp+temp1+temp2+temp3;
                result[row_pointer][col_pointer]=sum;
                col_pointer++;
            }
            row_pointer++;
        }
        return result;
    }

    //DO NOT CHANGE ANY DRIVER CODE BELOW THIS LINE
    public static void main(String[] args){
        Integer[][] matrix = {
            { 1 , 2 , 3 , 4 },
            { 5 , 6 , 7 , 8 },
            { 1 , 3 , 5 , 2 },
            {-2 , 0 , 6 ,-3 }
        };
        System.out.println("Given Matrix: ");
        Arr.print2D(matrix);
        
        System.out.println("\nExpected Output:");
        System.out.print("| 14 | 22 |\n| 2  | 10 |\n");
        
        System.out.print("\nYour Output:\n");
        Integer[][] returnedArray = compressMatrix( matrix );
        Arr.print2D( returnedArray );
    }
}