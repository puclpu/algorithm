package Lv2;

import java.util.ArrayList;

public class 우박수열정적분 {

  public static void main(String[] args) {
    int k = 5;
    int[][] ranges = {{0,0}, {0, -1}, {2,-3}, {3,-3}};
    Collatz collatz = new Collatz();
    double[] results = collatz.solution(k, ranges);
    for (double result : results) {
      System.out.println(result);
    }
  }

}

class Collatz {

  public double[] solution(int k, int[][] ranges) {
    double[] answer = new double[ranges.length];

    // 우박수열 계산
    ArrayList<Double> areas = calculateArea(k);
    int n = areas.size() - 1;

    // 주어진 범위의 넓이 계산
    for (int i = 0; i < ranges.length; i++) {
      int s = ranges[i][0];
      int e = n + ranges[i][1];

      if (s > e) {
        answer[i] = -1.0;
      } else {

        for (int j = s+1; j <= e; j++) {
          answer[i] += areas.get(j);
        }

      }
    }

    return answer;
  }

  private ArrayList<Double> calculateArea(int k) {
    int before = k;
    ArrayList<Double> areas = new ArrayList<>();
    areas.add(0.0);

    while (k > 1) {
      if (k % 2 == 0) {
        k = k / 2;
      } else {
        k = k * 3 + 1;
      }

      double area = (k + before) / 2.0;
      areas.add(area);

      before = k;
    }

    return areas;
  }

}