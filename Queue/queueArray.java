class Queue {
    public static int array[];
    public int size;
    public int rear;

    Queue(int size) {
        this.size = size;
        array = new int[size];
        this.rear = -1;
    }

    public boolean isEmpty() {
        return rear == -1;
    }

    // adding elements in the list
    public void add(int data) {
        if (rear == size - 1) {
            System.out.println("Queue is full");
            return;
        }
        rear++;
        array[rear] = data;

    }

    public int remove() {
        if (isEmpty()) {
            System.out.println("Queue is already empty");
            return -1;
        }
        int front = array[0];
        for (int i = 0; i < rear; i++) {
            array[i] = array[i + 1];
        }
        rear--;
        return front;
    }

    public int peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return -1;
        }
        return array[0];
    }
}

public class queueArray {
    public static void main(String args[]) {
        Queue q = new Queue(10);
        q.add(5);
        q.add(6);
        q.add(7);
        q.add(9);
        q.add(10);
        while (!q.isEmpty()) {
            System.out.print("| " + q.peek() + " ");
            q.remove();
        }

    }
}