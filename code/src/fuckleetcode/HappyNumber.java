package fuckleetcode;

/**
 * @author: huhao
 * @time: 2020/2/5 16:19
 * @desc:
 */
public class HappyNumber {
    public boolean isHappy(int n) {
        // 递归
        if(n<=0){
            return false;
        }


        int ret = 0;
        int temp = 0;
        while(n!=0){
            temp = n % 10;
            ret += temp * temp;
            n = n / 10;
        }

        if(ret == 1){
            return true;
        }

        return isHappy(ret);
    }

    public static void main(String[] args) {
        HappyNumber hn = new HappyNumber();
        int n = 19;
        System.out.println(hn.isHappy(n));
    }
}
