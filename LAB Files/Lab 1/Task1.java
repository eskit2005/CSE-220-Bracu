import java.util.Arrays;

public class Task1{
    public static void main(String[]args){
       int []arr1={1,2,3} ;
       int[] arr2={2,5,6};
       int k=0;//first array
       int z=0;//second array
       int [] result=new int[arr1.length+arr2.length];
       for(int i=0;i<result.length;i++){
        if(k==arr1.length){
            result[i]=arr2[z];
            z++;
        }
        else if(z==arr2.length){
            result[i]=arr1[k];
            k++;
        }
        else{
            int temp=arr1[k];
            int temp1=arr2[z];
            if(temp>temp1){
               result[i]=temp1;
               z++;
            }
            else if(temp>temp1){
                result[i]=temp;
                k++;

            }
            else{
                result[i]=temp;
                k++;

            }
        }
       }

       System.out.println(Arrays.toString(result));

    }
}