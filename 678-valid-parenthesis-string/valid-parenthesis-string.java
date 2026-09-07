class Solution {
    public boolean checkValidString(String s) {
        int minOpen = 0;
        int maxOpen = 0;

        for (char c : s.toCharArray()) {
            if (c == '(') {
                minOpen++;
                maxOpen++;
            } else if (c == ')') {
                minOpen--;
                maxOpen--;
            } else { // c == '*'
                minOpen--; // Treat '*' as ')'
                maxOpen++; // Treat '*' as '('
            }

            // If maxOpen drops below 0, there are too many ')'
            if (maxOpen < 0) {
                return false;
            }

            // minOpen cannot be negative (we can't have fewer than 0 open brackets)
            if (minOpen < 0) {
                minOpen = 0;
            }
        }

        // String is valid if we can achieve 0 open brackets at the end
        return minOpen == 0;
    }
}