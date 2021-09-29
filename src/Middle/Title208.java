package Middle;

/**
 * @Author: Urey
 * @Date: 2021/4/14
 */
public class Title208 {
    public class Trie{

        TrieNode node;

        class TrieNode{
            // 默认是false。代表未结束
            boolean isEnd = false;
            TrieNode[] next = new TrieNode[26];
        }

        public Trie(){
            node = new TrieNode();
        }

        public void insert(String word){
            TrieNode current = node;
            for (int i = 0;i < word.length();i++){
                char c = word.charAt(i);
                if (current.next[c - 'a'] == null){
                    current.next[c - 'a'] = new TrieNode();
                }
                current = current.next[c - 'a'];
            }
            current.isEnd = true;
        }

        public boolean search(String word){
            TrieNode current = node;
            for (int i = 0;i < word.length();i++){
                char c = word.charAt(i);
                if (current.next[c - 'a'] == null){
                    return false;
                }
                current = current.next[c - 'a'];
            }
            return current.isEnd;
        }

        public boolean startsWith(String prefix){
            TrieNode current = node;
            for (int  i = 0;i < prefix.length();i++){
                char c = prefix.charAt(i);
                if (current.next[c - 'a'] == null){
                    return false;
                }
                current = current.next[c - 'a'];
            }
            return true;
        }
    }
}
