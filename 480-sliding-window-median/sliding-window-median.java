class Solution {
    // Time Limit Exceeded
    // public double[] medianSlidingWindow(int[] nums, int k) {
    // int n = nums.length;
    // double[] result = new double[n - k + 1];
    // List<Integer> window = new ArrayList<>();

    // for (int i = 0; i < n; i++) {
    // window.add(nums[i]);

    // if (window.size() == k) {
    // Collections.sort(window);
    // result[i - k + 1] = getMedian(window);

    // window.remove((Integer) nums[i - k + 1]);
    // }
    // }

    // return result;
    // }

    // private double getMedian(List<Integer> window) {
    // int size = window.size();
    // if (size % 2 == 1) {
    // // Odd size: return the middle element
    // return window.get(size / 2);
    // } else {
    // // Even size: return the average of the two middle elements
    // return ((double) window.get(size / 2 - 1) + window.get(size / 2)) / 2.0;
    // }
    // }

    public double[] medianSlidingWindow(int[] nums, int k) {
        List<Double> medians = new ArrayList<>();
        Map<Integer, Integer> hash_table = new HashMap<>();
        PriorityQueue<Integer> lo = new PriorityQueue<>(Collections.reverseOrder()); // max heap
        PriorityQueue<Integer> hi = new PriorityQueue<>(); // min heap

        int i = 0; // index of the current incoming element being processed

        // Initialize the heaps
        while (i < k) {
            lo.offer(nums[i++]);
        }
        for (int j = 0; j < k / 2; j++) {
            hi.offer(lo.poll());
        }

        while (true) {
            // Get the median of the current window
            medians.add(k % 2 != 0 ? (double) lo.peek() : ((double) lo.peek() + (double) hi.peek()) * 0.5);

            if (i >= nums.length)
                break; // Break if all elements are processed

            int outNum = nums[i - k]; // Outgoing element
            int inNum = nums[i++]; // Incoming element
            int balance = 0; // Balance factor

            // Number `outNum` exits the window
            balance += (outNum <= lo.peek() ? -1 : 1);
            hash_table.put(outNum, hash_table.getOrDefault(outNum, 0) + 1);

            // Number `inNum` enters the window
            if (!lo.isEmpty() && inNum <= lo.peek()) {
                balance++;
                lo.offer(inNum);
            } else {
                balance--;
                hi.offer(inNum);
            }

            // Rebalance the heaps
            if (balance < 0) { // `lo` needs more valid elements
                lo.offer(hi.poll());
                balance++;
            }
            if (balance > 0) { // `hi` needs more valid elements
                hi.offer(lo.poll());
                balance--;
            }

            // Remove invalid numbers from the tops of the heaps
            while (!lo.isEmpty() && hash_table.getOrDefault(lo.peek(), 0) > 0) {
                hash_table.put(lo.peek(), hash_table.get(lo.peek()) - 1);
                lo.poll();
            }
            while (!hi.isEmpty() && hash_table.getOrDefault(hi.peek(), 0) > 0) {
                hash_table.put(hi.peek(), hash_table.get(hi.peek()) - 1);
                hi.poll();
            }
        }

        // Convert the list of medians to a double array
        double[] result = new double[medians.size()];
        for (int idx = 0; idx < medians.size(); idx++) {
            result[idx] = medians.get(idx);
        }

        return result;
    }
}