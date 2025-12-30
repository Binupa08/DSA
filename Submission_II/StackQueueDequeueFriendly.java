import java.util.Stack;

public class StackQueueDequeueFriendly {

    private Stack<Integer> s1;
    private Stack<Integer> s2;

    public StackQueueDequeueFriendly() {
        s1 = new Stack<>();
        s2 = new Stack<>();
    }

    
    public void enqueue(int value) {
        // Move all elements to s2
        while (!s1.isEmpty()) {
            s2.push(s1.pop());
        }

       
        s1.push(value);
        System.out.println(value + " enqueued");

        
        while (!s2.isEmpty()) {
            s1.push(s2.pop());
        }
    }

   
    public int dequeue() {
        if (s1.isEmpty()) {
            System.out.println("Queue is empty");
            return -1;
        }
        return s1.pop();
    }

    
    public void display() {
        System.out.println("Queue elements: " + s1);
    }

    public static void main(String[] args) {
        StackQueueDequeueFriendly queue = new StackQueueDequeueFriendly();

        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);

        queue.display();

        System.out.println("Dequeued: " + queue.dequeue());
        queue.display();
    }
}
