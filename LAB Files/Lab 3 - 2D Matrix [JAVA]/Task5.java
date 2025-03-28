// Task 05: Game Arena
class Task5 {

    // Complete this method so that it gives the Expected Output
    public static void playGame(Integer[][] arena) {
        int row_len = arena.length;
        int col_len = arena[0].length;
        int sum = 0;

        
        for (int i = 0; i < row_len; i++) {
            for (int j = 0; j < col_len; j++) {
                if (arena[i][j] % 50 == 0 && arena[i][j] != 0) { 

                    if (i > 0 && arena[i - 1][j] == 2) sum += 1;
                    if (i < row_len - 1 && arena[i + 1][j] == 2) sum += 1;
                  
                    if (j > 0 && arena[i][j - 1] == 2)  sum += 1;
                   
                    if (j < col_len - 1 && arena[i][j + 1] == 2)  sum += 1;
                }
            }
        }
        sum*=2;

       
        System.out.print("Points Gained: " + sum + ". ");
        if (sum >= 10) {
            System.out.print("Your team has survived the game.");
        } else {
            System.out.print("Your team is out.");
        }
    }

    // DO NOT CHANGE ANY DRIVER CODE BELOW THIS LINE
    public static void main(String[] args) {
        Integer[][] arena = {
            {0, 2, 2, 0},
            {50, 1, 2, 0},
            {2, 2, 2, 0},
            {1, 100, 2, 0}
        };
        System.out.println("Given Arena: ");
        Arr.print2D(arena);
        
        System.out.println("\nExpected Output:");
        System.out.print("Points Gained: 6. Your team is out.\n");
        
        System.out.print("\nYour Output:\n");
        playGame(arena);

        System.out.print("\n======================\n");

        Integer[][] arena1 = {
            {0, 2, 2, 0, 2},
            {1, 50, 2, 1, 100},
            {2, 2, 2, 0, 2},
            {0, 200, 2, 0, 0}
        };
        System.out.println("\nGiven Arena: ");
        Arr.print2D(arena1);
        
        System.out.println("\nExpected Output:");
        System.out.print("Points Gained: 14. Your team has survived the game.\n");
        
        System.out.print("\nYour Output:\n");
        playGame(arena1);
    }
}
