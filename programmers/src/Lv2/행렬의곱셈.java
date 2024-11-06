package Lv2;

public class 행렬의곱셈 {
    public static void main(String[] args) {
        int[][] arr1 = {{2,3,2}, {4,2,4}, {3,1,4}};
        int[][] arr2 = {{5,4,3}, {2,4,1}, {3,1,1}};
        MatrixMultiplication mm = new MatrixMultiplication();
        int[][] result = mm.solution(arr1, arr2);
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[i].length; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
    }
}

class MatrixMultiplication {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int[][] answer = new int[arr1.length][arr2[0].length];

        for (int i = 0; i < answer.length; i++) {
            for (int j = 0; j < answer[i].length; j++) {
                int sum = 0;
                for (int k = 0; k < arr1[0].length; k++) {
                    sum += arr1[i][k] * arr2[k][j];
                }
                answer[i][j] = sum;
            }
        }

        return answer;
    }
}