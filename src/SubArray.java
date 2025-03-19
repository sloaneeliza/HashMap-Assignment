import java.util.*;

public class SubArray {
    public static int[] sumTarget(int[] A, int K) {
        int left = 0, sum = 0;

        for (int right = 0; right < A.length; right++) {
            sum += A[right];

            while (sum > K && left <= right) {
                sum -= A[left];
                left++;
            }

            if (sum == K) {
                return new int[]{left, right};
            }
        }

        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(sumTarget(new int[]{1, 2, 3, 7, 5}, 12))); // [1, 3] or [3, 4]
        System.out.println(Arrays.toString(sumTarget(new int[]{1, 2, 3, 7, 5}, 5)));  // [1, 2] or [4, 4]
        System.out.println(Arrays.toString(sumTarget(new int[]{1, 2, 3, 7, 5}, 7)));  // [3, 3]
        System.out.println(Arrays.toString(sumTarget(new int[]{1, 2, 3, 7, 5}, 11))); // [-1, -1]
    }
}
