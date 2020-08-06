class TrieImplement {
    
    class TrieNode {
        Map<Character, TrieNode> children;
        boolean endOfWord;
        
        TrieNode() {
            // map for children
            children = new HashMap<Character, TrieNode>();
            endOfWord = false;
        }
    }
    
    static TrieNode root;
    
    /** Initialize your data structure here. */
    public TrieImplement() {
        root = new TrieNode();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        // start from the root
        TrieNode current = this.root;
        
        for(int i=0; i<word.length(); i++) {
            char ch = word.charAt(i);
            // get the node for the character from the current node
            TrieNode node = current.children.get(ch);
            // character is not present in the current node
            if(node == null) {
                // create a new empty node
                node = new TrieNode();
                // add the character to the current node
                current.children.put(ch, node);
            }
            current = node;  
        }
        
        // mark the end of the work
        current.endOfWord = true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        // start from the root
        TrieNode current = this.root;
        
        for(int i=0; i<word.length(); i++) {
            char ch = word.charAt(i);
            // get the node for the character in the current node
            TrieNode node = current.children.get(ch);
            // node not present
            if(node == null)
                return false;
            
            current = node;
        }
        
        // all the characters found, but a word is found only if it ends at a node with endOfWord true
        return current.endOfWord;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode current = this.root;
        
        for(int i=0; i<prefix.length(); i++) {
            char ch = prefix.charAt(i);
            TrieNode node = current.children.get(ch);
            if(node == null)
                return false;
            
            current = node;
        }
        
        // need not mark the end of the node since we only check prefix
        return true;
    }
}

/**
 * Your TrieImplement object will be instantiated and called as such:
 * TrieImplement obj = new TrieImplement();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */