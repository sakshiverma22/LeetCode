class Solution {
    public int majorityElement(int[] nums) {

        int cnt = 0;
        int el = 0;

        // Moore's Voting Algorithm
        for(int i = 0; i < nums.length; i++) {
            if(cnt == 0) {
                el = nums[i];
                cnt = 1;
            }
            else if(nums[i] == el) {
                cnt++;
            }
            else {
                cnt--;
            }
        }

        // Verification (optional for LeetCode 169)
        int cnt1 = 0;

        for(int num : nums) {
            if(num == el)
                cnt1++;
        }

        if(cnt1 > nums.length / 2)
            return el;

        return -1;
    }
}