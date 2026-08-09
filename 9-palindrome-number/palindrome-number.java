class Solution {
    public boolean isPalindrome(int x) {
        if(x<0) return false;
        int temp=x;
        int revSum=0;
        while(x>0){
            int rem=x%10;
            revSum=revSum*10+rem;
            x/=10;
        }
        if(revSum==temp) return true;
        else return false;
    }
}