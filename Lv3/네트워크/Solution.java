// https://school.programmers.co.kr/learn/courses/30/lessons/43162
package Lv3.네트워크;
// review : 1

// 문제이해
// computers[0][0] = 1
// computers[0][1] = 1  --> 0번과 1번 컴퓨터 연결 o
// computers[0][2] = 0  --> 0번과 2번 컴퓨터 연결 x

class Solution {
    // 한 컴퓨터에서 DFS 탐색을 시작하면, 그 컴퓨터와 연결된 모든 컴퓨터를 방문
    public void dfs(int node, boolean[] visited, int[][] computers) {
        // node = 0, 즉 컴퓨터 0을 방문
        visited[node] = true; // visited = [true, false, false]

        for (int i = 0; i < computers.length; i++) {
// i번째 컴퓨터가 아직 방문되지 않았고, 현재 컴퓨터와 연결되어 있으면 DFS 재귀 호출
            if (!visited[i] && computers[node][i] == 1) {
                dfs(i, visited, computers);
            }
            // computers[0][0] == 1은 이미 방문 상태이므로 재귀 호출x
            // computers[0][1] == 1)은 방문되지 않았고,
            //                       컴퓨터 0과 연결되어 있으므로 재귀 호출
        }
    }

    public int solution(int n, int[][] computers) {
        int answer = 0;

        // 탐색할 때 사용한 컴퓨터는 다시 방문하지 않도록 체크하기 위해
        boolean[] visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            if(!visited[i]) {
                answer++;
                dfs(i, visited, computers);
            }
        }
        return answer;
    }
}
