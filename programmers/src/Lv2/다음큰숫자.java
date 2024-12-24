package Lv2;

public class 다음큰숫자 {
    public static void main(String[] args) {
        int result = solution(78);
        assert result == 83;
    }

    private static int solution (int n) {
        int count = countOne(n);
        int answer = n;

        while(true) {
            answer++;
            int cnt = countOne(answer);
            if (count == cnt) {
                break;
            }
        }

        return answer;
    }

    private static int countOne(int n) {
        String s = Integer.toBinaryString(n);
        String zero = s.replace("0", "");
        int count = zero.length();
        return count;
    }
}
