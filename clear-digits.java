// https://leetcode.com/problems/clear-digits/

class Solution {
    public String clearDigits(String s) {
        int index = 0;

        StringBuilder result = new StringBuilder(s);

        while (index < result.length()) {
            if (Character.isDigit(result.charAt(index))) {
                result.deleteCharAt(index);
                if (index > 0) {
                    result.deleteCharAt(index - 1);
                    index--;
                }
            } else {
                index++;
            }
        }
        return result.toString();
    }
}
