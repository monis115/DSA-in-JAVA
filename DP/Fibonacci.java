public class Fibonacci {
    public static int fibo(int n, int f[]) {  //O(n) 
        if (n == 0 || n == 1) {
            return n;
        }
        if (f[n] != 0) { // fibo(n) is alredy calculated
            return f[n];
        }
        f[n] = fibo(n - 1, f) + fibo(n - 2, f);
        return f[n];
    }

    public static void main(String args[]) {
        int n = 5;
        int f[] = new int[n + 1];// Initial values 0,0,0,0,.....
        System.out.println(fibo(n, f));
    }
}