import java.util.Arrays;
public class MinHeap{
    private Integer[] list;
    private int size=0;
    public MinHeap(int capacity){
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
        swim(size,value);
        size++;
    }


    private void swim(int index, int value){
        if(index==0){
            return;
        }
        
        int parent=(index-1)/2;
        if(value<list[parent]){
            list[index]=list[parent];
            list[parent]=value;
            swim(parent,value);
        }
    }

    public Integer remove(){
        if(size==0){
            System.out.println("The array is empty");
            return null;
        }
        int temp=list[0];
        list[0]=list[size-1];
        list[--size]=null;
        sink(0);
        return temp;
        
    }
    private void sink(int index){
        if(index>=size) return;
        int min_index=index;
        int left=(index*2)+1;
        int right=(index*2)+2;
        if(left<size && list[min_index]>list[left]){
            min_index=left;
        }
        if(right<size && list[min_index]>list[right]){
            min_index=right;
        }
        
        if(min_index!=index){
            int temp=list[index];
            list[index]=list[min_index];
            list[min_index]=temp;
            sink(min_index);
        }
    }
    public Integer Extract_Min(){
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

class MinHeapTester{
    public static void main(String[] args){
        MinHeap heap=new MinHeap(20);
        heap.insert(10);
        heap.insert(20);
        heap.insert(30);
        heap.insert(15);
        heap.insert(5);
        
        System.out.println();
       
        int value=heap.Extract_Min();
        System.out.println();
        int value1=heap.remove();
        System.out.println(" The first smallest value is "+value + " and the second smallest is  "+ value1);
        Integer[] list=heap.sort();
        System.out.println(Arrays.toString(list));

        

    }
}