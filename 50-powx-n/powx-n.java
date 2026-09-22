class Solution {
    public double myPow(double x, int n) {
        long N = n;
        if (N < 0) {
            x = 1 / x;
            N = -N;
        }

        double ans = 1.0;
        double currentProduct = x;

        while (N > 0) {
            // If N is odd, multiply the current power into the answer
            if ((N % 2) == 1) {
                ans = ans * currentProduct;
            }
            // Square the base and halve the exponent
            currentProduct = currentProduct * currentProduct;
            N /= 2;
        }

        return ans;
    }
}