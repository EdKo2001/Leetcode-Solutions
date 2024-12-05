class SeatManager {
    private PriorityQueue<Integer> minHeap; // Manages available seats in ascending order
    private Set<Integer> reservedSeats; // Tracks currently reserved seats

    public SeatManager(int n) {
        minHeap = new PriorityQueue<>();
        reservedSeats = new HashSet<>();
        for (int i = 1; i <= n; i++) {
            minHeap.offer(i);
        }
    }

    public int reserve() {
        if (minHeap.isEmpty()) {
            throw new IllegalStateException("No available seats to reserve.");
        }
        int seat = minHeap.poll();
        reservedSeats.add(seat);
        return seat;
    }

    public void unreserve(int seatNumber) {
        if (!reservedSeats.contains(seatNumber)) {
            throw new IllegalArgumentException("Seat " + seatNumber + " is not currently reserved.");
        }
        reservedSeats.remove(seatNumber);
        minHeap.offer(seatNumber);
    }
}

/**
 * Usage example:
 * SeatManager obj = new SeatManager(n);
 * int seat = obj.reserve(); // Reserves and returns the smallest available seat
 * obj.unreserve(seatNumber); // Unreserves the specified seat number
 */
