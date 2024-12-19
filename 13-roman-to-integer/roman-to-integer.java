class Solution {
    public int romanToInt(String s) {
        int ans = 0;

        HashMap<Character, Integer> dic = new HashMap<>();
        dic.put('I', 1);
        dic.put('V', 5);
        dic.put('X', 10);
        dic.put('L', 50);
        dic.put('C', 100);
        dic.put('D', 500);
        dic.put('M', 1000);

        for (int i = 0; i < s.length(); i++) {
            char numeral = s.charAt(i);

            if (i < s.length() - 1 && numeral == 'I' && s.charAt(i + 1) == 'V') {
                ans += 4;
                i++;
            } else if (i < s.length() - 1 && numeral == 'I' && s.charAt(i + 1) == 'X') {
                ans += 9;
                i++;
            } else if (i < s.length() - 1 && numeral == 'X' && s.charAt(i + 1) == 'L') {
                ans += 40;
                i++;
            } else if (i < s.length() - 1 && numeral == 'X' && s.charAt(i + 1) == 'C') {
                ans += 90;
                i++;
            } else if (i < s.length() - 1 && numeral == 'C' && s.charAt(i + 1) == 'D') {
                ans += 400;
                i++;
            } else if (i < s.length() - 1 && numeral == 'C' && s.charAt(i + 1) == 'M') {
                ans += 900;
                i++;
            } else {
                ans += dic.get(numeral);
            }
        }

        return ans;
    }
}