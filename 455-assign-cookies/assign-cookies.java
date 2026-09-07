class Solution {
    public int findContentChildren(int[] g, int[] s) {
        int count=0;
        int i=0;
        int j=0;
        int n=g.length, m=s.length;
        Arrays.sort(g);
        Arrays.sort(s);
        while(i<n && j<m){
            if(g[i]<=s[j]){
                count++;
                i++;
                j++;
            }else{
                j++;
            }
        }
        return count;
    }
}