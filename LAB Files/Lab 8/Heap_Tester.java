import java.util.Arrays;

public class Heap_Tester {
    public static void main(String[]args){
        System.out.println("----------- Task3 ----------------");
        System.out.println();
        System.out.println("SAMPLE GIVEN INPUT: ");
        System.out.println("tasks=[2,4,7,1,6]");
        System.out.println("m = 4");
        System.out.println("SAMPLE OUTPUT\n[2,4,7,7]");
        System.out.println("MY OWN OUTPUT: ");
        int[] tasks={2,4,7,1,6};
        MinHeap final_heap=Task3_And_Task4.Task3(tasks,4,new MinHeap(4));
        Integer[] result=final_heap.sort();
        System.out.println(Arrays.toString(result));

        System.out.println();
        System.out.println("----------- Task4 ----------------");
        System.out.println();
        System.out.println("SAMPLE GIVEN INPUT: ");
        System.out.println("nums=[4,10,2,8,6,7]");
        System.out.println("k = 3");
        System.out.println("SAMPLE OUTPUT\n[10,8,7]");
        System.out.println("MY OWN OUTPUT: ");
        int [] nums={4,10,2,8,6,7};
        int[] answer=Task3_And_Task4.Task4(nums, 3);
        System.out.println(Arrays.toString(answer));


        


    }
    
}
