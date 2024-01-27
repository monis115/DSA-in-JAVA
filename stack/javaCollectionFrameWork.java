import java.util.Stack;

public class javaCollectionFrameWork {
    public static void main(String args[]) {
        Stack<Integer> s = new Stack<>();
        s.push(0);
        s.push(1);
        s.push(3);
        s.push(4);

        while (!s.isEmpty()) {
            System.out.println(s.peek());
            s.pop();
        }
    }
}