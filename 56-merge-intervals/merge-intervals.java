class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        int[][] res = new int[intervals.length][2];

        int start = intervals[0][0];
        int end = intervals[0][1];

        int resIdx = 0;
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] <= end) {
                end = Math.max(end, intervals[i][1]);
            } else {
                res[resIdx][0] = start;
                res[resIdx++][1] = end;
                start = intervals[i][0];
                end = intervals[i][1];
            }
        }

        res[resIdx][0] = start;
        res[resIdx++][1] = end;

        int[][] ans = new int[resIdx][2];
        for (int i = 0; i < resIdx; i++) {
            ans[i][0] = res[i][0];
            ans[i][1] = res[i][1];
        }

        return ans;
    }
}