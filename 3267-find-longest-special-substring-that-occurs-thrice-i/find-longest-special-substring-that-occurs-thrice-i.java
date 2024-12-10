class Solution {
    // Brute-Force Approach
    // public int maximumLength(String s) {
    //     int n = s.length();
    //     HashMap<String, Integer> substringCount = new HashMap<>();
    //     int maxLength = -1;

    //     for (int i = 0; i < n; i++) {
    //         for (int j = i + 1; j <= n; j++) {
    //             String sub = s.substring(i, j);

    //             if (isSpecial(sub)) {
    //                 substringCount.put(sub, substringCount.getOrDefault(sub, 0) + 1);

    //                 if (substringCount.get(sub) >= 3) {
    //                     maxLength = Math.max(maxLength, sub.length());
    //                 }
    //             }
    //         }
    //     }

    //     return maxLength;
    // }

    // private boolean isSpecial(String str) {
    //     char firstChar = str.charAt(0);
    //     for (int i = 1; i < str.length(); i++) {
    //         if (str.charAt(i) != firstChar) {
    //             return false;
    //         }
    //     }
    //     return true;
    // }

    public int maximumLength(String s) {
        int n = s.length();
        int left = 1, right = n;
        int maxLength = -1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (canFindSpecialSubstring(s, mid)) {
                maxLength = mid;
                left = mid + 1; // Try longer substrings
            } else {
                right = mid - 1; // Try shorter substrings
            }
        }

        return maxLength;
    }

    // Check if there exists a special substring of given length that appears at least 3 times
    private boolean canFindSpecialSubstring(String s, int length) {
        HashMap<String, Integer> substringCount = new HashMap<>();

        for (int i = 0; i <= s.length() - length; i++) {
            String sub = s.substring(i, i + length);
            if (isSpecial(sub)) {
                substringCount.put(sub, substringCount.getOrDefault(sub, 0) + 1);
                if (substringCount.get(sub) >= 3) {
                    return true;
                }
            }
        }

        return false;
    }

    // Check if a string is special (all characters are the same)
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
