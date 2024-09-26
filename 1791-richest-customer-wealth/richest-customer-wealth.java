class Solution {
    public int maximumWealth(int[][] accounts) {
        int maximumWealth = 0;

        for (int i = 0; i < accounts.length; i++) {
            int customerWealth = 0;
            for (int j = 0; j < accounts[i].length; j++) {
                customerWealth += accounts[i][j];
            }
            maximumWealth = Math.max(customerWealth, maximumWealth);
        }

        return maximumWealth;
    }
}