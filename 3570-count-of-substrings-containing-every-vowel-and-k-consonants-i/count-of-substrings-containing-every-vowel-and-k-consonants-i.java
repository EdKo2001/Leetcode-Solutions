class Solution {
    public int countOfSubstrings(String word, int k) {
        int cnt = 0;
        HashMap<Character, Integer> vowelsMap = new HashMap<>();

        int left = 0;
        int consonantCount = 0;
        for (int right = 0; right < word.length(); right++) {
            char currentChar = word.charAt(right);

            if (!isVowel(currentChar)) {
                consonantCount++;
            } else {
                vowelsMap.put(currentChar, vowelsMap.getOrDefault(currentChar, 0) + 1);
            }

            while (consonantCount > k) {
                char leftChar = word.charAt(left);
                if (!isVowel(leftChar)) {
                    consonantCount--;
                } else {
                    int curVowelCount = vowelsMap.get(leftChar);
                    if (curVowelCount == 1) {
                        vowelsMap.remove(leftChar);
                    } else {
                        vowelsMap.put(leftChar, curVowelCount - 1);
                    }
                }

                left++;
            }

            if (vowelsMap.size() == 5 && consonantCount == k) {
                cnt++;
                int tempLeft = left;
                int tempConsonantCount = consonantCount;
                HashMap<Character, Integer> tempVowelsMap = new HashMap<>(vowelsMap);
                boolean isFirstLoop = true;
                while (tempVowelsMap.size() == 5 && tempConsonantCount == k && tempLeft < right) {
                    if (!isFirstLoop) {
                        cnt++;
                    }
                    isFirstLoop = false;
                    char leftChar = word.charAt(tempLeft);
                    if (!isVowel(leftChar)) {
                        tempConsonantCount--;
                    } else {
                        int curVowelCount = tempVowelsMap.get(leftChar);
                        if (curVowelCount == 1) {
                            tempVowelsMap.remove(leftChar);
                        } else {
                            tempVowelsMap.put(leftChar, curVowelCount - 1);
                        }
                    }
                    tempLeft++;
                }
            }

        }

        return cnt;
    }

    private boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}