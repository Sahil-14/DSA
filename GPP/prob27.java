import java.util.*;

// reverse a linked list

 class prob27{
     Node head = null;
     class Node{
         int data;
         Node next;
         Node(int data){
             this.data = data;
             this.next = null;
         }
     }
      void reverse(){
        Node prev = null;
        Node curr = head;
        Node next = null;
        while(curr != null){
         next = curr.next;
         curr.next = prev;
         prev = curr;
         curr = next;
        }
        head = prev;
     }
     void reverseUsingStack(){
         Stack<Node> s = new Stack<Node>();
         Node temp = head;
         while(temp.next != null){
             s.add(temp);
             temp = temp.next;
         }
         head = temp;
         while(!s.isEmpty()){
             temp.next = s.peek();
             s.pop();
         
             temp = temp.next;
         }

     }
     public static void main(String arg[]){

     }
 }