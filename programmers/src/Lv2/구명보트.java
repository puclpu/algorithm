package Lv2;

import java.util.Arrays;

public class 구명보트 {
    public static void main(String[] args) {
        int[] people = {70, 50, 80, 50};
        int limit = 100;
        int result = solution(people, limit);
        assert result == 3;
    }
    private static int solution(int[] people, int limit) {
        int answer = 0;

        Arrays.sort(people);
        boolean[] got = new boolean[people.length];

        int j = got.length-1;
        for (int i = 0; i < got.length; i++) {
            if (got[i])
                break;

            answer++;

            while(i < j) {
                int sum = people[i] + people[j];
                got[j--] = true;
                if (sum <= limit) {
                    break;
                } else {
                    answer++;
                }
            }
        }

        return answer;
    }
}
