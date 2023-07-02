package DynamicProgrammingGrids;
import java.util.*;

/*
A Ninja has an ‘N’ Day training schedule. He has to perform one of these three activities
(Running, Fighting Practice, or Learning New Moves) each day. There are merit points associated with
performing an activity each day. The same activity can’t be performed on two consecutive days.
We need to find the maximum merit points the ninja can attain in N Days.

We are given a 2D Array POINTS of size ‘N*3’ which tells us the merit point of specific activity on that
particular day. Our task is to calculate the maximum number of merit points that the ninja can earn.
 */
public class NinjasTraining {
    static int ninjaTraining(int n, int[][] points) {

        int dp[][] = new int[n][4];
        dp[0][0] = Math.max(points[0][1],points[0][2]);
        dp[0][1] = Math.max(points[0][0],points[0][2]);
        dp[0][2] = Math.max(points[0][0],points[0][1]);
        dp[0][3] = Math.max(points[0][0],Math.max(points[0][1],points[0][2]));
        for(int day=1;day<n;day++) {
            for(int last=0;last<4;last++) {
                int maxi = 0;
                for (int i = 0; i <= 2; i++) {
                    if (i != last) {
                        int activity = points[day][i] + dp[day - 1][i];
                        maxi = Math.max(maxi, activity);
                    }
                }
                dp[day][last] = maxi;
            }
        }
        return dp[n-1][3];
    }
    static int ninjaTrainingTopDown(int n, int[][] points) {

        int dp[][] = new int[n][4];
        for (int[] row: dp)
            Arrays.fill(row, -1);

        return f(n - 1, 3, points, dp);
    }

    private static int f(int day, int last, int[][] points, int[][] dp) {
        if(dp[day][last]!=-1) return dp[day][last];
        if(day==0) {
            int maxi = 0;
            for(int i=0;i<=2;i++) {
                if(i!=last) {
                    maxi = Math.max(maxi,points[0][i]);
                }
            }
            dp[day][last] = maxi;
            return dp[day][last];
        }
        int maxi = 0;
        for(int i=0;i<=2;i++) {
            if(i!=last) {
                int activity = points[day][i] + f(day-1,i,points,dp);
                maxi = Math.max(maxi,activity);
            }
        }
        dp[day][last] = maxi;
        return dp[day][last];
    }

    public static void main(String args[]) {

        int[][] points = {{10,40,70},
                {20,50,80},
                {30,60,90}};


        int n = points.length;
        System.out.println(ninjaTraining(n, points));
    }
}
