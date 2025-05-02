// Complete the sumOfLeaves method
public class Task3 {

    //===================================TASK#3======================

    public static Integer sumOfLeaves(BSTNode root, Integer sum) {
        if (root == null) {
            return sum;
        }
        
        if (isleaf(root)) {
            sum += root.elem;
            return sum;
        }
        
        sum = sumOfLeaves(root.left, sum);
        sum = sumOfLeaves(root.right, sum);
        
        return sum;
    }


    public static boolean isleaf(BSTNode root){
        if(root==null){
            throw new NullPointerException("Empty tree");
        }
        if(root.left==null && root.right==null){
            return true;
        }
        return false;
    }
    //===============================================================

}
