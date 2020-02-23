package fuckleetcode;

/**
 * @author: huhao
 * @time: 2020/2/12 10:16
 * @desc:
 */
public class CountPrime1 {
    public int countPrimes(int n){

        if(n <=1 ) {
            return 0;
        }

        int count = 0;

        for(int i=2; i<n; i++){
            if(isPrime(i)){
                count++;
            }
        }
        return count;
    }

    public boolean isPrime(int n){
        if(n == 2){
            return true;
        }

        for(int i=3; i<n; i++){
            if(n % i == 0){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        CountPrime1 cp = new CountPrime1();
        cp.countPrimes(10);
    }
}
