import edu.princeton.cs.algs4.WeightedQuickUnionUF;

//import java.util.*;

/**
 * Created by before30 on 2016. 2. 3..
 */

public class Percolation {
    private boolean[] sites;
    private int n;
    private WeightedQuickUnionUF qu;
    private final int[] mx = { -1, 0, 1, 0 };
    private final int[] my = { 0, -1, 0, 1 };

    // create N-by-N grid, with all sites blocked
    public Percolation(int N) {
        this.n = N;
        this.sites = initSites(n);

        qu = initQuickUnionUF(n);
    }

    private WeightedQuickUnionUF initQuickUnionUF(int num) {
        WeightedQuickUnionUF nqu = new WeightedQuickUnionUF((num+2) * num);
        for (int i = 1; i < num; i++) {
            nqu.connected(0, i);
            nqu.connected((num+1)*num, (num+1)*num + i);
        }

        return nqu;
    }

    private boolean[] initSites(int num) {
        boolean[] s = new boolean[n*n];

        for (int i = 0; i < num; i++) {
            for (int j = 0; j < num; j++) {
                s[i*num + j] = false;
            }
        }
        return s;
    }

    private boolean isOpenSite(int i, int j) {
        return sites[i*n + j];
    }

    private int convertWeightedQuickUnionPoint(int i, int j) {
        return (i + 1)*n + j;
    }

    // open site (row i, column j) if it is not open already
    public void open(int i, int j) {
        if (i < 1 || j < 1 || i > n || j > n) {
            throw new IndexOutOfBoundsException();
        }

        int ni = i - 1;
        int nj = j - 1;

        if (!sites[ni * n + nj]) {
            sites[ni * n + nj] = true;

            for (int mv = 0; mv < 4; mv++) {
                int ti = ni + mx[mv];
                int tj = nj + my[mv];
                if (ti >= 0 && tj >= 0 && ti < n && tj < n && sites[ti * n + tj]) {
                    // something connected...

                    qu.union(convertWeightedQuickUnionPoint(ni, nj), convertWeightedQuickUnionPoint(ti, tj));
                }
            }

            if (i == 1) {
                qu.union(0, convertWeightedQuickUnionPoint(ni, nj));
            }

            if (i == n) {
                qu.union((n+2) * n -1, convertWeightedQuickUnionPoint(ni, nj));
            }
        }
    }

    // is site (row i, column j) open?
    public boolean isOpen(int i, int j) {
        if (i < 1 || j < 1 || i > n || j > n) {
            throw new IndexOutOfBoundsException();
        }
        int ni = i - 1;
        int nj = j - 1;

        return isOpenSite(ni, nj);
    }

    // is site (row i, column j) full?
    public boolean isFull(int i, int j) {
        if (i < 1 || j < 1 || i > n || j > n) {
            throw new IndexOutOfBoundsException();
        }
        int ni = i - 1;
        int nj = j - 1;

        return isOpen(i, j) && qu.connected(convertWeightedQuickUnionPoint(ni, nj), 0);
    }

    // does the system percolate?
    public boolean percolates() {
        return qu.connected(0, (n+2)*n - 1);
    }

    // test client (optional)
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        File file = new File(sc.next());
//        try {
//
//            FileReader reader = new FileReader(file);
//            Scanner sc2 = new Scanner(reader);
//            int n = sc2.nextInt();
//            Percolation p = new Percolation(n);
//            while(true) {
//                try {
//                    int i = sc2.nextInt();
//                    int j = sc2.nextInt();
//                    p.open(i, j);
//                }catch (NoSuchElementException ex) {
//                    break;
//                }
//            }
//
//            System.out.println(p.percolates());
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//    }

}
