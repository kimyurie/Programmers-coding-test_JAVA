// https://school.programmers.co.kr/learn/courses/30/lessons/43163
package Lv3.단어변환;

class Solution {
    // 각 단어가 변환과정에서 사용되었는지 여부 판단
    static boolean[] visited;
    // 몇 단계만에 변환 가능한지 저장
    static int answer = 0;


    // 현재 단어(begin)에서 target으로 가는 변환 과정을 재귀적으로 탐색
    public static void dfs(String begin, String target, String[] words, int cnt){
        if(begin.equals(target)) {
            answer = cnt;
            return;
        }

        for(int i = 0; i < words.length; i++) {
            if(visited[i]) {
                continue;
            }

            int k = 0; // 현재 단어(begin)와 words[i]가 몇글자가 같은지 체크
            for (int j = 0; j < begin.length(); j++) {
                if(begin.charAt(j) == words[i].charAt(j)) {
                    k++;
                }
            }

            // 글자가 딱 한글자만 다른 경우
            // hit -> hot
            if(k == begin.length() - 1) {
                visited[i] = true;
                dfs(words[i], target, words, cnt + 1);
                visited[i] = false; // 다른 경로 탐색 위해 방문표시 해재
//만약 hit -> hot -> dot -> cog로 변환하는 경로가 있다고 할 때,
// 다른 경로인 hit -> hot -> lot -> log -> cog도 탐색하려면,
// 이미 방문한 단어들을 다시 탐색할 수 있도록 방문 표시를 해제해야 함
            }
        }
    }

    public int solution(String begin, String target, String[] words) {
        visited = new boolean[words.length];

        dfs(begin, target, words, 0);

        return answer;
    }
}
