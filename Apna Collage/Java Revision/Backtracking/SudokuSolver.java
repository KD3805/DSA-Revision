import java.util.Arrays;

class SudokuSolver {
    public static void main(String[] args) {
        String[][] board = {{"5","3",".",".","7",".",".",".","."},{"6",".",".","1","9","5",".",".","."},{".","9","8",".",".",".",".","6","."},{"8",".",".",".","6",".",".",".","3"},{"4",".",".","8",".","3",".",".","1"},{"7",".",".",".","2",".",".",".","6"},{".","6",".",".",".",".","2","8","."},{".",".",".","4","1","9",".",".","5"},{".",".",".",".","8",".",".","7","9"}};

        System.out.println(Arrays.deepToString(board));

        solveSudoku(board);

        System.out.println(Arrays.deepToString(board));
    }


    public static boolean isSafe(String[][] board, int row, int col, int num) {
        // check for row & col
        for(int i=0; i<board.length; i++) {
            // row
            if(board[row][i] == Integer.toString(num)) {
                return false;
            }
            // column
            if(board[i][col] == Integer.toString(num)) {
                return false;
            }
        }
        int srow = (row/3)*3; // calc given 3×3 grid's starting row index (0, 3, 6)
        int scol = (col/3)*3; // calc given 3×3 grid's starting col index (0, 3, 6)

        // check for sub-boxes of the grid
        for(int i=srow; i<srow+3; i++) {
            for(int j=scol; j<scol+3; j++) {
                if(board[i][j] == Integer.toString(num)) {
                    return false;
                }
            }
        }
        return true;
    }


    public static boolean helper(String[][] board, int row, int col) {
        if(row == board.length) {
            return true;
        }

        // find new row & col for next iteration
        int nrow = 0;
        int ncol = 0;
        if(col != board.length-1) {
            nrow = row;
            ncol = col + 1;
        } else {
            nrow = row + 1;
            ncol = 0;
        }

        // if already a number exist at (row, col) 
        if(board[row][col] != ".") {
            // check for new row & column
            if(helper(board, nrow, ncol)) {
                return true;
            }
        } else {
            // check for valid number between 1-9 and set
            for(int i=1; i<=9; i++) {
                if(isSafe(board, row, col, i)) {
                    board[row][col] = Integer.toString(i);

                    // check for new row & column
                    if(helper(board, nrow, ncol)) {
                        return true;
                    } else {
                        // finds not safe via backtracking
                        board[row][col] = ".";
                    }
                }
            }
        }
        return false;
    }
    
    
    public static void solveSudoku(String[][] board) {
        helper(board, 0, 0);
    }
}