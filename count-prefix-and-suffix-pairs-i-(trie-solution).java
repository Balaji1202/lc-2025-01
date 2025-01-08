// https://leetcode.com/problems/count-prefix-and-suffix-pairs-i

class Node {
    private Node[] links = new Node[26];

    public boolean contains(char c) {
        return links[c - 'a'] != null;
    }

    public void put(char c, Node node) {
        links[c - 'a'] = node;
    }

    public Node next(char c) {
        return links[c - 'a'];
    }
}

class Trie {
    private Node root;

    public Trie() {
        root = new Node();
    }

    public void insert(String word) {
        Node node = root;

        for(char c: word.toCharArray()) {
            if(!node.contains(c)) {
                node.put(c, new Node());
            }
            node = node.next(c);
        }
    }

    public boolean startsWith(String word) {
        Node node = root;

        for(char c: word.toCharArray()) {
            if(!node.contains(c)) {
                return false;
            }
            node = node.next(c);
        }

        return true;
    }
}

class Solution {
    public int countPrefixSuffixPairs(String[] words) {
        int answer = 0;
        
        for(int i = 0; i < words.length; i++) {
            Trie prefixTrie = new Trie();
            Trie suffixTrie = new Trie();

            prefixTrie.insert(words[i]);

            suffixTrie.insert((new StringBuilder(words[i])).reverse().toString());

            for(int j = 0; j < i; j++) {
                if(words[j].length() > words[i].length()) {
                    continue;
                }

                String prefixWord = words[j];
                String suffixWord = (new StringBuilder(prefixWord)).reverse().toString();

                if(prefixTrie.startsWith(prefixWord) && suffixTrie.startsWith(suffixWord)) {
                    answer++;
                }
            }
        }

        return answer;
    }
}
