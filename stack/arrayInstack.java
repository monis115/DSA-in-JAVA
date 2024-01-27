
public class arrayInstack {

    public static int push(int data, int top, int n, int stack[]) {
        if (top == n) {
            System.out.println("OverFlow cant add more items");
            return -1;
        } else

            stack[++top] = data;
        return top;

    }

    public static void delete(int top, int stack[]) {
        if (top == 0) {
            System.out.println("underFlow cant delete anythiing");
            return;
        } else

            top--;
    }

    public static void display(int stack[], int top) {
        if (top == -1) {
            System.out.println("Empty");
            return;
        }
        for (int i = 0; i <= top; i++) {
            System.out.println(stack[i]);
        }
    }

    public static void main(String args[]) {
        int top = -1;

        int n = 10;
        int[] stack = new int[n];

        int t = push(1, top, n, stack);

        t = push(4, t, n, stack);// here we are giving the value of

        t = push(7, t, n, stack);

        t = push(2, t, n, stack);

        display(stack, t);

    }
}
