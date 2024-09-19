// https://school.programmers.co.kr/learn/courses/30/lessons/43164
package Lv3.여행경로;

import java.util.*;

class Solution {
    // 방문한 경로들을 저장할 리스트
    static ArrayList<String> list = new ArrayList<>();
    // 항공권 사용 여부 기록하는 배열
    static boolean visited[];

    static void dfs(int depth, String now, String path, String[][] tickets) {
        // 모든 티켓을 다 사용하면
        if (depth == tickets.length) {
            // 해당 경로(path)를 리스트에 추가하고 종료
            list.add(path);
            return;
        }

        // 현재 공항(now)에서 출발하는 모든 티켓을 탐색
        for (int i = 0; i < visited.length; i++) {
            // 티켓이 아직 사용되지 않았고, 출발 공항이 현재 공항과 일치하는지 확인
            if(!visited[i] && now.equals(tickets[i][0])) {
                visited[i] = true;
                // 재귀 호출: 목적지로 이동하고, 경로 업데이트
                dfs(depth + 1, tickets[i][1], path + " " + tickets[i][1], tickets);

                // 해당 티켓을 자시 사용 가능한 상태로 되돌림(백트래킹)
                visited[i] = false;
            }
        }
    }

    public String[] solution(String[][] tickets) {
        visited = new boolean[tickets.length];
        // DFS 탐색 시작: 초기 상태는 "ICN" 공항에서 출발하고, 경로도 "ICN"으로 시작
        dfs(0, "ICN", "ICN", tickets);
        // list에 저장된 경로들 알파벳 순으로 정렬
        Collections.sort(list);
        // 가장 알파벳 순서 앞서는 경로 선택해서 공백 기준으로 나눈 후 리턴
        return list.get(0).split(" ");

    }
}