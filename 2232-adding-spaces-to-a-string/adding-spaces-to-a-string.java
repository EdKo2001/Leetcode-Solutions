class Solution {
    public String addSpaces(String s, int[] spaces) {
        StringBuilder str = new StringBuilder();

        int spaceIndex = 0;
        for (int i = 0; i < s.length(); i++) {
            if (spaceIndex < spaces.length && i == spaces[spaceIndex]) {
                str.append(" ");
                spaceIndex++;
            }
            str.append(s.charAt(i));
        }

        return str.toString();
    }
}