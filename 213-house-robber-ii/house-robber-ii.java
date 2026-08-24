class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;
        if (n == 1) return nums[0];

        // arr1: houses[1..n-1]  (skip first house)
        // arr2: houses[0..n-2]  (skip last house)
        int[] arr1 = new int[n - 1];
        int[] arr2 = new int[n - 1];

        for (int i = 1; i < n; i++) {
            arr1[i - 1] = nums[i];   // shift index by -1 to fit the smaller array
        }
        for (int i = 0; i < n - 1; i++) {
            arr2[i] = nums[i];       // no shift needed, just stop one early
        }

        return Math.max(solve(arr1), solve(arr2));
    }

    private int solve(int[] arr) {
        int n = arr.length;
        if (n == 0) return 0;
        if (n == 1) return arr[0];

        int prev2 = 0;
        int prev = arr[0];

        for (int i = 1; i < n; i++) {
            int take = arr[i] + prev2;
            int notTake = prev;
            int curr = Math.max(take, notTake);
            prev2 = prev;
            prev = curr;
        }

        return prev;
    }
}