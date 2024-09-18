// https://school.programmers.co.kr/learn/courses/30/lessons/43165
package Lv2.타겟넘버;

import java.util.*;

class Solution {
    int answer = 0;

    private void dfs(int depth, int[] numbers, int target, int sum) {
        // 모든 숫자를 다 사용했을 때 (depth == numbers 배열의 길이)
        if (depth == numbers.length) {
            if (sum == target) {
                answer++;
            }
            return;
        }

        // dfs(0, [1, 1, 1, 1, 1], 3, 0) ->초기 상태
        // 현재 숫자를 더한 경우
        dfs(depth + 1, numbers, target, sum + numbers[depth]);
        // dfs(1, [1, 1, 1, 1, 1], 3, 1);

        // 현재 숫자를 뺀 경우
        dfs(depth + 1, numbers, target, sum - numbers[depth]);
        // dfs(1, [1, 1, 1, 1, 1], 3, -1);
    }

    public int solution(int[] numbers, int target) {
        dfs(0, numbers, target, 0);
        return answer;
    }
}