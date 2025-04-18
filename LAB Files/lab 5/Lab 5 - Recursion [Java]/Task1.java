
import java.util.Scanner;

public class Task1 {

    // Task 1A: Print numbers from 1 to 10 using a loop
    public static void task1A() {
        int i=10;
        while(i>0){
            System.out.println(i--);

        }
    }

    // Task 1B: Print numbers from 1 to 10 using recursion
    public static void task1B_recursive(int i) {
       if(i!=0){
        System.out.println(i);
        task1B_recursive(i-1);
       }
    }

    // Task 1C: Print numbers from 1 to n using a loop
    public static void task1C(int n) {
       for(int i=1;i<=n;i++){
        System.out.println(i);
       }
    }

    // Task 1D: Print numbers from 1 to n using recursion
    public static void task1D_recursive(int i, int n) {
        
        if(i!=n){
            System.out.println(i++);
            task1D_recursive(i,n);
        }
        else{
            System.out.println(i);
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        Task1 temp=new Task1();
        System.out.println("......Outputs of task1A() method....\n");
        temp.task1A();
        System.out.println();
        System.out.println("......Outputs of task1B() method....\n");
        temp.task1B_recursive(10);
        System.out.println("Enter the targer numbere");
        int n=sc.nextInt();
        System.out.println("......Outputs of task1C() method....\n");
        temp.task1C(n);
        System.out.println("......Outputs of task1D() method....\n");
        temp.task1D_recursive(1,n);

        sc.close();

        
    }
}
