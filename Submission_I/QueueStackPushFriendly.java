import java.util.LinkedList;
import java.util.Queue;

public class QueueStackPushFriendly {

    private Queue<Integer> q1;
    private Queue<Integer> q2;

    public QueueStackPushFriendly() {
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
    }

    
    public void push(int value) {
        q1.add(value);
        System.out.println(value + " pushed to stack");
    }

  
    public int pop() {
        if (q1.isEmpty()) {
            System.out.println("Stack is empty");
            return -1;
        }

      
        while (q1.size() > 1) {
            q2.add(q1.remove());
        }

       
        int poppedElement = q1.remove();

        
        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;

        return poppedElement;
    }

    public void display() {
        System.out.println("Stack elements: " + q1);
    }

    public static void main(String[] args) {
        QueueStackPushFriendly stack = new QueueStackPushFriendly();

        stack.push(10);
        stack.push(20);
        stack.push(30);

        stack.display();

        System.out.println("Popped: " + stack.pop());
        stack.display();
    }
}
