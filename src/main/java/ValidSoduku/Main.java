package ValidSoduku;

import java.util.HashSet;

public class Main {

    private static boolean isValidSudoku(char[][] board) {

        HashSet<String> uniqSet = new HashSet<>();

        for (int i = 0; i < 9; i++) { //row
            for (int j = 0; j < 9; j++) { //col
                if (board[i][j] == '.') {
                    continue;
                }
                int box_index = (i / 3) * 3 + j / 3;
                if (uniqSet.contains("b_" + box_index + "_" + board[i][j]) ||
                        uniqSet.contains("r_" + i + "_" + board[i][j]) ||
                        uniqSet.contains("c_" + j + "_" + board[i][j])) {
                    return false;
                } else {
                    uniqSet.add("b_" + box_index + "_" + board[i][j]);
                    uniqSet.add("r_" + i + "_" + board[i][j]);
                    uniqSet.add("c_" + j + "_" + board[i][j]);

                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        char[][] board1 = new char[][]{
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        System.out.println(isValidSudoku(board1)); //true
        char[][] board2 = new char[][]{
                {'8', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        System.out.println(isValidSudoku(board2)); //false
    }
}
