public class Dequeue {
    static final int MAX = 100;
    int arr[];
    int front;
    int rear;
    int size;
    public Dequeue(int size){
        arr = new int[MAX];
        front = -1;
        rear = 0;
        this.size = size;
    }
    boolean isFull(){
        return ((front == 0 && rear == size -1) || front == rear+1);
    }
    boolean isEmpty(){
        return front == -1;
    }

    void insertFront(int key){
        if(isFull()){
             System.out.println("Overflow");
             return;
        }
    }
}
