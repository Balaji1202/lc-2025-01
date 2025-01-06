// https://leetcode.com/problems/minimum-number-of-operations-to-move-all-balls-to-each-box/
class Solution {
    public int[] minOperations(String boxes) {
        int n = boxes.length();
        int[] answer = new int[n];
        
        for(int i = 0; i < n; i++) {
            for(int j = i - 1; j >= 0; j--) {
                if(boxes.charAt(j) == '1') {
                    answer[i] += Math.abs(i - j);
                }
            }
            for(int j = i + 1; j < n; j++) {
                if(boxes.charAt(j) == '1') {
                    answer[i] += Math.abs(i - j);
                }
            }
        }
        return answer;
    }
}
