import java.util.Stack;

public class reverse {
    public static void Reverse(Stack<Integer> s) {
        if (s.isEmpty()) {
            return;
        }
        int top = s.pop();
        Reverse(s);
        System.out.println(top);
    }

    public static void main(String args[]) {
        Stack<Integer> s = new Stack<>();
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);
        s.push(5);
        s.push(6);
        s.push(7);

        Reverse(s);

    }
}
