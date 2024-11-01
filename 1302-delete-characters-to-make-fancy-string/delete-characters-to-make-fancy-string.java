class Solution {
    public String makeFancyString(String s) {
        StringBuilder str = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            if (i < s.length() - 2 && s.charAt(i) == s.charAt(i + 1) && s.charAt(i + 1) == s.charAt(i + 2))
                continue;
            str.append(s.charAt(i));
        }

        return str.toString();
    }
}
