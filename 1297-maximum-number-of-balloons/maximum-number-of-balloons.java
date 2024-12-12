class Solution {
    public int maxNumberOfBalloons(String text) {
        HashMap<Character, Integer> dic = new HashMap<>();
        dic.put('b', 0);
        dic.put('a', 0);
        dic.put('l', 0);
        dic.put('o', 0);
        dic.put('n', 0);

        for (char ch : text.toCharArray()) {
            dic.put(ch, dic.getOrDefault(ch, 0) + 1);
        }

        int minBalloonCharCount = Integer.MAX_VALUE;
        for (char ch : dic.keySet()) {
            if (ch == 'b' || ch == 'a' || ch == 'l' || ch == 'o' || ch == 'n') {
                minBalloonCharCount = Math.min(minBalloonCharCount, (ch == 'l' || ch == 'o') ? dic.get(ch) / 2 : dic.get(ch));
            }
        }
        return minBalloonCharCount;
    }
}