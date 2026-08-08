class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int totalSum=0;
        int currmax=nums[0];
        int currmin=nums[0];
        int maxsum=nums[0];
        int minsum=nums[0];
        for(int i=0;i<nums.length;i++){
            totalSum+=nums[i];
            if(i>0){
                currmax=Math.max(nums[i], currmax+nums[i]);
                currmin=Math.min(nums[i],currmin+nums[i]);
                maxsum=Math.max(maxsum,currmax);
                minsum=Math.min(minsum,currmin);
            }
        }
        if(maxsum<0){
                return maxsum;
        }
        return Math.max(maxsum,totalSum-minsum);
    }
}