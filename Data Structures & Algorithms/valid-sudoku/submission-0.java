//Duplicates not allowed in - HashSet
class Solution {
    public boolean isValidSudoku(char[][] board) {
        //each row must contain value b/w 1-9 without duplicates
        //each col must contain value b/w 1-9 without duplicates
        for(int i=0; i<9; i++)
        {
            HashSet<Character> rowSet = new HashSet<>();
            HashSet<Character> colSet = new HashSet<>();
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
        }
        //each grid of 3*3 must contain value b/w 1-9 without duplicates
        for(int box=0;box<9;box++)
        {
            HashSet<Character> gridSet = new HashSet<>();
            for(int i=0;i<3;i++)
            {
                for(int j=0;j<3;j++)
                {
                    int r = (3 * (box/3))+i;
                    int c = (3 * (box%3))+j;

                    if(board[r][c]!='.')
                    {
                        if(!gridSet.add(board[r][c]))
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
