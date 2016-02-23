import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Quick;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;

/**
 * Created by before30 on 2016. 2. 23..
 */
public class Main2 {
    public static void main(String[] args) {
        In in = new In("collinear/input10.txt");
        int N = in.readInt();
        Point[] points = new Point[N];

        StdDraw.setXscale(0, 32768);
        StdDraw.setYscale(0, 32768);

        for (int j = 0; j < N; j++) {
            int x = in.readInt();
            int y = in.readInt();
            Point point = new Point(x, y);
            points[j] = point;
            point.draw();
        }

        Quick.sort(points);

        for (int p = 0; p < N; p++) {
            for (int q = p+1; q < N; q++) {
                for (int r = q+1; r < N; r++) {
                    for (int s = r+1; s < N; s++) {
                        if (points[p].slopeTo(points[q]) == points[p].slopeTo(points[r]) && points[p].slopeTo(points[q]) == points[p].slopeTo(points[s])) {
                            StdOut.println(points[p].toString() + " -> " + points[q].toString() + " -> " + points[r].toString() + " -> " +points[s].toString());
                            points[p].drawTo(points[s]);
                        }
                    }
                }
            }
        }
    }
}
