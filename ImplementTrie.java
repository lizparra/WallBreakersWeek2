class Trie {
    private class Node {
       Node[] children = new Node[26];
        boolean isEndOfWord;
        Node(){
            isEndOfWord = false;
            for(int i = 0; i < 26; i++){
                children[i] = null;
            }
        }
    }
    private Node root;
    /** Initialize your data structure here. */
    public Trie() {
        root = new Node();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        Node n = root;
        for(int i = 0; i < word.length(); i++){
            if(n.children[word.charAt(i) - 'a'] == null){
                n.children[word.charAt(i) - 'a'] = new Node();
            }
            n = n.children[word.charAt(i) - 'a'];
        }
        n.isEndOfWord = true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Node n = root;
        for(int i = 0; i < word.length(); i++){
            if(n.children[word.charAt(i) - 'a'] == null){
                return false;
            }
            n = n.children[word.charAt(i) - 'a'];
        }
        
        return n != null && n.isEndOfWord == true;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        Node n = root;
        for(int i = 0; i < prefix.length(); i++){
            if(n.children[prefix.charAt(i) - 'a'] == null){
                return false;
            }
            n = n.children[prefix.charAt(i) - 'a'];
        }
        
        return n != null;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
