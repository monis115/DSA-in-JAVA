import java.util.*;

public class arrayListINstack {
    public class stack {
        ArrayList<Integer> list = new ArrayList<>();

        public boolean isEmpty() { 
            return list.size() == 0;
        }

        public void push(int data) { // push data
            list.add(data);         // this will add the data at the end of the list
        }

        /// pop data
        public int pop() {
            if (isEmpty()) {
                return -1;
            }
            int top = list.get(list.size() - 1);
            list.remove(list.size() - 1);
            return top;
        }

        // peek data
        public int peek() {
            if (isEmpty()) {
                return -1;
            }
            return list.get(list.size() - 1);
        }
    }

    public static void main(String args[]) {
        Stack s = new Stack();
        s.push(0);
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);
        s.push(5);
        while (!s.isEmpty()) {
            System.out.print(s.peek() + " ");
            s.pop();
        }

    }
}
