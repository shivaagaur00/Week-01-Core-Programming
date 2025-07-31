public class CircularBuffer {
    int[] buffer;
    int size, start = 0, count = 0;

    CircularBuffer(int size) {
        this.size = size;
        buffer = new int[size];
    }

    void insert(int val) {
        buffer[(start + count) % size] = val;
        if (count == size) {
            start = (start + 1) % size;
        } else {
            count++;
        }
    }

    void printBuffer() {
        for (int i = 0; i < count; i++) {
            System.out.print(buffer[(start + i) % size] + " ");
        }
    }

    public static void main(String[] args) {
        CircularBuffer cb = new CircularBuffer(3);
        cb.insert(1);
        cb.insert(2);
        cb.insert(3);
        cb.insert(4);
        cb.printBuffer();
    }
}