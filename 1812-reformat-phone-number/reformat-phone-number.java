class Solution {
    public String reformatNumber(String number) {
        // Replace spaces and dashes
        String formattedNumber = number.replaceAll("[ -]", "");
        StringBuilder ans = new StringBuilder();
        while (formattedNumber.length() > 0) {
            if (formattedNumber.length() > 4) {
                ans.append(formattedNumber.substring(0, 3)).append("-");
                formattedNumber = formattedNumber.substring(3);
            } else if (formattedNumber.length() == 4) {
                ans.append(formattedNumber.substring(0, 2)).append("-").append(formattedNumber.substring(2));
                break;
            } else {
                ans.append(formattedNumber);
                break;
            }
        }
        return ans.toString();
    }
}