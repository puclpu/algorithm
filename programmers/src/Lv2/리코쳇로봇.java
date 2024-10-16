package Lv2;

import java.util.LinkedList;

public class 리코쳇로봇 {
  public static void main(String[] args) {
    String[] board = {"...D..R", ".D.G...", "....D.D", "D....D.", "..D...."};
    Recochat recochat = new Recochat();
    int result = recochat.solution(board);
    System.out.println(result);
  }
}

class Recochat {
  public int solution(String[] board) {
    int answer = -1;

    LinkedList<Point> queue = new LinkedList<>();

    char[][] arr = new char[board.length][board[0].length()];
    boolean[][] visit = new boolean[arr.length][arr[0].length];
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[0].length(); j++) {
        arr[i][j] = board[i].charAt(j);

        if (arr[i][j] == 'R') {
          queue.add(new Point(i, j, 'R', 0));
          visit[i][j] = true;
        }
      }
    }

    int[][] move = {{1,0}, {-1,0}, {0, 1}, {0, -1}};

    while(!queue.isEmpty()) {
      Point p = queue.poll();

      if (p.c == 'G') {
        if (answer == -1 || answer > p.depth) {
          answer = p.depth;
        }
      }

      for (int i = 0; i < move.length; i++) {
        int x = p.x;
        int y = p.y;

        while(x >= 0 && x < arr.length && y >= 0 && y < arr[0].length) {
          if (arr[x][y] == 'D') {
            break;
          }

          x += move[i][0];
          y += move[i][1];
        }

        x -= move[i][0];
        y -= move[i][1];

        if (visit[x][y])
          continue;

        queue.add(new Point(x, y, arr[x][y], p.depth+1));
        visit[x][y] = true;
      }

    }

    return answer;
  }
}

class Point {
  int x;
  int y;
  int c;
  int depth;

  public Point(int x, int y, char c, int depth) {
    this.x = x;
    this.y = y;
    this.c = c;
    this.depth = depth;
  }
}