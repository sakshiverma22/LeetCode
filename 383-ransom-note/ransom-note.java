class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        // int[] freq=new int[26];
        // //count letters in magazine
        // for(char ch:magazine.toCharArray()){
        //     freq[ch-'a']++;
        // }
        // //use letters for ransomNote
        // for(char ch:ransomNote.toCharArray()){
        //     freq[ch-'a']--;
        //     if(freq[ch-'a']<0) return false;
        // }
        // return true;
        HashMap<Character, Integer> map=new HashMap<>();
        //count fre of chars in magazine
        for(char ch: magazine.toCharArray()){
            map.put(ch, map.getOrDefault(ch,0)+1);
        }
        //try to construct ransomNote
        for(char ch:ransomNote.toCharArray()){
            if(!map.containsKey(ch) || map.get(ch)==0){
                return false;
            }
            map.put(ch,map.get(ch)-1);
        }
        return true;
    }
}