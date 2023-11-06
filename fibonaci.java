public class fibonaci {

    public static int nonRecursiveFibonacci(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("n must be a non-negative integer.");
        } else if (n == 0 || n == 1) {
            return n;
        } else {
            int a = 0;
            int b = 1;
            int c = 0;
            for (int i = 2; i <= n; i++) {
                c = a + b;
                a = b;
                b = c;
            }
            return c;
        }
    }

    public static int recursiveFibonacci(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("n must be a non-negative integer.");
        } else if (n == 0 || n == 1) {
            return n;
        } else {
            return recursiveFibonacci(n - 1) + recursiveFibonacci(n - 2);
        }
    }

    public static String analyzeTimeComplexity(int n) {
        String nonRecursiveTimeComplexity = "O(n)";
        String recursiveTimeComplexity = "O(2^n)";
        return "Non-recursive Fibonacci function time complexity: " + nonRecursiveTimeComplexity + "\n"
                + "Recursive Fibonacci function time complexity: " + recursiveTimeComplexity;
    }

    public static String analyzeSpaceComplexity(int n) {
        String nonRecursiveSpaceComplexity = "O(1)";
        String recursiveSpaceComplexity = "O(n)";
        return "Non-recursive Fibonacci function space complexity: " + nonRecursiveSpaceComplexity + "\n"
                + "Recursive Fibonacci function space complexity: " + recursiveSpaceComplexity;
    }

    public static void main(String[] args) {
        System.out.println("Non-recursive Fibonacci numbers:");
        for (int i = 0; i < 10; i++) {
            System.out.println(nonRecursiveFibonacci(i));
        }

        System.out.println("\nRecursive Fibonacci numbers:");
        for (int i = 0; i < 10; i++) {
            System.out.println(recursiveFibonacci(i));
        }

        System.out.println("\nTime complexity analysis:");
        System.out.println(analyzeTimeComplexity(10));

        System.out.println("\nSpace complexity analysis:");
        System.out.println(analyzeSpaceComplexity(10));
    }
}
