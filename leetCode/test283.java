public class test283 {
    public static void moveZeroes(int[] nums) {
        int index = 0;
        // 移动所有非零元素到数组前端
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[index++] = nums[i];
            }
        }
        // 将剩余位置填充为零
        for (int i = index; i < nums.length; i++) {
            nums[i] = 0;
        }
    }
    public static void main(String[] args) {
        moveZeroes(new int[]{0,1,0,3,12});
    }
}
