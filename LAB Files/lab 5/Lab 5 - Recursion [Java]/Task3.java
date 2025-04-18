import java.util.Random;

public class Task3 {

    // Task 3A: Print elements of a linked list using loop
    public static void task3A(Node head) {
        Node temp=head;
        while(temp!=null){
            System.out.print(" "+temp.elem);
            temp=temp.next;
            
        }
        System.out.println();
    }

    // Task 3B: Print elements of a linked list using recursion
    public static void task3B_recursive(Node head) {
        Node temp=head;
        if(temp==null){
            System.out.println();
            return;
        }
        System.out.print(" "+temp.elem);
        task3B_recursive(temp.next);
    }

    // Task 3C: Return sum of all elements using loop
    public static int task3C(Node head) {
        int sum=0;
        Node temp=head;
        while(temp!=null){
            sum+=temp.elem;
            temp=temp.next;
        }
        return sum;
    }

    // Task 3D: Return sum of all elements using recursion
    public static int task3D_recursive(Node head) {
        Node temp=head;
        if(temp==null){
            return 0;
        }
        int value=temp.elem;
        return value+task3D_recursive(temp.next);
    }
    

    // Task 3E: Return (sum of odd) - (product of even) using loop
    public static int task3E(Node head) {
        Node temp=head;
        int sum=0;
        int product=1;
        while(temp!=null){
            if(temp.elem%2==0){
                product=product*temp.elem;
            }
            else{
                sum+=temp.elem;
            }
            temp=temp.next;
        }

        return sum-product;
    }

    public static int odd(Node temp){
        if(temp==null){
            return 0;
        }
        if(temp.elem%2!=0){
            return temp.elem+odd(temp.next);
        }
        return odd(temp.next);
    }

    public static int even(Node temp){
        if(temp==null){
            return 0;
        }
        if(temp.elem%2==0){
            return (1*temp.elem)*even(temp.next);
        }
        return even(temp.next);
    }

    
    // Task 3F: Return (sum of odd) - (product of even) using recursion
    public static int task3F_recursive(Node head) {
        Node temp=head;
        
        int sum=odd(temp);
        int product=even(temp);
        return sum-product;
    }

    public static void main(String[] args) {
        // Driver code for testing Task 3 methods
        Node head = arr2LL( generateRandomArray(6, 1, 20) );
        
        System.out.println(" Task3A ");
        System.out.println("Expected Output: ");
        showLL(head);
        System.out.println("Your Output: ");
        task3A(head);

        System.out.println("\n Task3B ");
        System.out.println("Expected Output: ");
        showLL(head);
        System.out.println("Your Output: ");
        task3B_recursive(head);

        System.out.println("------------------------------");

        head = arr2LL( new int[]{23,5,3,11,7,6} );
        System.out.println("\n Task3C ");
        System.out.println("The LinkedList: ");
        showLL(head);
        System.out.println("Expected Output: "+55);
        System.out.println("Your Output: "+task3C(head));

        System.out.println("\n Task3D ");
        System.out.println("The LinkedList: ");
        showLL(head);
        System.out.println("Expected Output: "+55);
        System.out.println("Your Output: "+task3D_recursive(head));

        System.out.println("------------------------------");

        head = arr2LL( new int[]{3,5,8,3,2} );
        System.out.println("\n Task3E ");
        System.out.println("The LinkedList: ");
        showLL(head);
        System.out.println("Expected Output: "+29);
        System.out.println("Your Output: "+task3E(head));

        System.out.println("\n Task3F ");
        System.out.println("The LinkedList: ");
        showLL(head);
        System.out.println("Expected Output: "+29);
        System.out.println("Your Output: "+task3F_recursive(head));

        System.out.println("------------------------------");
    }



    //helper methods
    public static Node arr2LL(int[] arr) {
        if (arr.length == 0) return null;
        Node head = new Node(arr[0]);
        Node n = head;
        for (int i = 1; i < arr.length; i++) {
            Node newNode = new Node(arr[i]);
            n.next = newNode;
            n = newNode;
        }
        return head;
    }
    
    public static int[] generateRandomArray(int size, int start, int end) {
        if (start > end)
            throw new IllegalArgumentException("Start value must be less than or equal to end value.");
        int[] arr = new int[size];
        Random rand = new Random();
        for (int i = 0; i < size; i++)
            arr[i] = rand.nextInt(end - start + 1) + start;
        return arr;
    }

    public static void showLL(Node head) {
        while (head != null) {
            System.out.print(head.elem + " -> ");
            head = head.next;
        }
        System.out.println("null");
    }
}
