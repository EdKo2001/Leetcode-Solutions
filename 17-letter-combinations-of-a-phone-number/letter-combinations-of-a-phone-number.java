public class Solution {
    // In terms of time complexity, generating all combinations inherently involves
    // visiting all possible letter combinations, which is O(3n) for
    // digits like "abc", and O(4n) for digits like "pqrs", where \U0001d45b n
    // is the length of the digits.
    // // Iterative
    // public List<String> letterCombinations(String digits) {
    // List<String> ans = new ArrayList<>();
    // if (digits == null || digits.length() == 0) {
    // return ans; // Return an empty list if input is null or empty
    // }

    // String[] mapping = {
    // "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"
    // };

    // // Initialize the answer list with an empty string to build from
    // ans.add("");

    // // Loop through each digit in the input
    // for (int i = 0; i < digits.length(); i++) {
    // char digit = digits.charAt(i);
    // String letters = mapping[digit - '0']; // Get the corresponding letters

    // List<String> tempList = new ArrayList<>();
    // // Combine existing combinations with the new letters
    // for (String combination : ans) {
    // for (char letter : letters.toCharArray()) {
    // tempList.add(combination + letter);
    // }
    // }
    // ans = tempList; // Update the result list
    // }

    // return ans;
    // }

    // Recursive
    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        if (digits == null || digits.length() == 0)
            return ans; // Return an empty list if the input is null or empty

        String[] mapping = { // Mapping digits to corresponding letters
                "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"
        };

        f(digits, "", ans, mapping, 0); // Start the recursive function
        return ans; // Return the result after all combinations are generated
    }

    // Recursive helper function
    private List<String> f(String digits, String current, List<String> ans, String[] mapping, int index) {
        if (index == digits.length()) { // Base case: if we've processed all digits
            ans.add(current); // Add the formed combination to the result
            return ans;
        }

        // Convert current digit to an integer and retrieve its corresponding letters
        String letters = mapping[digits.charAt(index) - '0'];

        // Loop over the possible letters and recurse
        for (int i = 0; i < letters.length(); i++) {
            f(digits, current + letters.charAt(i), ans, mapping, index + 1); // Recurse with the next letter and digit
        }
        return ans;
    }
}
