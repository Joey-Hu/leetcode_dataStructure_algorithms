package fuckleetcode;

import javax.swing.text.TabExpander;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author: huhao
 * @time: 2020/2/6 12:49
 * @desc:
 */
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {

        HashMap<Integer, Integer> hp = new HashMap<Integer, Integer>();
        int[] ret = new int[2];

        for(int i=0; i<nums.length; i++){
            if(hp.containsKey(target - nums[i])){
                ret[1] = i;
                ret[0] = hp.get(target - nums[i]);
                return ret;
            }else{
                hp.put(nums[i], i);
            }
        }
        return ret;
    }
}
