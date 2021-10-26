package Middle;

public class Title221 {

    static class WordDictionary {

        Trie trie;

        public WordDictionary() {
            this.trie = new Trie();
        }

        public void addWord(String word) {
            trie.insert(word);
        }

        public boolean search(String word) {
            Trie node = this.trie;
            return searchWord(word,node,0);
        }

        private boolean searchWord(String word,Trie node,int index) {
            for (int i = index;i < word.length();i++){
                if (node == null){
                    return false;
                }
                if (word.charAt(i) == '.'){
                    for (int j = 0;j < 26;j++){
                        if(node.child[j] != null && searchWord(word,node.child[j],i + 1)){
                            return true;
                        }
                    }
                    return false;
                }else{
                    int a = word.charAt(i) - 'a';
                    node = node.child[a];
                }
            }
            return node.isEnd;
        }

        class Trie {
            Trie[] child;
            boolean isEnd = false;

            public Trie (){
                this.child = new Trie[26];
            }

            public void insert(String words){
                Trie node = this;
                for (int i = 0;i < words.length();i++){
                    int index = words.charAt(i) - 'a';
                    if (node.child[index] == null){
                        node.child[index] = new Trie();
                    }
                    node = node.child[index];
                }
                node.isEnd = true;
            }
        }
    }

    public static void main(String[] args) {
        WordDictionary wordDictionary = new WordDictionary();
        wordDictionary.addWord("bad");
        wordDictionary.addWord("dad");
        wordDictionary.addWord("mad");
        System.out.println(wordDictionary.search("pad"));
        System.out.println(wordDictionary.search("bad"));
        System.out.println(wordDictionary.search(".ad"));
        System.out.println(wordDictionary.search("b.."));
    }
}
