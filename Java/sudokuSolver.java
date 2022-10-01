package recursion;

public class sudokuSolver {
    public static void main(String[] args) {
        int[][] board = new int[][] {
                { 3, 0, 6, 5, 0, 8, 4, 0, 0 },
                { 5, 2, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 8, 7, 0, 0, 0, 0, 3, 1 },
                { 0, 0, 3, 0, 1, 0, 0, 8, 0 },
                { 9, 0, 0, 8, 6, 3, 0, 0, 5 },
                { 0, 5, 0, 0, 9, 0, 6, 0, 0 },
                { 1, 3, 0, 0, 0, 0, 2, 5, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 7, 4 },
                { 0, 0, 5, 2, 0, 6, 3, 0, 0 }
        };
        solve(board,9);
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
    }

    public static boolean solve(int[][] board, int n){
        int row=-1; int col=-1;
        boolean isEmpty = true; // to check if the board is already filled

        for(int i=0;i<n;i++){
            for (int j=0;j<n;j++){
                if(board[i][j] == 0) {
                    row = i; col=j;
                    isEmpty = false;
                    break;
                }
            }
            if(!isEmpty){
                break;
            }
        }
        if (isEmpty){
            return true; // there is no empty space in the board
        }

        for(int i=1;i<=9;i++){
            if(isSafe(board,row,col,i)){
                board[row][col] = i;
                if(solve(board,n)){
                    return true;
                }
                board[row][col] = 0;
            }
        }
        return false;
    }

    public static boolean isSafe(int[][] board, int row, int col, int target){
        for(int i=0;i<board.length;i++){ // check for queens in left of the current row
            if(board[row][i] == target) return false;
        }
        for(int i=0;i<board.length;i++){ // check for queens in upper side of the current column
            if(board[i][col] == target){
                return false;
            }
        }

        //check for queens in sub box
        int sqrt = (int)Math.sqrt(board.length);
        int boxRowStart = row - row % sqrt;
        int boxColStart = col - col % sqrt;

        for (int r = boxRowStart;
             r < boxRowStart + sqrt; r++)
        {
            for (int d = boxColStart;
                 d < boxColStart + sqrt; d++)
            {
                if (board[r][d] == target)
                {
                    return false;
                }
            }
        }
        return true;
    }
}
