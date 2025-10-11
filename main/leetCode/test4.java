package leetCode;

public class test4 {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int totalLength = nums1.length + nums2.length;
        double[] total = new double[totalLength];
        int p = 0;
        int q = 0;

        for (int i = 0; i < totalLength; i++) {

            if (i > totalLength / 2) break;

            if (p < nums1.length && q < nums2.length) {
                if (nums1[p] < nums2[q]) {
                    total[i] = nums1[p];
                    p++;
                } else {
                    total[i] = nums2[q];
                    q++;
                }
            } else if (p == nums1.length && q < nums2.length) {
                total[i] = nums2[q];
                q++;
            } else if (p < nums1.length && q == nums2.length) {
                total[i] = nums1[p];
                p++;
            }

        }
        if (totalLength % 2 == 0) {
            return (total[totalLength / 2] + total[totalLength / 2 - 1]) / 2;
        }
        return total[totalLength / 2];
    }
    public static void main(String[] args) {
        int[] nums1 = {1,2,3,4,5,6};
        int[] nums2 = {0,1,2,4};
        System.out.println(findMedianSortedArrays(nums1,nums2));
    }
}
