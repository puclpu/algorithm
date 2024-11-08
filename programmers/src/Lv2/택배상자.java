package Lv2;

import java.util.Stack;

public class 택배상자 {
    public static void main(String[] args) {
        int[] order = {4, 3, 1, 2, 5};
        DeliveryBox db = new DeliveryBox();
        int result = db.solution(order);
        System.out.println("result = " + result);
    }
}
class DeliveryBox {
    public int solution(int[] order) {
        int answer = 0;

        Stack<Integer> stack = new Stack<>();
        int index = 1;
        for (int i = 0; i < order.length; i++) {
            if (!stack.isEmpty() && stack.peek() == order[i]) {
                stack.pop();
                answer++;
                continue;
            } else if (order[i] < index) {
                break;
            }

            while(order[i] > index) {
                stack.add(index++);
            }

            if (order[i] == index) {
                answer++;
                index++;
            }
        }

        return answer;
    }
}