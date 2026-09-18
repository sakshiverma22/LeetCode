class Solution {
    public int maxDepth(String s) {
        int open=0;
        int max=0;
        for(char c:s.toCharArray()){
            if(c=='('){
                open++;
                max=Math.max(open,max);
            }else if(c==')'){
                open--;
            }else{
                continue;
            }
        }
        return max;
    }
}