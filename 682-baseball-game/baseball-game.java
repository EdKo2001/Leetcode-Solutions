class Solution {
    public int calPoints(String[] operations) {
        Stack<Integer> stack = new Stack<>();

        for (String operation : operations) {
            switch (operation) {
                case "+":
                    if (stack.size() >= 2) {
                        int one = stack.peek();
                        int two = stack.get(stack.size() - 2);
                        stack.push(one + two);
                    } else {
                        throw new IllegalStateException("Not enough elements for '+' operation.");
                    }
                    break;

                case "D":
                    if (!stack.isEmpty()) {
                        stack.push(stack.peek() * 2);
                    } else {
                        throw new IllegalStateException("No elements to double for 'D' operation.");
                    }
                    break;

                case "C":
                    if (!stack.isEmpty()) {
                        stack.pop();
                    } else {
                        throw new IllegalStateException("No elements to remove for 'C' operation.");
                    }
                    break;

                default:
                    try {
                        stack.push(Integer.parseInt(operation));
                    } catch (NumberFormatException e) {
                        throw new IllegalArgumentException("Invalid operation: " + operation, e);
                    }
                    break;
            }
        }

        int totalScore = 0;
        for (int score : stack) {
            totalScore += score;
        }
        return totalScore;
    }
}
