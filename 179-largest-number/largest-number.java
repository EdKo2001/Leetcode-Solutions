class Solution {
    public String largestNumber(int[] nums) {
        StringBuilder res = new StringBuilder();
        PriorityQueue<String> maxHeap = new PriorityQueue<>(
                new Comparator<String>() {
                    @Override
                    public int compare(String first, String second) {
                        return (second + first).compareTo(first + second);
                    }
                });

        for (int num : nums) {
            maxHeap.offer(Integer.toString(num));
        }

        while (maxHeap.size() > 0) {
            res.append(maxHeap.poll());
        }

        // Handle edge case where the result might be "000...0"
        return res.charAt(0) == '0' ? "0" : res.toString();
    }
}