public class Task2 {
    //height = [1,8,6,2,5,4,8,3,7]
    public static void main(String[]args){
        int[] height = {1,8,6,2,5,4,8,3,7};
        int area=0;
        for(int i=0;i<height.length;i++){
            for(int j=i+1;j<height.length;j++){
                int temp=0;
                if(height[i]>height[j]){
                    temp=height[j]*(j-i);
                }
                else if(height[j]>height[i]){
                     temp=height[i]*(j-i);
                }
                else{
                     temp=height[i]*(j-i);
                }

                if(area<temp){
                    area=temp;
                }
            }
        }
        System.out.println(area);
    }
}
