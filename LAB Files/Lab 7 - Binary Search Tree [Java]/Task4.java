// Complete the sumOfLeaves method
public class Task4 {

    //===================================TASK#4======================
    // This method takes only one parameter
    // it is root of the given tree
    // You can use extra helper private static methods as per need
    public static Integer mirrorSum( BSTNode root ){
        return mirrorSum(root.left,root.right,0);
        // remove this line
    }
    private static Integer mirrorSum(BSTNode Left,BSTNode Right,int sum){
        if((Left==null || Right==null)){
            return sum;
        }
        sum+=Left.elem+Right.elem;
        sum=mirrorSum(Left.left,Right.right,sum);
        sum=mirrorSum(Left.right,Right.left,sum);
        return sum;
        
    }

    // This is a another way of doing this questin in a much easier manner
    // public static Integer mirrorSum(BSTNode root) {
    //     if (root == null) return 0;
    //     return mirrorSum(root.left, root.right);
    // }
    
    // private static Integer mirrorSum(BSTNode left, BSTNode right) {
    //     if (left == null || right == null) {
    //         return 0;
    //     }
        
    //     int currentSum = left.elem + right.elem;
        
    //     return currentSum + mirrorSum(left.left, right.right) + mirrorSum(left.right, right.left);
    // }
    


    
    //===============================================================


}
