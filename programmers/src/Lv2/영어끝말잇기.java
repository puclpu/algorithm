package Lv2;

import java.util.HashSet;

public class 영어끝말잇기 {
    public static void main(String[] args) {
        int n = 3;
        String[] words = {"tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"};
        int[] result = solution(n, words);
        assert result[0] == 3;
        assert result[1] == 3;
    }

    private static int[] solution(int n, String[] words) {
        int[] answer = new int[2]; //  번호, 차례

        HashSet<String> set = new HashSet<>();

        for (int i = 0; i < words.length; i++) {
            if (set.contains(words[i]) ||
                    i != 0 && words[i-1].charAt(words[i-1].length()-1) != words[i].charAt(0)) {
                answer[1] = i / n + 1;
                answer[0] = i % n + 1;
                break;
            }else {
                set.add(words[i]);
            }
        }

        return answer;
    }
}
