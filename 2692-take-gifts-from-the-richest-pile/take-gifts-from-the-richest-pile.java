class Solution {
    public long pickGifts(int[] gifts, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
        for (int gift : gifts) {
            maxHeap.offer(gift);
        }
        for (int i = 0; i < k; i++) {
            maxHeap.offer((int) Math.sqrt(maxHeap.poll()));
        }
        long cnt = 0;
        for (int num : maxHeap) {
            cnt += num;
        }
        return cnt;
    }
}