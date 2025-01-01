class Solution {
    public int maxScore(String s) {
        int max = 0;
        int oneCnt = 0;
        for (char num : s.toCharArray()) {
            if (num - '0' == 1)
                oneCnt++;
        }
        int zeroCnt = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            char num = s.charAt(i);
            if (num - '0' == 0)
                ++zeroCnt;
            else
                --oneCnt;
            max = Math.max(max, zeroCnt + oneCnt);
        }
        return max;
    }
}