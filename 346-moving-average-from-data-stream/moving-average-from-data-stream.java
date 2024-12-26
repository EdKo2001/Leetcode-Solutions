class MovingAverage {
    int size, head = 0, windowSum = 0, count = 0;
    int[] queue;

    public MovingAverage(int size) {
        this.size = size;
        queue = new int[size];
    }

    public double next(int val) {
        count++;
        int tail = (head + 1) % size;
        windowSum = windowSum - queue[tail] + val;
        head = (head + 1) % size;
        queue[head] = val;
        return windowSum * 1.0 / Math.min(size, count);
    }
}