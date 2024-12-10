class Solution {
    public int maximumLength(String s) {
        int n = s.length();
        HashMap<String, Integer> substringCount = new HashMap<>();
        int maxLength = -1;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j <= n; j++) {
                String sub = s.substring(i, j);

                if (isSpecial(sub)) {
                    substringCount.put(sub, substringCount.getOrDefault(sub, 0) + 1);

                    if (substringCount.get(sub) >= 3) {
                        maxLength = Math.max(maxLength, sub.length());
                    }
                }
            }
        }

        return maxLength;
    }

    private boolean isSpecial(String str) {
        char firstChar = str.charAt(0);
        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) != firstChar) {
                return false;
            }
        }
        return true;
    }
}
