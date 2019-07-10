class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashSet<Character> set = new HashSet<>();
        
        //check if rows are valid
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                if(board[i][j] != '.'){
                    if(!set.add(board[i][j])){
                        return false;
                    }
                }
            }
            set.clear();
        }
        
        //check if columns are valid
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                if(board[j][i] != '.'){
                    if(!set.add(board[j][i])){
                        return false;
                    }
                }
            }
            set.clear();
        }
        
        
        //check if squares are valid
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                for(int k = i*3; k < i*3+3; k++){
                    for(int m = j*3; m < j*3+3; m++){
                        if(board[k][m] != '.'){
                            if(!set.add(board[k][m])){
                                return false;
                            }
                        }
                    }
                }
                set.clear();
            }
        }
        
        return true;
    }
}
