import java.util.Arrays;
public class MaxHeap{
    private Integer[] list;
    private int size=0;
    public MaxHeap(int capacity){
        list=new Integer[capacity];
    }


    private void resize(int index){
        Integer[] list1=new Integer[index*2];
        for(int i=0;i<list.length;i++){
            list1[i]=list[i];
        }
        list=list1;
    }

    public void insert(int value){
        if(size>=list.length) resize(size);
        list[size]=value;
        swim(size);
        size++;
    }
    private void swim(int index){
        if(index<=0){
            return;
        }

        int parent=(index-1)/2;

        if(list[index]>list[parent]){
            int temp=list[index];
            list[index]=list[parent];
            list[parent]=temp;

            swim(parent);
        }
    }
    public Integer remove(){
        if(size==0){
            System.out.println("The heap is empty");
            return null;
        }

        int temp=list[0];
        list[0]=list[size-1];
        list[--size]=null;
        sink(0);
        return temp;
    }

    private void sink(int index){
        if(index>=size){
            return;
        }
        int max_index=index;
        int left=(index*2)+1;
        int right=(index*2)+2;
        if(left<size && list[index]<list[left]){
            max_index=left;
        }
        else if(right<size && list[index]<list[right]){
            max_index=right;
        }

        if(max_index!=index){
            int temp=list[index];
            list[index]=list[max_index];
            list[max_index]=temp;
            sink(max_index);

        }
        
    }
    public Integer Extract_Max(){
        return remove();
    }

    public Integer[] sort(){
        Integer[] list1=new Integer[size];
        int i=0;
        while(size!=0){
            list1[i]=remove();
            i++;
       }
       return list1;
    }

}

class MaxHeapTester{
    public static void main(String[] args){
        MaxHeap heap=new MaxHeap(20);
        heap.insert(10);
        heap.insert(20);
        heap.insert(30);
        heap.insert(15);
        heap.insert(5);
        
        System.out.println();
       
        int value=heap.Extract_Max();
        System.out.println();
        int value1=heap.remove();
        System.out.println(" The first biggest value is "+value + " and the second biggest is  "+ value1);
        Integer[] list=heap.sort();
        System.out.println(Arrays.toString(list));

        

    }
}