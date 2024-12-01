class Solution {
    public int maximum69Number(int num) {
        int ans = 0;

        boolean isChanged = false;
        for (char ch : Integer.toString(num).toCharArray()) {
            if (ch - '0' == 6 && !isChanged) {
                isChanged = true;
                ans = ans * 10 + 9;
            } else {
                ans = ans * 10 + ch - '0';
            }

        }

        return ans;
    }
}