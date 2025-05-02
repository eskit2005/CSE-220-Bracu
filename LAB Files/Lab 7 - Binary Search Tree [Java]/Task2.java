// Complete the sumOfLeaves method
public class Task2 {

    //===================================TASK#2===================================
    // This method takes only 2 parameters
    // 1st one is root
    // 2nd one is an Integer
    // You'll need to find the path from the root to a node containing the Integer
    // return the path as a String
    public static String findPath( BSTNode root, Integer key ){
       
        return findPath(root, key,"");
    }
    private static String findPath( BSTNode root, Integer key,String path ){
        
        if(root==null){
            path="No Path Found";
            return path;
        }
        if(root.elem==key){
            path+=(int)root.elem;
            return path;
        }
        else if(root.elem>key){
            path+=root.elem+ " ";
            return findPath(root.left, key,path);
        }
        else {
            path+=+root.elem+ " ";
            return findPath(root.right, key,path);
        }
        
    }
    //============================================================================

}
