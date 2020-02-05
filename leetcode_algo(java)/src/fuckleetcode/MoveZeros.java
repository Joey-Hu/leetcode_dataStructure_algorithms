package fuckleetcode;

/**
 * @author: huhao
 * @time: 2020/2/5 14:57
 * @desc:
 */
public class MoveZeros {
    public void moveZeroes(int[] nums) {
        if(nums == null || nums.length == 0){
            return;
        }

        int insertPos = 0;
        for(int i=0; i<nums.length; i++){
            if(nums[i]!=0){
                nums[insertPos++] = nums[i];
            }
        }
        while(insertPos<nums.length){
            nums[insertPos++] = 0;
        }
    }

    public static void main(String[] args) {
        MoveZeros mz = new MoveZeros();
        int[] nums = {0, 1, 0, 3, 12};
        mz.moveZeroes(nums);
        for(int num : nums){
            System.out.println(num);
        }
    }
}
