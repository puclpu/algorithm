package Lv2;

public class 가장큰정사각형찾기 {

    public static void main(String[] args) {
        BiggestSquare bs = new BiggestSquare();
        int[][] board = {{1,1,1,1},{0,1,1,1},{0,1,1,1}};
        int result = bs.solution(board);
        System.out.println("result = " + result);
    }

}
class BiggestSquare
{
    public int solution(int [][]board)
    {
        int answer = 0;

        int[][] newBoard = new int[board.length+1][board[0].length+1];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                newBoard[i+1][j+1] = board[i][j];
            }
        }

        int max = 0;
        for (int i = 0; i < newBoard.length; i++) {
            for (int j = 0; j < newBoard[i].length; j++) {
                if (newBoard[i][j] == 1) {
                    int left = newBoard[i-1][j];
                    int up = newBoard[i][j-1];
                    int leftUp = newBoard[i-1][j-1];
                    int min = Math.min(left, Math.min(up, leftUp));
                    newBoard[i][j] = min+1;

                    max = Math.max(max, min+1);
                }
            }
        }

        answer = max * max;

        return answer;
    }

}