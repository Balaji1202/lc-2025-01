// https://leetcode.com/problems/check-if-a-parentheses-string-can-be-valid/

class Solution {
    public boolean canBeValid(String s, String locked) {
        int n = s.length();

        if(n % 2 == 1) return false;

        Stack<Integer> openBrackets = new Stack<>();
        Stack<Integer> unlocked = new Stack<>();

        for(int i = 0; i < n; i++) {
            if(locked.charAt(i) == '0') {
                unlocked.push(i);
            } else if(s.charAt(i) == '(') {
                openBrackets.push(i);
            } else if(s.charAt(i) == ')') {
                if(!openBrackets.empty()) {
                    openBrackets.pop();
                } else if(!unlocked.empty()) {
                    unlocked.pop();
                } else {
                    return false;
                }
            }
        }

        while(!unlocked.empty() && !openBrackets.empty() && openBrackets.peek() < unlocked.peek()) {
            openBrackets.pop();
            unlocked.pop();
        }

        return openBrackets.isEmpty();
    }
}
