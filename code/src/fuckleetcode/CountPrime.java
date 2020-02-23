package fuckleetcode;

/**
 * @author: huhao
 * @time: 2020/2/12 10:16
 * @desc:
 */
public class CountPrime {
    public int countPrimes(int n){

        if(n <=1 ){
            return 0;
        }

        boolean[] notPrime = new boolean[n];
        notPrime[0] = true;
        notPrime[1] = true;
        int count = 0;

        // 如果一个数的约数在其开平方的右边 则必然会存在一个约数在其开平方的左边 所以
        //判断一个数是否为质数 只需要观察在其2 到 开平方数中间是否含有约数即可
        for(int i=2; i<Math.sqrt(n); i++){
            if(!notPrime[i]){
                for (int j = 2; i*j < n; j++) {
                    notPrime[i*j] = true;
                }
            }

        }
        for(int i=0; i<notPrime.length; i++){
            if(!notPrime[i]){
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        CountPrime cp = new CountPrime();
        cp.countPrimes(10);
    }
}
