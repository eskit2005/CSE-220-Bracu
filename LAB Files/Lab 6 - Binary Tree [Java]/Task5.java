// Complete the subtractSummation method
public class Task5 {

    //===================================TASK#5===================================
    // This method takes only 1 parameter which is root of the given tree
    // This method returns an Integer
    // At times you may need to typeCast root.elem to Integer
    // You can use extra helper private static methods with extra extra params as per need
    public static Integer subtractSummation( BTNode root ){
        int sum1=sub_tree(root.left);
        int sum2=sub_tree(root.right);

        return sum1-sum2; 
    }
    private static Integer sub_tree(BTNode root){
        if(root==null) return 0;

        return (Integer)root.elem + sub_tree(root.left)+sub_tree(root.right);
    }
    //============================================================================

}