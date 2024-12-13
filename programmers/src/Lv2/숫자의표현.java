package Lv2;

public class 숫자의표현 {

  public static void main(String[] args) {
    ExpressionOfNumbers en = new ExpressionOfNumbers();
    int result = en.solution(15);
    System.out.println(result);
  }
}

class ExpressionOfNumbers {
  public int solution(int n) {
    int answer = 0;

    int sum = 0;
    int e = 1;
    for(int s=1; s<=n; s++) {
      while(sum < n && e <= n) {
        sum += e;
        e++;
      }

      if (sum == n) {
        answer++;
      }

      sum -= s;
    }

    return answer;
  }
}