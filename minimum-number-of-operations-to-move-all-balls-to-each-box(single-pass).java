// https://leetcode.com/problems/minimum-number-of-operations-to-move-all-balls-to-each-box
class Solution {
    public int[] minOperations(String boxes) {
        int n = boxes.length();
        int[] answer = new int[n];
        
        int ballsToLeft = 0;
        int movesFromLeft = 0;

        for(int i = 0; i < n; i++) {
            answer[i] += movesFromLeft;

            if(boxes.charAt(i) == '1') {
                ballsToLeft++;
            }
            movesFromLeft += ballsToLeft;
        }

        int ballsToRight = 0;
        int movesFromRight = 0;

        for(int i = n - 1; i >= 0; i--) {
            answer[i] += movesFromRight;

            if(boxes.charAt(i) == '1') {
                ballsToRight++;
            }
            movesFromRight += ballsToRight;
        }

        
        return answer;
    }
}
