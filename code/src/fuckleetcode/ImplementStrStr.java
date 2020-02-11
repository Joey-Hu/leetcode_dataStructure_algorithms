package fuckleetcode;

/**
 * @author: huhao
 * @time: 2020/2/11 16:18
 * @desc:
 */
public class ImplementStrStr {
    public int strStr(String haystack, String needle) {
        if(needle.isEmpty()){
            return 0;
        }

        int index = 0;

        for(int i=0, j=0; i<haystack.length() && j<needle.length();){
            if(haystack.charAt(i) != needle.charAt(j)){
                i++;
            }else {
                index++;
                i++;
                j++;
            }

            index = i;
        }
        return 0;

    }
}
