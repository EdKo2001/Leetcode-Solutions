class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int[] res = new int[2];
        HashSet<Integer> seen = new HashSet<>();
        int n = grid.length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int num = grid[i][j];
                if (seen.contains(num))
                    res[0] = num;
                else
                    seen.add(num);
            }
        }

        for (int i = 1; i <= n * n; i++) {
            if (!seen.contains(i)) {
                res[1] = i;
            }
        }

        return res;
    }
}