public class ArrayCircularQueue {

    private int[] queue;
    private int front, rear, size;

    public ArrayCircularQueue(int size) {
        this.size = size;
        queue = new int[size];
        front = -1;
        rear = -1;
    }

 
    public void enqueue(int value) {
        if ((rear + 1) % size == front) {
            System.out.println("Queue is full");
            return;
        }

        if (front == -1) {
            front = 0;
        }

        rear = (rear + 1) % size;
        queue[rear] = value;
        System.out.println(value + " enqueued");
    }

    
    public int dequeue() {
        if (front == -1) {
            System.out.println("Queue is empty");
            return -1;
        }

        int value = queue[front];

        if (front == rear) {
            front = -1;
            rear = -1;
        } else {
            front = (front + 1) % size;
        }

        return value;
    }

    
    public void display() {
        if (front == -1) {
            System.out.println("Queue is empty");
            return;
        }

        System.out.print("Queue elements: ");
        int i = front;
        while (true) {
            System.out.print(queue[i] + " ");
            if (i == rear)
                break;
            i = (i + 1) % size;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ArrayCircularQueue cq = new ArrayCircularQueue(5);

        cq.enqueue(10);
        cq.enqueue(20);
        cq.enqueue(30);
        cq.enqueue(40);

        cq.display();

        System.out.println("Dequeued: " + cq.dequeue());
        cq.display();
    }
}
