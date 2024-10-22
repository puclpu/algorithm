package Lv2;

import java.util.Arrays;

public class 퍼즐게임챌린지 {
  public static void main(String[] args) {
   int[] diffs = {1, 4, 4, 2};
   int[] times = {6, 3, 8, 2};
   long limit = 59;
   PuzzleGame pg = new PuzzleGame();
   int result = pg.solution(diffs, times, limit);
   System.out.println(result);
  }
}

class PuzzleGame {
  public int solution(int[] diffs, int[] times, long limit) {
    int answer = 0;

    int[] levels = diffs.clone();
    Arrays.sort(levels);
    int start = levels[0];
    int end = levels[levels.length-1];

    int mid = start;
    while(start <= end) {
      mid = (start + end) / 2;

      long sum = calculate_time(mid, diffs, times);
      if (sum > limit) {
        start = mid + 1;
      } else {
        answer = mid;
        end = mid - 1;
      }
    }

    return answer;
  }

  private long calculate_time(int level, int[] diffs, int[] times) {
    long total_time = 0;

    for (int j = 0; j < times.length; j++) {
      int time_cur = times[j];
      int time_prev = 0;
      if (j > 0) {
        time_prev = times[j-1];
      }

      if (level < diffs[j]) {
        total_time += (time_cur + time_prev) * (diffs[j] - level) + time_cur;
      } else {
        total_time += time_cur;
      }
    }

    return total_time;
  }
}