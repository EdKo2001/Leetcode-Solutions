class Solution {
    public int findChampion(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            int strongerThan = 0;
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1)
                    strongerThan++;
            }
            if (strongerThan > grid.length - 2)
                return i;
        }

        return -1;
    }
}