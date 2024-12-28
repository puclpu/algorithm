package Lv2;

import java.util.*;

public class 귤고르기 {
    public static void main(String[] args) {
        int k = 6;
        int[] tangerine = {1, 3, 2, 5, 4, 5, 2, 3};
        int result = solution(k, tangerine);
        assert result == 3;
    }
    private static int solution(int k, int[] tangerine) {
        int answer = 0;

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < tangerine.length; i++) {
            if (map.containsKey(tangerine[i])) {
                int value = map.get(tangerine[i]);
                map.replace(tangerine[i], value+1);
            } else {
                map.put(tangerine[i], 1);
            }
        }

        ArrayList<Integer> count = new ArrayList<>();
        for (int key : map.keySet()) {
            count.add(map.get(key));
        }

        Collections.sort(count, Collections.reverseOrder());

        int sum = 0;
        for(int c : count) {
            sum += c;
            answer++;
            if (sum >= k) {
                break;
            }
        }

        return answer;
    }
}
