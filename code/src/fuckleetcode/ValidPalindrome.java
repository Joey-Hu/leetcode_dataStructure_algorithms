package fuckleetcode;

import java.lang.annotation.ElementType;

/**
 * @author: huhao
 * @time: 2020/2/11 15:55
 * @desc:
 */
public class ValidPalindrome {
    public boolean isPalindrome(String s) {
        if(s.isEmpty()){
            return true;
        }

        int head = 0;
        int tail = s.length() - 1;
        char cHead, cTail;

        while(head < tail){
            cHead = s.charAt(head);
            cTail = s.charAt(tail);

            if(!Character.isLetterOrDigit(cHead)){
                head++;
            }else if(!Character.isLetterOrDigit(cTail)){
                tail--;
            }else {
                if(Character.toLowerCase(cHead) != Character.toLowerCase(cTail)){
                    return false;
                }
                head++;
                tail--;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        ValidPalindrome vp = new ValidPalindrome();
        String s = "A man, a plan, a canal: Panama";
        vp.isPalindrome(s);
    }
}
