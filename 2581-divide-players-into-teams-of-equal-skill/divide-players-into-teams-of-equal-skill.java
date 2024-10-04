class Solution {
    public long dividePlayers(int[] skill) {
        Arrays.sort(skill);
        int n = skill.length;
        int skillBalance = skill[0] + skill[n - 1];

        long sum = 0;
        for (int i = 0; i < n / 2; i++) {
            int pairSum = skill[i] + skill[n - i - 1];
            if (pairSum != skillBalance) {
                return -1;
            }
            sum += (long) skill[i] * skill[n - i - 1];
        }

        return sum;
    }
}
