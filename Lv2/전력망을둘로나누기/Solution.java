// https://school.programmers.co.kr/learn/courses/30/lessons/86971
package Lv2.전력망을둘로나누기;

import java.util.*;

class Solution {
    static ArrayList<Integer>[] graph;
    static int min;

    // 연결된 송전탑의 개수를 세는 함수
    static int dfs(int v, boolean[] visited) {
        // v: 현재 방문 중인 송전탑 번호
        visited[v] = true;
        int cnt = 1;

        for(int next : graph[v]) {
            if (!visited[next]) {
                cnt += dfs(next, visited);
            }
        }
        return cnt;
    }

    public int solution(int n, int[][] wires) {
        // 1. 그래프 초기화
        graph = new ArrayList[n+1];
        min = Integer.MAX_VALUE; // 자바에서 표현할 수 있는 가장 큰 정수 값

        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
            // graph[1] = []
            // graph[2] = []
            // graph[3] = []
            // graph[4] = []
        }

        // 2. 그래프에 전선 정보 추가(양방향)
        for (int i = 0; i < wires.length; i++) {
            int v1 = wires[i][0];
            int v2 = wires[i][1];
            graph[v1].add(v2);
            graph[v2].add(v1);
            // wires = [[1, 2], [2, 3], [3, 4]] 일때,
            // graph[1] = [2]
            // graph[2] = [1, 3]
            // graph[3] = [2, 4]
            // graph[4] = [3]
        }

        // 3. 전선을 하나씩 끊어서 두 전력망의 송전탑 개수 차이 계산
        for (int i = 0; i < wires.length; i++) {
            int v1 = wires[i][0];
            int v2 = wires[i][1];

            boolean[] visited = new boolean[n+1];

            // 전선을 끊음
            graph[v1].remove(Integer.valueOf(v2));
            graph[v2].remove(Integer.valueOf(v1));

            // DFS로 한 전력망의 송전탑 개수 세기
            int cnt = dfs(1, visited);

            // 다른 전력망의 송전탑 개수는 n - cnt
            // Math.abs : 절댓값 구함
            int diff = Math.abs(cnt - (n - cnt));
            min = Math.min(min, diff);

            // 전선 복구
            graph[v1].add(v2);
            graph[v2].add(v1);
        }
        return min;
    }
}
