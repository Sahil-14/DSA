public class FindMiddle {
    Node head;
    class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
            this.next = null;
        }
    }

// 1 -- 2 -- 3 -- 4 -- 5 -- 6 -- 7 --null
// count = 7, mid = 4 ,count/2 = 3 ,i = 0 (i < 4)
//current = 1


    int printMiddle(){
        int count = 0;
        Node temp = head;
        while(temp != null){
            temp = temp.next;
            count++;
        }
        Node mid = head;
        for(int i = 0;i<count/2;i++){
            mid = mid.next;
        }
        return mid.data;
    }
    // 1 -- 2 -- 3 -- 4 -- 5 -- 6 -- 7 -- 8 --null
    // s_p = 5,f_p = null
    int printMiddleUsingTwoPointer(){
        Node slow_pointer =head;
        Node fast_pointer = head;
        if(head != null){
            while(fast_pointer != null && fast_pointer.next != null){
                slow_pointer = slow_pointer.next;
                fast_pointer = fast_pointer.next.next;
            }
        }
        return slow_pointer.data;
    }
        // 1 -- 2 -- 3 -- 4 -- 5 -- 6 -- 7 -- 8 --null
// temp = n,mid = 5, count = 7
    int printMiddleByOddCount(){
        int count = 0;
        Node mid = head;
        Node temp = head;

        while(temp != null){
            
            if(count %2 == 1){
                mid = mid.next;
            }
            ++count;
            temp = temp.next;
            
        }
        return mid.data;
    }

    public void push(int new_data)
    {
        /* 1 & 2: Allocate the Node &
                  Put in the data*/
        Node new_node = new Node(new_data);
 
        /* 3. Make next of new Node as head */
        new_node.next = head;
 
        /* 4. Move the head to point to new Node */
        head = new_node;
    }
    public void printList()
    {
        Node tnode = head;
        while (tnode != null)
        {
            System.out.print(tnode.data+"->");
            tnode = tnode.next;
        }
        System.out.println("NULL");
    }
    public static void main(String [] args)
    {
        FindMiddle llist = new FindMiddle();
        for (int i=2; i>0; --i)
        {
            llist.push(i);
           
          
        }
     
        System.out.println( llist.printMiddle());
       System.out.println( llist.printMiddleUsingTwoPointer());
       System.out.println( llist.printMiddleByOddCount());
    }
}
