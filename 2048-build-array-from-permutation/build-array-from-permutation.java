class Solution {
    public int[] buildArray(int[] nums) {
        int n=nums.length;
        int[] ans=new int[n];
        int j=0;
        for(int i=0;i<n;i++){
            j=nums[i];
            ans[i]=nums[j];
        }
        return ans;
    }
}