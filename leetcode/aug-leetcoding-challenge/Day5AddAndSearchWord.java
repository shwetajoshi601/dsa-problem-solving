class WordDictionary {
    Map<Character, WordDictionary> children;
    boolean endOfWord;
    
    /** Initialize your data structure here. */
    public WordDictionary() {
        children = new HashMap<Character, WordDictionary>();
        endOfWord = false;
    }
    
    /** Adds a word into the data structure. */
    public void addWord(String word) {
        WordDictionary current = this;
        
        for(int i=0; i<word.length(); i++) {
            // for each character
            char ch = word.charAt(i);
            // get the node for the character in the current node
            WordDictionary node = current.children.get(ch);
            // character not present
            if(node == null) {
                // create a new node
                node = new WordDictionary();
                // add the character to the current node with an empty node with a reference to an empty node
                current.children.put(ch, node);
            }
            current = node;
        }
        // mark the end of the word
        current.endOfWord = true;
    }
    
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        WordDictionary current = this;
        // for each character
        for(int i=0; i < word.length(); i++) {
            char ch = word.charAt(i);
            // for a dot character
            if(ch == '.') {
                // iterate through all the children nodes in the current node
                for(WordDictionary w: current.children.values())
                    // recursively search for the remaining characters
                    // for example word=".ad"
                    // search for the path "ad" in all the nodes in the current children list
                    if(w != null && w.search(word.substring(i+1)))
                        return true;
                return false;
            }
            // get the node for the character
            WordDictionary node = current.children.get(ch);
            // if character not present in the current node
            if(node == null)
                return false;
            
            current = node;
        }
        
        // all characters found, return if it marks the end of the word
        return current.endOfWord;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */