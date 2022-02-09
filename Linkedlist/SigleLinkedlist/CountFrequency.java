public class CountFrequency {
    Node head;
    int frequency = 0;
    class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
            this.next = null;
        }
    }
    public void push(int new_data)
    {
       
        Node new_node = new Node(new_data);
        new_node.next = head;
        head = new_node;
    }
    int countForFrequency(int item){
        int count = 0;
        Node temp = head;
        while(temp != null){
            if(temp.data == item)
                count++;
            temp = temp.next;
        }
        return count;
    }
    int CountFrequencyRec(Node node,int key){
        if(node == null)
            return frequency;
        if(node.data == key){
            frequency++;
        }
        return CountFrequencyRec(node.next,key);
    }
    public static void main(String arg[]){
        CountFrequency llist = new CountFrequency();
        llist.push(1);
        llist.push(2);
        llist.push(1);
        llist.push(3);
        llist.push(1);
        System.out.println("Count of 1 is " + llist.countForFrequency(1));
        System.out.println("Count of 1 is " + llist.CountFrequencyRec(llist.head,1));
    }
}
