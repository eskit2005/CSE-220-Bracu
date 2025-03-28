// Task 03: Row Rotation Policy of BRACU Classroom
class Task3{

    //Complete this method so that it gives the Expected Output//
    public static Integer rowRotation( Integer examWeek, String[][] matrix ){

        int row_len=matrix.length;
        int col_len=matrix[0].length;

        String [][] storing=new String[examWeek-1][col_len];
        
        //Storing
        int steps=examWeek-1;
        int temp=0;
        for(int k=row_len-(steps);k<row_len;k++){
            storing[temp]=matrix[k];
            temp++;
        }
        //Rotating 
      
            for(int j=row_len-1;j>=steps;j--){
                matrix[j]=matrix[j-steps];
            }
        

        //Dumping values
        for(int i=0;i<steps;i++){
            matrix[i]=storing[i];
        }
        int valid_row=-1;
        for(int i=0;i<row_len;i++){
            for(int j=0;j<col_len;j++){
                if(matrix[i][j].equals("AA")){
                    valid_row=i+1;
                    break;
                }
            }
        }
        Arr.print2D(matrix);


        return valid_row;
    }

    //DO NOT CHANGE ANY DRIVER CODE BELOW THIS LINE
    public static void main(String[] args){
        String[][] seatStatus = {
                {"A" , "B"  , "C"  , "D"  , "E"},
                {"F" , "G"  , "H"  , "I"  , "J"},
                {"K" , "L"  , "M"  , "N"  , "O"},
                {"P" , "Q"  , "R"  , "S"  , "T"},
                {"U" , "V"  , "W"  , "X"  , "Y"},
                {"Z" , "AA" , "BB" , "CC" , "DD"}
        };
        System.out.println("Given Seat Status: ");
        Arr.print2D(seatStatus);
        
        System.out.println("\nExpected Output:");
        System.out.println("| U  | V  | W  | X  | Y  | ");
        System.out.println("| Z  | AA | BB | CC | DD | ");
        System.out.println("| A  | B  | C  | D  | E  | ");
        System.out.println("| F  | G  | H  | I  | J  | ");
        System.out.println("| K  | L  | M  | N  | O  | ");
        System.out.println("| P  | Q  | R  | S  | T  | ");
        System.out.println("Your friend AA will be on row 2");
        
        System.out.print("\nYour Output:\n");
        Integer examWeek = 3;
        //This following should print modified seat status after rotation and return the current exam week
        Integer rowNumber = rowRotation( examWeek, seatStatus );
        //The following should print Your friend AA will be on row 2
        System.out.println("Your friend AA will be on row "+rowNumber);
    }
}