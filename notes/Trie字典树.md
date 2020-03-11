## Trie(前缀树或字典树)
是一种有序树，用于保存关联数组，其中的键通常是字符串。与二叉查找树不同，键不是直接保存在节点中，而是有节点在树中的位置决定。一个节点的所有子孙都有相同的前缀，根节点对应空字符串。一般情况下，不是所有的节点都有对应的值，只有叶子节点和部分内部节点所对应的键才有相关的值。

Trie的典型应用是用于统计，排序和保存大量的字符串（但不仅限于字符串），所以经常被搜索引擎系统用于文本词频统计。它的优点是：利用字符串的公共前缀来减少查询时间，最大限度地减少无谓的字符串比较，查询效率比哈希树高。

#### 节点设计

```java
class Node{
    public boolean isWord;    // 表示该节点是否是单词结尾
    public Map<Character, Node> next;    // 该节点的下一个节点 
}
```

#### 具体实现
```java
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

```

#### 内存局限
**压缩字典树**
对于只有一条路径的几个节点，可以合并用一个结点来存储。

![“compressed tree”](https://raw.githubusercontent.com/Joey-Hu/leetcode_dataStructure_algorithms/master/images/compressedTrie.png)

优点：节省空间
缺点：维护成本更高

#### Ternary Search Tree

#### 字符串识别模式 -- 后缀树

#### 更多字符串问题
**子串查询**
1. KMP
2. Boyer-Moore
3. Rabin-Karp

**文件压缩**

**模式匹配**

参考：
https://blog.csdn.net/qq_25343557/article/details/88797312