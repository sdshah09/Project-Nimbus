public class Fibonacci {

    // Recursive approach with memoization
    public int fibRecursive(int n) {
        int[] dp = new int[n + 1];
        // Initialize the dp array with -1 to signify uncomputed values
        for (int i = 0; i <= n; i++) {
            dp[i] = -1;
        }
        return recurse(n, dp);
    }

    private int recurse(int n, int[] dp) {
        if (dp[n] != -1) {
            return dp[n];
        }
        if (n == 0) {
            dp[n] = 0;
        } else if (n == 1) {
            dp[n] = 1;
        } else {
            dp[n] = recurse(n - 1, dp) + recurse(n - 2, dp);
        }
        return dp[n];
    }

    // Iterative dynamic programming approach
    public int fibIterative(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    public static void main(String[] args) {
        Fibonacci solution = new Fibonacci();

        // Example usage
        int n = 10; // Example value

        System.out.println("Fibonacci number (Recursive): " + solution.fibRecursive(n));
        System.out.println("Fibonacci number (Iterative): " + solution.fibIterative(n));
    }
}
