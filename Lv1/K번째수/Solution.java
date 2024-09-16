// https://school.programmers.co.kr/learn/courses/30/lessons/42748
package Lv1.K번째수;

import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        for(int i = 0; i < commands.length; i++) {
            // commands[i][0] ~ commands[i][1]
            // 배열을 자를 때는 Arrays.copyOfRange()를 사용
            int[] subArray = Arrays.copyOfRange(array, commands[i][0] - 1, commands[i][1]);

            // 배열 정렬은 Arrays.sort()
            Arrays.sort(subArray);

            // k번째 수 answer 배열에 저장
            answer[i] = subArray[commands[i][2] - 1];
        }
        return answer;
    }
}