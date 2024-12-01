class Solution {
    public int maxNumberOfApples(int[] weight) {
        int ans = 0;
        int capacity = 5000;

        Arrays.sort(weight);

        for (int wt : weight) {
            if (capacity < wt)
                break;
            capacity -= wt;
            ans++;
        }

        return ans;
    }
}