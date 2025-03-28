//Task 02: Decryption Process
public class Task2{

    //Complete this method so that it gives the Expected Output
    public static Integer[] decryptMatrix(Integer[][] matrix) {
        int row_len = matrix.length;
        int col_len = matrix[0].length;
        Integer[] decrypt = new Integer[col_len - 1];

        for (int i = 0; i < col_len - 1; i++) {
            int sum1 = 0;
            int sum2 = 0;
            
            for (int j = 0; j < row_len; j++) {
                sum1 += matrix[j][i];
                //this points to the elements of the next column
                sum2+=matrix[j][i+1];
            }
            decrypt[i] = sum1 - sum2;
        }
        return decrypt;
    }

    //DO NOT CHANGE ANY DRIVER CODE BELOW THIS LINE
    public static void main(String[] args){
        Integer[][] matrix = {
            {1,3,1},
            {6,4,2},
            {5,1,7},
            {9,3,3},
            {8,5,4}
        };
        System.out.println("Given Matrix: ");
        Arr.print2D(matrix);
        System.out.println("\nExpected Output:\n[ -13 1 ]");
        Integer[] returned_val_1 = decryptMatrix( matrix );
        System.out.print("\nYour Output:\n");
        Arr.print(returned_val_1);

    }
}