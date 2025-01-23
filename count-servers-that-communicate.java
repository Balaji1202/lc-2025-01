// https://leetcode.com/problems/count-servers-that-communicate/

class Solution {
    public int countServers(int[][] grid) {
        int m = grid.length, n = grid[0].length;

        int result = 0;

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == 1) {
                    boolean isAdjacentFound = false;

                    for(int k = 0; k < n; k++) {
                        if(grid[i][k] == 1 && k != j) {
                            result++;
                            isAdjacentFound = true;
                            break;
                        }
                    }

                    if(!isAdjacentFound) {
                        for(int k = 0; k < m; k++) {
                            if(grid[k][j] == 1 && k != i) {
                                result++;
                                break;
                            }
                        }
                    }
                }
            }
        }

        return result;
    }
}
