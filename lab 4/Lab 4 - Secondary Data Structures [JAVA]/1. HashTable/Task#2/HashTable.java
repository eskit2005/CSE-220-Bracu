/*You will have to complete the FruitNode Contrustor first
 then within this class you only have to complete two methods
 hashFunction() and insert()
 the rest of the metods are already written
 DO NOT TOUCH any other methods or codes*/
 public class HashTable {

    //ht[] :: is the HashTable array that stores the FruitNode objects
    private FruitNode[] ht;

    //Constructor that initializes the HashTable array
    //DO NOT change this Constructor
    public HashTable(int size){
        this.ht = new FruitNode[size];
    }

    //This method basically prints the HashTable
    //DO NOT change this method
    public void show(){
        for(int i=0; i<ht.length; i++){
            System.out.print( i+" " );
            FruitNode n = ht[i];
            while (n!=null){
                System.out.print("('"+n.fruit[0]+"', "+n.fruit[1]+") --> ");
                n = n.next;
            }
            System.out.println();
        }
    }

    //you need to COMPLETE this method
    private int hashFunction( String key ){
        char[] chars=key.toCharArray();
        boolean even=(chars.length%2==0);
        int sum=0;
        for(int i=0;i<chars.length;i++){
            if(!even){
                if(i%2!=0){
                    sum+=(int)chars[i];
                }
            }
            else{
                if(i%2==0){
                    sum+=(int)chars[i];
                }
            }

        }
        sum=(sum)%ht.length;

        return sum;
    }

    //you need to COMPLETE this method
    //The insert() method will create a FruitNode using name(Key) & price(value)
    //then inserts it in the proper hashed index
    //If collision occurs resolve using the steps explained in the question
    public void insert(String key, Integer value){
        int index=hashFunction(key);
        FruitNode head=ht[index];
        if(head==null){
            head=new FruitNode(key,value);
            ht[index]=head;

        }
        else{
            FruitNode temp=head;
            while(temp!=null){
                if(temp.fruit[0].equals(key)){
                    temp.fruit[1]=value;
                    ht[index]=head;
                    return;
                }
                temp=temp.next;
            }

            FruitNode node=new FruitNode(key,value);
            // If the new node has a greater value than the head, insert at front
            if ((int) value > (int) head.fruit[1]) {
                node.next = head;
                ht[index] = node;  
                return;
            }

            // Traverse 
            temp = head;
            while (temp.next != null && (int) temp.next.fruit[1] > (int) value) {
                temp = temp.next;
            }

            
            node.next = temp.next;
            temp.next = node;
        }



        

    }
}