package Lv1;

import java.util.Arrays;
import java.util.Comparator;

public class 데이터분석 {
    public static void main(String[] args) {
        DataAnalysis da = new DataAnalysis();
        int[][] data = {{1, 20300104, 100, 80}, {2, 20300804, 847, 37}, {3, 20300401, 10, 8}};
        int[][] result = da.solution(data, "date", 20300501, "remain");
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[i].length; j++) {
                System.out.print(result[i][j]);
            }
            System.out.println();
        }
    }
}

class DataAnalysis {
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {

        String[] cols = {"code", "date", "maximum", "remain"};
        int ext_index = -1;
        int sort_index = -1;
        for(int i=0; i<cols.length; i++) {
            if (ext.equals(cols[i])) {
                ext_index = i;
            }
            if (sort_by.equals(cols[i])) {
                sort_index = i;
            }

            if (ext_index != -1 && sort_index != -1) {
                break;
            }
        }

        boolean[] underExt = new boolean[data.length];
        int count = 0;
        for(int i=0; i<underExt.length; i++) {
            if (data[i][ext_index] <= val_ext) {
                underExt[i] = true;
                count++;
            }
        }

        Integer[][] new_data = new Integer[count--][data[0].length];
        for(int i=0; i<underExt.length; i++) {
            if (underExt[i]) {
                for(int j=0; j<data[i].length; j++) {
                    new_data[count][j] = data[i][j];
                }
                count--;
            }
        }

        int finalSort_index = sort_index;
        Arrays.sort(new_data, new Comparator<Integer[]>(){
            @Override
            public int compare(Integer[] A, Integer[] B) {
                return A[finalSort_index] - B[finalSort_index];
            }
        });

        int[][] answer = new int[new_data.length][new_data[0].length];
        for(int i=0; i<new_data.length; i++) {
            for(int j=0; j<new_data[i].length; j++) {
                answer[i][j] = new_data[i][j];
            }
        }

        return answer;
    }
}

