// Task04: Word Decoder
public class Task2 {

    public static Node wordDecoder( Node head ){
       int length=0;
       Node current=head;
       while(current!=null){
        current=current.next;
        length++;
       }
       int multiples=13%length;
       Node lastnode=null;
       current=head;
       int size=0;
       while(current!=null){
        if(size%multiples==0 && size>0){
            Node temp=new Node(current.elem,lastnode);
            lastnode=temp;
        }
        current=current.next;
        size++;
       }
       Node dummy=new Node(null,lastnode);
       return dummy;
    }

    //NOTE: if you find any issue with the driver code please inform AIB
    //DO NOT TOUCH THE DRIVER CODE BELOW
    public static void main(String[] args){
        System.out.println("==============Test Case 1=============");
        Node head = LinkedList.createList(new Character[]{'B', 'M', 'D', 'T', 'N', 'O', 'A', 'P', 'S', 'C'});
        System.out.print("Encoded Word: ");
        LinkedList.printLL(head);
        System.out.println("\nExpected output: null -> C -> A -> T");
        Node result = wordDecoder(head);
        System.out.println( "Your output: ");
        LinkedList.printLL(result); //This should print null -> C -> A -> T
        System.out.println();
        System.out.println("==============Test Case 2=============");
        head = LinkedList.createList(new Character[]{'Z', 'O', 'T', 'N', 'X'});
        System.out.print("Encoded Word: ");
        LinkedList.printLL(head);
        System.out.println("\nExpected output: null -> N");
        result = wordDecoder(head);
        System.out.println( "Your output: ");
        LinkedList.printLL(result); //This should print null -> N
        System.out.println();
    }
}
