class Solution {
    public int secondHighest(String s) {
        int largest=-1;
        int seclargest=-1;
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(Character.isDigit(ch)){
                int dig=ch-'0';
                if(dig>largest){
                    seclargest=largest;
                    largest=dig;
                }
                else if(dig<largest && dig>seclargest){
                    seclargest=dig;
                }
            }
        }
        return seclargest;
    }
}