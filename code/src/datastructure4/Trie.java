package datastructure4;

import java.util.TreeMap;

/**
 * @author: huhao
 * @time: 2020/2/10 8:57
 * @desc: 实现前缀树结构
 */
public class Trie {

    private class Node{
        public boolean isWord;
        public TreeMap<Character, Node> next;

        public Node(boolean isWord){
            this.isWord = isWord;
            next = new TreeMap<>();
        }

        public Node(){
            this(false);
        }
    }

    private Node root;
    private int size;

    public Trie(){
        root = new Node();
        size = 0;
    }

    /**
     * 返回Trie中存储的单词数量
     * @return
     */
    public int getSize(){
        return size;
    }

    /**
     * 向Trie中添加一个单词word
     * @param word
     */
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
                size++;
            }
        }
    }

    /**
     * 查看单词word是否在Trie中
     * @param word
     * @return
     */
    public boolean contains(String word){
        Node cur = root;

        for(int i=0; i<word.length(); i++){
            char c = word.charAt(i);
            if(cur.next.get(c) == null){
                return false;
            }
            cur = cur.next.get(c);
        }

        /*if(cur.isWord){
            return true;
        }*/
        return cur.isWord;
    }

    /**
     * 查询是否在Trie中有单词以prefix为前缀
     * @param prefix
     * @return
     */
    public boolean isPrefix(String prefix){
        Node cur = root;

        for(int i=0; i<prefix.length(); i++){
            char c = prefix.charAt(i);
            if(cur.next.get(c) == null){
                return false;
            }
            cur = cur.next.get(c);
        }

        return false;
    }

    /**
     * Delete the given word in the Trie if exists
     * https://www.jianshu.com/p/6c8b18c5947b  暂时不会
     * @param word
     */
    public void remove(String word){

        if(!contains(word)){
            return;
        }

        Node cur = root;
        int count = 0;

        for(int i=0; i<word.length(); i++){
            char c = word.charAt(i);
            if(cur.next.get(c) != null){
                count++;
            }
            cur = cur.next.get(c);
        }

        if(cur.isWord){
            cur.isWord = false;
        }else{
            for(int i=0; i<count; i++){

            }
        }
    }
}
