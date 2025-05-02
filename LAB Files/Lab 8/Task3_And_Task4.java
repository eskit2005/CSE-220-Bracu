public class Task3_And_Task4{

    private static MinHeap populate_zeros(MinHeap heap,int m){
        while(m>0){
            heap.insert(0);
            m--;
        }
        return heap;
    }

    public static MinHeap Task3(int[] tasks,int m,MinHeap heap){
        heap=populate_zeros(heap, m);
        for(int i=0;i<tasks.length;i++){
            int temp=heap.Extract_Min();
            temp+=tasks[i];
            heap.insert(temp);
        }
        return heap;
    }

    public static int[] Task4(int[] nums,int k){
        MaxHeap heap=new MaxHeap(nums.length);
        for(int i=0;i<nums.length;i++){
            heap.insert(nums[i]);
        }

        int[] result=new int[k];
        int index=0;
        while(k>0){
            result[index]=heap.remove();
            index++;
            k--;
        }
        return result;

    }


    
}
