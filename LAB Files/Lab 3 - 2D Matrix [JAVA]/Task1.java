//Task 01: Zigzag Walk
class Task1{

    //Complete this method so that it gives the Expected Output
    public static void walkZigzag( Integer[][] matrix ){

       int row_len=matrix.length;
       int col_len=matrix[0].length;
       boolean isblack=true;
       for(int i=0;i<col_len;i++){

           if(i%2==0){
               for(int j=0;j<row_len;j++){
                   if(isblack) {
                       int value = matrix[j][i];
                       System.out.print(value + " ");
                       isblack=false;
                   }
                   else{
                       isblack=true;
                   }

               }
           }
           else{
               for(int j=row_len-1;j>=0;j--){
                   if(isblack) {
                       int value = matrix[j][i];
                       System.out.print(value + " ");
                       isblack=false;
                   }
                   else{
                       isblack=true;
                   }
               }
           }

           System.out.println();
       }

    }

    //DO NOT CHANGE ANY DRIVER CODE BELOW THIS LINE
    public static void main(String[] args){
        Integer[][] floor1 = {
            {3 , 8 , 4 , 6 , 1},
            {7 , 2 , 1 , 9 , 3},
            {9 , 0 , 7 , 5 , 8},
            {2 , 1 , 3 , 4 , 0},
            {1 , 4 , 2 , 8 , 6}
        };
        System.out.println("Given Matrix: ");
        Arr.print2D(floor1);
        System.out.println("\nExpected Output:");
        System.out.print("3 9 1\n1 2\n4 7 2\n4 9\n1 8 6\n");
        System.out.print("\nYour Output:\n");
        walkZigzag( floor1 );

        System.out.print("\n======================\n");

        Integer[][] floor2 = {
            {3 , 8 , 4 , 6 , 1},
            {7 , 2 , 1 , 9 , 3},
            {9 , 0 , 7 , 5 , 8},
            {2 , 1 , 3 , 4 , 0},
        };
        System.out.println("\nGiven Matrix: ");
        Arr.print2D(floor2);
        System.out.println("\nExpected Output:");
        System.out.print("3 9\n1 2\n4 7\n4 9\n1 8\n");
        System.out.print("\nYour Output:\n");
        walkZigzag( floor2 );

    }
}