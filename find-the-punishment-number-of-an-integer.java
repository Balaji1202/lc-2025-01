// https://leetcode.com/problems/find-the-punishment-number-of-an-integer/

class Solution {

    public boolean checkPartition(
        int index,
        int currentSum,
        String numString,
        int target,
        int[][] memo
    ) {
        if (index == numString.length()) {
            return currentSum == target;
        }

        if (currentSum > target) return false;

        if (memo[index][currentSum] != -1) return memo[index][currentSum] == 1;

        boolean isValidPartition = false;

        for (int i = index; i < numString.length(); i++) {
            String substring = numString.substring(index, i + 1);
            int value = Integer.parseInt(substring);

            isValidPartition = isValidPartition || checkPartition(i + 1, currentSum + value, numString, target, memo);
            if (isValidPartition) {
                memo[index][currentSum] = 1;
                return true;
            }
        }

        memo[index][currentSum] = 0;
        return false;
    }

    public int punishmentNumber(int limit) {
        int totalPunishmentNumber = 0;
        for (int num = 1; num <= limit; num++) {
            int square = num * num;
            String squareString = Integer.toString(square);

            int[][] memo = new int[squareString.length()][num + 1];
            for (int[] row : memo) {
                java.util.Arrays.fill(row, -1);
            }

            if (checkPartition(0, 0, squareString, num, memo)) {
                totalPunishmentNumber += square;
            }
        }
        return totalPunishmentNumber;
    }
}
