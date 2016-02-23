import edu.princeton.cs.algs4.Quick;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by before30 on 2016. 2. 11..
 */
public class BruteCollinearPoints {
    private Point[] points;
    private List<LineSegment> list;

    // finds all line segments containing 4 points
    public BruteCollinearPoints(Point[] points) {
        list = new ArrayList<>();
        Quick.sort(points);
        this.points = points;

        for (int p = 0; p < points.length; p++) {
            for (int q = p+1; q < points.length; q++) {
                for (int r = q+1; r < points.length; r++) {
                    for (int s = r+1; s < points.length; s++) {
                        if (points[p].slopeTo(points[q]) == points[p].slopeTo(points[r]) && points[p].slopeTo(points[q]) == points[p].slopeTo(points[s])) {
                            LineSegment lineSegment = new LineSegment(points[p], points[s]);
                            list.add(lineSegment);
                        }
                    }
                }
            }
        }
    }

    // the number of line segments
    public int numberOfSegments() {
        return list.size();
    }

    // the line segments
    public LineSegment[] segments() {
        LineSegment[] segments = new LineSegment[this.numberOfSegments()];
        for (int i=0; i<this.numberOfSegments(); i++) {
            segments[i] = list.get(i);
        }
        return segments;
    }
}
