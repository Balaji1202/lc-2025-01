// https://leetcode.com/problems/first-completely-painted-row-or-column

class Solution {
    public int firstCompleteIndex(int[] arr, int[][] mat) {
        int m = mat.length, n = mat[0].length;

        Map<Integer, Pair<Integer, Integer>> matMap = new HashMap<>();

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                matMap.put(mat[i][j], new Pair(i, j));
            }
        }

        int[] rowCount = new int[m];
        int[] colCount = new int[n];

        for(int i = 0; i < arr.length; i++) {
            Pair<Integer, Integer> position = matMap.get(arr[i]);

            int row = position.getKey();
            int col = position.getValue();

            rowCount[row]++;
            colCount[col]++;

            if(rowCount[row] == n || colCount[col] == m) {
                return i;
            }
        }

        return -1;
    }
}
