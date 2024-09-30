class CustomStack {
    int[] stack;
    int length;
    int idx = 0;

    public CustomStack(int maxSize) {
        stack = new int[maxSize];
        length = maxSize;
    }

    public void push(int x) {
        if (idx < length) {
            stack[idx++] = x;
        }
    }

    public int pop() {
        if (idx == 0) {
            return -1;
        }

        int tmp = stack[--idx];
        stack[idx] = 0;

        return tmp;
    }

    public void increment(int k, int val) {
        int limit = Math.min(k, idx);

        for (int i = 0; i < limit; i++) {
            stack[i] += val;
        }
    }
}

/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k,val);
 */