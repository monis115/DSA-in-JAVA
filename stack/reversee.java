import java.util.Stack;

public class reversee {
    public static void reverse(Stack<Integer> stack) {
        if (stack.isEmpty()) {
            return;
        }
        int top = stack.pop();
        reverse(stack);
        System.out.println(top);
    }

    public static void main(String args[]) {
        Stack<Integer> s = new Stack<>();
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(5);
        s.push(7);
        reverse(s);
    }
}
