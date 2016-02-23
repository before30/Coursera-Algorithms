import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by before30 on 2016. 2. 11..
 */
public class FastCollinearPoints {
    private static final int minCollinearCount = 4;
    private List<LineSegment> list;

    // finds all line segments containing 4 or more points
    public FastCollinearPoints(Point[] points) {
        list = new ArrayList<>();

        for(int i = 0; i < points.length - 1; i++) {

            //Sort the array with respect to one of the points
            Arrays.sort(points, i + 1, points.length, points[i].slopeOrder());

            //Calculate slope between i point and i + 1 to start with
            double currentSlope = points[i].slopeTo(points[i + 1]);
            int consecutiveCount = 1;

            //Move through the rest of the array comparing slopes
            for(int compare = i + 2; compare < points.length; compare++) {

                //When the same, increment the count because points are collinear
                if (points[i].slopeTo(points[compare]) == currentSlope) {
                    consecutiveCount++;

                    //Otherwise, reset the count and set the slope to compare
                } else {
                    currentSlope = points[i].slopeTo(points[compare]);
                    consecutiveCount = 1;
                }

                if (consecutiveCount >= minCollinearCount) {
                    //Continue the search until it changes


                    //Write the output
                    LineSegment lineSegment = new LineSegment(points[i], points[compare]);
                    list.add(lineSegment);


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
