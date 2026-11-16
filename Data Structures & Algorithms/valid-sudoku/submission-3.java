//Duplicates not allowed in - HashSet
//Each set needs to be redeclared(grid)/cleared(row/col) after one successful row/set/grid check operation
//both redeclaration & clearing set works but the former is more cleaner approach
class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashSet<Character> rowSet = new HashSet<>();
        HashSet<Character> colSet = new HashSet<>();
        for(int i=0;i<9;i++)
        {
            for(int j=0;j<9;j++)
            {
                if(board[i][j]!='.')
                {
                    if(!rowSet.add(board[i][j]))
                    {
                        return false;
                    }
                }
                if(board[j][i]!='.')
                {
                    if(!colSet.add(board[j][i]))
                    {
                        return false;
                    }
                }
            }
            rowSet.clear();
            colSet.clear();
        }

        for(int box=0;box<9;box++)
        {
            HashSet<Character> gridSet = new HashSet<>();
            for(int row=0;row<3;row++)
            {
                for(int col=0;col<3;col++)
                {
                    int row_box = (3*(box/3)) + row;
                    int col_box = (3*(box%3)) + col;

                    if(board[row_box][col_box]!='.')
                    {
                        if(!gridSet.add(board[row_box][col_box]))
                        {
                            return false;
                        }
                    }
                }
            }
        } 
        return true;
    }
}
