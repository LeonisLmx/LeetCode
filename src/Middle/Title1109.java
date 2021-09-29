package Middle;

/**
 * @Author: Urey
 * @Date: 2021/8/31
 */
public class Title1109 {

    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] arr = new int[n];
        for (int i = 0;i < bookings.length;i++){
            int count = bookings[i][2];
            int start = bookings[i][0] - 1;
            int end = bookings[i][1] - 1;
            for (int j = start;j <= end;j++){
                arr[j] = arr[j] + count;
            }
        }
        return arr;
    }
}
