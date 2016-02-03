/**
 * Created by before30 on 2016. 2. 3..
 */

public class Percolation {
    public enum Stats {
        BLOCKED(0),
        EMPTYOPENED(1),
        FULLOPENED(2);

        private int type;
        Stats(int type) {
            this.type = type;
        }

        public int getType() {
            return type;
        }
    }

    private int n;

    // create N-by-N grid, with all sites blocked
    public Percolation(int N) {
        this.n = N;
    }

    // open site (row i, column j) if it is not open already
    public void open(int i, int j) {

    }

    // is site (row i, column j) open?
    public boolean isOpen(int i, int j) {
        return false;
    }

    // is site (row i, column j) full?
    public boolean isFull(int i, int j) {
        return false;
    }

    // does the system percolate?
    public boolean percolates() {
        return false;
    }

    // test client (optional)
    public static void main(String[] args) {

    }

}
