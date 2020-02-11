package fuckleetcode;

import java.util.ArrayList;
import java.util.TreeMap;

/**
 * @author: huhao
 * @time: 2020/2/11 14:26
 * @desc:
 */
public class LongestCommonPrefix {
    // 字典树
    private class Node{
        public boolean isWord;
        public TreeMap<Character, Node> next;

        public Node(){
            isWord = false;
            next = new TreeMap<>();
        }
    }

    private Node root;

    public LongestCommonPrefix(){
        root = new Node();
    }

    public void add(String word){
        Node cur = root;

        for(int i=0; i<word.length(); i++){
            char c = word.charAt(i);
            if(cur.next.get(c) == null){
                cur.next.put(c, new Node());
            }

            cur = cur.next.get(c);

            if(!cur.isWord){
                cur.isWord = true;
            }
        }

    }

    public String longestCommonPrefix(String[] strs) {

        StringBuilder prefix = new StringBuilder();

        for(int i=0; i<strs.length; i++){
            add(strs[i]);
        }

        Node cur = root;
        if(cur.next.keySet().size() == 1){
            char c = cur.next.firstKey();
            prefix.append(c);
            cur = cur.next.get(c);
        }
        return prefix.toString();
    }
}
