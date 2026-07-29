class Solution {
    public String minWindow(String s, String t) {
        if(s.length()<t.length()) return "";
        HashMap<Character, Integer> freq=new HashMap<>();
        for(char ch:t.toCharArray() ){
            freq.put(ch,freq.getOrDefault(ch,0)+1);
        }
        int left=0, count=t.length(), minLen=Integer.MAX_VALUE, start=0;
        for(int right=0;right<s.length();right++){
            char ch=s.charAt(right);
            if(freq.containsKey(ch)){
                if(freq.get(ch)>0){
                    count--;
                }
                freq.put(ch,freq.get(ch)-1);
            }
            while(count==0){
                if(right-left+1<minLen){
                    minLen=right-left+1;
                    start=left;
                }
                char leftChar=s.charAt(left);
                if(freq.containsKey(leftChar)){
                    freq.put(leftChar,freq.get(leftChar)+1);
                    if(freq.get(leftChar)>0){
                        count++;
                    }
                }
                left++;
            }
        }
        return minLen==Integer.MAX_VALUE ? "" : s.substring(start,start+minLen);
    }
}