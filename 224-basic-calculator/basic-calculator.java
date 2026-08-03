class Solution {
    public int calculate(String s) {
        Stack<Integer> stack=new Stack<>();
        int result=0;
        int num=0;
        int sign=1;
        for(char ch:s.toCharArray()){
            if(Character.isDigit(ch)){
                num=num*10+(ch-'0');
            }else if(ch=='+'){
                result+=sign*num;
                num=0;
                sign=1;
            }else if(ch=='-'){
                result+=sign*num;
                num=0;
                sign=-1;
            }else if(ch=='('){
                stack.push(result);
                stack.push(sign);
                result=0;
                sign=1;
            }else if(ch==')'){
                result+=sign*num;
                num=0;
                int prevSign=stack.pop();
                int prevResult=stack.pop();
                result=prevResult+prevSign*result;
            }
        }
        result+=sign*num;
        return result;
    }
}