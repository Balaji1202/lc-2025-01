// https://leetcode.com/problems/counting-words-with-a-given-prefix/

class Node {
    Node[] links;
    int count;

    Node() {
        links = new Node[26];
        count = 0;
    }
}

class Trie {
    Node root;

    Trie() {
        root = new Node();
    }

    public void addWord(String word) {
        Node curr = root;

        for(int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);

            if(curr.links[c - 'a'] == null) {
                curr.links[c - 'a'] = new Node();
            }

            curr = curr.links[c - 'a'];
            curr.count++;
        }
    }

    public int countPrefix(String prefix) {
        Node curr = root;

        for(int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);

            if(curr.links[c - 'a'] == null) {
                return 0;
            }

            curr = curr.links[c - 'a'];
        }

        return curr.count;
    }
}

class Solution {
    public int prefixCount(String[] words, String pref) {
        int count = 0;
        Trie trie = new Trie();

        for(String word: words) {
            trie.addWord(word);
        }

        return trie.countPrefix(pref);
    }
}
