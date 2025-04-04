class TrieStructure {
    // Trie is K-ary tree/ Retrieval tree
    // 1. Search fast - Time complexity O(L); L: length of word
    // 2. Insertion and deletion of words are faster than BST
    // 3. Prefix is not repeated

    // Structure:

            //              [    ]
            //             /      \
            //     [0,1,2,...,25] [0,1,2,...,25]      
            //         /                \
            // [0,1,2,...,25]      [...,20,...,25]
            //           /   \
            // [0,1,2,...,25] [...,12,...,25]
            //              .....

    public static void main(String[] args) {
        // String words[] = {"the", "a", "there", "their", "any"};
        // String words[] = {"i", "like", "sam", "samsung", "mobile"}; // wordBreak
        String words[] = {"apple", "app", "mango", "man", "woman"}; // startsWith
        String prefix = "app";

        for(String word: words) {
            insert(word);
        }

        // System.out.println(search("their"));
        // System.out.println(search("thor"));
        // System.out.println(search("an"));

        System.out.println(wordBreak("ilikesung"));
        System.out.println(startsWith(prefix));
    }

    private static class Trie {
        Trie[] children;
        boolean eow;

        private Trie() {
            this.children = new Trie[26]; // a-z
            for(int i=0; i < this.children.length; i++) {   
                this.children[i] = null; //init with null
            }
            this.eow = false;
        }
    }

    private static Trie root = new Trie();

    // insert
    public static void insert(String word) {
        Trie curr = root;

        for(int i=0; i < word.length(); i++) {
            int idx = word.charAt(i) - 'a'; // i.e. "their" => word[0] = 't' => 't' - 'a' = 20

            if(curr.children[idx] == null) {
                curr.children[idx] = new Trie();
            }
            if(i == word.length()-1) {
                curr.children[idx].eow = true;
            }
            curr = curr.children[idx]; // update curr/root node
        }
    }

    // search
    public static boolean search(String key) {
        Trie curr = root;

        for(int i=0; i < key.length(); i++) {
            int idx = key.charAt(i) - 'a'; 
            Trie node = curr.children[idx];

            if(node == null) {
                return false;
            }
            if(i == key.length()-1 && node.eow == false) {
                return false;
            }
            curr = curr.children[idx]; // update curr/root node
        }
        return true;
    }

    // word break
    public static boolean wordBreak(String key) {
        if(key.length() == 0)
            return true;
        
        for(int i=1; i<=key.length(); i++) {
            String firstPart = key.substring(0, i);
            String secondPart = key.substring(i);
            
            if(search(firstPart) && wordBreak(secondPart))
                return true;
        }
        return false;
    }

    // startsWith
    public static boolean startsWith(String prefix) {
        Trie curr = root;

        for(int i=0; i < prefix.length(); i++) {
            int idx = prefix.charAt(i) - 'a';

            if(curr.children[idx] == null)
                return false;

            curr = curr.children[idx]; // updation
        }
        return true;
    }
}