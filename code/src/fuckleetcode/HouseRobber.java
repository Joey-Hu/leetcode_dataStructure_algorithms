package fuckleetcode;

/**
 * @author: huhao
 * @time: 2020/2/9 9:59
 * @desc:
 */
public class HouseRobber {
    public int rob(int[] nums){
        if(nums.length == 0){
            return 0;
        }

        int[] memo = new int[nums.length + 1];
        memo[0] = 0;
        memo[1] = nums[0];
        for(int i=1; i<nums.length; i++){
            int val = nums[i];
            memo[i+1] = Math.max(memo[i-1]+val, memo[i]);
        }
        return memo[nums.length];

    }

    public static void main(String[] args) {
        int[] nums = {2,7,9,3,1};
        HouseRobber hr = new HouseRobber();
        System.out.println(hr.rob(nums));
    }
}
