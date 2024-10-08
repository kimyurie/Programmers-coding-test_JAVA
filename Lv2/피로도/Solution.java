// https://school.programmers.co.kr/learn/courses/30/lessons/87946
package Lv2.피로도;
// review : 1 / 2

import java.util.*;

class Solution {
    // 던전 방문 여부 기록
    static boolean[] visited;
    // 탐험한 던전의 최대값
    static int count = 0;

    // 재귀적으로 던전 탐험
    // depth는 현재까지 탐험한 던전 개수 , fatigue는 남은 피로도
    private void dfs(int depth, int fatigue, int[][] dungeons) {
        for(int i = 0; i < dungeons.length; i++) {
            // 던전을 탐험할 수 없는 조건
            // : 이미 방문했거나, 남은 피로도가 최소 필요 피로도보다 부족한 경우
            if (visited[i] || dungeons[i][0] > fatigue) {
                continue; // 현재 던전 탐험 못하므로 다음 던전으로 넘어감
            }

            // 현재 던전 탐험
            visited[i] = true; // 현재 던전 탐험했음을 기록
            // 탐험 후 남은 피로도로 다음 탐험 진행
            dfs(depth + 1, fatigue - dungeons[i][1], dungeons);
            visited[i] = false; // 탐험 끝난 후 방문 여부 초기화
        }
// 탐험 깊이(탐험한 던전 수)와 기존 최대 던전 수(count)를 비교해 더 큰 값으로 갱신
        count = Math.max(count, depth);
    }

    public int solution(int k, int[][] dungeons) {
        visited = new boolean[dungeons.length];
        // 탐험시작 (초기 깊이 0, 현재 피로도 k)
        dfs(0, k, dungeons);
        return count;
    }
}