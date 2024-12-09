package Lv2;

public class JadenCase문자열만들기 {

  public static void main(String[] args) {
    JadenCase jc = new JadenCase();
    String result = jc.solution("3people unFollowed me");
    System.out.println(result);
  }
}

class JadenCase {
  public String solution(String s) {
    String answer = "";

    StringBuilder sb = new StringBuilder();
    for(int i=0; i<s.length(); i++) {
      char c = s.charAt(i);
      String cs = c + "";
      if (i==0 || s.charAt(i-1) == ' ' && Character.isLetter(c)) {
        sb.append(cs.toUpperCase());
      } else {
        sb.append(cs.toLowerCase());
      }
    }

    answer = sb.toString();
    return answer;
  }
}