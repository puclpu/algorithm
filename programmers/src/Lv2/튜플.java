package Lv2;

import java.util.*;

public class 튜플 {
    public static void main(String[] args) {
        int[] result = solution("{{2},{2,1},{2,1,3},{2,1,3,4}}");
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }
    }
    private static int[] solution(String s) {
        s = s.replaceAll("[{}]", "");
        String[] split = s.split(",");

        HashMap<Integer, Integer> map = new HashMap<>();
        for (String num : split) {
            Integer number = Integer.parseInt(num);

            if(map.containsKey(number)) {
                map.replace(number, map.get(number) + 1);
            } else {
                map.put(number, 1);
            }
        }

        ArrayList<Integer> keys = new ArrayList<>();
        for (Integer key : map.keySet()) {
            keys.add(key);
        }

        Collections.sort(keys, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return map.get(o1).compareTo(map.get(o2));
            }
        });

        int[] answer = new int[keys.size()];
        int index = answer.length-1;
        for (Integer key : keys) {
            answer[index--] = key;
        }

        return answer;
    }
}
