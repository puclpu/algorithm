package Lv2;

public class 이진변환반복하기 {

  public static void main(String[] args) {
    RepeatBinaryConversion bc = new RepeatBinaryConversion();
    int[] result = bc.solution("110010101001");
    for (int i = 0; i < result.length; i++) {
      System.out.print(result[i] + " ");
    }
  }
}

class RepeatBinaryConversion {
  public int[] solution(String s) {
    int[] answer = new int[2];

    while(s.length() > 0) {
      if (s.equals("1")) {
        break;
      }

      int one = 0;
      for(int i=0; i<s.length(); i++) {
        if(s.charAt(i) == '0') {
          answer[1]++;
        } else {
          one++;
        }
      }

      s = Integer.toBinaryString(one);
      answer[0]++;
    }

    return answer;
  }
}