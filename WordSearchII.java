class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        List<String> result = new ArrayList<>();
        
        for(String word: words){
            Node n = root;
            for(char c: word.toCharArray()){
                if(n.children[c - 'a'] == null){
                    n.children[c - 'a'] = new Node();
                }
                n = n.children[c - 'a'];
            }
            n.word = word;
        }
        
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                dfs(board, i, j, root, result);
            }
        }
        
        return result;
    }
    
    public void dfs(char[][] board, int i, int j, Node n, List<String> result){
        char c = board[i][j];
        if(c == '#' || n.children[c - 'a'] == null){
            return;
        }
        n = n.children[c - 'a'];
        if(n.word != null && n.word.length() != 0){
            result.add(n.word);
            n.word = null;
        }
        board[i][j] = '#';
        
        if(i > 0) { dfs(board, i - 1, j, n, result); }
        if(j > 0) { dfs(board, i, j - 1, n, result); }
        if(i < board.length - 1){
            dfs(board, i + 1, j, n, result);
        }
        if(j < board[0].length - 1){
            dfs(board, i, j + 1, n, result);
        }
        board[i][j] = c;
    }
    
    private Node root = new Node();
    
    public class Node {
        String word = "";
        Node[] children = new Node[26];
    }
}

