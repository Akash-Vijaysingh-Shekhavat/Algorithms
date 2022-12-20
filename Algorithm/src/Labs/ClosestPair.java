//To find the closest point in 1D array using divide and conquer
package Labs;
import java.util.Arrays;
import java.util.Scanner;

public class ClosestPair {
    public static double findClosestPairDistance(double[] points) {
        // base case: if there are less than two points, return Double.MAX_VALUE
        if (points.length < 2) {
            return Double.MAX_VALUE;
        }

        // base case: if there are only two points, return the distance between them
        if (points.length == 2) {
            return Math.abs(points[0] - points[1]);
        }

        // divide the points into two halves
        int mid = points.length / 2;
        double[] left = Arrays.copyOfRange(points, 0, mid);
        double[] right = Arrays.copyOfRange(points, mid, points.length);

        // find the minimum distance in the left and right halves
        double minDistanceLeft = findClosestPairDistance(left);
        double minDistanceRight = findClosestPairDistance(right);

        // find the minimum distance between a point in the left half and a point in the right half
        double minDistanceAcross = Double.MAX_VALUE;
        for (int i = 0; i < left.length; i++) {
            for (int j = 0; j < right.length; j++) {
                minDistanceAcross = Math.min(minDistanceAcross, Math.abs(left[i] - right[j]));
            }
        }

        // return the minimum of the three distances
        return Math.min(minDistanceLeft, Math.min(minDistanceRight, minDistanceAcross));
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the number of the points");
        int n= in.nextInt();
        double[] points = new double[n];
        System.out.println("Enter the array point ");
        for(int i=0;i<n;i++){
            points[i] = in.nextDouble();
        }
        Arrays.sort(points);
        double minDistance = findClosestPairDistance(points);
        System.out.println(minDistance);
    }

}


//Enter the number of points: 5
//Enter the points: 1.5 3.7 4.2 6.1 7.3
//Sorted points: 1.5 3.7 4.2 6.1 7.3
//Minimum distance: 0.5
//In this example, the user enters the number of points as
// 5 and the points themselves as 1.5 3.7 4.2 6.1 7.3.
// The program sorts the points in ascending order, resulting
// in the sorted points 1.5 3.7 4.2 6.1 7.3.
//
//Next, the program calls the findClosestPairDistance method to
// find the minimum distance between the points.
// The findClosestPairDistance method divides the points into
// two halves: 1.5 3.7 and 4.2 6.1 7.3. It then finds the minimum
// distance between points in the left half (0.2), the right half
// (1.9), and across the two halves (0.5). The minimum of these
// three distances is 0.5, which is returned by the method and
// printed to the console by the main program.
//
//In this case, the minimum distance is between the points 3.7
// and 4.2, which are 0.5 units apart.
