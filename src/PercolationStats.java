import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

/**
 * Created by before30 on 2016. 2. 3..
 */
public class PercolationStats {
    private double mean = 0.0;
    private double std = 0.0;
    private double upperConf = 0.0;
    private double lowerConf = 0.0;
    private double[] res;

    private class Point {
        private int x;
        private int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }
    }

    // perform T independent experiments on an N-by-N grid
    public PercolationStats(int N, int T) {
        if (N <= 0 || T <= 0) {
            throw new java.lang.IllegalArgumentException();
        }


        res = new double[T];
        for (int t = 0; t < T; t++) {
            test(N, t);
        }

        mean = StdStats.mean(res);
        std = StdStats.stddev(res);
        // confidence
        lowerConf = mean - 1.96 * std / Math.sqrt(T + 0.0);
        upperConf = mean + 1.96 * std / Math.sqrt(T + 0.0);

    }

    private void test(int N, int T) {
        /*
        Repeat the following until the system percolates:
        Choose a site (row i, column j) uniformly at random among all blocked sites.
        Open the site (row i, column j).
         */
        Percolation p = new Percolation(N);
        for (int t = 0; t < N*N; t++) {
            Point pt = getRandomPoint(N);
            while (p.isOpen(pt.getX(), pt.getY())) {
                pt = getRandomPoint(N);
            }
            p.open(pt.getX(), pt.getY());
            if (p.percolates()) {
                res[T] = (double) t / (N * N);
                break;
            }
        }

    }

    private Point getRandomPoint(int n) {
        int pt =  StdRandom.uniform(n*n);
        int x = pt / n + 1;
        int y = pt % n + 1;
        return new Point(x, y);
    }

    // sample mean of percolation threshold
    public double mean() {
        return mean;
    }

    // sample standard deviation of percolation threshold
    public double stddev() {
        return std;
    }

    // low  endpoint of 95% confidence interval
    public double confidenceLo() {
        return lowerConf;
    }

    // high endpoint of 95% confidence interval
    public double confidenceHi() {
        return upperConf;
    }

    // test client (described below)
    public static void main(String[] args) { // test client, described below
        PercolationStats ps = new PercolationStats(Integer.parseInt(args[0]),
                Integer.parseInt(args[1]));
        System.out.println("mean                    = " + ps.mean());
        System.out.println("stddev                  = " + ps.stddev());
        System.out.println("95% confidence interval = " + ps.confidenceLo()
                + ", " + ps.confidenceHi());
    }

}
