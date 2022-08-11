package 前缀树;


public class Trie {
    private TrieNode root;
    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode p = root;
        for(char c : word.toCharArray()){
            int i = c - 'a';
            if(p.children[i] == null){
                p.children[i] = new TrieNode();
            }
            p = p.children[i];
        }
        p.val = true;
    }

    public boolean search(String word) {
        TrieNode p = root;
        for (char c : word.toCharArray()) {
            int i = c - 'a';
            // 路径不存在的情况，直接返回 false
            if (p.children[i] == null) return false;
            p = p.children[i];
        }
        // 路径存在，直接返回该路径的终点处的节点的有效性
        return p.val;
    }

    public boolean startsWith(String prefix) {
        TrieNode p = root;
        for (char c : prefix.toCharArray()) {
            int i = c - 'a';
            if (p.children[i] == null) return false;
            p = p.children[i];
        }
        return p.val;
    }
}

class TrieNode{
     boolean val;
     TrieNode[] children = new TrieNode[26];
}

