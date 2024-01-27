class Queue {
    public int array[];
    public int size;
    public int rear;
    public int front;

    Queue(int size) {
        this.size = size;
        array = new int[size];
        this.rear = -1;
        this.front = -1;
    }

    public boolean isEmpty() {
        return rear == -1 && front == -1;
    }

    public boolean isFull() {
        return (rear + 1) % size == front;
    }

    // adding elements in the list
    public void add(int data) {
        if (isFull()) {
            System.out.println("Queue is full");
            return;
        }
        rear = (rear + 1) % size;
        array[rear] = data;

    }

    public int remove() {
        if (isEmpty()) {
            System.out.println("Queue is already empty");
            return -1;
        }
        int result = array[front];
        // for single element presnt in the list
        if (rear == front) {
            rear = front = -1;
        }
        front = (front + 1) % size;

        return result;
    }

    public int peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return -1;
        }
        return array[front];
    }
}

public class circularQueue {
    public static void main(String args[]) {
        Queue q = new Queue(8);
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);
        q.add(6);
        q.add(7);
        System.out.println("Removed elements " + q.remove());
        System.out.println("Removed elements " + q.remove());
        q.add(10);
        q.add(10);
        q.add(10);

        while (!q.isEmpty()) {
            System.out.print("| " + q.peek() + " ");
            q.remove();
        }

    }
}