package Lv2;

import java.util.LinkedList;
import java.util.Stack;

public class 캐시 {
    public static void main(String[] args) {
        int cacheSize = 3;
        String[] cities = {"Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul"};
        Cache cache = new Cache();
        int result = cache.solution(cacheSize, cities);
        System.out.println("result = " + result);
    }
}
class Cache {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;

        LinkedList<String> queue = new LinkedList<>();

        for (String city : cities) {
            Stack<String> stack = new Stack<>();

            int size = queue.size();
            while (!queue.isEmpty()) {
                String s = queue.pop();
                if (s.equalsIgnoreCase(city)) {
                    break;
                } else {
                    stack.add(s);
                }
            }

            if (stack.size() == size) {
                answer += 5;
            } else {
                answer += 1;
            }

            while(!stack.isEmpty()) {
                queue.addFirst(stack.pop());
            }
            queue.add(city);

            if (queue.size() > cacheSize)
                queue.pop();

        }

        return answer;
    }
}