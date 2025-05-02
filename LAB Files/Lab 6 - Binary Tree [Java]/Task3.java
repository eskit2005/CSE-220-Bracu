// Complete the sumTree method
public class Task3 {

        //===================================TASK#3===================================
        // This method takes only 1 parameter which is root of the given tree
        // This method returns an Integer
        // At times you may need to typeCast root.elem to Integer
        // You can use extra helper private static methods as per need
        public static Integer sumTree( BTNode root ){
            return sumTree(root,0);
           
        }
        private static Integer sumTree(BTNode root, int lvl){
            if(root==null) return 0;
            
            if(lvl==0){
                return (Integer)root.elem +sumTree(root.left,lvl+1)+ sumTree(root.right,lvl+1);
            }

            return ((Integer)root.elem % lvl)+sumTree(root.left,lvl+1)+ sumTree(root.right,lvl+1);
        }
       //============================================================================

}
