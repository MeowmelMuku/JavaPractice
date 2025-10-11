package leetCode;

public class test11 {
    public static int maxArea(int[] height) {

        int max = 0;
        int i = 0;
        int j = height.length-1;
        int length = j;
        while(i<j){
            int area;
            if(height[i]<height[j]){
                area = height[i] * (length);
                max = Math.max(max,area);
                i++;

            } else {
                area = height[j] * (length);
                max = Math.max(max,area);
                j--;
            }
            length--;
        }
        return max;
    }
    public static void main(String[] args) {
        int[] height = {8,7,2,1};
        System.out.println(maxArea(height));
    }
}
