class Solution {
    public List<List<Integer>> findWinners(int[][] matches) {
        HashMap<Integer, Integer> playersStats = new HashMap<>();

        for (int[] match : matches) {
            int winner = match[0];
            int loser = match[1];
            playersStats.put(winner, playersStats.getOrDefault(winner, 0));
            playersStats.put(loser, playersStats.getOrDefault(loser, 0) - 1);
        }

        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());
        res.add(new ArrayList<>());

        for (int player : playersStats.keySet()) {
            int losses = playersStats.get(player);
            if (losses == 0) {
                res.get(0).add(player);
            } else if (losses == -1) {
                res.get(1).add(player);
            }
        }

        res.get(0).sort((a, b) -> a - b);
        res.get(1).sort((a, b) -> a - b);

        return res;
    }
}