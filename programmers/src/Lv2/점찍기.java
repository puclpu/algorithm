package Lv2;

public class 점찍기 {
  public static void main(String[] args) {
    Dot dot = new Dot();
    long result = dot.solution(3, 7);
    System.out.println(result);
  }
}
class Dot {
  public long solution(int k, int d) {
    long answer = 0;

    for (int i = 0; i <= d; i += k) {
      long dd = (long) d * d;
      long ii = (long) i * i;
      int my = (int)Math.sqrt(dd - ii);
      int yc = my / k + 1;
      answer += yc;
    }

    return answer;
  }
}