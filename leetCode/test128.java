import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class test128 {

    public static int longestConsecutive(int[] nums) {
        if(nums.length==0)return 0;
        Arrays.sort(nums);
        ArrayList<Integer> list = new ArrayList<>();
        int j=0;
        list.add(1);
        for (int i=0;i<nums.length-1;i++)
        {
            if(nums[i]==nums[i+1]-1){
                list.set(j,list.get(j)+1);
            } else if(nums[i]!=nums[i+1]){
                list.add(1);
                j++;
            }
        }
        Collections.sort(list);
        return list.getLast();
    }

    public static void main(String[] args) {
        System.out.println(longestConsecutive(new int[]{9,1,4,7,3,-1,0,5,8,-1,6}));
    }

}
