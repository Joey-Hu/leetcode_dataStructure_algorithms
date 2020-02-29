package fuckleetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: huhao
 * @time: 2020/2/29 9:34
 * @desc:
 */
public class FirstUniqueCharacterInAString {

    public int firstUniqueChar(String s){
        Map<Character, Integer> hashMap = new HashMap<Character, Integer>();

        for(int i=0; i<s.length(); i++){
            if(!hashMap.containsKey(s.charAt(i))){
                hashMap.put(s.charAt(i), 1);
            }else{
                hashMap.put(s.charAt(i), hashMap.get(s.charAt(i))+1);
            }
        }

        for(int i=0; i<s.length(); i++){
            if(hashMap.get(s.charAt(i)) == 1){
                return i;
            }
        }

        return-1;
    }

}
