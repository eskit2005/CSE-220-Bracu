// Complete the levelSum method
public class Task6 {

    //===================================TASK#6===================================
    // This method takes only 1 parameter which is root of the given tree
    // This method returns an Integer
    // At times you may need to typeCast root.elem to Integer
    // You can use extra helper private static methods with extra extra params as per need
    public static Integer levelSum( BTNode root ){
       return levelsum(root,1);
        
    }
    private static Integer levelsum(BTNode root, int lvl){
        if(root==null) return 0;
        if(lvl%2!=0){
            return (-1*(Integer)root.elem)+levelsum(root.left,lvl+1)+levelsum(root.right,lvl+1);
        }
        else{
            return (Integer)root.elem+levelsum(root.left,lvl+1)+levelsum(root.right,lvl+1);
        
        }
        
    }
    //============================================================================

}