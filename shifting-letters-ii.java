// https://leetcode.com/problems/shifting-letters-ii

class Solution {
    public String shiftingLetters(String s, int[][] shifts) {
        int n = s.length();
        int[] shiftAmount = new int[n];
        
        for(int[] shift: shifts) {
            int startIndex = shift[0];
            int endIndex = shift[1];
            int direction = shift[2];
            
            if(direction == 1) {
                shiftAmount[startIndex] += 1;
                if(endIndex + 1 < n) {
                    shiftAmount[endIndex + 1] -= 1;
                }
            } else if(direction == 0) {
                shiftAmount[startIndex] -= 1;
                if(endIndex + 1 < n) {
                    shiftAmount[endIndex + 1] += 1;
                }
            }
        }

        int numberOfShifts = 0;
        char[] chars = s.toCharArray();

        for(int i = 0; i < n; i++) {
            numberOfShifts = (numberOfShifts + shiftAmount[i]) % 26;

            if (numberOfShifts < 0) numberOfShifts += 26;

            char shiftedChar = (char) ('a' +
                ((s.charAt(i) - 'a' + numberOfShifts) % 26));
                
            chars[i] = shiftedChar;
        }

        return new String(chars);
    }
}
